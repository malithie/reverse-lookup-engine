package lk.uom.cse.msc.rle.util;


import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.exception.XACMLParsingException;

public class DataTypeConverterUtil {

    public static String XACML_3_0_DATA_TYPE_STRING = "http://www.w3.org/2001/XMLSchema#string";

    public static String XACML_3_0_DATA_TYPE_INTEGER = "http://www.w3.org/2001/XMLSchema#integer";

    public static String XACML_3_0_DATA_TYPE_DOUBLE = "http://www.w3.org/2001/XMLSchema#double";

    public static String XACML_3_0_DATA_TYPE_ANYURI = "http://www.w3.org/2001/XMLSchema#anyURI";

    public static String XACML_3_0_DATA_TYPE_BOOLEAN = "http://www.w3.org/2001/XMLSchema#boolean";

    public static Comparable<?> convert(String value, String dataType) throws XACMLParsingException {

        if (dataType.equalsIgnoreCase(XACML_3_0_DATA_TYPE_STRING)) {
            return value;
        } else if (dataType.equalsIgnoreCase(XACML_3_0_DATA_TYPE_INTEGER)) {
            return new Integer(Integer.parseInt(value));
        } else if (dataType.equalsIgnoreCase(XACML_3_0_DATA_TYPE_DOUBLE)) {
            return new Double(Double.parseDouble(value));
        } else if (dataType.equalsIgnoreCase(XACML_3_0_DATA_TYPE_ANYURI)) {
            return value;
        } else {
            throw new XACMLParsingException("Unsupported data type: " + dataType);
        }
    }

    public static TypeDefinitions.DataType getDataType(String dataType) throws XACMLParsingException {
        if (XACML_3_0_DATA_TYPE_STRING.equalsIgnoreCase(dataType)) {
            return TypeDefinitions.DataType.STRING;
        } else if (XACML_3_0_DATA_TYPE_INTEGER.equalsIgnoreCase(dataType)) {
            return TypeDefinitions.DataType.INTEGER;
        } else if (XACML_3_0_DATA_TYPE_DOUBLE.equalsIgnoreCase(dataType)) {
            return TypeDefinitions.DataType.DOUBLE;
        } else if (XACML_3_0_DATA_TYPE_ANYURI.equalsIgnoreCase(dataType)) {
            return TypeDefinitions.DataType.ANYURI;
        } else if (XACML_3_0_DATA_TYPE_BOOLEAN.equalsIgnoreCase(dataType)){
            return TypeDefinitions.DataType.BOOLEAN;
        } else {
            throw new XACMLParsingException("Unsupported data type: " + dataType);
        }
    }


}
