package helpers;

import hooks.ExecutionHook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ElementLocatorReader;

public class BaseHelper {

    public void click(String key) {

        By locator = ElementLocatorReader.get(key);

        try {
            ExecutionHook.wait
                    .until(ExpectedConditions.elementToBeClickable(locator))
                    .click();

        } catch (StaleElementReferenceException e) {

            ExecutionHook.wait
                    .until(ExpectedConditions.elementToBeClickable(locator))
                    .click();
        }
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) ExecutionHook.driver;

        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }


    public void sendKeys(String key, String text) {
        By locator = ElementLocatorReader.get(key);

        var element = ExecutionHook.wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        element.click();
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }


}