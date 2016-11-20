package lk.uom.cse.msc.rle.builder;

import lk.uom.cse.msc.rle.model.ResultConditions;
import lk.uom.cse.msc.rle.model.edges.GraphEdge;

import java.util.ArrayList;
import java.util.List;

public class ResultBuilder {

    private static ResultConditions create(GraphEdge edge) {

        ResultConditions resultConditions = new ResultConditions(edge.getDecision());
        edge.getSubjectNode().getConditions().forEach(condition -> resultConditions.addSubjectCondition(condition));
        edge.getResourceNode().getConditions().forEach(condition -> resultConditions.addResourceCondition(condition));
        edge.getConditions().forEach(condition -> resultConditions.addPermissionCondition(condition));

        return resultConditions;
    }

    public static List<ResultConditions> build(List<GraphEdge> edges) {

        List<ResultConditions> resultConditionsList = new ArrayList<>();

        if (edges != null && !edges.isEmpty()) {

            edges.forEach(edge -> resultConditionsList.add(create(edge)));
        }

        return resultConditionsList;
    }
}
