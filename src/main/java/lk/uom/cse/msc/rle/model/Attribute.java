package lk.uom.cse.msc.rle.model;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;

public class Attribute {

    private String attributeId;
    private TypeDefinitions.AttributeCategory category;
    private TypeDefinitions.DataType dataType;

    public Attribute(String attributeId, TypeDefinitions.AttributeCategory category, TypeDefinitions.DataType
            dataType) {
        this.attributeId = attributeId;
        this.category = category;
        this.dataType = dataType;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public TypeDefinitions.AttributeCategory getCategory() {
        return category;
    }

    public TypeDefinitions.DataType getDataType() {
        return dataType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute attribute = (Attribute) o;

        if (attributeId != null ? !attributeId.equals(attribute.attributeId) : attribute.attributeId != null)
            return false;
        if (category != attribute.category) return false;
        return dataType == attribute.dataType;

    }

    @Override
    public int hashCode() {
        int result = attributeId != null ? attributeId.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attribute{" + "attributeId='" + attributeId + '\'' + ", category=" + category + ", dataType=" +
                dataType + '}';
    }
}
