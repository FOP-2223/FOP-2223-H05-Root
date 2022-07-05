package h05;

public interface HybridVehicle extends FuelDriven, ElectricallyDriven{
    DriveType getPreferredDriveType();
}
