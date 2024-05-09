import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("============= ДЗ 2 =============");
        System.out.println("Введите путь к файлу или папке: ");
        String path = new Scanner(System.in).nextLine();
        printSize(path);

        System.out.println("============= ДЗ 3 =============");
        List<Car> cars = readFile(path);
        cars.forEach(System.out::println);
    }

    private static void printSize(String path) {
        try {
            long fileSize = Files.size(Path.of(path));
            System.out.println(fileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<Car> setSale(List<String> strings) {
        List<Car> cars = new ArrayList<>();
        int quantityPropertiesOfCar = 3;
        double discountOlderThan5Years = 0.05;
        double discountYoungerThan5Years = 0.02;

        for (String string : strings) {
            String[] propertiesOfCar = string.split(" ");

            if (propertiesOfCar.length == quantityPropertiesOfCar) {
                String label = propertiesOfCar[0];
                int yearOfCreation = Integer.parseInt(propertiesOfCar[1]);
                int price = Integer.parseInt(propertiesOfCar[2]);
                int year = Year.now().getValue();
                price = (int) ((year - yearOfCreation > 5) ?  price * (1 - discountOlderThan5Years): price * (1 - discountYoungerThan5Years));

                cars.add(new Car(label,yearOfCreation,price));

            }
            else{
                System.out.println("Недостаточно данных о машине");
            }
        }
        return cars;
    }

    private static List<Car> readFile(String path) {
        List<Car> cars;
        try {
            List<String> strings = Files.readAllLines(Path.of(path));
            cars = setSale(strings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

}
