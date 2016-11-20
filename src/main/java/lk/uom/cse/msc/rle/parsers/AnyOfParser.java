package lk.uom.cse.msc.rle.parsers;

import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.xacml3.core.schema.AllOfType;
import lk.uom.cse.msc.rle.xacml3.core.schema.AnyOfType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class AnyOfParser {

    private static final Log log = LogFactory.getLog(AnyOfParser.class);

    public static List<Node> parse(AnyOfType anyOf) throws XACMLParsingException {

        List<AllOfType> allOfList = anyOf.getAllOf();

        if (allOfList == null || allOfList.isEmpty()) {
            throw new XACMLParsingException("At least one AllOf element should be present within an AnyOf element.");
        }

        if (log.isDebugEnabled()) {
            log.debug("Parsing AnyOf element.");
        }

        List<Node> conditionPaths = new ArrayList<>();

        for (AllOfType allOfType : allOfList) {
            conditionPaths.add(AllOfParser.parse(allOfType));
        }

        if (log.isDebugEnabled()) {
            log.debug("Condition Paths : " + conditionPaths);
        }

        return conditionPaths;
    }
}
