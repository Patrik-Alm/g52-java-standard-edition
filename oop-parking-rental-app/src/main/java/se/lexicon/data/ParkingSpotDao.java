package se.lexicon.data;

import se.lexicon.model.ParkingSpot;

import java.util.Collection;

public interface ParkingSpotDao {

    ParkingSpot create(ParkingSpot parkingSpot);

    ParkingSpot findBySpotNumber(int spotNumber);

    boolean removeBySpotNumber(int spotNumber);

    Collection<ParkingSpot> findAll();

    Collection<ParkingSpot> findByAreaCode(int areaCode);

    void occupy(ParkingSpot parkingSpot);

    void vacate(ParkingSpot parkingSpot);

}
