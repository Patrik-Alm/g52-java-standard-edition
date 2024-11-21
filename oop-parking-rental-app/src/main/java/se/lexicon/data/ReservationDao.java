package se.lexicon.data;

import se.lexicon.model.Reservation;

public interface ReservationDao {

    Reservation create(Reservation reservation);

    Reservation findById(int id);

    Reservation findByCustomerId(int cid);

    Reservation findByLicensePlate(String licensePlate);

    Reservation findByParkingSpotNumber(int spotNumber);

    boolean removeById(int id);


}
