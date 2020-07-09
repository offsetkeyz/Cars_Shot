/**
 * //TODO add javadoc to each method
 */
public class Car {

    private String customer, stockNumber, make, year, model;
    private int numPics;
    private boolean newCar;

    public Car(String customerIn, String stockNumberIn,
               String yearIn, String makeIn, String modelIn, int numPicsIn, boolean newCarIn) { //TODO assign date to each car
        this.customer = customerIn;
        this.stockNumber = stockNumberIn;
        this.year = yearIn;
        this.make = makeIn;
        this.model = modelIn;
        this.numPics = numPicsIn;
        this.newCar = newCarIn;

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
