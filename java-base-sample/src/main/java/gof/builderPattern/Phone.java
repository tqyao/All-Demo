/**
 * Copyright 2020-2030 The author personally reserves all rights.
 */
package gof.builderPattern;

/**
 * 建造者模式用途之一
 * .<br>
 *
 * @author tanqinyao<br>
 * @version 1.0.0 <br>
 * @date Create in 2021/6/7 22:00 <br>
 */
public class Phone {

    private String cup;
    private String screen;
    private String speaker;
    private String camera;
    private String battery;

    private Phone(Builder builder) {
        this.cup = builder.cpu;
        this.screen = builder.screen;
        this.speaker = builder.speaker;
        this.camera = builder.camera;
        this.battery = builder.battery;
    }

    public static final class Builder {

        private String cpu;
        private String screen;
        private String speaker;
        private String camera;
        private String battery;

        public  Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder speaker(String speaker) {
            this.speaker = speaker;
            return this;
        }
        public Builder camera(String camera) {
            this.camera = camera;
            return this;
        }
        public Builder battery(String battery) {
            this.battery = battery;
            return this;
        }

        public Phone build(){
            return new Phone(this);
        }

    }

    @Override
    public String toString() {
        return "Phone{" +
                "cup='" + cup + '\'' +
                ", screen='" + screen + '\'' +
                ", speaker='" + speaker + '\'' +
                ", camera='" + camera + '\'' +
                ", battery='" + battery + '\'' +
                '}';
    }
}

