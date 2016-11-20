package lk.uom.cse.msc.rle.model.edges;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.model.Condition;
import lk.uom.cse.msc.rle.model.nodes.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class GraphEdge {

    private TypeDefinitions.PermissionResult decision;
    private List<Condition> conditions;
    private GraphNode subjectNode;
    private GraphNode resourceNode;

    public GraphEdge(TypeDefinitions.PermissionResult decision) {
        this.decision = decision;
        this.conditions = new ArrayList<>();
    }

    public TypeDefinitions.PermissionResult getDecision() {
        return decision;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public boolean addCondition(Condition condition) {

        if (conditions.contains(condition)) {
            return false;
        }
        return conditions.add(condition);
    }

    public GraphNode getSubjectNode() {
        return subjectNode;
    }

    public GraphNode getResourceNode() {
        return resourceNode;
    }

    public void setNode(GraphNode node) {

        if (TypeDefinitions.NodeCategory.SUBJECT == node.getCategory()) {
            this.subjectNode = node;
        } else if (TypeDefinitions.NodeCategory.RESOURCE == node.getCategory()) {
            this.resourceNode = node;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphEdge graphEdge = (GraphEdge) o;

        if (decision != graphEdge.decision) return false;
        if (conditions != null ? !conditions.equals(graphEdge.conditions) : graphEdge.conditions != null) return false;
        if (subjectNode != null ? !subjectNode.equals(graphEdge.subjectNode) : graphEdge.subjectNode != null)
            return false;
        return resourceNode != null ? resourceNode.equals(graphEdge.resourceNode) : graphEdge.resourceNode == null;

    }

    @Override
    public int hashCode() {
        int result = decision != null ? decision.hashCode() : 0;
        result = 31 * result + (conditions != null ? conditions.hashCode() : 0);
        result = 31 * result + (subjectNode != null ? subjectNode.hashCode() : 0);
        result = 31 * result + (resourceNode != null ? resourceNode.hashCode() : 0);
        return result;
    }
}
