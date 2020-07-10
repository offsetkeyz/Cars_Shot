/**
 * //TODO add javadoc to each method
 */
public class Car {

    private String customer, stockNumber, make, year, model;
    private int numPics;
    private boolean newCar, video;
    private double income;

    private final double NEW_CAR_INCOME = 2.75;
    private final double USED_21to24_INCOME =  5.00;
    private final double USED_27to32_INCOME = 5.50;
    private final double VIDEO_INCOME = 3.00;

    public Car(String customerIn, String stockNumberIn,
               String yearIn, String makeIn, String modelIn, int numPicsIn, boolean newCarIn) { //TODO assign date to each car
        this.customer = customerIn;
        this.stockNumber = stockNumberIn;
        this.year = yearIn;
        this.make = makeIn;
        this.model = modelIn;
        this.numPics = numPicsIn;
        this.newCar = newCarIn;
        this.video = true;

        this.income = this.calculateIncome();

    }

    public double calculateIncome() {
        double income = 0.0;
        switch (customer) {
            case "Findlay Honda NW":
                if (newCar) {
                    income = NEW_CAR_INCOME;
                } else {
                    income = USED_27to32_INCOME;
                    if (this.video) {
                        income += VIDEO_INCOME;
                    }
                }
                break;

            case "Findlay North VW":
                if (newCar) {
                    income = NEW_CAR_INCOME;
                    if (this.video) {
                        income += VIDEO_INCOME;
                    }
                } else {
                    income = USED_21to24_INCOME;
                }
                break;

            case "Prestige CJDR":
                if (newCar) {
                    income = NEW_CAR_INCOME;
                } else {
                    income = USED_21to24_INCOME;
                    if (video) {
                        income += VIDEO_INCOME;
                    }
                }
                break;

            case "Jim Marsh Chrysler Jeep":

            case "Jim Marsh Kia":
                if (newCar) {
                    income = NEW_CAR_INCOME;
                } else {
                    income = USED_27to32_INCOME;
                }
                break;

            default:
                System.out.println("Something went wrong finding the customer");

        }
        return income;
    }

    public void setVideo(boolean b) {
        this.video = b;
    }

    @Override
    public String toString() {
        return newCar + " - " + customer + " - " + stockNumber + " - " + year + " - " + make + " - " + model + " - " + numPics;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public String setYear(String year) {
        this.year = year;
        return this.year;
    }

    public int getNumPics() {
        return numPics;
    }

    public void setNumPics(int numPics) {
        this.numPics = numPics;
    }

}
