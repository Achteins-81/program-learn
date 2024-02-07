package org.achteins81.app.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class JsonParseDemo {

    public static void main(String[] args) {
        String jsonString = "{'name':'tom','age':8}";
        Map map = (Map) JSONObject.parse(jsonString);
        System.out.println(map.get("age"));
    }
}
