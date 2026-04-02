package StepImplementations;

import com.thoughtworks.gauge.Step;
import helpers.*;

public class OrtakStepler {



    @Step("<button> butonuna tıklanır")
    public void clickButton(String button) {
        WindowHelper.storeCurrentWindows();
        new BaseHelper().click(button);
    }

    @Step("<element> alanına <text> girilir")
    public void sendKeys(String element, String text) throws InterruptedException {
        Thread.sleep(2000);
        new BaseHelper().sendKeys(element,text);
    }

    @Step("Eğer varsa <buton> butonuna tıkla")
    public void PopupKapat(String button) {
        PopupHelper.clickIfPresent(button);
    }





}
