package com.cseazeem.PinggyAuthAPI.config;


public class ThreadLocalStorage {
    private static final ThreadLocal<String> pinggyAuthHeader = new ThreadLocal<>();

    public static void setPinggyAuthHeader(String value) {
        pinggyAuthHeader.set(value);
    }

    public static String getPinggyAuthHeader() {
        return pinggyAuthHeader.get();
    }

    public static void clear() {
        pinggyAuthHeader.remove();
    }
}
