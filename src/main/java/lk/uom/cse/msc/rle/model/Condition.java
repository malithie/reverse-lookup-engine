package lk.uom.cse.msc.rle.model;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;

public class Condition {

    Attribute attribute;
    AttributeValue attributeValue;
    TypeDefinitions.Operator operator;

    public Condition(Attribute attribute, AttributeValue attributeValue, TypeDefinitions.Operator operator) {

        this.attribute = attribute;
        this.attributeValue = attributeValue;
        this.operator = operator;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public TypeDefinitions.Operator getOperator() {
        return operator;
    }

    public AttributeValue getAttributeValue() {
        return attributeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition = (Condition) o;

        if (attribute != null ? !attribute.equals(condition.attribute) : condition.attribute != null) return false;
        if (attributeValue != null ? !attributeValue.equals(condition.attributeValue) : condition.attributeValue !=
                null)
            return false;
        return operator == condition.operator;

    }

    @Override
    public int hashCode() {
        int result = attribute != null ? attribute.hashCode() : 0;
        result = 31 * result + (attributeValue != null ? attributeValue.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Condition{" + "attribute=" + attribute + ", attributeValue=" + attributeValue + ", operator=" +
                operator + '}';
    }
}
