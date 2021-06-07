package gof.BuilderPattern;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class PhoneDemo {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .battery("4000hm")
                .cpu("xiaolong865")
                .camera("suoni")
                .screen("sanqing")
                .speaker("xxx")
                .build();
        System.out.println(phone);
    }
}
