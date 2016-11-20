package lk.uom.cse.msc.rle.parsers;

import lk.uom.cse.msc.rle.builder.ConjunctiveBuilder;
import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.model.nodes.CategoryNode;
import lk.uom.cse.msc.rle.model.nodes.DecisionNode;
import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.model.nodes.PermitDenyNode;
import lk.uom.cse.msc.rle.model.nodes.TrueNode;
import lk.uom.cse.msc.rle.xacml3.core.schema.ConditionType;
import lk.uom.cse.msc.rle.xacml3.core.schema.EffectType;
import lk.uom.cse.msc.rle.xacml3.core.schema.RuleType;
import lk.uom.cse.msc.rle.xacml3.core.schema.TargetType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class RuleParser {

    private static final Log log = LogFactory.getLog(RuleParser.class);

    public static List<Node> parse(RuleType rule) throws XACMLParsingException {

        if (log.isDebugEnabled()) {
            log.debug("Parsing Target element.");
        }

        List<Node> targetResult;
        List<Node> conditionResult;

        TargetType targetType = rule.getTarget();

        if (targetType == null) {
            targetResult = new ArrayList<>();
            targetResult.add(TrueNode.create());
        } else {
            targetResult = TargetParser.parse(targetType);
        }

        ConditionType conditionType = rule.getCondition();

        if (conditionType == null) {
            conditionResult = new ArrayList<>();
            conditionResult.add(TrueNode.create());
        } else {
            conditionResult = ConditionParser.parse(conditionType);
        }

        List<Node> joinedResult = ConjunctiveBuilder.and(targetResult, conditionResult);

        TypeDefinitions.PermissionResult ruleEffect = convertRuleEffect(rule.getEffect());

        for (int i = 0; i < joinedResult.size(); i++) {
            Node node = joinedResult.get(i);
            if (node instanceof DecisionNode) {
                joinedResult.set(i, new PermitDenyNode(ruleEffect));
            } else {
                setEffect(ruleEffect, (CategoryNode) node);
            }
        }

        return joinedResult;

    }

    public static void setEffect(TypeDefinitions.PermissionResult effect, CategoryNode node) {

        CategoryNode currentNode = node;
        while (!(currentNode.getNext() instanceof DecisionNode)) {
            currentNode = (CategoryNode) currentNode.getNext();
        }

        currentNode.setNext(new PermitDenyNode(effect));
    }

    public static TypeDefinitions.PermissionResult convertRuleEffect(EffectType effect) throws XACMLParsingException {

        switch (effect) {
            case PERMIT:
                return TypeDefinitions.PermissionResult.PERMIT;
            case DENY:
                return TypeDefinitions.PermissionResult.DENY;
        }

        throw new XACMLParsingException("Unknown Rule Effect.");
    }

}
