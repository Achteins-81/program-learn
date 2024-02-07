package org.achteins81.app.base.object;

import java.util.HashMap;
import java.util.Map;

public class BaseObject {
    public static Map map1 = new HashMap();

    static {
        map1.put("id", "1");
        map1.put("name", "Aa");
    }
}
