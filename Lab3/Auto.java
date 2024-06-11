package Lab3;

public class Auto {
    // Закрытый член нашего класса с названием фирмы автомобиля
    private String firm;
    // Закрытый член класса, содержащий максимальную скорость
    private int maxSpeed;
    // Закрытый член класса, содержащий гос. номер
    private String licensePlate;

    // Открытая функция (метод класса) для задания значения фирмы автомобиля
    public void setFirm(String firma) {
        firm = firma;
    }

    // Открытая функция (метод класса) для задания значения максимальной скорости автомобиля
    public void setMaxSpeed(int speed) {
        maxSpeed = speed;
    }

    // Открытая функция (метод класса) для задания значения гос. номера
    public void setLicensePlate(String license) {
        licensePlate = license;
    }

    // Открытая функция (метод класса) для вывода значения гос. номера
    public String getLicensePlate() {
        return licensePlate;
    }

    // Открытая функция (метод класса) для вывода значения максимальной скорости
    public int getMaxSpeed() {
        return maxSpeed;
    }

    // Открытая функция (метод класса) для вывода значения заданной фирмы
    public String getFirm() {
        return firm;
    }

    // Конструктор класса (без параметров)
    public Auto() {
        firm = "Без названия";
        maxSpeed = 0;
        licensePlate = "Без номера";
    }

    // Конструктор класса (с параметрами)
    public Auto(String firma, int speed, String license) {
        firm = firma;
        maxSpeed = speed;
        licensePlate = license;
    }

    // Переопределенный метод toString для вывода информации об автомобиле
    @Override
    public String toString() {
        return "Фирма: " + firm + ", Макс. скорость: " + maxSpeed + " км/ч, Гос. номер: " + licensePlate;
    }
}
