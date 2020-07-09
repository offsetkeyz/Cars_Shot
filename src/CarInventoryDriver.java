import java.io.FileNotFoundException;

public class CarInventoryDriver {

    private static EmailScanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        try {
            scanner = new EmailScanner("test input files\\July_7_Photo_Upload.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.getAllCars();
    }


}
