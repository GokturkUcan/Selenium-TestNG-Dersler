package _webApplicationTestScenarioProject;

import __webApplicationPages.websitePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;

public class negativeLogin {


    @Test(groups = "smoke")
    public void negativeLoginTest(){

        //1) testotomasyonu ana sayfa gidin
        Driver.getDriver().get(ConfigReader.getProperty("websiteUrl"));

        //2) Account lik tiklayin
        websitePage websitePage = new websitePage();
        websitePage.accountLink.click();

        //3) Login olmak için gecerli Email ve Gecerli passowrd giriniz
        Actions actions = new Actions(Driver.getDriver());

        actions.click(websitePage.loginEmailBox)
                .sendKeys(ConfigReader.getProperty("websiteInvalidEmail"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("websiteInvalidPassword"))
                .perform();

        //4) SginIn Button basin
        websitePage.signInButton.click();




        //5) Negative login oldugunuzu dogrulayin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(websitePage.loginEmailBox.isDisplayed(),"enterValidInformationText not displayed");



        //6) Sayfayi Kapatin ve raporla
        softAssert.assertAll();
        Driver.quitDriver();

    }











}
