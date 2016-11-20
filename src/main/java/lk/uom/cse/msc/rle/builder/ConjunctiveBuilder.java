package lk.uom.cse.msc.rle.builder;

import lk.uom.cse.msc.rle.model.Condition;
import lk.uom.cse.msc.rle.model.nodes.CategoryNode;
import lk.uom.cse.msc.rle.model.nodes.DecisionNode;
import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.model.nodes.PermitDenyNode;
import lk.uom.cse.msc.rle.util.NodeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class ConjunctiveBuilder {

    private static final Log log = LogFactory.getLog(ConjunctiveBuilder.class);

    public static void reduce(Node node) {

        if (log.isDebugEnabled()) {
            log.debug("Merging " + node);
        }

        if (node instanceof DecisionNode) {
            if (log.isDebugEnabled()) {
                log.debug("Decision node found. Returning.");
            }
            return;
        }

        CategoryNode internalNode = (CategoryNode) node;

        CategoryNode currentNode = internalNode;
        while (currentNode.hasNext()) {

            if (currentNode.getNext() instanceof DecisionNode) {
                break;
            }

            currentNode = (CategoryNode) currentNode.getNext();

            if (canMerge(internalNode, currentNode)) {

                if (log.isDebugEnabled()) {
                    log.debug("Another node of category " + internalNode.getCategory() + " found. Merging");
                }

                merge(internalNode, currentNode);
                currentNode = internalNode;
            }
        }

        if (log.isDebugEnabled()) {
            log.debug("No node of " + internalNode.getCategory() + " found. Check next.");
        }

        reduce(internalNode.getNext());
    }

    private static boolean canMerge(CategoryNode node1, CategoryNode node2) {
        return node1.getCategory() == node2.getCategory();
    }

    private static void merge(CategoryNode node1, CategoryNode node2) {

        for (Condition condition : node2.getConditions()) {
            node1.addCondition(condition);
        }

        CategoryNode currentNode = node1;
        for (int i = node1.getIndex(); i < node2.getIndex() - 1; i++) {
            currentNode = (CategoryNode) currentNode.getNext();
        }

        currentNode.setNext(node2.getNext());

        while (!(currentNode.getNext() instanceof DecisionNode)) {
            currentNode = (CategoryNode) currentNode.getNext();
            currentNode.setIndex(currentNode.getIndex() - 1);
        }
    }

    private static void switchDecisionNode(DecisionNode decisionNode, CategoryNode categoryNode) {

        CategoryNode currentNode = categoryNode;
        while (!(currentNode.getNext() instanceof DecisionNode)) {
            currentNode = (CategoryNode) currentNode.getNext();
        }

        if (!(currentNode.getNext() instanceof PermitDenyNode)) {
            currentNode.setNext(decisionNode);
        }
    }

    public static Node and(Node node1, Node node2) {

        if (log.isDebugEnabled()) {
            log.debug("AND [ " + node1 + ", " + node2 + " ]");
        }

        node1 = NodeUtils.clone(node1);
        node2 = NodeUtils.clone(node2);

        // If both are decision nodes give precedence to Permit/Deny node
        if (node1 instanceof DecisionNode && node2 instanceof DecisionNode) {
            if (node1 instanceof PermitDenyNode) {
                return node1;
            } else if (node2 instanceof PermitDenyNode) {
                return node2;
            }

            return node1;
        }

        // If at least one is a decision node switch the decision node of the other giving precedence to Permit/Deny
        if (node1 instanceof DecisionNode) {

            switchDecisionNode((DecisionNode) node1, (CategoryNode) node2);
            return node2;
        }

        if (node2 instanceof DecisionNode) {

            switchDecisionNode((DecisionNode) node2, (CategoryNode) node1);
            return node1;
        }

        CategoryNode currentNode = (CategoryNode) node1;
        while (!(currentNode.getNext() instanceof DecisionNode)) {
            currentNode = (CategoryNode) currentNode.getNext();
        }

        currentNode.setNext(node2);

        int index = currentNode.getIndex();
        while (!(currentNode.getNext() instanceof DecisionNode)) {
            currentNode = (CategoryNode) currentNode.getNext();
            currentNode.setIndex(++index);
        }

        reduce(node1);

        return node1;
    }

    public static List<Node> and(List<Node> nodeList1, List<Node> nodeList2) {

        List<Node> newNodeList = new ArrayList<>();
        for (Node node1 : nodeList1) {
            for (Node node2 : nodeList2) {
                newNodeList.add(and(node1, node2));
            }
        }

        return newNodeList;
    }
}
