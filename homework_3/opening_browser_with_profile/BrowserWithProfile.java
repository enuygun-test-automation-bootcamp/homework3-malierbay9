package homework_3.opening_browser_with_profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserWithProfile{

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        String[] arguments = {"user-data-dir=C:\\Users\\malie\\AppData\\Local\\Google\\Chrome\\User Data","--profile-directory=Profile 1"};
        //chromeOptions içine atmamız gereken argumanları yukarıdaki diziye koyduk

        ChromeOptions options = new ChromeOptions();//chromeopitons nesnesi oluşturduk
        options.addArguments(arguments);//diziyi options nesnemize ekledik

        WebDriver driver = new ChromeDriver(options);//options ı driverımıza ekledik
        driver.get("https://www.enuygun.com/");
    }

}

