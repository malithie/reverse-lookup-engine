package lk.uom.cse.msc.rle.test;

import lk.uom.cse.msc.rle.xacml3.core.schema.AttributeType;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributeValueType;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributesType;
import lk.uom.cse.msc.rle.xacml3.core.schema.ObjectFactory;
import lk.uom.cse.msc.rle.xacml3.core.schema.RequestType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestGenerator {


    protected Map<String, List<String>> subjAttrMapperValues;
    protected Map<String, List<String>> resAttrMapperValues;
    protected Map<String, List<String>> actAttrMapperValues;
    protected Map<String, List<String>> envAttrMapperValues;

    protected Map<String, String> attrMapperDataTypes;

    protected ObjectFactory factory;

    public RequestGenerator() {
        subjAttrMapperValues = new HashMap<>();
        resAttrMapperValues = new HashMap<>();
        actAttrMapperValues = new HashMap<>();
        envAttrMapperValues = new HashMap<>();

        attrMapperDataTypes = new HashMap<>();

        factory = new ObjectFactory();
    }

    public void addSubjectAttribute(String attrId, String dataType, List<String> attrValues) {
        List<String> values = new ArrayList<String>(attrValues);

        subjAttrMapperValues.put(attrId, values);
        attrMapperDataTypes.put(attrId, dataType);
    }

    public void addResourceAttribute(String attrId, String dataType, List<String> attrValues) {
        List<String> values = new ArrayList<String>(attrValues);

        resAttrMapperValues.put(attrId, values);
        attrMapperDataTypes.put(attrId, dataType);
    }

    public void addActionAttribute(String attrId, String dataType, List<String> attrValues) {
        List<String> values = new ArrayList<String>(attrValues);

        actAttrMapperValues.put(attrId, values);
        attrMapperDataTypes.put(attrId, dataType);
    }

    public void addEnvAttribute(String attrId, String dataType, List<String> attrValues) {
        List<String> values = new ArrayList<String>(attrValues);

        envAttrMapperValues.put(attrId, values);
        attrMapperDataTypes.put(attrId, dataType);
    }

    public RequestType generate() {

        RequestType request = factory.createRequestType();

        AttributesType subjectAttributes = createAttributeCategory("urn:oasis:names:tc:xacml:1.0:subject-category:access-subject");
        for (String attrId : subjAttrMapperValues.keySet()) {
            AttributeType attr = createAttribute(attrId, subjAttrMapperValues.get(attrId));
            subjectAttributes.getAttribute().add(attr);
        }
        request.getAttributes().add(subjectAttributes);

        AttributesType resourceAttributes = createAttributeCategory("urn:oasis:names:tc:xacml:3.0:attribute-category:resource");
        for (String attrId : resAttrMapperValues.keySet()) {
            AttributeType attr = createAttribute(attrId, resAttrMapperValues.get(attrId));
            resourceAttributes.getAttribute().add(attr);
        }
        request.getAttributes().add(resourceAttributes);

        AttributesType actionAttributes = createAttributeCategory("urn:oasis:names:tc:xacml:3.0:attribute-category:action");
        for (String attrId : actAttrMapperValues.keySet()) {
            AttributeType attr = createAttribute(attrId, actAttrMapperValues.get(attrId));
            actionAttributes.getAttribute().add(attr);
        }
        request.getAttributes().add(actionAttributes);

        AttributesType environmentAttributes = createAttributeCategory("urn:oasis:names:tc:xacml:3.0:attribute-category:environment");
        for (String attrId : envAttrMapperValues.keySet()) {
            AttributeType attr = createAttribute(attrId, envAttrMapperValues.get(attrId));
            environmentAttributes.getAttribute().add(attr);
        }
        request.getAttributes().add(environmentAttributes);

        return request;
    }

    protected AttributeType createAttribute(String attrId, List<String> values) {

        AttributeType attr = factory.createAttributeType();
        attr.setAttributeId(attrId);
        for (String value : values) {
            AttributeValueType attrValue = factory.createAttributeValueType();
            attrValue.setDataType(this.attrMapperDataTypes.get(attrId));
            attrValue.getContent().add(value);
            attr.getAttributeValue().add(attrValue);
        }

        return attr;
    }
    
    protected AttributesType createAttributeCategory(String category) {
        
        AttributesType attrs = factory.createAttributesType();
        attrs.setCategory(category);
        return attrs;
    }
}
