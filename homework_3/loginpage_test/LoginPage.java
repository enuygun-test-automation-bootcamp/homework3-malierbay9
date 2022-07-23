package homework_3.loginpage_test;

import homework_3.driver_manager.DriverManager;
import homework_3.driver_manager.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends DriverManager {//bu classta login testi için gerekli elemanların locatorları ve o elemanlarla yapılacak işlemlerin olduğu metotlar mevcut


    private final By loginButton = By.id("ctx-LoginBtn");//gerekli elemanların locatorları
    private final By emailBox = By.cssSelector("input[name='_email']");
    private final By passwordBox = By.cssSelector("input[name='_password'][aria-invalid]");
    private final By enterButton = By.xpath("//span[starts-with(text(),'Giriş')]");
    private final By recaptchaFrame = By.cssSelector("iframe[title='reCAPTCHA']");
    private final By recaptchaButton = By.xpath("//div[@class='recaptcha-checkbox-border']");
    private final By recaptchaPuzzle = By.cssSelector("iframe[title='reCAPTCHA sorusunun süresi iki dakika sonra dolacak']");

    public LoginPage(){//constructor metot
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

    public void clickLoginButton(){
        chromeDriver.findElement(loginButton).click();
    }//giriş yap butonuna tıklayan metot

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

    public void clickEnterButton(){//email ve şifre girdikten sonra giriş yap butonuna tıklayan metot
        chromeDriver.findElement(enterButton).click();
    }

    public void clickRecaptcha(){//recaptcha butonuna tıklayan metot
        wait(10).until(ExpectedConditions.elementToBeClickable(recaptchaButton));//eleman tıklanabilir olana kadar beklemeyi sağlar
        chromeDriver.findElement(recaptchaButton).click();
    }

    public void switchToRecaptchaFrame(){//recaptcha ayrı bir frame içinde, bu frame e geçmeyi sağlayan metot
        wait(10).until(ExpectedConditions.visibilityOfElementLocated(recaptchaFrame));
        chromeDriver.switchTo().frame(chromeDriver.findElement(recaptchaFrame));
    }

    public boolean checkLogin(){//captcha geçilemediğinden captcha butonuna tıklanabilir olduğu zaman testi geçti olarak saydım.
        //metot bu durumu kontrol ediyor.

        wait(5).until(ExpectedConditions.visibilityOfElementLocated(recaptchaButton));
        return chromeDriver.findElement(recaptchaButton).isEnabled();
    }

    private WebDriverWait wait(int seconds){//bekleme koymayı sağlayan metot
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver,Duration.ofSeconds(seconds));
        return webDriverWait;
    }


}
