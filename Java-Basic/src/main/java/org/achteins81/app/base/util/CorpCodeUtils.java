package org.achteins81.app.base.util;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成企业组织机构代码、营业执照代码、税务登记号码、统一社会信用代码并校验
 *
 * @author Achteins-81
 * @see <a href="https://blog.csdn.net/xiaoerbuyu1233/article/details/122898677">source</a>
 * @since 2022-09-17
 */
public class CorpCodeUtils {

    /**
     * 获取随机英文字母和数据
     *
     * @param length
     * @param status
     * @return
     */
    public static String getCharAndNumr(int length, int status) {
        SecureRandom random = new SecureRandom();
        StringBuffer valSb = new StringBuffer();
        String charStr = "0123456789abcdefghijklmnopqrstuvwxy";
        if (status == 1) {
            charStr = "0123456789";
        }
        if (status == 2) {
            charStr = "0123456789";
        }
        if (status == 3) {
            charStr = "0123456789ABCDEFGHJKLMNPQRTUWXY";
        }
        int charLength = charStr.length();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charLength);
            if (status == 1 && index == 0) {
                index = 3;
            }
            valSb.append(charStr.charAt(index));
        }
        return valSb.toString();
    }

    /**
     * @param st
     * @return
     */
    public static int getAsc(String st) {
        byte[] gc = st.getBytes();
        int ascNum = (int) gc[0] - 55;
        return ascNum;
    }

    /**
     * 获取 营业执照注册号的校验码
     *
     * @param ints
     * @return bit
     */
    public static int getCheckCode(int[] ints) {
        if (null != ints && ints.length > 1) {
            int ti = 0;
            int si = 0;// pi|11+ti
            int cj = 0;// （si||10==0？10：si||10）*2
            int pj = 10;// pj=cj|11==0?10:cj|11
            for (int i = 0; i < ints.length; i++) {
                ti = ints[i];
                pj = (cj % 11) == 0 ? 10 : (cj % 11);
                si = pj + ti;
                cj = (0 == si % 10 ? 10 : si % 10) * 2;
                if (i == ints.length - 1) {
                    pj = (cj % 11) == 0 ? 10 : (cj % 11);
                    return pj == 1 ? 1 : 11 - pj;
                }
            }
        }
        return -1;

    }

    /**
     * 校验 营业执照注册号
     *
     * @param businesslicense
     * @return
     */
    public static int getBusinesslicenseCheckBit(String businesslicense) {
        if (businesslicense.length() != 14) {
            return 0;
        }

        char[] chars = businesslicense.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return getCheckCode(ints);
    }

    public static boolean checkTaxRegistrationCode(String data) {
        String regex = "[1-8][1-6]\\d{4}[a-zA-Z0-9]{9}$";
        return data.matches(regex);
    }

    public static String getCheckBit(String code) {
        String yz = "";
        int[] in = {3, 7, 9, 10, 5, 8, 4, 2};
        int a = 0;
        for (int i = 0; i < in.length; i++) {
            if (code.substring(i, i + 1).matches("[A-Z]")) {
                a += in[i] * getAsc(code.substring(i, i + 1));
            } else {
                a += in[i] * Integer.parseInt(code.substring(i, i + 1));
            }
        }
        int c9 = 11 - a % 11;
        if (c9 == 10) {
            yz = "X";
        } else if (c9 == 11) {
            yz = "0";
        } else {
            yz = c9 + "";
        }

        return yz;
    }

    /**
     * 生成企业组织机构代码
     *
     * @return
     */
    public static String getOrganizationCode() {
        int[] in = {3, 7, 9, 10, 5, 8, 4, 2};
        String data = "";
        String yz = "";
        int a = 0;
        //随机生成英文字母和数字
        for (int j : in) {
            String word = getCharAndNumr(1, 0).toUpperCase();
            if (word.matches("[A-Z]")) {
                a += j * getAsc(word);
            } else {
                a += j * Integer.parseInt(word);
            }
            data += word;
        }
        //确定序列
        int c9 = 11 - a % 11;
        //判断c9大小，安装 X 0 或者C9
        if (c9 == 10) {
            yz = "X";
        } else if (c9 == 11) {
            yz = "0";
        } else {
            yz = c9 + "";
        }
        data += "-" + yz;
        return data.toUpperCase();
    }

    public static char getUSCCCheckBit(String businessCode) {
        if (("".equals(businessCode)) || businessCode.length() != 17) {
            return 0;
        }
        String baseCode = "0123456789ABCDEFGHJKLMNPQRTUWXY";
        char[] baseCodeArray = baseCode.toCharArray();
        Map<Character, Integer> codes = new HashMap<Character, Integer>();
        for (int i = 0; i < baseCode.length(); i++) {
            codes.put(baseCodeArray[i], i);
        }
        char[] businessCodeArray = businessCode.toCharArray();

        int[] wi = {1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            Character key = businessCodeArray[i];
            if (baseCode.indexOf(key) == -1) {
                return 0;
            }
            sum += (codes.get(key) * wi[i]);
        }
        int value = 31 - sum % 31;
        if (value == 31) {
            value = 0;
        }
        return baseCodeArray[value];
    }

    public static boolean checkSocialCreditCode(String data) {
        if (data == null) {
            return false;
        }
        if (data.length() != 18) {
            return false;
        }
        if (!data.matches("[a-zA-Z0-9]+")) {
            return false;
        }
        String regex = "^([159Y]{1})([1239]{1})([0-9ABCDEFGHJKLMNPQRTUWXY]{6})([0-9ABCDEFGHJKLMNPQRTUWXY]{9})([0-90-9ABCDEFGHJKLMNPQRTUWXY])$";
        return data.matches(regex);
    }

    /**
     * 生成营业执照代码
     *
     * @return
     */
    public static String getBusinessLisenseCode() {
        String data = "";
        //随机生成14位数字
        String number = getCharAndNumr(14, 1);
        //获取校验后的第15位
        String yz = getBusinesslicenseCheckBit(number) + "";
        //拼凑
        data = number + yz;
        return data.toUpperCase();
    }

    /**
     * 生成税务登记号码
     *
     * @return
     */
    public static String getTaxRegistrationCode() {
        String data = "";
        String first = "73" + getCharAndNumr(4, 2);
        String end = getOrganizationCode();
        data = first + end;
        data = data.toUpperCase().replaceAll("-", "");
        if (!checkTaxRegistrationCode(data.toUpperCase())) {
            getTaxRegistrationCode();
        }
        return data;
    }

    /**
     * 生成统一社会信用代码
     *
     * @return
     */
    public static String getSocialCreditCode() {
        String data = "";
        String first = "Y2" + getCharAndNumr(6, 3) + getCharAndNumr(9, 3);
        String end = String.valueOf(getUSCCCheckBit(first));
        data = first + end;
        if (!checkSocialCreditCode(data.toUpperCase())) {
            getSocialCreditCode();
        }
        return data.toUpperCase();
    }

}
