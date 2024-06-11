package Lab3;
import java.util.ArrayList;

public class GarageCar {
    // массив с машинами
    private ArrayList<Auto> masCar = new ArrayList<Auto>();

    // метод для добавления машины в гараж
    public void addCar(Auto m) {
        masCar.add(m);
    }

    // конструктор без параметров
    public GarageCar() {
    }

    // конструктор для внесения существующего списка машин
    public GarageCar(ArrayList<Auto> n) {
        // в гараж
        masCar = n;
    }

    // для выяснения – есть ли машина m в гараже
    public Boolean findCar(Auto m) {
        return masCar.contains(m);
    }

    // метод для удаления машины из гаража
    public boolean removeCar(Auto m) {
        return masCar.remove(m);
    }

    // для вывода на экран списка машин в гараже
    public void printGarage() {
        System.out.println("В гараже: ");
        for (Auto a : masCar) {
            System.out.println("\t" + a.toString());
        }
    }
}
