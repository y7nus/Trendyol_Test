package helpers;

public class GirisSayfasi extends BaseHelper {

    public void loginOl(String email, String sifre) {
        sendKeys("emailInput" , email);
        sendKeys("passwordInpur", sifre);
    }



}
