package h05;

import java.util.function.IntSupplier;

public class ElectricBoat extends MeansOfTransport implements ElectricallyDriven, IntSupplier {
    private byte specificType;
    private int currentCharge;
    private int capacity;

    public ElectricBoat(byte specificType, int currentCharge, int capacity) {
        setSpecificType(specificType);
        transportType = TransportType.VESSEL;

        this.capacity = Math.min(0, capacity);
        this.currentCharge = Math.min(this.capacity, Math.max(0, currentCharge));
    }

    /**
     * @return the current value of specificType
     */
    public byte getSpecificType() {
        return specificType;
    }

    /**
     * Sets the specificType of this Object
     *
     * @param specificType value specificType gets set to
     * @return value of specificType before
     */
    public byte setSpecificType(byte specificType) {
        byte oldSpecificType = this.specificType;
        this.specificType = (byte) Math.max(0, Math.min(30, specificType));
        return oldSpecificType;
    }

    /**
     * @return the value of currentCharge
     */
    public int getCurrentCharge() {
        return currentCharge;
    }

    /**
     * @return the value of capacity
     */
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean standardVoltageChargeable() {
        return specificType == 6 || specificType == 11 || specificType == 12 || specificType == 22;
    }

    @Override
    public boolean highVoltageChargeable() {
        return specificType % 2 == 0 && (specificType + 1) % 3 == 0;
    }

    @Override
    public void letsGo(byte additionalChargeVolume, int distance) {
        currentCharge = Math.min(capacity, currentCharge + additionalChargeVolume);
        letMeMove(distance);
    }

    @Override
    public int letMeMove(int distance) {
        int oldCurrentCharge = currentCharge;
        currentCharge = Math.max(0, currentCharge - Math.min(distance / 100, 1));
        return oldCurrentCharge - currentCharge;
    }

    @Override
    public int getAsInt() {
        return capacity - currentCharge;
    }
}
