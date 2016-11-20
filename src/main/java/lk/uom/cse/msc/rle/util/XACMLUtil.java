package lk.uom.cse.msc.rle.util;

import lk.uom.cse.msc.rle.xacml3.core.schema.ObjectFactory;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicySetType;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicyType;
import lk.uom.cse.msc.rle.xacml3.core.schema.RequestType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

public class XACMLUtil {

    public static PolicySetType unmarshalPolicySetType(InputStream istream)
            throws ParserConfigurationException, SAXException, IOException {
        Document doc = readXML(istream);
        Element xmlDom = doc.getDocumentElement();

        PolicySetType policyset = unmarshalPolicySetType(xmlDom);
        if (policyset != null && policyset.getPolicySetId() != null) {
            return policyset;
        }

        return null;
    }

    public static PolicySetType unmarshalPolicySetType(String policysetFile)
            throws ParserConfigurationException, SAXException, IOException {
        Document doc = readXML(policysetFile);
        Element xmlDom = doc.getDocumentElement();

        return unmarshalPolicySetType(xmlDom);
    }

    /**
     * @param
     * @return
     */
    private static PolicySetType unmarshalPolicySetType(Element dom) {
        return unmarshall(PolicySetType.class, dom);
    }

    private static <T> T unmarshall(Class<T> cls, Element dom) {

        try {
            JAXBContext jc = JAXBContext.newInstance(cls);
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            JAXBElement<T> jaxbObject = unmarshaller.unmarshal(dom, cls);

            return jaxbObject.getValue();
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static Document readXML(InputStream istream)
            throws ParserConfigurationException, SAXException, IOException {
        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory
                .newInstance();
        dbf.setNamespaceAware(true);

        javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(istream);

        return doc;
    }

    public static Document readXML(String xmlFile)
            throws ParserConfigurationException, SAXException, IOException {
        javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory
                .newInstance();
        dbf.setNamespaceAware(true);

        javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(new FileInputStream(xmlFile));

        return doc;
    }


    public static RequestType unmarshalRequestType(InputStream istream)
            throws ParserConfigurationException, SAXException, IOException {
        Document doc = readXML(istream);
        Element xmlDom = doc.getDocumentElement();

        return unmarshalRequestType(xmlDom);
    }

    public static RequestType unmarshalRequestType(Element xmlDom) {
        return unmarshall(RequestType.class, xmlDom);
    }

    public static PolicyType unmarshalPolicyType(InputStream istream)
            throws ParserConfigurationException, SAXException, IOException {
        Document doc = readXML(istream);
        Element xmlDom = doc.getDocumentElement();

        return unmarshalPolicyType(xmlDom);
    }

    public static PolicyType unmarshalPolicyType(String policyFile)
            throws ParserConfigurationException, SAXException, IOException {
        Document doc = readXML(policyFile);
        Element xmlDom = doc.getDocumentElement();

        PolicyType policy = unmarshalPolicyType(xmlDom);
        if (policy != null && policy.getPolicyId() != null) {
            return policy;
        }

        return null;
    }

    private static PolicyType unmarshalPolicyType(Element xmlDom) {
        return unmarshall(PolicyType.class, xmlDom);
    }

    public static RequestType unmarshalRequestType(String xmlFile)
            throws ParserConfigurationException, SAXException, IOException {
        Document doc = readXML(xmlFile);
        Element xmlDom = doc.getDocumentElement();

        return unmarshalRequestType(xmlDom);
    }

    public static <T> void print(JAXBElement<T> jaxbElement, Class<T> cls,
                                 OutputStream os) {
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(cls);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            m.marshal(jaxbElement, os);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String print(RequestType request) {

        OutputStream os = new ByteArrayOutputStream();

        print((new ObjectFactory()).createRequest(request),
                RequestType.class, os);

        return os.toString();
    }
}
