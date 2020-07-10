import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarList { //TODO store the data

   private File email;
   private List<Car> allCars;

   /**
    * Scans in a text file in the dealers specific format.
    * @param fileName
    * @throws FileNotFoundException
    */
   public CarList(String fileName) throws IOException {
      try {
         email = new File(fileName);
         if (!email.canRead()) {
            throw new Exception();
         }
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("File could not be read in.");
      }
      allCars = this.getAllCars();
   }

   /**
    * Calculates the total income for all cars in this list.
    * @return double.
    */
   public double totalIncome() {
      double income = 0.0;
      for (Car c : allCars) {
         income += c.calculateIncome();
      }
      return income;
   }

   /**
    * Returns an ArrayList of all cars found in this email.
    * @return ArrayLis
    */
   public List<Car> getAllCars() throws IOException {
      if(!this.isValidEmail()) {
         System.exit(0);
      }

      this.replaceUsed();

      List<Car> allCars = new ArrayList<>();
      ArrayList<String> strings = this.getAllCarLines();
      for (int i = 0; i < strings.size() - 3; i++) {
         String currentLine = strings.get(i);
         Scanner lineScan = new Scanner(currentLine);
         String dealership = "";
         String test = "";
         do {
            dealership += test + " ";
            test = lineScan.next();
         } while(!test.equals("(NEW)")
                 && !test.equals("(USED)"));
         dealership = dealership.trim();

         // new car and stock number
         boolean isNew = test.equals("(NEW)");
         String stockNumber = lineScan.next();

         // year make model
         String yearMakeModel = lineScan.next();
         Scanner ymm = new Scanner(yearMakeModel);
         ymm.useDelimiter("/");
         String year = ymm.next();
         String make = ymm.next();
         String model = ymm.next();
         String nxt = "";
         do {
            model += " " + nxt;
            nxt = lineScan.next();
         } while(!nxt.matches(".*\\d.*"));

         int numPics = Integer.parseInt(nxt);

         Car c = new Car(dealership, stockNumber, year, make, model, numPics, isNew);
         allCars.add(c);
      }
      System.out.println("Cars added: " + allCars.size());
      return allCars;
   }

   /**
    * Replaces "(USED)" to add a space afterwards.
    * Occasionally the (USED) is merged with the stock number.
    * This fixes that issue.
    * @throws IOException
    */
   private void replaceUsed() throws IOException {
      String oldContent = "";
      String newContent = "";
      BufferedReader reader = new BufferedReader(new FileReader(email));
      //Reading all the lines of input text file into oldContent
      String line = reader.readLine();

      while (line != null) {
         oldContent = oldContent + line + System.lineSeparator();
         line = reader.readLine();
      }
      newContent = oldContent.replaceAll("\\(USED\\)", "(USED) ");
      FileWriter write = new FileWriter(email);
      write.write(newContent);

      reader.close();
      write.close();

   }

   /**
    * Takes in a String and removes extra spaces.
    * @param lineIn original line
    * @return String line with reduced spaces
    */
   private String reduceSpaces(String lineIn) {
      String output = "";
      Scanner scan = new Scanner(lineIn);
      while(scan.hasNext()) {
         output += scan.next();
         output += " ";
      }
      return output;
   }

   /**
    * Parses through the email to find lines that represent individual cars.
    *    Then it condenses each line and adds it to an ArrayList.
    *    This method basically prepares the email for quick processing.
    * @return ArrayList full of strings.
    */
   private ArrayList<String> getAllCarLines() throws FileNotFoundException {
      ArrayList<String> allCars = new ArrayList<>();
      Scanner emailScan = new Scanner(email);
      // skips top 7 lines
      for (int i = 0; i < 7; i++) {
         emailScan.nextLine();
      }
      String nextL = "";
      while(emailScan.hasNextLine()) {
         nextL = emailScan.nextLine();
         Scanner lineScanner = new Scanner(nextL);
         String trimmedLine = "";
         while(lineScanner.hasNext()) {
            trimmedLine += lineScanner.next() + " ";
         }
         allCars.add(trimmedLine);
      }

      return allCars;
   }

   /**
    * Determines if the email is valid by
    *    checking if the first word starts with 'B'
    *    for "Batch"
    * @return boolean
    */
   private boolean isValidEmail() throws FileNotFoundException {
      Scanner emailScan = new Scanner(email);
      emailScan.nextLine();
      String nextL = emailScan.nextLine();
      return nextL.charAt(0) == 'B';
   }

   /**
    * Determines how many lines are in the email.
    * @return int
    */
   private int numLines() throws FileNotFoundException {
      int counter = 0;
      Scanner counterScan = new Scanner(email);
      while(counterScan.hasNextLine()) {
         counter++;
         counterScan.nextLine();
      }
      return counter;
   }

}
