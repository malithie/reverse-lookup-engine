package lk.uom.cse.msc.rle.test.parsers;

import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.parsers.PolicySetParser;
import lk.uom.cse.msc.rle.util.XACMLUtil;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicySetType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PolicySetParserTest {

    private static final String DUTY_FREE_ALLOWANCE_XACML3_POLICY_FILE =
            "policies/DutyFreeAllowance-policy-xacml-3.xml";

    @Test
    public void parse() throws Exception {

        PolicySetType policySet = XACMLUtil.unmarshalPolicySetType(DUTY_FREE_ALLOWANCE_XACML3_POLICY_FILE);

        List<Node> conditionPaths = PolicySetParser.parse(policySet, null);

        System.out.println();

    }

}