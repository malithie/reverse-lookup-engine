package lk.uom.cse.msc.rle;

import lk.uom.cse.msc.rle.builder.GraphBuilder;
import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.exception.XACMLParsingException;
import lk.uom.cse.msc.rle.finder.PolicyFinder;
import lk.uom.cse.msc.rle.model.Graph;
import lk.uom.cse.msc.rle.model.ResultConditions;
import lk.uom.cse.msc.rle.model.Variable;
import lk.uom.cse.msc.rle.parsers.PolicySetParser;
import lk.uom.cse.msc.rle.util.AttributeCategoryConverterUtil;
import lk.uom.cse.msc.rle.util.AttributeConverterUtil;
import lk.uom.cse.msc.rle.util.EvaluationUtils;
import lk.uom.cse.msc.rle.xacml3.core.schema.AttributesType;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicySetType;
import lk.uom.cse.msc.rle.xacml3.core.schema.PolicyType;
import lk.uom.cse.msc.rle.xacml3.core.schema.RequestType;
import lk.uom.cse.msc.rle.xacml3.core.schema.ResponseType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PDP {

    private static final Log log = LogFactory.getLog(PDP.class);

    protected boolean fXACMLParsingError;

    protected boolean fProcessingError;

    protected PolicySetType policySet;

    protected PolicyType policy;

    private PolicyFinder policyFinder;

    private Graph graph;

    public PDP(PolicySetType policySet, PolicyFinder policyFinder) throws XACMLParsingException {

        if (policySet == null) {
            throw new IllegalArgumentException("Policyset argument must not be null");
        }

        this.policySet = policySet;
        this.policy = null;
        this.policyFinder = policyFinder;

    }

    public void initialize() throws XACMLParsingException {

        if (policySet != null) {

            graph = GraphBuilder.build(PolicySetParser.parse(policySet, policyFinder));
        } else {

            throw new RuntimeException("No valid policy set found to initialize.");
        }

    }

    public ResponseType evaluate(RequestType request) {

        resetErrorFlags();

        return null;
    }

    public void review(RequestType request) {

        resetErrorFlags();

        Map<TypeDefinitions.AttributeCategory, List<Variable<?>>> variables;

        try {
            variables = convertRequest(request);

            List<ResultConditions> conditionsList = EvaluationUtils.review(graph, variables);

            conditionsList.forEach(resultConditions -> System.out.println("Result: \n" + resultConditions));

        } catch (XACMLParsingException e1) {
            log.error(e1);
            fXACMLParsingError = true;
        }
    }


    protected void resetErrorFlags() {
        fXACMLParsingError = false;
        fProcessingError = false;
    }

    protected Map<TypeDefinitions.AttributeCategory, List<Variable<?>>> convertRequest(RequestType requestType)
            throws XACMLParsingException {

        Map<TypeDefinitions.AttributeCategory, List<Variable<?>>> variableMap = new HashMap<>();

        for (AttributesType attributesType : requestType.getAttributes()) {

            TypeDefinitions.AttributeCategory attributeCategory = AttributeCategoryConverterUtil.getCategory
                    (attributesType.getCategory());
            variableMap.put(attributeCategory, AttributeConverterUtil.convert(attributesType));
        }

        return variableMap;
    }

}
