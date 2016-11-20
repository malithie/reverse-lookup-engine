package lk.uom.cse.msc.rle.parsers;

import lk.uom.cse.msc.rle.builder.ConjunctiveBuilder;
import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.finder.PolicyFinder;
import lk.uom.cse.msc.rle.model.nodes.Node;
import lk.uom.cse.msc.rle.model.nodes.TrueNode;
import lk.uom.cse.msc.rle.xacml3.core.schema.IdReferenceType;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicySetType;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicyType;
import lk.uom.cse.msc.rle.xacml3.core.schema.TargetType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;

public class PolicySetParser {

    private static final Log log = LogFactory.getLog(PolicySetParser.class);


    public static List<Node> parse(PolicySetType policySetType, PolicyFinder policyFinder) throws
            XACMLParsingException {

        if (log.isDebugEnabled()) {
            log.debug("Parsing Policy element.");
        }

        List<Node> targetResult;

        TargetType targetType = policySetType.getTarget();

        if (targetType == null) {
            targetResult = new ArrayList<>();
            targetResult.add(TrueNode.create());
        } else {
            targetResult = TargetParser.parse(targetType);
        }

        List<Object> policySetChildren = getChilden(policySetType, policyFinder);

        List<Node> result = new ArrayList<>();

        for (Object policySetChild : policySetChildren) {

            if (policySetChild instanceof PolicyType) {
                result.addAll(ConjunctiveBuilder.and(targetResult, PolicyParser.parse((PolicyType) policySetChild)));
            } else if (policySetChild instanceof PolicySetType) {
                result.addAll(ConjunctiveBuilder.and(targetResult, parse((PolicySetType) policySetChild,
                        policyFinder)));
            } else {
                throw new XACMLParsingException("Unknown child for PolicySet type");
            }
        }

        return result;
    }

    private static void addChildrenByRef(IdReferenceType idReference, PolicyFinder policyFinder, List<Object>
            children) {

        String id = idReference.getValue();
        if (id == null || id.isEmpty()) {
            if (log.isDebugEnabled()) {
                log.debug("Invalid reference to policy or policyset ");
            }
            return;
        }

        Object obj = policyFinder.lookup(id);

        if (obj instanceof PolicyType || obj instanceof PolicySetType) {
            children.add(obj);
        } else {
            if (log.isDebugEnabled()) {
                log.debug("No policy/policyset found for the reference " + id);
            }
        }
    }

    private static List<Object> getChilden(PolicySetType policySetType, PolicyFinder policyFinder) throws
            XACMLParsingException {

        List<JAXBElement<?>> objs = policySetType.getPolicySetOrPolicyOrPolicySetIdReference();

        if (objs == null || objs.size() == 0) {
            throw new XACMLParsingException("No children policy/policyset found in the policyset " + policySetType
                    .getPolicySetId());
        }

        List<Object> children = new ArrayList<>();

        for (JAXBElement<?> obj : objs) {
            if (obj != null) {
                Object objValue = obj.getValue();
                if (objValue instanceof PolicyType || objValue instanceof PolicySetType) {
                    children.add(objValue);
                } else if (objValue instanceof IdReferenceType) {
                    if (policyFinder != null) {
                        addChildrenByRef((IdReferenceType) objValue, policyFinder, children);
                    } else {
                        if (log.isDebugEnabled()) {
                            log.debug("No policy finder found to lookup reference in the policy: " + policySetType
                                    .getPolicySetId());
                        }
                    }
                } else {
                    if (log.isDebugEnabled()) {
                        // we ignore other types in this version: e.g. references to rule
                        log.info("Unsupported object type:" + objValue.getClass() + "inside the policyset '" +
                                policySetType.getPolicySetId() + "'");
                    }
                }
            }
        }

        if (children.size() == 0) {
            throw new XACMLParsingException("No children policy/policyset found in the policy: " + policySetType
                    .getPolicySetId());
        }

        return children;
    }

}
