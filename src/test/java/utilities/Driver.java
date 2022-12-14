package utilities;

import com.graphbuilder.curve.MultiPath;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    public static MultiPath getDriver;

    private Driver() {

    }

    static WebDriver driver;
    /*
    testlerimizi calistirdiğimizda her seferinde yeni driver olusturduğu icin her test methodu icin yeni bir
    pencencere(driver) aciyor
    eger driver a bir deger atanmamissa yani driver == null ise bir kere driver i calistir diyerek bir kere if icini
    calistiracak ve driver bir kere calistigi icin ve deger atandigi icin null olmayacak ve direk return edecek ve diger
    testlerimiz ayni pencere (driver) uzerinde calisacak
     */

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "Frifox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { //driver'a deger atanmissa kapat
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}
