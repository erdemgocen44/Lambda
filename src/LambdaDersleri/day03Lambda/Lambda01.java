package day03Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda01 {

    public static void main(String[] args) {

        List<String> l = new ArrayList<>(Arrays.asList("Ali","Ali","Aysima","Abdurrahman","Mehmet","Mustafa","Bedirhan","Yüksel","Süleyman"));

        yazdirBuyuk1(l);
        System.out.println();
        uzunlukSirala(l);
        System.out.println();
        farkliSonHarfSirala(l);
        System.out.println();
        uzunlukSiralaIlkEleman(l);
        System.out.println();
        yazdirAileBaslayan(l);
        System.out.println();
        AbaslaVeyaiBit(l);
        System.out.println();
        siralaBuyut(l);
        System.out.println();
        isimUzunlukSirala(l);
        System.out.println();
        karesiniAlSiralaSil(l);
        System.out.println();
        ebikGabik(l);
        System.out.println();
        sondanIkinciSiralaIlk(l);
        System.out.println();
        terstenSiralaIlkYazdir(l);


    }



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 1)list in elemanlarını büyük harfle yazdır
    public static void yazdirBuyuk1(List<String> l) {
        l.stream().map(t->t.toUpperCase()).forEach(methodLambda02::bosluklaYazdir);
        // ALİ ALİ AYSİMA ABDURRAHMAN MEHMET MUSTAFA BEDİRHAN YÜKSEL SÜLEYMAN
        System.out.println();
        l.stream().map(String::toUpperCase).forEach(methodLambda02::bosluklaYazdir);
        // ALİ ALİ AYSİMA ABDURRAHMAN MEHMET MUSTAFA BEDİRHAN YÜKSEL SÜLEYMAN
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 2) elemanları uzunluklarına göre sırala ve yazdır... Note: Java, elemanları varsayılan olarak artan sıraya koyar.
    public static void uzunlukSirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).forEach(methodLambda02::bosluklaYazdir); // Kucukten buyuge
        // Ali Ali Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman
        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(methodLambda02::bosluklaYazdir); // buyukten kucuge
        // Abdurrahman Bedirhan Süleyman Mustafa Aysima Mehmet Yüksel Ali Ali
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 3) farklı elemanlarını son harflerine göre sıralayıp yazdır
    public static void farkliSonHarfSirala(List<String> l) {
        l.stream().distinct().sorted(Comparator.comparing(t->t.substring(t.length()-1))).forEach(methodLambda02::bosluklaYazdir);
        // Aysima Mustafa Ali Yüksel Abdurrahman Bedirhan Süleyman Mehmet
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 4) Elemanları uzunluklarına ve ardından (aynı uzunlukta olanları) ilk karakterlerine göre sıralamak için bir yöntem oluşturun
    public static void uzunlukSiralaIlkEleman(List<String> l) {
        l.add("Ata");
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.substring(0,1))).forEach(methodLambda02::bosluklaYazdir);
        // Ali Ali Ata Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman
        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.substring(0,1)).thenComparing(t->t.substring(1,2))).
                forEach(methodLambda02::bosluklaYazdir);
        // Ali Ali Ata Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 5)Büyük harflerle, "A" ile başlayan liste öğelerini yazdırmak için bir yöntem oluşturun
    public static void yazdirAileBaslayan(List<String> l) {

        l.stream().filter(t->t.startsWith("A")).map(String::toUpperCase).forEach(methodLambda02::bosluklaYazdir);
        // ALİ ALİ AYSİMA ABDURRAHMAN ATA
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 6)  Küçük harflerle, "A" ile başlayan veya "i" ile biten liste öğelerini yazdırmak için bir yöntem oluşturun
    public static void AbaslaVeyaiBit(List<String> l) {
        l.stream().filter(t->t.startsWith("A")||t.endsWith("i")).map(String::toLowerCase).forEach(methodLambda02::bosluklaYazdir);
        // ali ali aysima abdurrahman ata
        //metod reference ile yaparsak komutların içine sadece bir işlem alabiliriz.arrow (->) function da && || larla istediğimiz kadar işlem alabiliriz
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 7) Öğeleri uzunluklarına göre sıraladıktan sonra büyük harflerle yazdırmak için bir yöntem oluşturun
    public static void siralaBuyut(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).map(String::toUpperCase).forEach(methodLambda02::bosluklaYazdir);
        // ALİ ALİ ATA AYSİMA MEHMET YÜKSEL MUSTAFA BEDİRHAN SÜLEYMAN ABDURRAHMAN
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 8) Elemanları uzunluklarına göre sıralayın önce elemanı sonra uzunluğunu yazdırın
    // Ali:3 Aysima:6
    public static void isimUzunlukSirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).map(t->t + ":"+ t.length()).forEach(methodLambda02::bosluklaYazdir);
        // Ali:3 Ali:3 Ata:3 Aysima:6 Mehmet:6 Yüksel:6 Mustafa:7 Bedirhan:8 Süleyman:8 Abdurrahman:11
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // Ali:3 Ali:3 Ata:3 Aysima:6 Mehmet:6 Yüksel:6 Mustafa:7 Bedirhan:8 Süleyman:8 Abdurrahman:11
    // 9) Her elemanın uzunluğunun karesini alıp tekrarlıları sil, bunların 20'den büyük olanlarını ters sırada  yazdırın
    public static void karesiniAlSiralaSil(List<String> l) {
        l.stream().map(t->t.length()*t.length()).distinct().filter(t->t>20).sorted(Comparator.reverseOrder()).forEach(methodLambda02::bosluklaYazdir);
        // 121 64 49 36
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // 10) Tüm elemanların uzunluklarını 12'den az olup olmadığını kontrol etmek için bir metod olusturun
    public static void ebikGabik(List<String> l) {

    //allMatch(): bütün elemanlarda olmasını istediğimiz şeyleri yazarız sonuç boolean verir
    //örneğin String bir list için==> allMatch(t -> t.length() < 7)==elemanların hepsinin uzunluğu 7 den küçükse true, biri bile değilse false
        boolean result1=    l.stream().allMatch(t->t.length()<12);
        System.out.println("elemanlarin uzunlukları 12 den kücük mü? : " +result1); // elemanların uzunlukları 12 den küçükmü? true
        System.out.println();

    // bütün elemanların "x" ile baslamadıgını kontrol etmek için bir yöntem olusturun...
    // NOt : noneMatch():hiçbir elemanda olmasın istersek kullanırız, elemanların tümünde yoksa true, bir tane elemanda bile varsa false
    // örneğin==>noneMatch(t-> t.startsWith("X"))==hiçbiri X ile başlamıyorsa true
        boolean result2= l.stream().noneMatch(t->t.startsWith("X"));
        System.out.println("X ile baslayan öge yok : "+result2); // X ile baslayan öge yok : true
        System.out.println();

    // en az 1 tane "R" ile biten eleman olup olmadıgını kontrol etmek icin bir metod olusturun.
    // Not : anyMatch(): en az bir elemanda olmasını istediğimiz bir özellik varsa kullanırız,sonuç boolean dır
    // örneğin==>anyMatch(t-> t.endsWith("R"))== en az bir eleman R ile bitiyorsa true,yoksa false
        boolean result3= l.stream().anyMatch(t->t.endsWith("R"));
        System.out.println("elemanlardan herhangi biri R ile bitiyormu : " +result3); // false -- elemanlardan herhangi biri R ile bitiyormu : false
    }

    // elemanları sondan 2. elemanlarına gore sıralayıp ilk elemanı yazdır
    // Not : findFirst():listedeki ilk elemanı verir. (tek eleman vereceği için, foreach ile yazdırılmaz. Bütün soru syso nun içine alınarak yazdırılabilir)
    public static void sondanIkinciSiralaIlk(List<String> l) {
        System.out.println(l.stream().sorted(Comparator.comparing(t -> t.charAt(t.length() - 2))).findFirst()); // Optional[Abdurrahman]
    }

    // elemanları uzunluklarına göre tersten sıralayıp  ilk elemanı yazdır
    public static void terstenSiralaIlkYazdir(List<String> l) {
        System.out.println(l.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst()); // Optional[Abdurrahman]
        System.out.println();

    // Eleman 'A', 'a' ile başlıyor veya 'N', 'n' ile bitiyorsa o elemanı silin

        l.removeIf(t->t.toUpperCase().startsWith("A")||t.toUpperCase().endsWith("N"));
        System.out.println(l); // [Mehmet, Mustafa, Yüksel]
    }

}