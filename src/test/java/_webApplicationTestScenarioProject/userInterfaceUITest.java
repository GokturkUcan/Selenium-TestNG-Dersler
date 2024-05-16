package _webApplicationTestScenarioProject;

import __webApplicationPages.websitePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class userInterfaceUITest {



    @Test
    public void userİnterfaceTest(){

        //1) wesite anasayfasina gidin ve sayfa gidildiğini doğrulayin
        Driver.getDriver().get(ConfigReader.getProperty("websiteUrl"));
        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("websiteUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl);


        //2) anasayfada yukarida sign up discount link gürüldüğünü test edin ve
        //tikladiğinizda kaydolma sayfasina gidildiğini dogrulayin ve geri anasayfa dönün

        websitePage websitePage = new websitePage();
        websitePage.mainPageDiscountLink.click();
        softAssert.assertTrue(websitePage.firstNameBox.isDisplayed());
        Driver.getDriver().navigate().back();

        //3) website logo ve arama kutusunun göründügünü ve select Kategori görünür oldugunu ve
        //Account link ve Wishlist yourCart göründügünü ve görünür oldugunu ve aktif çalişrigini test edin

        Assert.assertTrue(websitePage.websiteLogo.isDisplayed());

        Assert.assertTrue(websitePage.searchBox.isDisplayed());

        Assert.assertTrue(websitePage.searchBoxCategoryList.isDisplayed());

        Assert.assertTrue(websitePage.accountLink.isDisplayed());
        websitePage.accountLink.click();
        Driver.getDriver().navigate().back();

        Assert.assertTrue(websitePage.wishlistLink.isDisplayed());
        websitePage.wishlistLink.click();

        Assert.assertTrue(websitePage.yourCartLink.isDisplayed());
        websitePage.yourCartLink.click();
        Driver.getDriver().navigate().back();


        //4) Electronics kategori tiklayin 16 urun bulundugunu test edin ayni şekilde Men Fashion
        //MenFashion 11, WomenFashion 9, Shoes 5, Furniture 6,Travel 4, Kids boys1 girls1, Grocery 1 urun oldugunu dogrulayin

        softAssert.assertTrue(websitePage.electronicCategoryLink.isDisplayed());
        websitePage.electronicCategoryLink.click();
        softAssert.assertEquals(websitePage.electronicCategoryProductFoundList.getSize(),16);
        Driver.getDriver().navigate().back();

        softAssert.assertTrue(websitePage.manFashionCategoryLink.isDisplayed());
        websitePage.manFashionCategoryLink.click();
        softAssert.assertEquals(websitePage.manFashionCategoryProductFoundList.getSize(),11);
        Driver.getDriver().navigate().back();

        softAssert.assertTrue(websitePage.womenFashionCategoryLink.isDisplayed());
        websitePage.womenFashionCategoryLink.click();
        softAssert.assertEquals(websitePage.womenFashionCategoryProductFoundList.getSize(),9);
        Driver.getDriver().navigate().back();


        softAssert.assertTrue(websitePage.shoseCategoryLink.isDisplayed());
        websitePage.shoseCategoryLink.click();
        softAssert.assertEquals(websitePage.shoseCategoryProductFoundList.getSize(),5);
        Driver.getDriver().navigate().back();


        softAssert.assertTrue(websitePage.furnitureCategoryLink.isDisplayed());
        websitePage.furnitureCategoryLink.click();
        softAssert.assertEquals(websitePage.furnitureCategoryProductFoundList.getSize(),6);
        Driver.getDriver().navigate().back();


        softAssert.assertTrue(websitePage.travelCategoryLink.isDisplayed());
        websitePage.travelCategoryLink.click();
        softAssert.assertEquals(websitePage.travelCategoryProductFoundList.getSize(),4);
        Driver.getDriver().navigate().back();

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.bekle(1);
        actions.moveToElement(websitePage.kidsWearCategoryLink)
                .click(websitePage.kidsWearBoysLink)
                .perform();

        softAssert.assertEquals(websitePage.kidsBoysCategoryProductFoundList,1);
        Driver.getDriver().navigate().back();

        actions.moveToElement(websitePage.kidsWearCategoryLink)
                .click(websitePage.kidsWearGirlsLink)
                .perform();

        softAssert.assertEquals(websitePage.kidsGirlsCategoryProductFoundList,1);
        Driver.getDriver().navigate().back();

        websitePage.groceryCategoryLink.click();
        softAssert.assertEquals(websitePage.groceryCategoryProductFoundList,1);
        Driver.getDriver().navigate().back();



        //5) anasayfada olan reklamlarin görünür ve tiklanabilir oldugunu test edin

        websitePage.mainPageMenFashionAdvert.click();
        websitePage.mainPageSaleUpAdvert.click();
        Assert.assertTrue(websitePage.mainPageSaleUpAdvert.isDisplayed());
        Assert.assertTrue(websitePage.mainPageMenFashionAdvert.isDisplayed());



        //6) anasayfada topSelling metin göründügü flashSaleForYou metin ve shopByCategory ve newProduct ve FeaturedProducts
        //MostPopularProducts metinlerin göründügünü test edin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(websitePage.topSellingPageText.isDisplayed());
        Assert.assertTrue(websitePage.flashSaleForYouText.isDisplayed());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(websitePage.shopByCategoryText.isDisplayed());
        Assert.assertTrue(websitePage.newProductText.isDisplayed());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(websitePage.featuredProductsText.isDisplayed());
        Assert.assertTrue(websitePage.mostPopularText.isDisplayed());
        Assert.assertTrue(websitePage.mostPopularText.isDisplayed());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(websitePage.ourLatestBlogsText.isDisplayed());




















    }


}
