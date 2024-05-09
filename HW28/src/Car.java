public class Car {
    private  int price;
    private final String label;
    private final int yearOfCreation;



    public Car(String label, int yearOfCreation, int price) {
        this.label = label;
        this.yearOfCreation = yearOfCreation;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        if(price > 0){
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", label='" + label + '\'' +
                ", yearOfCreation=" + yearOfCreation +
                '}';
    }
}
