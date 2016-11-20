package lk.uom.cse.msc.rle.parsers;

import lk.uom.cse.msc.rle.builder.ConjunctiveBuilder;
import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.model.Condition;
import lk.uom.cse.msc.rle.model.nodes.CategoryNode;
import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.model.nodes.TrueNode;
import lk.uom.cse.msc.rle.xacml3.core.schema.AllOfType;
import lk.uom.cse.msc.rle.xacml3.core.schema.MatchType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class AllOfParser {

    private static final Log log = LogFactory.getLog(AllOfParser.class);

    public static Node parse(AllOfType allOf) throws XACMLParsingException {

        List<MatchType> matchList = allOf.getMatch();

        if (matchList == null || matchList.isEmpty()) {
            throw new XACMLParsingException("At least one Match element should be present within an AllOf element.");
        }


        if (log.isDebugEnabled()) {
            log.debug("Parsing AllOf element.");
        }

        CategoryNode rootNode = null;
        CategoryNode currentNode = null;

        int index = 0;

        for (MatchType matchType : matchList) {

            Condition matchCondition = MatchParser.parse(matchType);

            if (log.isDebugEnabled()) {
                log.debug("Found condition " + matchCondition);
            }

            CategoryNode internalNode = getNode(matchCondition);
            internalNode.setIndex(index++);

            if (rootNode == null) {
                rootNode = internalNode;
            }

            if (currentNode != null) {
                currentNode.setNext(internalNode);
            }

            currentNode = internalNode;
        }

        currentNode.setNext(TrueNode.create());

        ConjunctiveBuilder.reduce(rootNode);

        return rootNode;
    }

    private static CategoryNode getNode(Condition matchCondition) {

        CategoryNode node = null;
        switch (matchCondition.getAttribute().getCategory()) {

            case SUBJECT:

                if (log.isDebugEnabled()) {
                    log.debug("Subject category attribute found. Creating subject category node.");
                }

                node = new CategoryNode(TypeDefinitions.NodeCategory.SUBJECT);
                node.addCondition(matchCondition);
                break;

            case RESOURCE:

                if (log.isDebugEnabled()) {
                    log.debug("Resource category attribute found. Creating resource category node.");
                }

                node = new CategoryNode(TypeDefinitions.NodeCategory.RESOURCE);
                node.addCondition(matchCondition);
                break;

            case ACTION:
            case ENVIRONMENT:

                if (log.isDebugEnabled()) {
                    log.debug("Action or Environment category attribute found. Creating link category node.");
                }
                node = new CategoryNode(TypeDefinitions.NodeCategory.LINK);
                node.addCondition(matchCondition);
                break;
        }

        return node;
    }

}
