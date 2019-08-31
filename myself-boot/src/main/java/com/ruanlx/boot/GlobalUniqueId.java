package com.ruanlx.boot;

import java.util.UUID;

/**
 * 全局唯一ID，用于日志定位
 * @author ruanlx
 * @ClassName GlobalUniqueId
 * @DateTime 2019/8/31 19:43
 * @Version 1.0
 */
public class GlobalUniqueId {

    public static final ThreadLocal<String> GLOBAL_UNIQUE_ID = new ThreadLocal<>();

    private static String genGlobalUniqueId() {
        String globalUniqueId = UUID.randomUUID().toString().replace("-", "");
        GLOBAL_UNIQUE_ID.set(globalUniqueId);
        return globalUniqueId;
    }

    /**
     * 获取 GlobalUniqueId
     * @return
     */
    public static String get() {
        return GLOBAL_UNIQUE_ID.get();
    }

    /**
     * 设置 GlobalUniqueId
     * @param globalUniqueId
     */
    public static void set(String globalUniqueId) {
        if (globalUniqueId == null || globalUniqueId.equals("") || globalUniqueId.length() == 0) {
            genGlobalUniqueId();
        }
        GLOBAL_UNIQUE_ID.set(globalUniqueId);
    }

    /**
     * 移除 GlobalUniqueId
     */
    public static void clear() {
        GLOBAL_UNIQUE_ID.remove();
    }
}
