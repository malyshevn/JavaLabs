package Lab3;

public class Car extends Auto {
    private String model;
    private int numDoors;
    private Boolean fullTime; // Полный привод

    public Car() {
        // Вызываем конструктор класса-родителя без параметров (см. класс Auto)
        super();
        model = ""; // Добавляем инициализацию новых членов
        numDoors = 4;
        fullTime = false;
    }

    public Car(String firma, int speed, String license, String name, int n, Boolean f) {
        // Вызываем конструктор класса-родителя с параметрами (см. класс Auto)
        super(firma, speed, license);
        model = name; // Добавляем инициализацию новых членов
        numDoors = n;
        fullTime = f;
    }

    public void setModel(String name) {
        model = name;
    }

    public String getModel() {
        return model;
    }

    public void setNumDoors(int n) {
        numDoors = n;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setFullTime(Boolean b) {
        fullTime = b;
    }

    public Boolean isFullTime() {
        return fullTime;
    }

    @Override
    public String toString() {
        return super.toString() + ", Модель: " + model + ", Количество дверей: " + numDoors + ", Полный привод: " + fullTime;
    }
}
