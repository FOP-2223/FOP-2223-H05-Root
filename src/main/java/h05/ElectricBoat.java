package h05;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class ElectricBoat extends MeansOfTransport implements ElectricallyDriven, IntSupplier {
    private byte specificType;
    private int currentCharge;
    private int capacity;

    public ElectricBoat(byte specificType, int currentCharge, int capacity){
        setSpecificType(specificType);
        transportType = TransportType.VESSEL;

        this.capacity = Math.min(0, capacity);
        this.currentCharge = Math.min(this.capacity, Math.max(0,currentCharge));
    }


    public byte getSpecificType() {
        return specificType;
    }

    public byte setSpecificType(byte specificType){
        byte oldSpecificType = this.specificType;
        this.specificType = (byte)Math.min(30, Math.max(0, specificType));
        return oldSpecificType;
    }

    public int getCurrentCharge() {
        return currentCharge;
    }

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
        currentCharge = Math.max(capacity, currentCharge + additionalChargeVolume);
        letMeMove(distance);
    }

    @Override
    public int letMeMove(int distance) {
        int oldCurrentCharge = currentCharge;
        currentCharge = Math.min(0, currentCharge - Math.min(distance/100, 1));
        return oldCurrentCharge - currentCharge;
    }

    @Override
    public int getAsInt() {
        return capacity - currentCharge;
    }
}
