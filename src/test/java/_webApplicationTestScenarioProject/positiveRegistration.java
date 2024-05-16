package _webApplicationTestScenarioProject;

import __webApplicationPages.websitePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class positiveRegistration {


    @Test(groups = "regressions")
    public void positiveRegistrationTest(){

        //1) testotomasyonu sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("websiteUrl"));

        //2) Ana sayfada dan accoun link tiklayin
        websitePage websitePage = new websitePage();
        websitePage.accountLink.click();

        //3) sigUp link tiklayin
        websitePage.signUpLink.click();
        ReusableMethods.bekle(2);

        //4) Register formunu doldurun
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(2);
        actions.click(websitePage.firstNameBox)
                .sendKeys(ConfigReader.getProperty("websiteValidName"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("websiteValidSurname"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("websiteValidEmail"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("websiteValidPassword"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("websiteValidPassword"))
                .perform();

        //5) SignUp button basin
        websitePage.signUpButton.click();


        //6) kaydoldugunuzu dogrulayin
        websitePage.accountLink.click();

        String expectedProfileName = ConfigReader.getProperty("websiteValidName");
        String actualProfileName = websitePage.profileName.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualProfileName,expectedProfileName,"actual profile name not equals");


        //7) Sayfayi Kapatin ve raporla
        softAssert.assertAll();
        Driver.quitDriver();
    }




























}
