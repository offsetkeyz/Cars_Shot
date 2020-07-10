import java.io.FileNotFoundException;
import java.io.IOException;

public class CarInventoryDriver {

    private static CarList list1;
    private static CarList list2;
    private static AllCars allCars;

    public static void main(String[] args) throws IOException {
        try {
            list1 = new CarList("test input files\\July_7_Photo_Upload.txt");
            list2 = new CarList("test input files\\list2.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        allCars = new AllCars();
        allCars.addCars(list1.getAllCars());
        allCars.addCars(list2.getAllCars());
        System.out.println(list2.totalIncome()); 
    }


}
