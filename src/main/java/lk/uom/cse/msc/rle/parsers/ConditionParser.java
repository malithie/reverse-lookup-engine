package lk.uom.cse.msc.rle.parsers;

import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.model.nodes.TrueNode;
import lk.uom.cse.msc.rle.xacml3.core.schema.ConditionType;

import java.util.ArrayList;
import java.util.List;

public class ConditionParser {

    public static List<Node> parse(ConditionType conditionType) throws XACMLParsingException {

        // return TRUE node if no AnyOf elements present.
        List<Node> conditionPaths =  new ArrayList<>();
        conditionPaths.add(TrueNode.create());

        return conditionPaths;
    }
}
