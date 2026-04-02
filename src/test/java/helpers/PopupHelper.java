package helpers;

import hooks.ExecutionHook;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementLocatorReader;

import java.time.Duration;


public class PopupHelper {

    public static void clickIfPresent(String key) {
      By locator = ElementLocatorReader.get(key);

        WebDriverWait shorWait = new WebDriverWait(ExecutionHook.driver, Duration.ofSeconds(3));

      try {
         shorWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
      }catch (TimeoutException ignored) {
          // element yoksa bişey yapmaz
      }

    }
}
