package tests.SELENİUM_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import pages.ZeroWebAppPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;


public class _SELENİUM_TestNGDeneme extends TestBaseRapor {




    //[1]
    //Priority kullanarak 3 farkli method ile asagidaki testleri yapin
    //1) testotomasyonu anasayfaya gidin
    //2) test otomasyonu sayfasinin acildigini test edin
    //1) youtube anasayfaya gidin
    //2) youtube sayfasinin acildigini test edin
    //1) walmart anasayfaya gidin
    //2) test otomasyonu sayfasinin acildigini test edin

    @Test(priority = 1)
    public void testOtomasyonuPriorityTest(){

        //1) testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        //2) test otomasyonu sayfasinin acildigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);

    }

    @Test(priority = 2)
    public void youtubePriorityTest(){

        //1) youtube anasayfaya gidin
        Driver.getDriver().get("https://www.youtube.com");

        //2) youtube sayfasinin acildigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);

    }

    @Test @Ignore
    public void walmartPriorityTest(){

        //1) walmart anasayfaya gidin
        Driver.getDriver().get("https://www.walmart.com");

        //2) walmart anasayfa gidildiğini test din
        String expectedUrlIcerik = "walmart";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);

    }









    //[2]
    // Test otomasyonu sayfasina gidip, asagidaki 3 testi farkli test method'larinda calistirin
    // 1- testotomasyonu gidip sayfasina gittigimizi test edin
    // 2- phone icin arama yapip,  arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu click yapip, acilan urun isminde case sensitive olmadan phone bulundugunu test edin

    @Test
    public void anasayfaDependsOnMethodTest(){

        // 1- testotomasyonu gidip sayfasina gittigimizi test edin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }

    @Test(dependsOnMethods = "anasayfaTesti")
    public void phoneAramaDependOnMethodTest(){

        // 2- phone icin arama yapip,  arama sonucunda urun bulunabildigini test edin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        WebElement aramaSonucElementi = Driver.getDriver().findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);


    }

    @Test(dependsOnMethods = "phoneAramaTesti")
    public void ilkUrunIsimDependOnMethodsTest(){

        // 3- ilk urunu click yapip, acilan sayfada, urun isminde case sensitive olmadan phone bulundugunu test edin
        Driver.getDriver().findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]"))
                .click();

        WebElement ilkUrunIsimElementi = Driver.getDriver().findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));


    }







    //[3]
    //1 - https://testotomasyonu.com/form adresine gidin
    //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
    //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
    //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
    //5- Secilen değerleri konsolda yazdirin
    //6- Ay dropdown menüdeki tum değerleri(value) yazdırın
    //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin

    @Test
    public void pageObjectModelDropDownTest(){

        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");

        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        TestotomasyonuPage testOtomasyonuFormPage = new TestotomasyonuPage();

        Select selectGun = new Select(testOtomasyonuFormPage.gunDropdownElementi);
        selectGun.selectByIndex(5);

        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy = new Select(testOtomasyonuFormPage.ayDropdownElementi);
        selectAy.selectByValue("nisan");

        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(testOtomasyonuFormPage.yilDropdownElementi);
        selectYil.selectByVisibleText("1990");

        //5- Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());


        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayOptionElementleriListesi  = selectAy.getOptions();

        System.out.println(ReusableMethods.stringListeDonustur(ayOptionElementleriListesi));

        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        int expectedListeBoyutu = 13;
        int actualListeBoyutu = ayOptionElementleriListesi.size();

        Assert.assertEquals(actualListeBoyutu,expectedListeBoyutu);


        ReusableMethods.bekle(3);
        Driver.quitDriver();
    }








    //[4]
    //1) testotomasyonu anasayfaya gidin
    //2) belirlenmis olan arama kelimesi icin arama yapin
    //3) belirlenmis arama kelimesi icin istenen minimum sonuc sayisindan daha fazla sonuc bulundugunu test edin
    //4) sayfayi kapatin

    @Test
    public void dataProviderAramaTest(){

        //1) testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


        //2) belirlenmis olan arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);


        //3) belirlenmis arama kelimesi icin istenen minimum sonuc sayisindan daha fazla sonuc bulundugunu test edin
        int expectedMinSonucSayisi = Integer.parseInt(ConfigReader.getProperty("minSonucSayisi")); // 2
        int actualSonucSayisi = testotomasyonuPage.bulunanSonucElementleriListesi.size(); // 4

        ReusableMethods.bekle(2);

        Assert.assertTrue(actualSonucSayisi >= expectedMinSonucSayisi);

        //4) sayfayi kapatin
        Driver.quitDriver();

    }











    //[5]
    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3- Kullanici email'i olarak gecerli email girin
    //4- Kullanici sifresi olarak gecerli password girin
    //5- Login butonuna basarak login olun
    //6- Basarili olarak giris yapilabildigini test edin
    //7- logout olup, sayfayi kapatin

    @Test
    public void dataProviderPozitifLoginTest(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiLoginButonu.click();

        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isEnabled());

        //7- logout olup, sayfayi kapatin
        ReusableMethods.bekle(1);
        testotomasyonuPage.logoutButonu.click();
        Driver.quitDriver();

    }








    //[6]
    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3-  3 farkli test method’u olusturun.
    //  - gecerli email, gecersiz password
    //	- gecersiz email, gecerli password
    //	- gecersiz email, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin

    @Test
    public void gecersizPasswordTest(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- gecerli username, gecersiz password yazin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiLoginButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isEnabled());

        //6- Sayfayi kapatin
        Driver.quitDriver();

    }



    @Test
    public void gecersizUsernameTest(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- gecersiz username, gecerli password yazin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        //4- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiLoginButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isEnabled());

        //6- Sayfayi kapatin
        Driver.quitDriver();

    }

    @Test
    public void gecersizUsernameGecersizPasswordTest(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- gecersiz username, gecersiz password yazin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiLoginButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isEnabled());

        //6- Sayfayi kapatin
        Driver.quitDriver();

    }










    //[7]
    //1) testotomasyonu anasayfaya gidin
    //2) testotomasyonu sayfasina gittiginizi test edin
    //3) belirlenen aranacak kelime icin arama yapin
    //4) arama sonuclarinin, belirlenen min.arama sayisindan fazla oldugunu test edin
    //5) ilk urunu tiklayin
    //6) acilan urun sayfasindaki, urun isminde case sensitive olmadan belirlenmis aranacak kelime gectigini test edin
    //7) sayfayi kapatin

    @Test
    public void normalAssertionTest(){

        //1) testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2) testotomasyonu sayfasina gittiginizi test edin
        String expectedurl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedurl);

        //3) belirlenen aranacak kelime icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")
                + Keys.ENTER);

        //4) arama sonuclarinin, belirlenen min.arama sayisindan fazla oldugunu test edin
        int expectedMinAramaSonucu = Integer.parseInt(ConfigReader.getProperty("minSonucSayisi"));
        int actualAramaSonucSayisi = testotomasyonuPage.bulunanSonucElementleriListesi.size();

        Assert.assertTrue(actualAramaSonucSayisi>=expectedMinAramaSonucu);

        //5) ilk urunu tiklayin
        testotomasyonuPage.bulunanSonucElementleriListesi.get(0).click();

        //6) acilan urun sayfasindaki, urun isminde case sensitive olmadan belirlenmis aranacak kelime gectigini test edin
        String expectedUrunIsimIcerigi = ConfigReader.getProperty("toAranacakKelime").toLowerCase();
        String actualUrunIsmi = testotomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi));

        //7) sayfayi kapatin
        Driver.quitDriver();
    }







    //[8]
    //1. “http://zero.webappsecurity.com/” Adresine gidin
    //2. webbappsecurity ana sayafaya gittiginizi dogrulayin
    //3. Sign in butonuna basin
    //4. Login kutusuna “username” yazin
    //5. Password kutusuna “password” yazin
    //6. Sign in tusuna basin
    //7. Back tusuna basin
    //8. Giris yapilabildigini dogrulayin
    //9. Online banking menusunu tiklayin
    //10. Pay Bills sayfasina gidin
    //11. “Purchase Foreign Currency” tusuna basin
    //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
    //13. “Currency” dropdown menusunden Eurozone’u secin
    //14. "Eurozone (euro)" secildigini dogrulayin
    //15. Dropdown menude 16 option bulundugunu dogrulayin.
    //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
    //17. Sayfayi kapatin





    @Test
    public void softAssertionTest(){

        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroWebAppUrl"));

        //2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();

        String expectedUrl = ConfigReader.getProperty("zeroWebAppUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl, "anasayfa Url test datasi olarak verilen degerle ayni degil");

        //3. Sign in butonuna basin
        ZeroWebAppPage zeroWebAppPage = new ZeroWebAppPage();
        zeroWebAppPage.anasayfaSigninButonu.click();

        //4. Login kutusuna “username” yazin
        zeroWebAppPage.usernameKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliUsername"));

        //5. Password kutusuna “password” yazin
        zeroWebAppPage.passwordKutusu.sendKeys(ConfigReader.getProperty("zeroGecerliPassword"));

        //6. Sign in tusuna basin
        zeroWebAppPage.loginSayfasiSigninButonu.click();

        //7. Back tusuna basin
        Driver.getDriver().navigate().back();

        //8. Giris yapilabildigini dogrulayin
        softAssert.assertTrue(zeroWebAppPage.usernameDropdown.isDisplayed(),"Giris yapilamadi");

        //9. Online banking menusunu tiklayin
        zeroWebAppPage.onlineBanking.click();

        //10. Pay Bills sayfasina gidin
        zeroWebAppPage.payBillsLinki.click();

        //11. “Purchase Foreign Currency” tusuna basin
        zeroWebAppPage.purchaseForeignCurrency.click();

        //12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroWebAppPage.pcCurrencyDropdownElementi.isEnabled(), "Pc currency dropdown menu kullanilamiyor");

        //13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(zeroWebAppPage.pcCurrencyDropdownElementi);
        select.selectByValue("EUR");

        //14. "Eurozone (euro)" secildigini dogrulayin
        String expectedSecilenOption = "Eurozone (euro)";
        String actualSecilenOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSecilenOption,expectedSecilenOption, "Currency olarak euro secilmemis");

        //15. Dropdown menude 16 option bulundugunu dogrulayin.
        int expectedOptionSayisi = 16;
        int actualOptionSayisi = select.getOptions().size();

        softAssert.assertEquals(actualOptionSayisi,expectedOptionSayisi, "Currency dropdown'da 16 option yok");

        //16. Dropdown menude "Canada (dollar)" bulunduğunu dogrulayin
        List<WebElement> dropdownMenuElementleriList = select.getOptions();
        List<String> dropdownOptionListStr = ReusableMethods.stringListeDonustur(dropdownMenuElementleriList);

        String expectedOption = "Canada (dollar)";
        softAssert.assertTrue(dropdownOptionListStr.contains(expectedOption), "dropdown menu Canada (dollar) icermiyor");

        //17. Sayfayi kapatin
        softAssert.assertAll();
        Driver.quitDriver();

    }











    //[9]
    //1. testotomasyonu anasayfaya gidin
    //2. Title'in Test icerdigini dogrulayin
    //3. url'in testdatasi olarak verilen url ile ayni oldugunu dogrulayin
    //4. arama kutusunun kullanilabilir durumda oldugunu dogrulayin
    //5. belirlenmis aranacak kelimeyi aratip urun bulundugunu dogrulayin
    //6. Nutella aratip, urun bulunamadigini dogrulayin
    //7. sayfayi Kapatin

    @Test
    public void htmlReportluAramaTest(){

        extentTest = extentReports.createTest("soft assert ile urun arama testi",
                "Kullanici bulunmasi ve bulunmamasi gereken kelimeleri test eder");

        //1. testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        //2. Title'in Test icerdigini dogrulayin
        SoftAssert softAssert = new SoftAssert();

        String expectedTitleIcerik = "Test";
        String actualTitle = Driver.getDriver().getTitle();

        softAssert.assertTrue(actualTitle.contains(expectedTitleIcerik), "title Test icermiyor");
        extentTest.pass("Title'in Test icerdigini dogrular");

        //3. url'in testdatasi olarak verilen url ile ayni oldugunu dogrulayin
        String expectedUrl = ConfigReader.getProperty("toUrl");
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl, "url test datasi olarak verilenden farkli");
        extentTest.pass("url'in testdatasi olarak verilen url ile ayni oldugunu dogrular");

        //4. arama kutusunun kullanilabilir durumda oldugunu dogrulayin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        softAssert.assertTrue(testotomasyonuPage.aramaKutusu.isEnabled(), "Arama kutusu kullanilabilir durumda degil");
        extentTest.pass("arama kutusunun kullanilabilir durumda oldugunu dogrular");

        //5. belirlenmis aranacak kelimeyi aratip urun bulundugunu dogrulayin
        testotomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
        extentTest.info("belirlenmis aranacak kelimeyi aratir");

        softAssert.assertTrue(testotomasyonuPage.bulunanSonucElementleriListesi.size()>0, "aranacak kelime aratildiginda urun bulunamadi");
        extentTest.pass("belirlenmis aranacak kelime icin urun bulundugunu dogrular");


        //6. Nutella aratip, urun bulunamadigini dogrulayin
        testotomasyonuPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        extentTest.info("Nutella aratir");

        String expectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = testotomasyonuPage.aramaSonucYaziElementi.getText();

        softAssert.assertEquals(actualSonucYazisi,expectedSonucYazisi, "Nutella icin urun bulundu");
        extentTest.pass("Nutella icin urun bulunamadigini dogrular");

        //7. sayfayi Kapatin
        softAssert.assertAll();

    }







    //[10]
    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3- Kullanici email'i olarak gecerli email girin
    //4- Kullanici sifresi olarak gecerli password girin
    //5- Login butonuna basarak login olun
    //6- Basarili olarak giris yapilabildigini test edin
    //7- logout olup

    @Test
    public void htmlReportpozitifLoginTesti(){

        extentTest = extentReports.createTest("Pozitif login testi",
                "Gecerli kullanici adi ve sifre ile giris yapilabilmeli");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfasina gider");

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");

        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli password girer");

        //5- Login butonuna basarak login olun
        testotomasyonuPage.loginSayfasiLoginButonu.click();
        extentTest.info("Login butonuna basarak login olur");

        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isEnabled());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");

        //7- logout olup,
        ReusableMethods.bekle(1);
        testotomasyonuPage.logoutButonu.click();
        extentTest.info("logout olur");

    }






}
