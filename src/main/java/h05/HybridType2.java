package h05;

public class HybridType2 extends MeansOfTransport implements FuelDriven, ElectricallyDriven {

    private HybridType1 hybridObject;

    HybridType2() {
        hybridObject = new HybridType1();
    }

    @Override
    public boolean standardVoltageChargeable() {
        return hybridObject.standardVoltageChargeable();
    }

    @Override
    public boolean highVoltageChargeable() {
        return hybridObject.highVoltageChargeable();
    }

    @Override
    public void letsGo(byte additionalChargeVolume, int distance) {
        hybridObject.letsGo(additionalChargeVolume, distance);
    }

    @Override
    public FuelType getFuelType() {
        return hybridObject.getFuelType();
    }

    @Override
    public double getAverageConsumption(double speed) {
        return hybridObject.getAverageConsumption(speed);
    }

    @Override
    public int letMeMove(int distance) {
        return 0;
    }
}
