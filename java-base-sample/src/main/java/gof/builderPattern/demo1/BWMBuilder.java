/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.builderPattern.demo1;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/11 11:20 <br>
 */
public class BWMBuilder implements Builder {

    private BWMCat cat = new BWMCat();

    @Override
    public Builder setEngine(Engine engine) {
        cat.setEngine(engine);
        return this;
    }

    @Override
    public Builder setWheel(String wheel) {
        cat.setWheel(wheel);
        return this;
    }

    @Override
    public Builder setSeat(String seat) {
        cat.setSeat(seat);
        return this;
    }

    @Override
    public Vehicle build() {
        return cat;
    }

    public static BWMBuilder builder(){
        return new BWMBuilder();
    }
}
