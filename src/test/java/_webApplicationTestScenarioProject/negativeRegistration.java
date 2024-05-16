package _webApplicationTestScenarioProject;

import __webApplicationPages.websitePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class negativeRegistration extends TestBaseRapor {






    @Test(groups = "smoke")
    public void negativeRegistrationTest(){
        extentTest = extentReports.createTest("Negative Registration Test", "Gecersiz bilgiler ile form doldurma ve kayit olmamali");
        //1) testotomasyonu sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("websiteUrl"));
        extentTest.info("testotomasyonu ana sayfa gider");


        //2) Ana sayfada dan accoun link tiklayin
        websitePage websitePage = new websitePage();
        websitePage.accountLink.click();
        extentTest.info("Account Link Tiklar");

        //3) sigUp link tiklayin
        websitePage.signUpLink.click();
        extentTest.info("SignUp Link Tiklar");

        //4) Register formunu doldurun
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(2);
        actions.click(websitePage.firstNameBox)
                .sendKeys(ConfigReader.getProperty("websiteInvalidName"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("websiteInvalidSurname"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("websiteInvalidEmail"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("websiteInvalidPassword"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("websiteInvaldPssword"))
                .perform();
        extentTest.info("Gecersiz Form Doldurur");

        //5) SignUp button basin
        websitePage.signUpButton.click();
        extentTest.info("SigUp Link Tiklar");

        //6) kaydolmadiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(websitePage.enterValidInformationText.isDisplayed(),"enterValidInformationText not displayed");
        extentTest.pass("Negative olarak kaydoldugunu Test Eder");



        //7) Sayfayi Kapatin ve raporla
        softAssert.assertAll();
        extentTest.info("Sayfa Kapatir");
    }












}
