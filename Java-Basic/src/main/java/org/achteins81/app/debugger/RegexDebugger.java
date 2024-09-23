package org.achteins81.app.debugger;

import org.achteins81.app.base.util.ValidateUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式调试
 *
 * @author Achteins-81
 * @since 2021-04-19
 */
public class RegexDebugger {
    public static void main(String[] args) {
        String content = "（缴款登记吗：JK210319033683）";
//        busNumMatcherDebugger();
//        busNumMatcherInNC(content, null);
//        busNumMatcherInFS(content, null);
        String pwd = "1 _?，2";
        passwordRegexMatcher(pwd, null);
    }

    public static void busNumMatcherDebugger() {
        String reg = "(CJBJ)[0-9]+((单位|个人)(部分))";
        String content = "abcCJBJ210224 000343个人部分123";
        boolean isMatch = false;
        String jkdjh = "";
        String matchStr;
//        System.out.println(content.matches(reg));

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            matchStr = matcher.group();
            int index1 = matchStr.indexOf("单位部分");
            int index2 = matchStr.indexOf("个人部分");
            matchStr = matchStr.substring(0, (index1 >= 0) ? index1 : index2);
            if (ValidateUtil.isEmpty(jkdjh)) {
                jkdjh = matchStr;
                isMatch = true;
            } else if (!jkdjh.equals(matchStr)) {
                isMatch = false;
            }
        }
        if (isMatch) {
            System.out.println(jkdjh);
        } else {
            System.out.println("no match");
        }
    }

    public static Map busNumMatcherInNC(String content, String regStr) {
        if (ValidateUtil.isEmpty(regStr)) {
            regStr = "(CJBJ)[0-9]+((单位|个人)(部分))";
        }
        Map result = new HashMap();
        String busNum = "";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        String matchStr;
        int index1;
        int index2;
        boolean isMatch = false;
        while (matcher.find()) {
            matchStr = matcher.group();
            index1 = matchStr.indexOf("单位部分");
            index2 = matchStr.indexOf("个人部分");
            matchStr = matchStr.substring(0, (index1 >= 0) ? index1 : index2);
            if (ValidateUtil.isEmpty(busNum)) {
                busNum = matchStr;
                isMatch = true;
            } else if (!busNum.equals(matchStr)) {//存在不同的缴款登记号时，不进行匹配
                isMatch = false;
            }
        }
        result.put("isMatch", isMatch);
        if (isMatch) {
            result.put("busNum", busNum);
        }
        return result;
    }

    public static Map busNumMatcherInFS(String content, String regStr) {
        Map result = new HashMap();
        String busNum = "";
        if (ValidateUtil.isEmpty(regStr)) {
            regStr = "(JK)[0-9]+";
        }
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        String matchStr;
        boolean isMatch = false;
        while (matcher.find()) {
            matchStr = matcher.group();
            if (ValidateUtil.isEmpty(busNum)) {
                busNum = matchStr;
                isMatch = true;
            } else if (!busNum.equals(matchStr)) {//存在不同的缴款登记号时，不进行匹配
                isMatch = false;
            }
        }
        result.put("isMatch", isMatch);
        if (isMatch) {
            result.put("busNum", busNum);
        }
        System.out.println(result.toString());
        return result;
    }

    public static void passwordRegexMatcher(String pwd, String regEx) {
        regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(pwd);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
