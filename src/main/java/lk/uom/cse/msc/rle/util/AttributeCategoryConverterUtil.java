package lk.uom.cse.msc.rle.util;

import lk.uom.cse.msc.rle.constants.TypeDefinitions;
import lk.uom.cse.msc.rle.exception.UnsupprtedCategoryTypeException;

public class AttributeCategoryConverterUtil {

    private static final String[] SUBJECT_CATEGORY_URIS = new
            String[]{"urn:oasis:names:tc:xacml:1.0:subject-category:access-subject",
            "urn:oasis:names:tc:xacml:1.0:subject-category:recipient-subject",
            "urn:oasis:names:tc:xacml:1.0:subject-category:intermediary-subject",
            "urn:oasis:names:tc:xacml:1.0:subject-category:codebase",
            "urn:oasis:names:tc:xacml:1.0:subject-category:requesting-machine"};

    private static final String RESOURCE_CATEGORY_URI = "urn:oasis:names:tc:xacml:3.0:attribute-category:resource";

    private static final String ACTION_CATEGORY_URI = "urn:oasis:names:tc:xacml:3.0:attribute-category:action";

    private static final String ENVIRONMENT_CATEGORY_URI =
            "urn:oasis:names:tc:xacml:3.0:attribute-category:environment";

    public static TypeDefinitions.AttributeCategory getCategory(String attributeCategoryURI) {

        if (isSubjectCategory(attributeCategoryURI)) {
            return TypeDefinitions.AttributeCategory.SUBJECT;
        }

        if (RESOURCE_CATEGORY_URI.equals(attributeCategoryURI)) {
            return TypeDefinitions.AttributeCategory.RESOURCE;
        }

        if (ACTION_CATEGORY_URI.equals(attributeCategoryURI)) {
            return TypeDefinitions.AttributeCategory.ACTION;
        }

        if (ENVIRONMENT_CATEGORY_URI.equals(attributeCategoryURI)) {
            return TypeDefinitions.AttributeCategory.ENVIRONMENT;
        }

        throw new UnsupprtedCategoryTypeException("Unknown attribute category.");
    }

    private static boolean isSubjectCategory(String attributeCategoryURI) {
        for (String uri : SUBJECT_CATEGORY_URIS) {
            if (uri.equals(attributeCategoryURI)) {
                return true;
            }
        }

        return false;
    }
}
