package lk.uom.cse.msc.rle.model;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.model.edges.GraphEdge;
import lk.uom.cse.msc.rle.model.nodes.CategoryNode;
import lk.uom.cse.msc.rle.model.nodes.DecisionNode;
import lk.uom.cse.msc.rle.model.nodes.GraphNode;
import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.model.nodes.PermitDenyNode;
import lk.uom.cse.msc.rle.util.NodeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Relation {

    private GraphNode subjectNode;
    private GraphNode resourceNode;
    private GraphEdge edge;

    public GraphNode getSubjectNode() {
        return subjectNode;
    }

    public GraphNode getResourceNode() {
        return resourceNode;
    }

    public GraphEdge getEdge() {
        return edge;
    }


    public static class RelationBuilder {

        private static final Log log = LogFactory.getLog(RelationBuilder.class);

        public static Relation build(Node node) {

            if (node instanceof DecisionNode) {
                if (log.isDebugEnabled()) {
                    log.debug("Only a Permit/ Deny decision found. Cannot build a subject-resource relationship.");
                }

                return null;
            }


            CategoryNode subjectNode = null;
            CategoryNode resourceNode = null;
            CategoryNode linkNode = null;
            TypeDefinitions.PermissionResult decision = null;

            Node currentNode = node;
            while (!(currentNode instanceof DecisionNode)) {

                CategoryNode newNode = (CategoryNode) NodeUtils.getCurrentNode(currentNode);

                switch (newNode.getCategory()) {
                    case SUBJECT:
                        subjectNode = newNode;
                        break;

                    case RESOURCE:
                        resourceNode = newNode;
                        break;

                    case LINK:
                        linkNode = newNode;
                        break;
                }

                currentNode = ((CategoryNode) currentNode).getNext();
            }

            if (currentNode instanceof PermitDenyNode) {
                decision = ((PermitDenyNode) (currentNode)).getResult();
            } else {
                //todo: throw an exception as this is an error state
                if (log.isDebugEnabled()) {
                    log.debug("Permit/ Deny decision not found. Cannot build a subject-resource relationship.");
                }

                return null;
            }

            if (subjectNode == null || resourceNode == null) {
                if (log.isDebugEnabled()) {
                    log.debug("No subject-resource relationship found. Ignoring node " + node);
                }

                return null;
            }

            Relation relation = new Relation();
            relation.subjectNode = createNode(subjectNode);
            relation.resourceNode = createNode(resourceNode);
            relation.edge = createEdge(decision, linkNode);

            relation.subjectNode.addEdge(relation.edge);
            relation.resourceNode.addEdge(relation.edge);

            return relation;

        }

        private static GraphNode createNode(CategoryNode node) {

            GraphNode graphNode = new GraphNode(node.getCategory());
            for (Condition condition : node.getConditions()) {
                graphNode.addCondition(condition);
            }

            return graphNode;
        }

        private static GraphEdge createEdge(TypeDefinitions.PermissionResult decision, CategoryNode node) {

            GraphEdge graphEdge = new GraphEdge(decision);
            if (node != null && node.getCategory() == TypeDefinitions.NodeCategory.LINK) {
                for (Condition condition:node.getConditions()) {
                    graphEdge.addCondition(condition);
                }
            }

            return graphEdge;
        }

    }
}
