package lk.uom.cse.msc.rle.util;

import lk.uom.cse.msc.rle.model.nodes.CategoryNode;
import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.model.nodes.PermitDenyNode;
import lk.uom.cse.msc.rle.model.nodes.TrueNode;

public class NodeUtils {

    private NodeUtils() {
    }

    public static Node clone(Node node) {

        if (node instanceof TrueNode) {
            return TrueNode.create();
        } else if (node instanceof PermitDenyNode) {
            return new PermitDenyNode(((PermitDenyNode) node).getResult());
        }

        CategoryNode categoryNode = (CategoryNode) node;

        CategoryNode clonedNode = new CategoryNode(categoryNode);

        if (categoryNode.hasNext()) {
            clonedNode.setNext(clone(categoryNode.getNext()));
        }

        return clonedNode;
    }

    public static Node getCurrentNode(Node node) {

        if (node instanceof TrueNode) {
            return TrueNode.create();
        } else if (node instanceof PermitDenyNode) {
            return new PermitDenyNode(((PermitDenyNode) node).getResult());
        }

        return new CategoryNode((CategoryNode) node);
    }
}
