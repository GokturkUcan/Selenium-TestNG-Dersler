package _webApplicationTestScenarioProject;

import __webApplicationPages.websitePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class positiveLogin {



    @Test(groups = "regressions")
    public void positiveLoginTest(){

        //1) testotomasyonu ana sayfa gidin
        Driver.getDriver().get(ConfigReader.getProperty("websiteUrl"));

        //2) Account lik tiklayin
        websitePage websitePage = new websitePage();
        websitePage.accountLink.click();

        //3) Login olmak için gecerli Email ve Gecerli passowrd giriniz
        Actions actions = new Actions(Driver.getDriver());

        actions.click(websitePage.loginEmailBox)
                .sendKeys(ConfigReader.getProperty("websiteValidEmail"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("websiteValidPassword"))
                .perform();

        //4) SginIn Button basin
        websitePage.signInButton.click();




        //5) positive login oldugunuzu dogrulayin
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods.bekle(2);
        String expectedProfileName = ConfigReader.getProperty("websiteValidName");
        String actualProfileName = websitePage.profileName.getText();
        softAssert.assertEquals(actualProfileName,expectedProfileName,"actual profile name not equals");
        ReusableMethods.bekle(2);


        //6) Sayfayi Kapatin ve raporla
        softAssert.assertAll();
        Driver.quitDriver();

    }


}
