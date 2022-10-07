package tests.day13;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class Amazon {

    AmazonPage amazonPage;

    @Test
    public void test01() {


        amazonPage =new AmazonPage();
        Driver.getDriver().get("https://amazon.com");
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


    }



}
