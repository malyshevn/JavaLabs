// Малышев Никита Евгеньевич
// группа ПРИ-О-21, вариант 11
// Работа №3, Задание 2. Обработка и запись файлов
/*
Создайте структуру классов с указанным в варианте базовым классом. Добавьте также два производных
класса и агрегирующий класс, который предусматривает работу указанного метода раздельного подсчёта
(используйте оператор instanceof).
Каждый класс (кроме агрегирующего) должен содержать по меньшей мере 4 поля, для каждого из которых
необходимо добавить методы чтения (getter) и записи (setter), а также ввод всех данных класса с клавиатуры.
Основная программа должна иметь меню, при помощи которого должна быть возможность выводить список существующих объектов в агрегирующем объекте, добавление новых элементов, удаление и подсчёт
объектов каждого типа.
Базовый класс   Производные классы     Агрегирующий класс
  Компьютер     Ноутбук и Смартфон        РемонтСервис
*/

package Lab3.Task2;
import java.util.ArrayList;
import java.util.Scanner;

// Базовый класс Компьютер
class Computer {
    private String brand;
    private String model;
    private double price;
    private int year;

    // Конструктор
    public Computer(String brand, String model, double price, int year) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    // Методы чтения (getter) и записи (setter)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Метод для ввода данных о компьютере с клавиатуры
    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите марку компьютера:");
        brand = scanner.nextLine();
        System.out.println("Введите модель компьютера:");
        model = scanner.nextLine();
        System.out.println("Введите цену компьютера:");
        price = scanner.nextDouble();
        System.out.println("Введите год выпуска компьютера:");
        year = scanner.nextInt();
    }

    // Переопределение метода toString для вывода информации о компьютере
    @Override
    public String toString() {
        return "Компьютер: " + brand + " " + model + ", Цена: " + price + " руб., Год выпуска: " + year;
    }
}

// Производный класс Ноутбук
class Laptop extends Computer {
    private double screenSize;
    private int batteryLife;

    // Конструктор
    public Laptop(String brand, String model, double price, int year, double screenSize, int batteryLife) {
        super(brand, model, price, year);
        this.screenSize = screenSize;
        this.batteryLife = batteryLife;
    }

    // Методы чтения (getter) и записи (setter) для дополнительных полей
    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    // Переопределение метода ввода данных о ноутбуке с клавиатуры
    @Override
    public void inputDetails() {
        super.inputDetails();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер экрана ноутбука (в дюймах):");
        screenSize = scanner.nextDouble();
        System.out.println("Введите время автономной работы ноутбука (в часах):");
        batteryLife = scanner.nextInt();
    }
}

// Производный класс Смартфон
class Smartphone extends Computer {
    private int cameraResolution;
    private boolean dualSim;

    // Конструктор
    public Smartphone(String brand, String model, double price, int year, int cameraResolution, boolean dualSim) {
        super(brand, model, price, year);
        this.cameraResolution = cameraResolution;
        this.dualSim = dualSim;
    }

    // Методы чтения (getter) и записи (setter) для дополнительных полей
    public int getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
    }

    public boolean isDualSim() {
        return dualSim;
    }

    public void setDualSim(boolean dualSim) {
        this.dualSim = dualSim;
    }

    // Переопределение метода ввода данных о смартфоне с клавиатуры
    @Override
    public void inputDetails() {
        super.inputDetails();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите разрешение камеры смартфона (в мегапикселях):");
        cameraResolution = scanner.nextInt();
        System.out.println("Смартфон поддерживает две SIM-карты? (true/false):");
        dualSim = scanner.nextBoolean();
    }
}

// Агрегирующий класс РемонтСервис
class RepairService {
    private ArrayList<Computer> computers = new ArrayList<>();

    // Метод для добавления компьютера в сервис
    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    // Метод для вывода списка компьютеров в сервисе
    public void printComputers() {
        if (computers.isEmpty()) {
            System.out.println("Нет компьютеров в сервисе.");
        } else {
            System.out.println("Компьютеры в сервисе:");
            for (int i = 0; i < computers.size(); i++) {
                System.out.println((i + 1) + ". " + computers.get(i));
            }
        }
    }

    // Метод для удаления компьютера из сервиса
    public void removeComputer(int index) {
        if (index >= 0 && index < computers.size()) {
            computers.remove(index);
            System.out.println("Компьютер успешно удален из сервиса.");
        } else {
            System.out.println("Некорректный индекс компьютера.");
        }
    }

    // Метод для подсчета количества ноутбуков в сервисе
    public int countLaptops() {
        int count = 0;
        for (Computer computer : computers) {
            if (computer instanceof Laptop) {
                count++;
            }
        }
        return count;
    }

    // Метод для подсчета количества смартфонов в сервисе
    public int countSmartphones() {
        int count = 0;
        for (Computer computer : computers) {
            if (computer instanceof Smartphone) {
                count++;
            }
        }
        return count;
    }
}

// Основная программа
public class Main {
    public static void main(String[] args) {
        RepairService repairService = new RepairService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Вывести список компьютеров в сервисе");
            System.out.println("2. Добавить новый компьютер в сервис");
            System.out.println("3. Удалить компьютер из сервиса");
            System.out.println("4. Подсчитать количество ноутбуков в сервисе");
            System.out.println("5. Подсчитать количество смартфонов в сервисе");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Чтобы считать символ новой строки после ввода числа

            switch (choice) {
                case 0:
                    System.out.println("Программа завершена.");
                    return;
                case 1:
                    repairService.printComputers();
                    break;
                case 2:
                    System.out.println("Выберите тип компьютера (1 - Ноутбук, 2 - Смартфон): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();  // Чтобы считать символ новой строки после ввода числа
                    if (type == 1) {
                        Laptop laptop = new Laptop("", "", 0, 0, 0, 0);
                        laptop.inputDetails();
                        repairService.addComputer(laptop);
                    } else if (type == 2) {
                        Smartphone smartphone = new Smartphone("", "", 0, 0, 0, false);
                        smartphone.inputDetails();
                        repairService.addComputer(smartphone);
                    } else {
                        System.out.println("Некорректный выбор типа компьютера.");
                    }
                    break;
                case 3:
                    System.out.println("Введите номер компьютера для удаления: ");
                    int index = scanner.nextInt();
                    repairService.removeComputer(index - 1);
                    break;
                case 4:
                    System.out.println("Количество ноутбуков в сервисе: " + repairService.countLaptops());
                    break;
                case 5:
                    System.out.println("Количество смартфонов в сервисе: " + repairService.countSmartphones());
                    break;
                default:
                    System.out.println("Некорректный выбор. Повторите попытку.");
            }
        }
    }
}
