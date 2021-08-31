package LambdaDersleri.IkinciGun.AbstractIkinciSoru;

import java.util.Scanner;

public class Runner {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Musteri musteri = new Musteri();
    System.out.println(
      "Ekmeği nereden almak istersiniz : \n1-Market\n2-Halkekmek"
    );
    int tercih = scan.nextInt();
    if (tercih == 1) {
      musteri.anaAbstract = new Market();
      musteri.alisveris();
      System.out.println();
    } else {
      musteri.anaAbstract = new HalkEkmek();
      System.out.println();
      musteri.alisveris();
    }
  }
}
