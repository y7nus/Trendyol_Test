package StepImplementations;

import com.thoughtworks.gauge.Step;
import hooks.ExecutionHook;
import helpers.PopupHelper;

public class Login {

    @Step("<url> adresine gidilir")
    public void siteyeGit(String url) {
        ExecutionHook.driver.get(url);
    }
}