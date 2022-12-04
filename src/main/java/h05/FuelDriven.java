package h05;

/**
 * Represents something which is driven by fuel
 */
public interface FuelDriven {
    /**
     * @return the FuelType of the Vehicle
     */
    FuelType getFuelType();

    /**
     * @param speed current speed of vehicle
     * @return the Average Consumption depending on the current speed
     */
    double getAverageConsumption(double speed);
}
