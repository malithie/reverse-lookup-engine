package lk.uom.cse.msc.rle.test;

import lk.uom.cse.msc.rle.PDP;
import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.util.EvaluationUtils;
import lk.uom.cse.msc.rle.util.XACMLUtil;
import lk.uom.cse.msc.rle.xacml3.core.schema.ObjectFactory;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicySetType;
import lk.uom.cse.msc.rle.xacml3.core.schema.RequestType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import javax.xml.parsers.ParserConfigurationException;

public class ReverseQueryTest {

    private static final Log log = LogFactory.getLog(EvaluationUtils.class);

    private static final String DUTY_FREE_ALLOWANCE_XACML3_POLICY_FILE =
            "policies/DutyFreeAllowance-policy-xacml-3.xml";

    private PDP initPDP() throws ParserConfigurationException, SAXException, IOException, XACMLParsingException {

        log.info("Initializing Reverse Query Engine.");

        log.info("Parsing XACML PolicySet");

        PolicySetType policySet = XACMLUtil.unmarshalPolicySetType(DUTY_FREE_ALLOWANCE_XACML3_POLICY_FILE);

        log.info("Initializing Reverse Query Engine with parsed Policy Set");
        PDP pdp = new PDP(policySet, null);
        pdp.initialize();

        return pdp;
    }

    private String print(RequestType request) {

        OutputStream os = new ByteArrayOutputStream();
        XACMLUtil.print((new ObjectFactory()).createRequest(request), RequestType.class, os);

        return os.toString();
    }

    private RequestType generatePartialRequestForDutyFreeAllowanceForLiquor() {

        RequestGenerator requestGenerator = new RequestGenerator();
        /*requestGenerator.addSubjectAttribute("citizenship", "http://www.w3.org/2001/XMLSchema#string", Arrays.asList
                (new String[]{"foreigner"}));*/
        requestGenerator.addSubjectAttribute("citizenship", "http://www.w3.org/2001/XMLSchema#string", Arrays.asList
                (new String[]{"local"}));
        requestGenerator.addSubjectAttribute("stay", "http://www.w3.org/2001/XMLSchema#integer", Arrays.asList
                (new String[]{"60"}));
        /*requestGenerator.addResourceAttribute("urn:oasis:names:tc:xacml:1.0:resource:resource-id", "http://www" + ""
                + ".w3.org/2001/XMLSchema#string", Arrays.asList(new String[]{"wine"}));
        requestGenerator.addResourceAttribute("volume", "http://www.w3.org/2001/XMLSchema#double", Arrays.asList(new
                String[]{"2"}));*/
        /*requestGenerator.addResourceAttribute("urn:oasis:names:tc:xacml:1.0:resource:resource-id", "http://www" + ""
                + ".w3.org/2001/XMLSchema#string", Arrays.asList(new String[]{"allowedItems"}));
        requestGenerator.addResourceAttribute("value", "http://www.w3.org/2001/XMLSchema#integer", Arrays.asList(new
                String[]{"200"}));*/

        /*requestGenerator.addResourceAttribute("volume", "http://www.w3.org/2001/XMLSchema#double", Arrays.asList(new
                String[]{"1"}));*/

        return requestGenerator.generate();
    }


    private void evaluatePartialRequestForDutyFreeAllowanceForLiquor(PDP pdp) {

        RequestType request = generatePartialRequestForDutyFreeAllowanceForLiquor();
        log.info("Request : \n\n" + print(request));

        pdp.review(request);
    }

    @Test
    public void run() throws ParserConfigurationException, XACMLParsingException, SAXException, IOException {

        PDP pdp = initPDP();

        evaluatePartialRequestForDutyFreeAllowanceForLiquor(pdp);

    }
}
