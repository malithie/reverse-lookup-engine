package lk.uom.cse.msc.rle.parsers;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.model.Attribute;
import lk.uom.cse.msc.rle.model.AttributeValue;
import lk.uom.cse.msc.rle.model.Condition;
import lk.uom.cse.msc.rle.util.AttributeCategoryConverterUtil;
import lk.uom.cse.msc.rle.util.DataTypeConverterUtil;
import lk.uom.cse.msc.rle.util.MatchIdConverterUtil;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributeDesignatorType;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributeValueType;
import lk.uom.cse.msc.rle.xacml3.core.schema.MatchType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class MatchParser {

    private static final Log log = LogFactory.getLog(MatchParser.class);

    public static Condition parse(MatchType matchType) throws XACMLParsingException {

        validate(matchType);

        Attribute attribute = getAttribute(matchType.getAttributeDesignator());
        AttributeValue attributeValue = getAttributeValue(matchType.getAttributeValue());
        TypeDefinitions.Operator operator = MatchIdConverterUtil.getOperator(matchType.getMatchId());

        return new Condition(attribute, attributeValue, operator);
    }

    private static void validate(MatchType match) throws XACMLParsingException {

        AttributeValueType attrValue = match.getAttributeValue();
        AttributeDesignatorType attrDesignator = match.getAttributeDesignator();
        if (attrValue == null) {
            throw new XACMLParsingException("No attribute value found");
        }
        if (attrDesignator == null) {
            throw new XACMLParsingException("No attribute designator found");
        }

        String attrValueDataType = attrValue.getDataType();
        if (attrValueDataType == null || !attrValueDataType.equals(attrDesignator.getDataType())) {
            throw new XACMLParsingException("Data types in match expression are not valid");
        }
    }

    private static Attribute getAttribute(AttributeDesignatorType attributeDesignatorType) throws XACMLParsingException {

        String attributeId = attributeDesignatorType.getAttributeId();
        TypeDefinitions.AttributeCategory attributeCategory = AttributeCategoryConverterUtil.getCategory
                (attributeDesignatorType.getCategory());
        TypeDefinitions.DataType dataType = DataTypeConverterUtil.getDataType(attributeDesignatorType.getDataType());

        return new Attribute(attributeId, attributeCategory, dataType);
    }

    private static AttributeValue getAttributeValue(AttributeValueType attributeValueType) throws XACMLParsingException {

        List<Object> objects = attributeValueType.getContent();
        if (objects == null || objects.size() == 0) {
            throw new XACMLParsingException("Cannot extract attribute value");
        }

        // only support 1-value at the moment.
        String strValue = (String) objects.get(0);
        return new AttributeValue(DataTypeConverterUtil.convert(strValue, attributeValueType.getDataType()));
    }
}
