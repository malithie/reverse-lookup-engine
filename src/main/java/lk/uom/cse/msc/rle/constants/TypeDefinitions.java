package lk.uom.cse.msc.rle.constants;

public class TypeDefinitions {

    private TypeDefinitions() {
    }

    public enum AttributeCategory {
        SUBJECT, RESOURCE, ACTION, ENVIRONMENT
    }

    public enum ConditionResult {
        TRUE, FALSE
    }

    public enum PermissionResult {
        PERMIT, DENY
    }

    public enum Operator {
        GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, EQUAL
    }

    public enum DataType {
        STRING, BOOLEAN, INTEGER, DOUBLE, TIME, DATE, DATETIME, ANYURI, HEX, BASE64
    }

    public enum NodeCategory {
        SUBJECT, RESOURCE, LINK
    }
}
