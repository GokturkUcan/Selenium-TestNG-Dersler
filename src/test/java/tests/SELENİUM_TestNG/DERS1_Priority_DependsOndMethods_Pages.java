package tests.SELENİUM_TestNG;

public class DERS1_Priority_DependsOndMethods_Pages {

  /*
        JUnit'de test method'larin hangi sira ile calisacagini ONGOREMEYIZ
        ve istedigimiz sirada calismasini SAGLAYAMAYIZ

        TestNG
        - test method'lari icin biz bir siralama vermezsek, isim sirasina gore calistirir
        - eger method'lar icin oncelik siralamasi yapmak istersek
          method'lara priority degeri atayabiliriz
          TestNG priority degerlerine bakip, kucukten buyuge dogru calistirir
        - Eger bazi method'lara priority atayip, bazilarina atamazsak
          priority atanmayanlar icin default olarak 0 degerini kabul eder
        - Eger priority degeri esit olan method'lar varsa
          priority degeri esit olanlari, kendi iclerinde harf sirasina uygun olarak calistirir

          @Ignore notasyonu yazilan method'lar
          TestNG tarafindan ignore edilir(gormezden gelinir) ve calistirilmaz

     */



     /*
        Eger bir test method'un calismasi icin onceden farkli bir test method'un calismasi gerekiyorsa
        dependsOnMethods kullanabiliriz

        dependsOnMethods bir SIRALAMA yontemi degildir
        siralama icin priority kullanilir

        - calistirmak istedigimiz B method'unda, dependsOnMethod = "A" yazili ise
          A test method'u calisip PASSED olmadikca
          B test method'u IGNORE edilir ve calistirilmaz

        - Eger calistirilma sirasi B'ye geldiyse
          B method'u onceligi A'ya verir
          ve once A calisir, A calisip PASSED olursa B calistirilir

        - Biz sadece B method'unu calistirmak istesek de
          dependsOnMethod ozelliginden dolayi
          TestNG once A method'unu calistirir, sonra B'yi calistirir
          Ancak bu ozellik 2'den fazla method icin calismaz
     */





}
