package h05;

/**
 * Defines a HybridVehicle
 */
public class HybridType3 implements HybridVehicle {

    private static FuelType fuelType;
    private static double averageConsumption;
    private static boolean standardVoltageChargeable;
    private static boolean highVoltageChargeable;
    private static DriveType preferredDriveType;

    @Override
    public boolean standardVoltageChargeable() {
        return standardVoltageChargeable;
    }

    @Override
    public boolean highVoltageChargeable() {
        return highVoltageChargeable;
    }

    @Override
    public void letsGo(byte additionalChargeVolume, int distance) {

    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * Setter for fuelType
     *
     * @param fuelType value to set fuelType to
     */
    public void setFuelType(FuelType fuelType) {
        HybridType3.fuelType = fuelType;
    }

    @Override
    public double getAverageConsumption(double speed) {
        return averageConsumption;
    }

    /**
     * Setter for avergae Consumption
     *
     * @param averageConsumption value to set averageConsumption to
     */
    public void setAverageConsumption(double averageConsumption) {
        HybridType3.averageConsumption = averageConsumption;
    }

    /**
     * Toggles the value of standardVoltageChargeable
     */
    public void toggleStandardVoltageChargeable() {
        standardVoltageChargeable = !standardVoltageChargeable;
    }

    /**
     * Toggles the value of highVoltageChargeable
     */
    public void toggleHighVoltageChargeable() {
        highVoltageChargeable = !highVoltageChargeable;
    }

    @Override
    public DriveType getPreferredDriveType() {
        return preferredDriveType;
    }

    /**
     * Toggles the value of prefferedDriveType between ELECTRICAL and FUEL_BASED
     */
    public void togglePreferredDriveType() {
        preferredDriveType = preferredDriveType == DriveType.ELECTRICAL ? DriveType.FUEL_BASED : DriveType.ELECTRICAL;
    }
}
