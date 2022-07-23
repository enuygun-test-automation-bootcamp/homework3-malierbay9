package homework_3.singuppage_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SignupPageTest extends SignupBaseTest{
    @Test
    public void testSignup() {//test metodumuz

        signupPage.clickSignupButton();//üye ol butonuna tıklama
        signupPage.setEmail("malierbay@gmail.com");//email i girme
        signupPage.setPassword("123456789");//şifreyi girme
        signupPage.clickEnterButton();//bunları girdikten sonra giriş yap a tıklama

        Assertions.assertTrue(signupPage.checkSignUp());    //checkSignUp() açılan pencerede kullanıcı barı var ise true döndürür
        //assertTrue() checkSignup() metodundan gelecek sonucu kontrol eder.

    }
}

