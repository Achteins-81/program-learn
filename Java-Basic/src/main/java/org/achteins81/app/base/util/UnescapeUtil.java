package org.achteins81.app.base.util;

public class UnescapeUtil {
    public static void main(String[] args) throws Exception {
        String str = "uX3&#x24;ik!vhPvN7ZaFn8!7&#x24;ERnvQ";
        String result = decode(str);
        System.out.println("结果: " + result);
    }

    public static String unescape(String src) {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        src = src.replace("&#x", "%u").replace(";", "");
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    public static String ConvertDecimalNCRToString(String hex) {
        String myString = hex.replace("&#", "");
        String[] split = myString.split(";");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            sb.append((char) Integer.parseInt(split[i]));
        }
        return sb.toString();
    }

    public static String decode(String str) {
        StringBuffer sb = new StringBuffer();
        int i1 = 0;
        int i2 = 0;


        while (i2 < str.length()) {
            i1 = str.indexOf("&#", i2);
            if (i1 == -1) {
                sb.append(str.substring(i2));
                break;
            }
            sb.append(str.substring(i2, i1));
            i2 = str.indexOf(";", i1);
            if (i2 == -1) {
                sb.append(str.substring(i1));
                break;
            }


            String tok = str.substring(i1 + 2, i2);
            try {
                int radix = 10;
                if (tok.charAt(0) == 'x' || tok.charAt(0) == 'X') {
                    radix = 16;
                    tok = tok.substring(1);
                }
                sb.append((char) Integer.parseInt(tok, radix));
            } catch (NumberFormatException exp) {
                //sb.append(unknownCh);
            }
            i2++;
        }
        return sb.toString();
    }
}
