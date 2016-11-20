package lk.uom.cse.msc.rle.xacml3.core.schema;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PolicyType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PolicyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Description" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}PolicyIssuer" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}PolicyDefaults" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Target"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}CombinerParameters" minOccurs="0"/>
 *           &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}RuleCombinerParameters" minOccurs="0"/>
 *           &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}VariableDefinition"/>
 *           &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}Rule"/>
 *         &lt;/choice>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}ObligationExpressions" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}AdviceExpressions" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PolicyId" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="Version" use="required" type="{urn:oasis:names:tc:xacml:3.0:core:schema:wd-17}VersionType"
 * />
 *       &lt;attribute name="RuleCombiningAlgId" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="MaxDelegationDepth" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PolicyType", propOrder = {
        "description",
        "policyIssuer",
        "policyDefaults",
        "target",
        "combinerParametersOrRuleCombinerParametersOrVariableDefinition",
        "obligationExpressions",
        "adviceExpressions"
})
public class PolicyType {

    @XmlElement(name = "AdviceExpressions")
    protected AdviceExpressionsType adviceExpressions;
    @XmlElements({
            @XmlElement(name = "CombinerParameters", type = CombinerParametersType.class),
            @XmlElement(name = "RuleCombinerParameters", type = RuleCombinerParametersType.class),
            @XmlElement(name = "VariableDefinition", type = VariableDefinitionType.class),
            @XmlElement(name = "Rule", type = RuleType.class)
    })
    protected List<Object> combinerParametersOrRuleCombinerParametersOrVariableDefinition;
    @XmlElement(name = "Description")
    protected String description;
    @XmlAttribute(name = "MaxDelegationDepth")
    protected BigInteger maxDelegationDepth;
    @XmlElement(name = "ObligationExpressions")
    protected ObligationExpressionsType obligationExpressions;
    @XmlElement(name = "PolicyDefaults")
    protected DefaultsType policyDefaults;
    @XmlAttribute(name = "PolicyId", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String policyId;
    @XmlElement(name = "PolicyIssuer")
    protected PolicyIssuerType policyIssuer;
    @XmlAttribute(name = "RuleCombiningAlgId", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String ruleCombiningAlgId;
    @XmlElement(name = "Target", required = true)
    protected TargetType target;
    @XmlAttribute(name = "Version", required = true)
    protected String version;

    /**
     * Gets the value of the adviceExpressions property.
     *
     * @return possible object is {@link AdviceExpressionsType }
     */
    public AdviceExpressionsType getAdviceExpressions() {
        return adviceExpressions;
    }

    /**
     * Gets the value of the combinerParametersOrRuleCombinerParametersOrVariableDefinition property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the combinerParametersOrRuleCombinerParametersOrVariableDefinition property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCombinerParametersOrRuleCombinerParametersOrVariableDefinition().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list {@link CombinerParametersType } {@link
     * RuleCombinerParametersType } {@link VariableDefinitionType } {@link RuleType }
     */
    public List<Object> getCombinerParametersOrRuleCombinerParametersOrVariableDefinition() {
        if (combinerParametersOrRuleCombinerParametersOrVariableDefinition == null) {
            combinerParametersOrRuleCombinerParametersOrVariableDefinition = new ArrayList<Object>();
        }
        return this.combinerParametersOrRuleCombinerParametersOrVariableDefinition;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the value of the maxDelegationDepth property.
     *
     * @return possible object is {@link BigInteger }
     */
    public BigInteger getMaxDelegationDepth() {
        return maxDelegationDepth;
    }

    /**
     * Gets the value of the obligationExpressions property.
     *
     * @return possible object is {@link ObligationExpressionsType }
     */
    public ObligationExpressionsType getObligationExpressions() {
        return obligationExpressions;
    }

    /**
     * Gets the value of the policyDefaults property.
     *
     * @return possible object is {@link DefaultsType }
     */
    public DefaultsType getPolicyDefaults() {
        return policyDefaults;
    }

    /**
     * Gets the value of the policyId property.
     *
     * @return possible object is {@link String }
     */
    public String getPolicyId() {
        return policyId;
    }

    /**
     * Gets the value of the policyIssuer property.
     *
     * @return possible object is {@link PolicyIssuerType }
     */
    public PolicyIssuerType getPolicyIssuer() {
        return policyIssuer;
    }

    /**
     * Gets the value of the ruleCombiningAlgId property.
     *
     * @return possible object is {@link String }
     */
    public String getRuleCombiningAlgId() {
        return ruleCombiningAlgId;
    }

    /**
     * Gets the value of the target property.
     *
     * @return possible object is {@link TargetType }
     */
    public TargetType getTarget() {
        return target;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is {@link String }
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the adviceExpressions property.
     *
     * @param value allowed object is {@link AdviceExpressionsType }
     */
    public void setAdviceExpressions(AdviceExpressionsType value) {
        this.adviceExpressions = value;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Sets the value of the maxDelegationDepth property.
     *
     * @param value allowed object is {@link BigInteger }
     */
    public void setMaxDelegationDepth(BigInteger value) {
        this.maxDelegationDepth = value;
    }

    /**
     * Sets the value of the obligationExpressions property.
     *
     * @param value allowed object is {@link ObligationExpressionsType }
     */
    public void setObligationExpressions(ObligationExpressionsType value) {
        this.obligationExpressions = value;
    }

    /**
     * Sets the value of the policyDefaults property.
     *
     * @param value allowed object is {@link DefaultsType }
     */
    public void setPolicyDefaults(DefaultsType value) {
        this.policyDefaults = value;
    }

    /**
     * Sets the value of the policyId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setPolicyId(String value) {
        this.policyId = value;
    }

    /**
     * Sets the value of the policyIssuer property.
     *
     * @param value allowed object is {@link PolicyIssuerType }
     */
    public void setPolicyIssuer(PolicyIssuerType value) {
        this.policyIssuer = value;
    }

    /**
     * Sets the value of the ruleCombiningAlgId property.
     *
     * @param value allowed object is {@link String }
     */
    public void setRuleCombiningAlgId(String value) {
        this.ruleCombiningAlgId = value;
    }

    /**
     * Sets the value of the target property.
     *
     * @param value allowed object is {@link TargetType }
     */
    public void setTarget(TargetType value) {
        this.target = value;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is {@link String }
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
