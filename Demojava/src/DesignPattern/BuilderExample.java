package DesignPattern;


public class BuilderExample {
    public static class Car {
        private String make;
        private String model;
        private int year;
        private String color;
        private boolean isElectric;

        private Car(Builder builder) {
            this.make = builder.make;
            this.model = builder.model;
            this.year = builder.year;
            this.color = builder.color;
            this.isElectric = builder.isElectric;
        }
        @Override
        public String toString() {
            return "Car [make=" + make + ", model=" + model + ", year=" + year + ", color=" + color + ", isElectric="
                    + isElectric + "]";
        }

        public static class Builder {
            private String make;
            private String model;
            private int year = 0;
            private String color = "Unknown";
            private boolean isElectric = false;

            public Builder(String make, String model) {
                this.make = make;
                this.model = model;
            }

            public Builder setYear(int year) {
                this.year = year;
                return this;
            }

            public Builder setColor(String color) {
                this.color = color;
                return this;
            }

            public Builder setElectric(boolean isElectric) {
                this.isElectric = isElectric;
                return this;
            }

            public Car build() {
                return new Car(this);
            }

        }
    }

    public static void main(String[] args) {
        Car car = new Car.Builder("Tesla", "Model S")
                .setYear(2022)
                .setColor("Red")
                .setElectric(true)
                .build();

        System.out.println(car);
    }
}
