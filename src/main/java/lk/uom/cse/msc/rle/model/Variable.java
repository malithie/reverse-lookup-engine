package lk.uom.cse.msc.rle.model;

public class Variable<T extends Comparable<T>> {

    Attribute attribute;
    AttributeValue<T> attributeValue;

    public Variable(Attribute attribute, AttributeValue<T> attributeValue) {
        this.attribute = attribute;
        this.attributeValue = attributeValue;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public AttributeValue<T> getAttributeValue() {
        return attributeValue;
    }

}
