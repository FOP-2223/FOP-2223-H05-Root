package h05;

public interface HybridVehicle extends FuelDriven, ElectricallyDriven{
    /**
     * @return the preferred DriveType
     */
    DriveType getPreferredDriveType();
}
