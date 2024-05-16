package tests.SELENİUM_TestNG;

public class DERS2_Assertions_DataProvider {



  /*
            JUnit'te ve suana kadar TestNG'de yaptigimiz assertion'larda
            ilk failed olan assertion'da kod calismayi durduruyor
            ve bize hata mesaji veriyor

            TestNG assertion konusunda bize 2 alternatif sunar
            1- Bugune kadar yaptigimiz gibi yapmaya devam etmek
               Ancak bu yontemle assertion yaptigimizda
               bir method'un icinde birden fazla failed olan assertion varsa
               bize sadece ilkini verir,
               ilkini duzelttikten sonra yola devam edip varsa diger assertion hatalarini verir

            2- SoftAssert
               SoftAssert ile assertion'lari yapmaya basladigimizda
               biz RAPORLA diyene kadar,
               assertion'lar failed olsa da kod calismaya devam eder
               biz RAPORLA dedigimizde
               yaptigi tum assertion'lari raporlar
               ve failed olan varsa exception firlatip calismayi durdurur.

             - bu yonteme softAssert deyince,
               bugune kadar kullandigimiz Assert class'ina da Hard Assert ismi verilmistir
             - soft assert assertion'lar failed oldugunda yola devam ettikleri icin tercih edilebilir
               ancak failed olan her assertion'in yerini soylemediginden
               hatalarin yerini bulabilmek icin
               assertion'lara aciklama eklemekte fayda vardir
             - Eger assertion'lari yaptigimiz halde
               en sona assertall() demeyi unutursak
               assertion'lar failed olsa bile TEST PASSED diye sonuc verir

         */








}
