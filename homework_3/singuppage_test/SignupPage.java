package homework_3.singuppage_test;


import homework_3.driver_manager.DriverManager;
import homework_3.driver_manager.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage extends DriverManager {//bu classta signup testi için gerekli elemanların locatorları ve o elemanlarla yapılacak işlemlerin olduğu metotlar mevcut

    private final By signupButton = By.id("ctx-RegisterBtn");//gerekli elemanların locatorları
    private final By emailBox = By.cssSelector("input[name='_email']");
    private final By passwordBox = By.cssSelector("input[name='_password'][aria-invalid]");
    private final By enterButton = By.xpath("//span[starts-with(text(),'Üye Ol')]");
    private final By userBar = By.cssSelector("div.NavbarUser");

    public SignupPage(){//constructor metot
        DriverSettings.chromeOptions.addArguments("start-maximized");//DriverSettings classından static olarak chromeOptions a ulaşıp büyük pencerede açmayı sağladık
        chromeDriverSetup();//Bu classta extend ettiğimiz DriverManager ın chromeDriverSetup() metoduyla chrome driver ımızı initiate ettik
        //artık chromeDriver yazarak kullanabiliriz
    }

    public void openUrl(String url){//gerekli sayfayı açmayı sağlayan metot
        //gerekli driver ın setup metodunu çalıştırmadıysak driver ımız null olacaktır.
        //bu durumda bu metottan kullanılacak yere hata fırlatıp orda ilgilenilmesini sağlarız.
        if(chromeDriver==null){
            throw new NullPointerException();
        }
        else{//driver boş değilse gerekli siteyi açar.
            chromeDriver.get(url);
        }
    }

    public void quitDriver(){
        chromeDriver.quit();
    }//driverı sonlandıran metot

    public void clickSignupButton(){//üye ol butonuna tıklayan metot
        chromeDriver.findElement(signupButton).click();
    }

    public void setEmail(String email){//email giren metot
        wait(5).until(ExpectedConditions.visibilityOfElementLocated(emailBox));// -> bu kısım element görünür olana kadar beklemeyi sağlar
        //email text box u butona tıkladıktan bir süre sonra geliyor bu yüzde beklemekoymalıyız.

        WebElement emailBox = chromeDriver.findElement(this.emailBox);
        emailBox.click();
        emailBox.sendKeys(email);
    }

    public void setPassword(String password){//şifre giren metot
        WebElement passwordBox = chromeDriver.findElement(this.passwordBox);
        passwordBox.click();
        passwordBox.sendKeys(password);
    }

    public void clickEnterButton(){//email ve şifre girdikten sonra üye ol butonuna tıklayan metot
        chromeDriver.findElement(enterButton).click();
    }

    public boolean checkSignUp(){//üye olunduğunda açılan sayfada kullanıcı barı elementi geliyor.
        //bu element ekranda görünüyor ise test başarılıdır saydım.

        wait(5).until(ExpectedConditions.visibilityOfElementLocated(userBar));
        return chromeDriver.findElement(userBar).isDisplayed();//isDisplayed() metodu istenilen element sayfada görünüyor ise true döndürür
    }

    private WebDriverWait wait(int seconds){//bekleme koymayı sağlayan metot
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(seconds));
        return webDriverWait;
    }

}
