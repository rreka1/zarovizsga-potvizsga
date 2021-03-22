package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {

    private final String address;
    private final int area;
    private final int numberOfFloors;

    public Office(String address, int area, int numberOfFloors) {
        this.address = address;
        this.area = area;
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public int clean() {
        return area * numberOfFloors * 100;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
