package lk.uom.cse.msc.rle.util;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.model.Attribute;
import lk.uom.cse.msc.rle.model.AttributeValue;
import lk.uom.cse.msc.rle.model.Variable;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributeType;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributeValueType;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributesType;

import java.util.ArrayList;
import java.util.List;

public class AttributeConverterUtil {

    public static List<Variable<?>> convert(AttributesType attributesType) throws XACMLParsingException {

        List<Variable<?>> variables = new ArrayList<>();

        if (attributesType != null) {
            for (AttributeType attributeType : attributesType.getAttribute()) {
                if (attributeType != null) {
                    Variable var = convert(attributesType.getCategory(), attributeType);
                    variables.add(var);
                }
            }
        }

        return variables;
    }

    public static Variable<?> convert(String category, AttributeType attributeType) throws XACMLParsingException {

        if (attributeType == null) {
            throw new IllegalArgumentException("Argument AttributeType must not be null");
        }

        List<AttributeValueType> attributeValuesType = attributeType.getAttributeValue();
        if (attributeValuesType == null || attributeValuesType.size() == 0) {
            throw new XACMLParsingException("Empty value in the attribute:" + attributeType.getAttributeId());
        }

        AttributeValueType attributeValueType = attributeValuesType.get(0);

        Attribute attribute = getAttribute(category, attributeType.getAttributeId(), attributeValueType.getDataType());
        AttributeValue attributeValue = getAttributeValue(attributeValueType);

        return new Variable<>(attribute, attributeValue);
    }

    private static Attribute getAttribute(String strCategory, String attributeId, String strDataType) throws
            XACMLParsingException {

        TypeDefinitions.AttributeCategory attributeCategory = AttributeCategoryConverterUtil.getCategory(strCategory);
        TypeDefinitions.DataType dataType = DataTypeConverterUtil.getDataType(strDataType);

        return new Attribute(attributeId, attributeCategory, dataType);
    }

    private static AttributeValue getAttributeValue(AttributeValueType attributeValueType) throws
            XACMLParsingException {

        if (attributeValueType == null || attributeValueType.getContent() == null || attributeValueType.getContent()
                .isEmpty()) {
            throw new XACMLParsingException("Empty attribute value");
        }

        // only support 1-value at the moment.
        String strValue = (String) attributeValueType.getContent().get(0);
        return new AttributeValue(DataTypeConverterUtil.convert(strValue, attributeValueType.getDataType()));
    }
}
