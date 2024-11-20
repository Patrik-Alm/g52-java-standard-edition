package se.lexicon.model;

import java.time.LocalDate;

public class Reservation {

    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Customer customer;
    private Vehicle associatedVehicle;
    private ParkingSpot parkingSpot;

    public Reservation(int id, LocalDate startDate, LocalDate endDate, Customer customer, Vehicle associatedVehicle, ParkingSpot parkingSpot) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.associatedVehicle = associatedVehicle;
        this.parkingSpot = parkingSpot;
    }

    public boolean extend(int days){
        if (days <= 0){
            return false;
        }

        endDate = endDate.plusDays(days);
        return true;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getAssociatedVehicle() {
        return associatedVehicle;
    }

    public void setAssociatedVehicle(Vehicle associatedVehicle) {
        this.associatedVehicle = associatedVehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
