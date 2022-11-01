package h05;

public class HybridType1 implements FuelDriven, ElectricallyDriven {

    private static FuelType fuelType;
    private static double averageConsumption;
    private static boolean standardVoltageChargeable;
    private static boolean highVoltageChargeable;

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
        this.fuelType = fuelType;
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
        this.averageConsumption = averageConsumption;
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
}
