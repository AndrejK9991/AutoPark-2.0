import model.*;
import model.enums.Brand;
import model.enums.CategoryOfRights;
import model.enums.Color;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void menu() throws IOException {
        System.out.println("|    Hello in taxi7788!!!    |");
        Scanner input = new Scanner(System.in);
        int choise;

//        Car[] autoPark = new Car[99];
//        Driver[] drivers = new Driver[99];

        Autopark autoparkVederko = new Autopark();
        autoparkVederko.setName("Vederko");
        autoparkVederko.setCars(FileUtil.parseCarFile("auto.txt"));
        autoparkVederko.setDrivers(FileUtil.parseDriverFile("drivers.txt"));

        do {
            System.out.println("для добавления Авто - введите 1; Водителя - 2; Сохранить - 3 ");
            choise = input.nextInt();

            switch (choise) {
                case 1:

                    Passenger newAuto = new Passenger();

                    System.out.println("Введите тип авто:");
                    newAuto.setBrand(Brand.valueOf(input.next()));
                    System.out.println("Введите цвет авто:");
                    newAuto.setColor(Color.valueOf(input.next()));
                    System.out.println("Введите год авто:");
                    newAuto.setYear(input.nextInt());
                    int freeIndex = autoparkVederko.getFreeIndexCar();
                    autoparkVederko.getCars()[freeIndex] = newAuto;
                    System.out.println("Новое авто успешно добавлено!!!");
                    System.out.println("Сохранить текущий статус автопарка?");

                    break;
                case 2:

                    Man newHuman = new Man();
                    System.out.println("Введите ФИО:");
                    newHuman.setFio(input.next());
                    System.out.println("Введите возраст:");
                    newHuman.setAge(input.nextInt());
                    System.out.println("Введите категорию прав:");
                    newHuman.setCategoryOfRights(CategoryOfRights.valueOf(input.next()));
                    int freeIndexDr = autoparkVederko.getFreeIndexDriver();
                    autoparkVederko.getDrivers()[freeIndexDr] = newHuman;
                    System.out.println("Новый водитель принят!!!");
                    System.out.println("Сохранить текущий статус автопарка?");
                    break;
                case 3:
                    FileUtil.writeFileAuto("C:\\book\\AutoPark 2.0\\auto.txt", autoparkVederko.getCars());
                    FileUtil.writeFileDriver("C:\\book\\AutoPark 2.0\\drivers.txt", autoparkVederko.getDrivers());
            }
        } while (choise != '0');
    }

//
//    public static int getFreeIndexDriver(Driver[] drivers) {
//        for (int i = 0; i < drivers.length; i++) {
//            if (drivers[i] == null) {
//                return i;
//            }
//        }
//        return -1;
//    }
//    public static int getFreeIndexCar(Car[] autoPark) {
//        for (int i = 0; i < autoPark.length; i++) {
//            if (autoPark[i] == null) {
//                return i;
//            }
//        }
//        return -1;
//    }

}
