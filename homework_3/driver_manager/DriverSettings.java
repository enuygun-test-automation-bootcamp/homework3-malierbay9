package homework_3.driver_manager;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSettings {
    //bu class sayesinde driver properties, options, capabilities gibi şeyleri ayarlayabiliyoruz

    public static ChromeOptions chromeOptions;      //her driver ın kendi option sınıfından bir attribute oluşturduk
    public static EdgeOptions edgeOptions;          //bunları static tanımlamamın amacı capability ya da extension ayarları yapmak için
    public static FirefoxOptions firefoxOptions;    // bu options nesnelerine direk erişmeye ihtiyaç oluyor.

    public DriverSettings(){
        chromeOptions = new ChromeOptions();//attributeları constructor içinde initiate ettik
        edgeOptions = new EdgeOptions();
        firefoxOptions = new FirefoxOptions();
    }


    protected void setDriverProps(Enum driverType){//bu metot driver tipine göre property ayarlamaya yarıyor

        if(driverType.equals(DriverType.CHROME)){//enum kullanarak hataya yatkınlığını ortadan kaldırdık
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        }
        else if(driverType.equals(DriverType.FIREFOX)){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        }
        else if(driverType.equals(DriverType.EDGE)){
            System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
        }
    }

}

