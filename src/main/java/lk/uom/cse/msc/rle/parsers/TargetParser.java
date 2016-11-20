package lk.uom.cse.msc.rle.parsers;

import lk.uom.cse.msc.rle.builder.ConjunctiveBuilder;
import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.model.nodes.TrueNode;
import lk.uom.cse.msc.rle.xacml3.core.schema.AnyOfType;
import lk.uom.cse.msc.rle.xacml3.core.schema.TargetType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TargetParser {

    private static final Log log = LogFactory.getLog(TargetParser.class);

    public static List<Node> parse(TargetType target) throws XACMLParsingException {

        if (log.isDebugEnabled()) {
            log.debug("Parsing Target element.");
        }

        List<Node> conditionPaths;

        List<AnyOfType> anyOfList = target.getAnyOf();
        if (anyOfList == null || anyOfList.isEmpty()) {

            if (log.isDebugEnabled()) {
                log.debug("Empty Target. Return TRUE.");
            }
            // return TRUE node if no AnyOf elements present.
            conditionPaths = new ArrayList<>();
            conditionPaths.add(TrueNode.create());

            return conditionPaths;
        }

        Iterator<AnyOfType> iterator = anyOfList.iterator();

        conditionPaths = AnyOfParser.parse(iterator.next());

        while (iterator.hasNext()) {
            conditionPaths = ConjunctiveBuilder.and(conditionPaths, AnyOfParser.parse(iterator.next()));
        }

        if (log.isDebugEnabled()) {
            log.debug("Condition Paths : " + conditionPaths);
        }

        return conditionPaths;
    }
}
