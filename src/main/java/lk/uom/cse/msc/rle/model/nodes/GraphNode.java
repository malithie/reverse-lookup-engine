package lk.uom.cse.msc.rle.model.nodes;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.model.Condition;
import lk.uom.cse.msc.rle.model.edges.GraphEdge;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    private TypeDefinitions.NodeCategory category;
    private List<Condition> conditions;
    private List<GraphEdge> edges;

    public GraphNode(TypeDefinitions.NodeCategory category) {
        this.category = category;
        this.conditions = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public TypeDefinitions.NodeCategory getCategory() {
        return category;
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

    public List<GraphEdge> getEdges() {
        return edges;
    }

    public boolean addEdge(GraphEdge edge) {

        if (edges.contains(edge)) {
            return false;
        }

        edge.setNode(this);
        return edges.add(edge);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphNode graphNode = (GraphNode) o;

        if (category != graphNode.category) return false;

        if (conditions != null) {
            if (graphNode.conditions == null) {
                return false;
            }

            for (Condition condition : conditions) {
                if (!graphNode.conditions.contains(condition)) {
                    return false;
                }
            }

            for (Condition condition : graphNode.conditions) {
                if (!conditions.contains(condition)) {
                    return false;
                }
            }

            return true;
        }

        return graphNode.conditions == null;

    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result;

        if (conditions != null) {
            for (Condition condition : conditions) {
                result += condition.hashCode();
            }
        }

        return result;
    }
}
