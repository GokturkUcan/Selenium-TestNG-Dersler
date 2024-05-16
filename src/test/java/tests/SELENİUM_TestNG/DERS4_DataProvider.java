package tests.SELENİUM_TestNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DERS4_DataProvider {


    /*
            data provider datalari test method'u disindan tek tek test method'una yollamamizi saglar
            biz testimizi parametre ile calisacak sekilde hazirlariz

            sonra bize disardan parametreleri yollamasi icin bir data provider olustururuz
            @DataProvider notasyonuna sahip method'larin EN ONEMLI OZELLIGI
            iki katli bir array return etmesidir

            Dolayisiyla data provider'in bize parametre olarak yollamasini istedigimiz datalari
            iki katli bir array olarak olusturmaliyiz
         */


    @Test
    public void test01(){

        /*
            Aranacak kelimeleri bir list olarak olusturup
            tek tek listedeki elemanlari aratmak istedigimizde
            bulamadigi ilk urunde assertion failed olacak
            TestNG calismayi durduracak
         */

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // asagida verilen kelimeler icin arama yaptirip
        // hepsinde urun bulunabildigini test edin
        // aranacak kelimeler : phone, java, dress, baby, nutella, samsung, cokokrem, iphone

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();

        String[] aranacakUrunler = {"phone", "java", "dress", "baby", "nutella", "samsung",
                "cokokrem", "iphone"};

        for (int i = 0; i < aranacakUrunler.length ; i++) {

            testotomasyonuPage.aramaKutusu.sendKeys(aranacakUrunler[i] + Keys.ENTER);

            Assert.assertTrue(testotomasyonuPage.bulunanSonucElementleriListesi.size()>0);

            ReusableMethods.bekle(1);

        }

        Driver.quitDriver();

    }








    @DataProvider
    public static Object[][] kullaniciBilgileriDataProvider() {
        String[][] kullaniciBilgileriArrayi = {
                {"banu@gmail.com",     "898989"},
                {"sedat@yahoo.com",    "989887"},
                {"orkong@tmail.com",   "122334"},
                {"joeblack@gmail.com",  "1a2s3djoeblackpassword"},
                {"arzu@senmail.com",   "676767"},
                {"mehmet@mynet.com",   "878987"}
        };

        return kullaniciBilgileriArrayi;
    }

    // testotomasyonu anasayfaya gidin
    // asagida liste olarak verilen kullanici adi ve sifreler ile
    // giris yapilamadigini test edin
    //    banu@gmail.com     898989
    //    sedat@yahoo.com    989887
    //    orkong@tmail.com   122334
    //    fatih@hotmail.com  454545
    //    arzu@senmail.com   676767
    //    mehmet@mynet.com   878987

    @Test(dataProvider = "kullaniciBilgileriDataProvider")
    public void cokluNegatifLoginTesti(String email , String password){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        // verilen email ve sifreleri girin
        testotomasyonuPage.emailKutusu.sendKeys(email);
        testotomasyonuPage.passwordKutusu.sendKeys(password);

        // login butonuna basin
        testotomasyonuPage.loginSayfasiLoginButonu.click();

        // giris yapilamadigini test edin

        try {
            Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        } catch (NoSuchElementException e) { // istemedigimiz bir durum olustu ve giris yapildi

            testotomasyonuPage.logoutButonu.click();
            // sonraki kullanici bilgileri ile testin calismasi icin logout olacak

            // try-catch ile exception'i handle ettigimiz icin
            // failed olan testi Passed haline dondurduk
            // yeniden testi failed haline getirelim

            Assert.assertTrue(false); // %100 failed olacak bir assertion yazdik

        }

        Driver.quitDriver();

    }




}
