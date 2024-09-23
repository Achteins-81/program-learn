package org.achteins81.app.base.util;

import java.util.Collection;
import java.util.Map;

/**
 * @author Achteins-81
 * @since 2021-03-26
 */
public class ValidateUtil {
    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        } else {
            if (value instanceof String) {
                if (((String) value).length() == 0) {
                    return true;
                }
            } else if (value instanceof Collection) {
                if (((Collection) value).isEmpty()) {
                    return true;
                }
            } else if (value instanceof Map) {
                if (((Map) value).size() == 0) {
                    return true;
                }
            } else if (value instanceof String[] && ((String[]) ((String[]) value)).length == 0) {
                return true;
            }

            return false;
        }
    }

    public static boolean isEmpty(Collection c) {
        return c == null || c.isEmpty();
    }

    public static boolean isNotEmpty(Collection c) {
        return c != null && !c.isEmpty();
    }
}
