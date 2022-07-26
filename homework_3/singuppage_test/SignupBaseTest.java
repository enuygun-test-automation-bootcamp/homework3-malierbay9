package homework_3.singuppage_test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)//bu anotasyonu kullanmazsak @BeforeAll ve @AfterAll altında metotlar static olmak zorunda
public class SignupBaseTest {//bu classı asıl test classımızdan extend ettiğimizde buradaki @BeforeAll,@AfterAll altındaki metotlar da çalışacak

    public SignupPage signupPage;

    public SignupBaseTest() {
        this.signupPage = new SignupPage();//SignupPage sınıfımızdan nesne üretiyoruz. Bu nesne ile gerekli metotları kullanabileceğiz.
        //Bu class ı asıl test classımızdan exten edeceğimiz oradan da bu nesneye ulaşabiliyor olacağız.
    }

    @BeforeAll//altında ki metotta herşeyden once yapılmasını istediğimiz şeyleri yaptığımız JUnit anotasyonu
    public void setUp() {
        outer:
        try {
            signupPage.openUrl("https://www.enuygun.com/"); //sayfamızı açıyoruz
            //openUrl metodu eğer driver ımız null ise hata fırlatacaktı, onu burada try-catch ile kontrol ediyoruz
        }
        catch (NullPointerException e) {//driver null ise kod buraya düşecektir
            signupPage.chromeDriverSetup();//driver ı initiate ediyoruz
            break outer;//daha sonra outer etiketi sayesinde başa dönüp tekrar sayfayı açacak metot çalışıyor.
        }
    }

    @AfterAll//altında ki metotta işimiz bittikten sonra yapılmasını istediğimiz şeyleri yaptığımız JUnit anotasyonu
    public void tearDown() {
        signupPage.quitDriver();
    }


}
