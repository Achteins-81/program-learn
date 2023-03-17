package org.achteins81.app.base.constant;

/**
 * 基础常量
 *
 * @author Achteins-81
 * @since 2023-01-26
 */
public class BaseConstant {
    /**
     * 数字字符
     */
    public static final String NUMBER_STRING = "0123456789";
    /**
     * 小写字母字符
     */
    public static final String LOWER_CAPITAL_STRING = "abcdefghijklmnopqrstuvwxyz";
    /**
     * 特殊字符
     */
    public static final String SPECIAL_CHARACTER_STRING = "~!@#$%^&*()_+/-=[]{};'<>?.";

    /**
     * 国际无线电通话拼写字母，(International) Radiotelephony Spelling Alphabet
     *
     * @see <a href="https://en.wikipedia.org/wiki/NATO_phonetic_alphabet">source1</a>
     * and
     * <a href="https://baike.baidu.com/item/%E5%8C%97%E7%BA%A6%E9%9F%B3%E6%A0%87%E5%AD%97%E6%AF%8D/4157760">source2</a>
     */
    public static final String[] RADIOTELEPHONY_SPELLING_ALPHABET = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot",
            "Golf", "Hotel", "India", "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo",
            "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "Xray", "Yankee", "Zulu"};

    /**
     * 天干
     */
    public static final String HEAVENLY_STEMS = "甲乙丙丁戊己庚辛壬癸";
    /**
     * 天干，数组形式
     */
    public static final String[] HEAVENLY_STEMS_ARRAY = HEAVENLY_STEMS.split("");
    /**
     * 地支
     */
    public static final String EARTHLY_BRANCHES = "子丑寅卯辰巳午未申酉戌亥";
    /**
     * 地支，数组形式
     */
    public static final String[] EARTHLY_BRANCHES_ARRAY = EARTHLY_BRANCHES.split("");

    /**
     * 月份 in English
     */
    public static final String[] MONTHS_ENGLISH = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    /**
     * 月份 auf Deutsch
     */
    public static final String[] MONATE_DEUTSCH = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli",
            "August", "September", "Oktober", "November", "Dezember"};

    /**
     * 星座
     * <br/>
     * <table>
     * <tr>
     * ♈	白羊座	Aries
     * </tr>
     * <tr>
     * ♉	金牛座	Taurus
     * </tr>
     * <tr>
     * ♊	双子座	Gemini
     * </tr>
     * <tr>
     * ♋	巨蟹座	Cancer
     * </tr>
     * <tr>
     * ♌	狮子座	Leo
     * </tr>
     * <tr>
     * ♍	处女座	Virgo
     * </tr>
     * <tr>
     * ♎	天秤座	Libra
     * </tr>
     * <tr>
     * ♏	天蝎座	Scorpio
     * </tr>
     * <tr>
     * ♐	射手座	Sagittarius
     * </tr>
     * <tr>
     * ♑	摩羯座	Capricorn
     * </tr>
     * <tr>
     * ♒	水瓶座	Aquarius
     * </tr>
     * <tr>
     * ♓	双鱼座	Pisces
     * </tr>
     * </table>
     */
    public static final String[] TWELVE_CONSTELLATIONS = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
            "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"};
}
