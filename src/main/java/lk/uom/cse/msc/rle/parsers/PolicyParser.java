package lk.uom.cse.msc.rle.parsers;

import lk.uom.cse.msc.rle.builder.ConjunctiveBuilder;
import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.model.nodes.TrueNode;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicyType;
import lk.uom.cse.msc.rle.xacml3.core.schema.RuleType;
import lk.uom.cse.msc.rle.xacml3.core.schema.TargetType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class PolicyParser {

    private static final Log log = LogFactory.getLog(PolicyParser.class);

    public static List<Node> parse(PolicyType policyType) throws XACMLParsingException {

        if (log.isDebugEnabled()) {
            log.debug("Parsing Policy element.");
        }

        List<Node> targetResult;

        TargetType targetType = policyType.getTarget();

        if (targetType == null) {
            targetResult = new ArrayList<>();
            targetResult.add(TrueNode.create());
        } else {
            targetResult = TargetParser.parse(targetType);
        }


        List<Node> conditionPaths = new ArrayList<>();

        //todo: consider on how to honour rule combining algorithm while merging rule results.
        List<RuleType> ruleTypes = getRules(policyType);

        for (RuleType ruleType : ruleTypes) {
            List<Node> ruleResult = RuleParser.parse(ruleType);
            conditionPaths.addAll(ConjunctiveBuilder.and(targetResult, ruleResult));
        }

        return conditionPaths;
    }

    private static List<RuleType> getRules(PolicyType policyType) throws XACMLParsingException {

        List<Object> objs = policyType.getCombinerParametersOrRuleCombinerParametersOrVariableDefinition();

        if (objs == null || objs.size() == 0) {
            throw new XACMLParsingException("No children rules found in the policy: " + policyType.getPolicyId());
        }

        List<RuleType> rules = new ArrayList<RuleType>();

        for (Object obj : objs) {
            if (obj instanceof RuleType) {
                rules.add((RuleType) obj);
            } else {
                log.info("Unsupport element of type " + obj.getClass() + " inside policy '" + policyType.getPolicyId
                        () + "'");
            }

        }
        if (rules.size() == 0) {
            throw new XACMLParsingException("No children rules found in the policy: '" + policyType.getPolicyId() +
                    "'");
        }

        return rules;
    }
}
