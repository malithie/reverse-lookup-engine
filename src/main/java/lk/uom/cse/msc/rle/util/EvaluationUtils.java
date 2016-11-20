package lk.uom.cse.msc.rle.util;

import lk.uom.cse.msc.rle.builder.ResultBuilder;
import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.model.Condition;
import lk.uom.cse.msc.rle.model.Graph;
import lk.uom.cse.msc.rle.model.ResultConditions;
import lk.uom.cse.msc.rle.model.Variable;
import lk.uom.cse.msc.rle.model.edges.GraphEdge;
import lk.uom.cse.msc.rle.model.nodes.GraphNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvaluationUtils {

    private static final Log log = LogFactory.getLog(EvaluationUtils.class);

    public static List<ResultConditions> review(Graph graph, Map<TypeDefinitions.AttributeCategory,
            List<Variable<?>>> variables) {

        List<Variable<?>> subjectCategoryVariables = variables.get(TypeDefinitions.AttributeCategory.SUBJECT);
        List<Variable<?>> resourceCategoryVariables = variables.get(TypeDefinitions.AttributeCategory.RESOURCE);
        List<Variable<?>> allVariables = new ArrayList<>();

        variables.values().stream().forEach(list -> allVariables.addAll(list));

        List<GraphEdge> matchingEdges;
        if (subjectCategoryVariables != null && !subjectCategoryVariables.isEmpty()) {

            matchingEdges = getEdgesOfMatchingNodes(graph.getSubjectNodeList(), subjectCategoryVariables);
            filterMatchingEdges(matchingEdges, allVariables);

            if (resourceCategoryVariables != null && !resourceCategoryVariables.isEmpty()) {

                filterMatchingEdgesForResourceVariables(matchingEdges, resourceCategoryVariables);
            }

            return ResultBuilder.build(matchingEdges);
        }

        if (resourceCategoryVariables != null && !resourceCategoryVariables.isEmpty()) {

            matchingEdges = getEdgesOfMatchingNodes(graph.getResourceNodeList(), resourceCategoryVariables);
            filterMatchingEdges(matchingEdges, allVariables);

            return ResultBuilder.build(matchingEdges);
        }

        return new ArrayList<>();

    }

    public static boolean matchedPartially(List<Condition> conditions, List<Variable<?>> variables) {

        if (conditions == null || conditions.isEmpty()) {
            return true;
        }

        boolean matchingVariableFound = false;
        for (Condition condition : conditions) {
            Variable<?> variable = getMatchingVariable(condition, variables);
            if (variable == null) continue;

            matchingVariableFound = true;

            if (!match(condition, variable)) {
                return false;
            }
        }

        return matchingVariableFound;
    }

    public static boolean match(Condition condition, Variable<?> variable) {

        if (condition.getAttribute().equals(variable.getAttribute())) {

            switch (condition.getOperator()) {
                case EQUAL:
                    if (condition.getAttributeValue().getValue().compareTo(variable.getAttributeValue().getValue())
                            == 0) {
                        return true;
                    }
                    break;
                case GREATER_THAN:
                    if (condition.getAttributeValue().getValue().compareTo(variable.getAttributeValue().getValue()) >
                            0) {
                        return true;
                    }
                    break;
                case GREATER_THAN_OR_EQUAL:
                    if (condition.getAttributeValue().getValue().compareTo(variable.getAttributeValue().getValue())
                            >= 0) {
                        return true;
                    }
                    break;
                case LESS_THAN:
                    if (condition.getAttributeValue().getValue().compareTo(variable.getAttributeValue().getValue()) <
                            0) {
                        return true;
                    }
                    break;
                case LESS_THAN_OR_EQUAL:
                    if (condition.getAttributeValue().getValue().compareTo(variable.getAttributeValue().getValue())
                            <= 0) {
                        return true;
                    }
                    break;
            }
        }

        return false;
    }

    public static Variable<?> getMatchingVariable(Condition condition, List<Variable<?>> variables) {

        for (Variable variable : variables) {
            if (condition.getAttribute().equals(variable.getAttribute())) {
                return variable;
            }
        }

        return null;
    }

    public static List<GraphEdge> getEdgesOfMatchingNodes(List<GraphNode> nodes, List<Variable<?>> variables) {

        List<GraphEdge> matchingEdges = new ArrayList<>();

        List<GraphNode> matchingNodes = findMatchingNodes(nodes, variables);
        matchingNodes.forEach(graphNode -> graphNode.getEdges().forEach(edge -> matchingEdges.add(edge)));

        return matchingEdges;
    }

    public static List<GraphNode> findMatchingNodes(List<GraphNode> nodes, List<Variable<?>> variables) {

        return nodes.stream().filter(node -> matchedPartially(node.getConditions(), variables)).collect(Collectors
                .toList());
    }

    public static void filterMatchingEdges(List<GraphEdge> edges, List<Variable<?>> variables) {

        edges.removeIf((edge -> !matchedPartially(edge.getConditions(), variables)));
    }

    public static void filterMatchingEdgesForSubjectVariables(List<GraphEdge> edges, List<Variable<?>> variables) {

        edges.removeIf(edge -> !matchedPartially(edge.getSubjectNode().getConditions(), variables));
    }

    public static void filterMatchingEdgesForResourceVariables(List<GraphEdge> edges, List<Variable<?>> variables) {

        edges.removeIf(edge -> !matchedPartially(edge.getResourceNode().getConditions(), variables));
    }
}
