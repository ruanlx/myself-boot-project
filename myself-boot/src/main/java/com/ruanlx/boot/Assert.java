package com.ruanlx.boot;

/**
 * @author ruanlx
 * @ClassName Assert
 * @DateTime 2019/8/31 16:42
 * @Version 1.0
 */
public class Assert<E extends Exception> {

    public void isTrue(boolean expression, String message) {
        if (!expression) {
            //throw new E(message);
        }
    }
}
