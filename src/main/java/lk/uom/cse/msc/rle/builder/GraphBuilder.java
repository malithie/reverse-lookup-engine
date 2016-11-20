package lk.uom.cse.msc.rle.builder;

import lk.uom.cse.msc.rle.model.Graph;
import lk.uom.cse.msc.rle.model.Relation;
import lk.uom.cse.msc.rle.model.nodes.Node;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class GraphBuilder {

    private static final Log log = LogFactory.getLog(GraphBuilder.class);

    public static Graph build(List<Node> conditionPaths) {

        Graph graph = new Graph();

        for (Node node : conditionPaths) {

            Relation nodeRelation = Relation.RelationBuilder.build(node);

            if (nodeRelation != null) {

                graph.addNode(nodeRelation.getSubjectNode());
                graph.addNode(nodeRelation.getResourceNode());
            } else {
                if (log.isDebugEnabled()) {
                    log.debug("Could not build subject-resource relationship for " + node);
                }
            }
        }

        return graph;
    }
}
