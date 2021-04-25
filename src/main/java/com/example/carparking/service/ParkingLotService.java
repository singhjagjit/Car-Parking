package com.example.carparking.service;

import com.example.carparking.dao.ParkingLotDAO;
import com.example.carparking.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ParkingLotService {
    @Autowired
    private ParkingLotDAO parkingLotDAO;

    public Collection<ParkingLot> getParkingLots() {
        return parkingLotDAO.getParkingLots();
    }

    public Collection<ParkingLot> getEmptyLots(String size) {
        return parkingLotDAO.getEmptyLots(size);
    }

    public ParkingLot updateParkingLot(ParkingLot parkingLot) {
        return parkingLotDAO.updateParkingLot(parkingLot);
    }
}
