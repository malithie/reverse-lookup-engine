package lk.uom.cse.msc.rle.model;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;

import java.util.ArrayList;
import java.util.List;

public class ResultConditions {

    private List<Condition> subjectConditions;
    private List<Condition> resourceConditions;
    private List<Condition> permissionConditions;
    private TypeDefinitions.PermissionResult decision;

    public ResultConditions(TypeDefinitions.PermissionResult decision) {

        this.decision = decision;
        subjectConditions = new ArrayList<>();
        resourceConditions = new ArrayList<>();
        permissionConditions = new ArrayList<>();

    }

    public TypeDefinitions.PermissionResult getDecision() {
        return decision;
    }

    public List<Condition> getSubjectConditions() {
        return subjectConditions;
    }

    public List<Condition> getResourceConditions() {
        return resourceConditions;
    }

    public List<Condition> getPermissionConditions() {
        return permissionConditions;
    }

    public boolean addSubjectCondition(Condition condition) {

        if (!subjectConditions.contains(condition)) {
            return subjectConditions.add(condition);
        }
        return false;
    }

    public boolean addResourceCondition(Condition condition) {

        if (!resourceConditions.contains(condition)) {
            return resourceConditions.add(condition);
        }
        return false;
    }

    public boolean addPermissionCondition(Condition condition) {

        if (!permissionConditions.contains(condition)) {
            return permissionConditions.add(condition);
        }
        return false;
    }

    @Override
    public String toString() {
        return "ResultConditions{\n" + "\tsubjectConditions=\n\t" + subjectConditions + ",\n\tresourceConditions=\n\t" +
                resourceConditions + ",\n\tpermissionConditions=\n\t" + permissionConditions + ",\n\tdecision=" + decision + "\n}\n";
    }
}
