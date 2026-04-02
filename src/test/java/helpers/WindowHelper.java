package helpers;

import hooks.ExecutionHook;

import java.util.Set;

public class WindowHelper {
    private static Set<String> oldWindows;

    public static void storeCurrentWindows() {
        oldWindows = ExecutionHook.driver.getWindowHandles();
    }

    public static void swictToNewWindow() {
        Set<String> newWindows = ExecutionHook.driver.getWindowHandles();

        for (String window : newWindows) {
            if (!oldWindows.contains(window)) {
                ExecutionHook.driver.switchTo().window(window);
                return;
            }
        }
        throw new RuntimeException("Sayfa bulunamadı");
    }

}
