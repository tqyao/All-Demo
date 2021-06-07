package gof.simpleFactoryPattern;

import java.security.PrivateKey;
import java.time.LocalDate;

public class LocalDateFactory {
    public static void main(String[] args) {
        System.out.println(fromInt(20210606));

    }
    public static LocalDate fromInt(int yyyyMMdd) {
        int year = yyyyMMdd / 10000;
        int month = yyyyMMdd % 10000 / 100;
        int day = yyyyMMdd % 100;

//       if (month < 10) {
//           month = Integer.getInteger("0" + month);
//       }
//       if (day < 10) {
//           day = Integer.getInteger("0" + day);
//       }

        return LocalDate.of(year, month, day);
    }
}
