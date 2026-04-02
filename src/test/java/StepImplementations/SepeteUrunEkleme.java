package StepImplementations;

import com.thoughtworks.gauge.Step;
import helpers.WindowHelper;

public class SepeteUrunEkleme {
    @Step("Yeni sekmeye geçilir")
    public void YeniSekmeyeGeç() {
        WindowHelper.swictToNewWindow();
    }
}


