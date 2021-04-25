package com.example.carparking;

import com.example.carparking.dao.AdminRepository;
import com.example.carparking.dao.CarRepository;
import com.example.carparking.dao.OwnerRepository;
import com.example.carparking.dao.ParkingLotRepository;
import com.example.carparking.entity.Admin;
import com.example.carparking.entity.Car;
import com.example.carparking.entity.Owner;
import com.example.carparking.entity.ParkingLot;
import com.example.carparking.service.AdminService;
import com.example.carparking.service.CarService;
import com.example.carparking.service.OwnerService;
import com.example.carparking.service.ParkingLotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class CarParkingApplicationTests {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CarService carService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private ParkingLotService parkingLotService;

    @MockBean
    private AdminRepository adminRepository;

    @MockBean
    private CarRepository carRepository;

    @MockBean
    private OwnerRepository ownerRepository;

    @MockBean
    private ParkingLotRepository parkingLotRepository;

    /*----- Admin Tests --------------------------- */
    @Test
    public void getAdminsTest() {
        when(adminRepository.getAdmins("admin", "admin123")).thenReturn(Stream
                .of(new Admin()).collect(Collectors.toList()));

        assertEquals(1, adminService.getAdmins("admin", "admin123").size());

        verify(adminRepository, times(1)).getAdmins("admin", "admin123");
    }

    /*----- Car Tests --------------------------- */
    @Test
    public void createCarTest() {
        Car car = new Car();

        when(carRepository.insert(car)).thenReturn(car);

        assertEquals(car, carService.createCar(car));

        verify(carRepository, times(1)).insert(car);
    }

    @Test
    public void updateCarTest() {
        Car car = new Car();

        when(carRepository.save(car)).thenReturn(car);

        assertEquals(car, carService.updateCar(car));

        verify(carRepository, times(1)).save(car);
    }

    /*----- Owner Tests --------------------------- */
    @Test
    public void createOwnerTest() {
        Owner owner = new Owner();

        when(ownerRepository.insert(owner)).thenReturn(owner);

        assertEquals(owner, ownerService.createOwner(owner));

        verify(ownerRepository, times(1)).insert(owner);
    }

    /*----- ParkingLot Tests --------------------------- */
    @Test
    public void updateParkingLotTest() {
        ParkingLot parkingLot = new ParkingLot();

        when(parkingLotRepository.save(parkingLot)).thenReturn(parkingLot);

        assertEquals(parkingLot, parkingLotService.updateParkingLot(parkingLot));

        verify(parkingLotRepository, times(1)).save(parkingLot);
    }

}