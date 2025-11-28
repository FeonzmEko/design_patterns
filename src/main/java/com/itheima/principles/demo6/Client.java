package com.itheima.principles.demo6;

public class Client {
    public static void main(String[] args) {
        Color red = new Red();
        MoveBehavior petrol = new PetrolCar();

        Car redPetrolCar = new Car(red,petrol);
        redPetrolCar.showInfo();
        redPetrolCar.move();
    }
}
