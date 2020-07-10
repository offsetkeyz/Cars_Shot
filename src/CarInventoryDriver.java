import java.io.FileNotFoundException;
import java.io.IOException;

public class CarInventoryDriver {

    private static CarList scanner;

    public static void main(String[] args) throws IOException {
        try {
            scanner = new CarList("test input files\\July_7_Photo_Upload.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print(scanner.totalIncome());
    }


}
