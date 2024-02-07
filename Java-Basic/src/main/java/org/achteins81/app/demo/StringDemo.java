package org.achteins81.app.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDemo {
    public static void main(String[] args) {
        String temp = "b.bankcategory = #yhhb:VARCHAR#";
        temp = temp.replace(":VARCHAR", ",jdbcType=VARCHAR");

        Matcher matcher = getMatcher("\\#(.*?)#", temp);
        while (matcher.find()) {
            String group = matcher.group(1);
            String target = "#" + group + "#";
            String dir = "#{" + group + "}";
            temp = temp.replace(target, dir);
        }

        System.out.println(temp);
    }

    public static Matcher getMatcher(String regex, String source) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        return matcher;

    }
}
