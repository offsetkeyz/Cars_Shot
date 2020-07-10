import java.util.ArrayList;
import java.util.List;

public class AllCars {

   private ArrayList<List<Car>> allCars;

   public AllCars() {
      allCars = new ArrayList<List<Car>>();
   }

   public void addCars(List<Car> l) {
      allCars.add(l);
   }
}
