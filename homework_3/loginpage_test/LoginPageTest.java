package homework_3.loginpage_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends LoginBaseTest {

    @Test
    public void testLogin() {//test metodumuz

        loginPage.clickLoginButton();   //giriş yap butonuna tıklama
        loginPage.setEmail("malierbay@gmail.com");  //email i girme
        loginPage.setPassword("123456789"); //şifreyi girme
        loginPage.clickEnterButton();   //bunları girdikten sonra giriş yap a tıklama
        loginPage.switchToRecaptchaFrame();  //recaptcha butonunun olduğu frame e geçme
        //loginPage.clickRecaptcha();

        Assertions.assertTrue(loginPage.checkLogin());  //checkLogin() recaptcha butonuna tıklanılabilir olduğunda true döndürür
        //assertTrue sonucu kontrol eder.

    }
}
