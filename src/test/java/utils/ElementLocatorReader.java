package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ElementLocatorReader {
    private static Map<String, JSONObject> pages = new HashMap<>();

    static {
        try {
            JSONParser parser = new JSONParser();
            File folder = new File("src/test/resources");

            File[] files = folder.listFiles();
            if (files == null) {
                throw new RuntimeException("JSON klasörü bulunamadı");
            }
            for (File file : files) {
                if (file.getName().endsWith(".json")) {
                    String pagename = file.getName().replace(".json", "");

                    JSONObject json = (JSONObject) parser.parse(new FileReader(file));
                    pages.put(pagename, json);
                }
            }


        } catch (Exception e) {
            throw new RuntimeException("JSON'lar yüklenemedi", e);
        }
    }

    public static By get(String key) {

        int foundCount = 0;
        By result = null;

        for (Map.Entry<String, JSONObject> entry : pages.entrySet()) {
            JSONObject pageObject = entry.getValue();
            if (pageObject.containsKey(key)) {
                foundCount++;

                JSONObject element = (JSONObject) pageObject.get(key);

                String by = (String) element.get("by");
                String value = (String) element.get("value");

                result = switch (by) {
                    case "id" -> By.id(value);
                    case "css" -> By.cssSelector(value);
                    case "xpath" -> By.xpath(value);
                    case "name" -> By.name(value);
                    default -> throw new RuntimeException("Hatalı locator tipi:" + by);
                };
            }
        }
        if (foundCount == 0) {
            throw new RuntimeException("Element hiçbir sayfada bulunamadı: " + key);
        }

        if (foundCount > 1) {
            throw new RuntimeException("Aynı key birden fazla sayfada var: " + key);
        }

        return result;
    }
}




