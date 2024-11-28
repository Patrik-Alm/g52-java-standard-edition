package se.lexicon.impl;

import se.lexicon.data.ReservationDao;
import se.lexicon.model.Reservation;
import java.util.*;
public class ReservationDaoImpl implements ReservationDao {

    private final Set<Reservation> reservations = new HashSet<>();

    @Override
    public Reservation create(Reservation reservation) {
        reservations.add(reservation);
        return reservation;
    }

    @Override
    public Reservation findById(int id) {
        for (Reservation reservation : reservations) {
            if (reservation.getId() == id) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public Reservation findByCustomerId(int customerId) {
        for (Reservation reservation : reservations) {
            if (reservation.getCustomer().getId() == customerId) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public Reservation findByLicensePlate(String licensePlate) {
        for (Reservation reservation : reservations) {
            if (reservation.getAssociatedVehicle().getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public Reservation findByParkingSpotNumber(int spotNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getParkingSpot().getSpotNumber() == spotNumber) {
                return reservation;
            }
        }
        return null;
    }

    @Override
    public boolean removeById(int id) {
        for (Reservation reservation : reservations){
            if (reservation.getId() == id){
               return reservations.remove(reservation);
            }
        }

        return false;
    }
}
