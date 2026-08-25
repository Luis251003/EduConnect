package com.luis.springboot.EduConnect.context;

public class AppContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setAppName(String appName) {
        contextHolder.set(appName);
    }

    public static String getAppName() {
        return contextHolder.get();
    }

    public static void limpiar() {
        contextHolder.remove();
    }
}
