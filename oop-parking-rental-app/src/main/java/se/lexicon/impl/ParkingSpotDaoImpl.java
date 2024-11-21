package se.lexicon.impl;

import se.lexicon.data.ParkingSpotDao;
import se.lexicon.model.ParkingSpot;

import java.util.Collection;
import java.util.HashSet;

public class ParkingSpotDaoImpl implements ParkingSpotDao {

    private HashSet<ParkingSpot> parkingSpots = new HashSet<>();

    @Override
    public ParkingSpot create(ParkingSpot parkingSpot) {
        if (!parkingSpots.add(parkingSpot)) {
            throw new IllegalArgumentException("Parking spot already exists.");
        }
        return parkingSpot;
    }

    @Override
    public ParkingSpot findBySpotNumber(int spotNumber) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotNumber() == spotNumber) {
                return spot;
            }
        }
        return null;
    }

    @Override
    public boolean removeBySpotNumber(int spotNumber) {
        ParkingSpot toRemove = findBySpotNumber(spotNumber);
        if (toRemove != null) {
            return parkingSpots.remove(toRemove);

        }
        return false;
    }

    @Override
    public Collection<ParkingSpot> findAll() {
        return new HashSet<>(parkingSpots);
    }


    @Override
    public Collection<ParkingSpot> findByAreaCode(int areaCode) {
        HashSet<ParkingSpot> result = new HashSet<>();
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getAreaCode() == areaCode) {
                result.add(spot);
            }
        }
        return result;
    }

    @Override
    public void occupy(ParkingSpot parkingSpot) {
        if (parkingSpot == null) throw new IllegalArgumentException("parkingSpot was null!");

        ParkingSpot spot = findBySpotNumber(parkingSpot.getSpotNumber());

        if (!spot.isOccupied()) {
            spot.occupy();
        } else {
            throw new IllegalStateException("Parking spot is either occupied or does not exist.");
        }
    }

    @Override
    public void vacate(ParkingSpot parkingSpot) {
        if (parkingSpot == null) throw new IllegalArgumentException("parkingSpot was null!");

        ParkingSpot spot = findBySpotNumber(parkingSpot.getSpotNumber());
        if (spot.isOccupied()) {
            spot.vacate();
        } else {
            throw new IllegalStateException("Parking spot is either vacant or does not exist.");
        }
    }
}

