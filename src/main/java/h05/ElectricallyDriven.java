package h05;

public interface ElectricallyDriven {
    boolean standardVoltageChargeable();
    boolean highVoltageChargeable();
    void letsGo(byte additionalChargeVolume, int distance);
}
