package homework_3.driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    //bu sınıf driverlara kolay erişim sağlamak için var
    //bu class ı gerekli yerde extend ettiğimiz zaman içindeki önce ilgili driver ın setup metodunu çalıştırıp
    //gerekli driver a kolayca ulaşabiliriz.

    protected WebDriver chromeDriver;
    protected WebDriver edgeDriver;
    protected WebDriver firefoxDriver;//driverları attribute olarak tanımlıyoruz

    protected DriverSettings driverSettings;//property, driver options ,capabilities gibi ayarları yapabilmeyi sağlayan DriverSettings classından da attribute oluşturuyoruz.


    public DriverManager(){
        this.driverSettings = new DriverSettings();//constructor metodunun içinde driverSettings atribute umuzu initiate ediyoruz
    }

    public void chromeDriverSetup(){//bu setup metotlarınlarında driverların propertyleri ayarlanıp, driverlar initiate ediliyor
        this.driverSettings.setDriverProps(DriverType.CHROME);
        this.chromeDriver = new ChromeDriver(DriverSettings.chromeOptions);//driverları initiate ederken içlerine kendi options ögelerini de veriyoruz
    }

    public void edgeDriverSetup(){
        this.driverSettings.setDriverProps(DriverType.EDGE);
        this.edgeDriver = new EdgeDriver(DriverSettings.edgeOptions);
    }

    public void firefoxDriverSetup(){
        this.driverSettings.setDriverProps(DriverType.FIREFOX);
        this.firefoxDriver = new FirefoxDriver(DriverSettings.firefoxOptions);
    }

}
