package lk.uom.cse.msc.rle.model.nodes;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;

public class PermitDenyNode extends DecisionNode {

    private TypeDefinitions.PermissionResult result;

    public PermitDenyNode(TypeDefinitions.PermissionResult result) {
        this.result = result;
    }

    public TypeDefinitions.PermissionResult getResult() {
        return result;
    }

    @Override
    public String getStringResult() {
        return result.name();
    }

    public static PermitDenyNode create() {
        return new PermitDenyNode(TypeDefinitions.PermissionResult.PERMIT);
    }

    @Override
    public String toString() {
        return "PermitDenyNode{" + "result=" + result + '}';
    }
}
