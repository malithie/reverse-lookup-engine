package lk.uom.cse.msc.rle.model;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.model.edges.GraphEdge;
import lk.uom.cse.msc.rle.model.nodes.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<GraphNode> subjectNodeList;
    private List<GraphNode> resourceNodeList;

    public Graph() {

        subjectNodeList = new ArrayList<>();
        resourceNodeList = new ArrayList<>();
    }

    public void addNode(GraphNode node) {

        if (TypeDefinitions.NodeCategory.SUBJECT == node.getCategory()) {
            addNode(subjectNodeList, node);
        } else if (TypeDefinitions.NodeCategory.RESOURCE == node.getCategory()) {
            addNode(resourceNodeList, node);
        }
    }

    private void addNode(List<GraphNode> nodeList, GraphNode node) {

        int index = nodeList.indexOf(node);
        if (index != -1) {

            GraphNode nodeExisting = nodeList.get(index);
            for (GraphEdge edge : node.getEdges()) {
                nodeExisting.addEdge(edge);
            }
        } else {

            nodeList.add(node);
        }
    }

    public List<GraphNode> getSubjectNodeList() {
        return subjectNodeList;
    }

    public List<GraphNode> getResourceNodeList() {
        return resourceNodeList;
    }
}
