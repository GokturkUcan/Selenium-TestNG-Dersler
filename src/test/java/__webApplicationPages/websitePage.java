package __webApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.List;

public class websitePage {

    public websitePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//*[@class=\"menu-icon-text\"])[1]")
    public WebElement accountLink;

    @FindBy(xpath = "//*[@class=\"sign-up \"]")
    public WebElement signUpLink;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    public WebElement firstNameBox;

    @FindBy(xpath = "//button[@id=\"btn-submit-form\"]")
    public WebElement signUpButton;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement profileName;

    @FindBy(xpath = "(//span[@class=\"text-danger\"])[7]")
    public WebElement enterValidInformationText;

    @FindBy(xpath = "//input[@id=\"email\"]")
    public WebElement loginEmailBox;

    @FindBy(xpath = "//Button[@id=\"submitlogin\"]")
    public WebElement signInButton;


    @FindBy(xpath = "//b[text()='Sign Up Now']")
    public WebElement mainPageDiscountLink;

    @FindBy(xpath = "(//img[@alt=\"Logo\"])[1]")
    public WebElement websiteLogo;

    @FindBy(xpath = "//*[@id=\"global-search\"]")
    public WebElement searchBox;

    @FindBy(xpath = "(//span[@class=\"toggle-active\"])[1]")
    public WebElement selectCategory;

    @FindBy(xpath = "(//span[@class=\"toggle-active\"])[1]")
    public WebElement searchBoxCategoryList;

    @FindBy(xpath = "(//span[@class=\"menu-icon-text\"])[2]")
    public WebElement wishlistLink;

    @FindBy(xpath = "(//span[@class=\"menu-icon-text\"])[3]")
    public WebElement yourCartLink;

    @FindBy(xpath = "(//li[@class=\"has-sub\"])[1]")
    public WebElement electronicCategoryLink;

    @FindBy(xpath = "//*[@class=\"product-box mb-2 pb-1\"]")
    public WebElement electronicCategoryProductFoundList;

    @FindBy(xpath = "(//li[@class=\"has-sub\"])[2]")
    public WebElement manFashionCategoryLink;

    @FindBy(xpath = "//div[@class=\"product-box mb-2 pb-1\"]")
    public WebElement manFashionCategoryProductFoundList;

    @FindBy(xpath = "(//li[@class=\"has-sub\"])[3]")
    public WebElement womenFashionCategoryLink;

    @FindBy(xpath = "//div[@class=\"product-box mb-2 pb-1\"]")
    public WebElement womenFashionCategoryProductFoundList;


    @FindBy(xpath = "(//li[@class=\"has-sub\"])[4]")
    public WebElement shoseCategoryLink;

    @FindBy(xpath = "//div[@class=\"product-box mb-2 pb-1\"]")
    public WebElement shoseCategoryProductFoundList;

    @FindBy(xpath = "(//li[@class=\"has-sub\"])[5]")
    public WebElement furnitureCategoryLink;

    @FindBy(xpath = "//div[@class=\"product-box mb-2 pb-1\"]")
    public WebElement furnitureCategoryProductFoundList;


    @FindBy(xpath = "(//li[@class=\"has-sub\"])[6]")
    public WebElement travelCategoryLink;

    @FindBy(xpath = "//div[@class=\"product-box mb-2 pb-1\"]")
    public WebElement travelCategoryProductFoundList;

    @FindBy(xpath = "(//li[@class=\"has-sub\"])[7]")
    public WebElement kidsWearCategoryLink;

    @FindBy(xpath = "(//*[text()='Boys'])[1]")
    public WebElement kidsWearBoysLink;

    @FindBy(xpath = "//div[@class=\"product-box mb-2 pb-1\"]")
    public WebElement kidsBoysCategoryProductFoundList;

    @FindBy(xpath = "(//*[text()='Girls'])[1]")
    public WebElement kidsWearGirlsLink;

    @FindBy(xpath = "//div[@class=\"product-box mb-2 pb-1\"]")
    public WebElement kidsGirlsCategoryProductFoundList;

    @FindBy(xpath = "(//li[@class=\"has-sub\"])[8]")
    public WebElement groceryCategoryLink;

    @FindBy(xpath = "//div[@class=\"product-box mb-2 pb-1\"]")
    public WebElement groceryCategoryProductFoundList;

    @FindBy(xpath = "(//*[@class=\"banner-slide bg-img sub-slider justify-content-center mb-4\"])[1]")
    public WebElement mainPageSaleUpAdvert;

    @FindBy(xpath = "(//*[@class=\"banner-slide bg-img sub-slider justify-content-center mb-4\"])[1]")
    public WebElement mainPageMenFashionAdvert;


    @FindBy(xpath = "(//div[@class=\"heading-lg\"])[1]")
    public WebElement topSellingPageText;

    @FindBy(xpath = "(//div[@class=\"heading-lg\"])[2]")
    public WebElement flashSaleForYouText;

    @FindBy(xpath = "(//div[@class=\"heading-lg\"])[3]")
    public WebElement shopByCategoryText;

    @FindBy(xpath = "(//div[@class=\"heading-lg\"])[4]")
    public WebElement newProductText;

    @FindBy(xpath = "(//div[@class=\"heading-lg\"])[5]")
    public WebElement featuredProductsText;

    @FindBy(xpath = "(//div[@class=\"heading-lg\"])[6]")
    public WebElement mostPopularText;

    @FindBy(xpath = "(//div[@class=\"heading-lg\"])[7]")
    public WebElement topBrandsText;

    @FindBy(xpath = "(//div[@class=\"heading-lg\"])[8]")
    public WebElement ourLatestBlogsText;

}
