package lk.uom.cse.msc.rle.model.nodes;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;

public class TrueNode extends DecisionNode {


    public static TrueNode create() {
        return new TrueNode();
    }

    @Override
    public String getStringResult() {
        return TypeDefinitions.ConditionResult.TRUE.name();
    }

    @Override
    public String toString() {
        return "TrueNode{}";
    }
}
