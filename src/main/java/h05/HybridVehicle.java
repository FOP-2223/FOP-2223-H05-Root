package h05;

/**
 * Defines a Vehicle, which can be driven by fuel or electricity
 */
public interface HybridVehicle extends FuelDriven, ElectricallyDriven {
    /**
     * @return the preferred DriveType
     */
    DriveType getPreferredDriveType();
}
