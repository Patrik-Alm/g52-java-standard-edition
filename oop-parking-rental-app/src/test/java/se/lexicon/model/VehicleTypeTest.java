package se.lexicon.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class VehicleTypeTest {


    @Test
    void getVehicleTypeSuccesfullyCodeOne() {
        // Arrange
        int code = 1;
        // Act
        VehicleType vt = VehicleType.getVehicleType(code);
        // Assert
        assertEquals(VehicleType.CAR,vt);

    }

    @Test
    void getVehicleTypeUnsuccessful() {
        // Arrange
        int code = 12000;
        // Act,Assert
        // Throw an exception
        assertThrowsExactly(
                EnumConstantNotPresentException.class,
                ()-> VehicleType.getVehicleType(code));
    }

}
