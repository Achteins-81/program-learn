package org.achteins81.app.demo;

import org.achteins81.app.base.util.CorpCodeUtils;

/**
 * @author Achteins-81
 * @since 2023-02-13
 */
public class CorpCodeDemo {
    public static void main(String[] args) throws Exception {


        //
//        String code1 = "91530622292785224";
//        String code2 = "97028471650403700000";
//
//        SocialCreditCodeOperation object= new SocialCreditCodeOperation(20562);
        String code = CorpCodeUtils.getOrganizationCode();
        System.out.println(code);
        System.out.println(test(code));
        code = CorpCodeUtils.getBusinessLisenseCode();
        System.out.println(code);
        System.out.println(test1(code));
        code = CorpCodeUtils.getTaxRegistrationCode();
        System.out.println(code);
        System.out.println(test2(code));
        System.out.println(CorpCodeUtils.checkTaxRegistrationCode(code));
        code = CorpCodeUtils.getSocialCreditCode();
        System.out.println(code);
        System.out.println(test3(code));
        System.out.println(CorpCodeUtils.checkSocialCreditCode(code));
//        System.out.println(object.dataVerify(code2));
//        System.out.println("仿真:" + object.simulation(code2));

//        System.out.println("屏蔽:" + object.maskingOut(code2));
//        System.out.println("替换:" + object.substitution(code2));
//        System.out.println("仿真:" + object.simulation(code2));
//        System.out.println("变形:" + object.variance(code2));
//        System.out.println("加密:" + object.encrypt(code2));
    }

    public static boolean test(String data) {
        String code = data.replace("-", "");
        return data.endsWith(CorpCodeUtils.getCheckBit(code.substring(0, code.length() - 1)));
    }

    public static boolean test1(String data) {
        return data.endsWith(String.valueOf(CorpCodeUtils.getBusinesslicenseCheckBit(data.substring(0, data.length() - 1))));
    }

    public static boolean test2(String data) {
        return data.endsWith(String.valueOf(CorpCodeUtils.getCheckBit(data.substring(6, data.length() - 1))));
    }

    public static boolean test3(String data) {
        return data.endsWith(String.valueOf(CorpCodeUtils.getUSCCCheckBit(data.substring(0, data.length() - 1))));
    }
}
