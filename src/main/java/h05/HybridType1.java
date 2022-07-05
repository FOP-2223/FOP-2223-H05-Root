package h05;

public class HybridType1 implements FuelDriven, ElectricallyDriven{

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

    public void setFuelType(FuelType fuelType){
        this.fuelType = fuelType;
    }

    public void setAverageConsumption(double averageConsumption){
        this.averageConsumption = averageConsumption;
    }

    public void toggleStandardVoltageChargeable(){
        standardVoltageChargeable = !standardVoltageChargeable;
    }

    public void toggleHighVoltageChargeable(){
        highVoltageChargeable = !highVoltageChargeable;
    }

    @Override
    public double getAverageConsumption(double speed) {
        return averageConsumption;
    }

}
