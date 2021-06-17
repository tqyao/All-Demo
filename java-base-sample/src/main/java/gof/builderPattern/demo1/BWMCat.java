/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.builderPattern.demo1;

/**
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/11 11:12 <br>
 */
public class BWMCat implements Vehicle {

    private Engine engine;
    private String wheel;
    private String seat;

    public BWMCat(){}

    public BWMCat(Engine engine, String wheel, String seat) {
        this.engine = engine;
        this.wheel = wheel;
        this.seat = seat;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s,%s,%s", engine.running(), wheel, seat));
    }
}
