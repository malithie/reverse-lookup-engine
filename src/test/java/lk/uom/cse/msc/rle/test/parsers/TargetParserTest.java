package lk.uom.cse.msc.rle.test.parsers;

import lk.uom.cse.msc.rle.parsers.TargetParser;
import lk.uom.cse.msc.rle.xacml3.core.schema.AllOfType;
import lk.uom.cse.msc.rle.xacml3.core.schema.AnyOfType;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributeDesignatorType;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributeValueType;
import lk.uom.cse.msc.rle.xacml3.core.schema.MatchType;
import lk.uom.cse.msc.rle.xacml3.core.schema.TargetType;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class TargetParserTest {
    @Test
    public void parse() throws Exception {

        TargetParser.parse(createTarget());

    }

    TargetType createTarget() {

        List<AnyOfType> anyOfTypeList = new ArrayList<>();

        List<AllOfType> allOfTypeList1 = new ArrayList<>();

        AttributeDesignatorType resource_id = createAttributeDesignatorType
                ("urn:oasis:names:tc:xacml:1.0:resource:resource-id",
                        "urn:oasis:names:tc:xacml:3.0:attribute-category:resource", "http://www" +
                                ".w3.org/2001/XMLSchema#string");
        AttributeValueType resource_id_allowedItems = createAttributeValueType("allowedItems", "http://www" +
                ".w3.org/2001/XMLSchema#string");

        List<MatchType> matchTypeList = new ArrayList<>();
        matchTypeList.add(createMatchType("urn:oasis:names:tc:xacml:1.0:function:string-equal",
                resource_id, resource_id_allowedItems));
        allOfTypeList1.add(createAllOfType(matchTypeList));

        anyOfTypeList.add(createAnyOfType(allOfTypeList1));


        List<AllOfType> allOfTypeList2 = new ArrayList<>();

        AttributeDesignatorType stay = createAttributeDesignatorType("stay",
                "urn:oasis:names:tc:xacml:1.0:subject-category:access-subject", "http://www" + "" + "" +
                        ".w3.org/2001/XMLSchema#integer");
        AttributeValueType stay_90 = createAttributeValueType("90", "http://www.w3.org/2001/XMLSchema#integer");
        AttributeValueType stay_365 = createAttributeValueType("365", "http://www.w3.org/2001/XMLSchema#integer");

        AttributeDesignatorType value = createAttributeDesignatorType("value",
                "urn:oasis:names:tc:xacml:3.0:attribute-category:resource", "http://www.w3.org/2001/XMLSchema#integer");
        AttributeValueType value_250 = createAttributeValueType("250", "http://www.w3.org/2001/XMLSchema#integer");
        AttributeValueType value_625 = createAttributeValueType("625", "http://www.w3.org/2001/XMLSchema#integer");
        AttributeValueType value_1750 = createAttributeValueType("1750", "http://www.w3.org/2001/XMLSchema#integer");

        List<MatchType> matchTypeList1 = new ArrayList<>();
        matchTypeList1.add(createMatchType("urn:oasis:names:tc:xacml:1.0:function:integer-greater-than-or-equal",
                stay, stay_90));
        matchTypeList1.add(createMatchType("urn:oasis:names:tc:xacml:1.0:function:integer-greater-than-or-equal",
                value, value_250));
        allOfTypeList2.add(createAllOfType(matchTypeList1));

        List<MatchType> matchTypeList2 = new ArrayList<>();
        matchTypeList2.add(createMatchType("urn:oasis:names:tc:xacml:1.0:function:integer-less-than", stay, stay_90));
        matchTypeList2.add(createMatchType("urn:oasis:names:tc:xacml:1.0:function:integer-greater-than-or-equal",
                stay, stay_365));
        matchTypeList2.add(createMatchType("urn:oasis:names:tc:xacml:1.0:function:integer-greater-than-or-equal",
                value, value_625));
        allOfTypeList2.add(createAllOfType(matchTypeList2));

        List<MatchType> matchTypeList3 = new ArrayList<>();
        matchTypeList3.add(createMatchType("urn:oasis:names:tc:xacml:1.0:function:integer-less-than", stay, stay_365));
        matchTypeList3.add(createMatchType("urn:oasis:names:tc:xacml:1.0:function:integer-greater-than-or-equal",
                value, value_1750));
        allOfTypeList2.add(createAllOfType(matchTypeList3));

        anyOfTypeList.add(createAnyOfType(allOfTypeList2));

        TargetType targetType = Mockito.mock(TargetType.class);
        when(targetType.getAnyOf()).thenReturn(anyOfTypeList);

        return targetType;
    }

    AnyOfType createAnyOfType(List<AllOfType> allOfTypeList) {

        AnyOfType anyOfType = Mockito.mock(AnyOfType.class);
        when(anyOfType.getAllOf()).thenReturn(allOfTypeList);

        return anyOfType;
    }

    AllOfType createAllOfType(List<MatchType> matchTypeList) {

        AllOfType allOfType = Mockito.mock(AllOfType.class);
        when(allOfType.getMatch()).thenReturn(matchTypeList);

        return allOfType;
    }

    MatchType createMatchType(String matchId, AttributeDesignatorType attributeDesignatorType, AttributeValueType
            attributeValueType) {

        MatchType matchType = Mockito.mock(MatchType.class);
        when(matchType.getMatchId()).thenReturn(matchId);
        when(matchType.getAttributeDesignator()).thenReturn(attributeDesignatorType);
        when(matchType.getAttributeValue()).thenReturn(attributeValueType);

        return matchType;
    }

    AttributeDesignatorType createAttributeDesignatorType(String id, String category, String dataType) {

        AttributeDesignatorType attributeDesignatorType = Mockito.mock(AttributeDesignatorType.class);
        when(attributeDesignatorType.getAttributeId()).thenReturn(id);
        when(attributeDesignatorType.getCategory()).thenReturn(category);
        when(attributeDesignatorType.getDataType()).thenReturn(dataType);

        return attributeDesignatorType;
    }

    AttributeValueType createAttributeValueType(Object value, String dataType) {

        List<Object> content = new ArrayList<>();
        content.add(value);

        AttributeValueType attributeValueType = Mockito.mock(AttributeValueType.class);
        when(attributeValueType.getContent()).thenReturn(content);
        when(attributeValueType.getDataType()).thenReturn(dataType);

        return attributeValueType;
    }

}