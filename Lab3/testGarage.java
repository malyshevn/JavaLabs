package Lab3;

public class testGarage {
    public static void main(String[] args) {
        // Создаем новый гараж
        GarageCar myGarage = new GarageCar();

        // Создаем легковую машину
        Car myCar1 = new Car("Ford", 200, "AB1234CD", "Mustang", 2, false);

        // Добавляем ее в гараж
        myGarage.addCar(myCar1);

        // Добавляем еще одну машину
        myGarage.addCar(new Car("LADA", 140, "EF5678GH", "Kalina", 4, false));

        // Создаем грузовик
        Truck myTruck = new Truck("Dove", 160, "IJ9012KL", "DTS", 700, true);

        // Добавляем его в гараж
        myGarage.addCar(myTruck);

        // Выводим на экран содержимое гаража
        myGarage.printGarage();

        // Ищем машину
        if (myGarage.findCar(myCar1)) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}
