package com.ruanlx.boot.toolkit.lang;

import org.apache.commons.lang3.StringUtils;

/**
 * String 常用的处理方法摘要
 * @author ruanlx
 * @ClassName MyString
 * @DateTime 2019/9/1 16:56
 * @Version 1.0
 */
public class MyString {
    public MyString() {
        super();
    }

    /**
     * null || ""
     * @param charSequence
     * @return
     */
    public static boolean isEmpty(final CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
    public static boolean isNotEmpty(final CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    /**
     * null || "" || 不可见字符
     * @param charSequence
     * @return
     */
    public static boolean isBlank(final CharSequence charSequence) {
        int strLen;
        if (charSequence == null || (strLen = charSequence.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean isNotBlank(final CharSequence charSequence) {
        return !isBlank(charSequence);
    }
}
