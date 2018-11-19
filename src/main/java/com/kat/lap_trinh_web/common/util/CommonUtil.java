package com.kat.lap_trinh_web.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CommonUtil {
    public static void main(String[] args){
        try {
            System.out.println(rfc5987_encode("abc"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public static boolean isNull(String args){
        return args == null || args.equals("") ? true : false;
    }

    public static String rfc5987_encode(final String s) throws UnsupportedEncodingException {
        final byte[] s_bytes = s.getBytes("UTF-8");
        final int len = s_bytes.length;
        final StringBuilder sb = new StringBuilder(len << 1);
        final char[] digits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        final byte[] attr_char = {'!','#','$','&','+','-','.','0','1','2','3','4','5','6','7','8','9',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','^','_','`',
                'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','|', '~'};
        for (int i = 0; i < len; ++i) {
            final byte b = s_bytes[i];
            if (Arrays.binarySearch(attr_char, b) >= 0)
                sb.append((char) b);
            else {
                sb.append('%');
                sb.append(digits[0x0f & (b >>> 4)]);
                sb.append(digits[b & 0x0f]);
            }
        }

        return sb.toString();
    }

    public static String getObjectString(Object inputObj){
        if(inputObj == null){
            return null;
        }else{
            return String.valueOf(inputObj);
        }
    }
}
