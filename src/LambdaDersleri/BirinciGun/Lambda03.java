package LambdaDersleri.BirinciGun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda03 {

  public static void main(String[] args) {
    List<Integer> l = new ArrayList<>(
      Arrays.asList(7, 12, 14, 4, 9, 2, 4, 12, 16)
    );
    ilkDortEleman(l);
    System.out.println();
    ilkDortElemanGec(l);
  }

  //2) küçükten büyüğe sırala ve ilk dört elemanı atlayarak yazdır.
  public static void ilkDortElemanGec(List<Integer> l) {
    l.stream().sorted().skip(4).forEach(MethodLambda02::bosluklaYazdir);
  }

  //1)küçükten büyüğe sırala ve ilk dört eleamnını yazdır.

  public static void ilkDortEleman(List<Integer> l) {
    l.stream().sorted().limit(4).forEach(MethodLambda02::bosluklaYazdir);
  }
}
