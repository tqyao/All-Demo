/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.builderPattern.demo1;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/11 11:13 <br>
 */
public class Engine {

    String brand;

    Double mileage;

    public Engine(String brand, Double mileage) {
        this.brand = brand;
        this.mileage = mileage;
    }

    public String running(){
        StringBuilder sb = new StringBuilder();
        sb
                .append("use\t")
                .append(brand)
                .append("running\t")
                .append(mileage);
        return sb.toString();
    }
}
