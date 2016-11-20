package lk.uom.cse.msc.rle.test.parsers;

import lk.uom.cse.msc.rle.parsers.MatchParser;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributeDesignatorType;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributeValueType;
import lk.uom.cse.msc.rle.xacml3.core.schema.MatchType;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class MatchParserTest {
    @Test
    public void parse() throws Exception {

        AttributeDesignatorType attributeDesignatorType = Mockito.mock(AttributeDesignatorType.class);
        when(attributeDesignatorType.getAttributeId()).thenReturn("citizenship");
        when(attributeDesignatorType.getCategory()).thenReturn
                ("urn:oasis:names:tc:xacml:1.0:subject-category:access-subject");
        when(attributeDesignatorType.getDataType()).thenReturn("http://www.w3.org/2001/XMLSchema#string");

        AttributeValueType attributeValueType = Mockito.mock(AttributeValueType.class);
        List content = new ArrayList<>();
        content.add("foreigner");
        when(attributeValueType.getContent()).thenReturn(content);
        when(attributeValueType.getDataType()).thenReturn("http://www.w3.org/2001/XMLSchema#string");

        MatchType matchType = Mockito.mock(MatchType.class);
        when(matchType.getMatchId()).thenReturn("urn:oasis:names:tc:xacml:1.0:function:string-equal");
        when(matchType.getAttributeDesignator()).thenReturn(attributeDesignatorType);
        when(matchType.getAttributeValue()).thenReturn(attributeValueType);

        System.out.println(MatchParser.parse(matchType));
    }

}