package se.lexicon.data;

import se.lexicon.model.ParkingSpot;

import java.util.Collection;

public interface ParkingSpotDao {

    ParkingSpot create(ParkingSpot parkingSpot);

    ParkingSpot findBySpotNumber(int spotNumber);

    boolean removeBySpotNumber(int spotNumber);

    Collection<ParkingSpot> findAll();

    Collection<ParkingSpot> findByAreaCode(String areaCode);

    void occupy();

    void vacate();

}
