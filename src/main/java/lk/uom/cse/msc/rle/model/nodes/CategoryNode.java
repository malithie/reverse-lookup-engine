package lk.uom.cse.msc.rle.model.nodes;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.model.Condition;

import java.util.ArrayList;
import java.util.List;

public class CategoryNode implements Node {

    protected TypeDefinitions.NodeCategory category;
    protected List<Condition> conditions;
    protected Node nextNode;
    protected int index;

    public CategoryNode(TypeDefinitions.NodeCategory category) {

        this.category = category;
        this.conditions = new ArrayList<>();
        this.index = 0;
    }

    public CategoryNode(CategoryNode node) {
        this.category = node.getCategory();
        this.conditions = new ArrayList<>();
        this.conditions.addAll(node.getConditions());
        this.index = node.getIndex();
    }

    public TypeDefinitions.NodeCategory getCategory() {
        return category;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public boolean addCondition(Condition condition) {

        if (!conditions.contains(condition)) {
            return conditions.add(condition);
        }
        return false;
    }

    public Node getNext() {
        return this.nextNode;
    }

    public void setNext(Node node) {
        this.nextNode = node;
    }

    public boolean hasNext() {
        return this.nextNode != null;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "CategoryNode{" + "category=" + category + ", conditions=" + conditions + ", index=" + index + "} ->\n\t "
                + nextNode;
    }
}
