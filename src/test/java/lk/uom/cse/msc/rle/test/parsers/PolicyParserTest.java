package lk.uom.cse.msc.rle.test.parsers;

import lk.uom.cse.msc.rle.parsers.PolicyParser;
import lk.uom.cse.msc.rle.util.XACMLUtil;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicySetType;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicyType;
import org.junit.Test;

import java.util.List;
import javax.xml.bind.JAXBElement;

public class PolicyParserTest {

    private static final String DUTY_FREE_ALLOWANCE_XACML3_POLICY_FILE =
            "policies/DutyFreeAllowance-policy-xacml-3.xml";

    @Test
    public void parse() throws Exception {

        PolicySetType policySet = XACMLUtil.unmarshalPolicySetType(DUTY_FREE_ALLOWANCE_XACML3_POLICY_FILE);

        List<JAXBElement<?>> objs = policySet.getPolicySetOrPolicyOrPolicySetIdReference();

        PolicyType policyType = null;

        for (JAXBElement<?> obj : objs) {
            if (obj != null) {
                Object objValue = obj.getValue();
                if (objValue instanceof PolicyType) {
                    policyType = (PolicyType) objValue;
                    break;
                }
            }
        }

        PolicyParser.parse(policyType);
    }

}