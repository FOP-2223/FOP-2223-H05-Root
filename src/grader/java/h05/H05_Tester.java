package h05;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.tudalgo.algoutils.reflect.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

public class H05_Tester {

    public static final double minSim = 0.8d;

    //H1.1
    public static final ClassTester<?> ELECTRICALLY_DRIVEN_CT =  new ClassTester<>("h05", "ElectricallyDriven", minSim, Modifier.INTERFACE | Modifier.PUBLIC | Modifier.ABSTRACT); // Abstract needed
    public static final MethodTester ELECTRICALLY_DRIVEN_STANDARD_VOLTAGE_CHARGEABLE_MT =  new MethodTester(ELECTRICALLY_DRIVEN_CT, "standardVoltageChargeable", minSim, Modifier.PUBLIC | Modifier.ABSTRACT, boolean.class, new ArrayList<>(){});
    public static final MethodTester ELECTRICALLY_DRIVEN_HIGH_VOLTAGE_CHARGEABLE_MT = new MethodTester(ELECTRICALLY_DRIVEN_CT, "highVoltageChargeable", minSim, Modifier.PUBLIC | Modifier.ABSTRACT, boolean.class, new ArrayList<>(){});
    public static final ParameterMatcher [] ELECTRICALLY_DRIVEN_LETS_GO_PARAMETER_MATCHERS = {
        new ParameterMatcher("additionalChargeVolume", minSim, byte.class),
        new ParameterMatcher("distance", minSim, int.class),
    };
    public static final MethodTester ELECTRICALLY_DRIVEN_LETS_GO_MT = new MethodTester(ELECTRICALLY_DRIVEN_CT, "letsGo", minSim, Modifier.PUBLIC | Modifier.ABSTRACT, void.class, Arrays.asList(ELECTRICALLY_DRIVEN_LETS_GO_PARAMETER_MATCHERS));

    //H1.2
    public static final ClassTester<?> FUEL_TYPE_CT =  new ClassTester<>("h05", "FuelType", minSim, Modifier.PUBLIC | TestUtils.ENUM |Modifier.FINAL); // final needed??
    public static final ClassTester<?> FUEL_DRIVEN_CT =  new ClassTester<>("h05", "FuelDriven", minSim, Modifier.INTERFACE | Modifier.PUBLIC | Modifier.ABSTRACT);
    public static final MethodTester FUEL_DRIVEN_GET_FUEL_TYPE_MT =  new MethodTester(FUEL_DRIVEN_CT, "getFuelType", minSim, Modifier.PUBLIC | Modifier.ABSTRACT, FUEL_TYPE_CT.findClass(), new ArrayList<>(){});

    public static final ParameterMatcher [] FUEL_DRIVEN_GET_AVERAGE_CONSUMPTION_PARAMETER_MATCHERS = {
        new ParameterMatcher("speed", minSim, double.class)
    };
    public static final MethodTester FUEL_DRIVEN_GET_AVERAGE_CONSUMPTION_MT = new MethodTester(FUEL_DRIVEN_CT, "getAverageConsumption", minSim, Modifier.PUBLIC | Modifier.ABSTRACT, double.class, Arrays.asList(FUEL_DRIVEN_GET_AVERAGE_CONSUMPTION_PARAMETER_MATCHERS));

    //H1.3
    public static final ClassTester<?> DRIVE_TYPE_CT =  new ClassTester<>("h05", "DriveType", minSim, Modifier.PUBLIC | TestUtils.ENUM | Modifier.FINAL);
    public static final IdentifierMatcher[] HYBRID_VEHICLE_SUPER_INTERFACES = {
        new IdentifierMatcher("FuelDriven", "h05", minSim),
        new IdentifierMatcher("ElectricallyDriven", "h05", minSim)
    };
    public static final ClassTester<?> HYBRID_VEHICLE_CT =  new ClassTester<>("h05", "HybridVehicle", minSim, Modifier.INTERFACE | Modifier.PUBLIC | Modifier.ABSTRACT, null,  new ArrayList<>(Arrays.asList(HYBRID_VEHICLE_SUPER_INTERFACES)));

    public static final MethodTester HYBRID_VEHICLE_GET_PREFERRED_DRIVE_TYPE_MT =  new MethodTester(HYBRID_VEHICLE_CT, "getPreferredDriveType", minSim, Modifier.PUBLIC | Modifier.ABSTRACT, DRIVE_TYPE_CT.findClass(), new ArrayList<>(){});

    // H2
    public static final ClassTester<?>  TRANSPORT_TYPE_CT =  new ClassTester<>("h05", "TransportType", minSim, Modifier.PUBLIC | TestUtils.ENUM | Modifier.FINAL);

    public static final ClassTester<?> MEANS_OF_TRANSPORT_CT =  new ClassTester<>("h05", "MeansOfTransport", minSim, Modifier.PUBLIC | Modifier.ABSTRACT);
    public static final AttributeMatcher MEANS_OF_TRANSPORT_TRANSPORT_TYPE_AM = new AttributeMatcher("transportType", minSim, Modifier.PROTECTED, TRANSPORT_TYPE_CT.findClass());
    public static final ParameterMatcher [] MEANS_OF_TRANSPORT_LET_ME_MOVE_PARAMETER_MATCHERS = {
        new ParameterMatcher("distance", minSim, int.class),
    };
    public static final MethodTester MEANS_OF_TRANSPORT_LET_ME_MOVE_MT = new MethodTester(MEANS_OF_TRANSPORT_CT, "letMeMove", minSim, Modifier.PUBLIC | Modifier.ABSTRACT, int.class, Arrays.asList(MEANS_OF_TRANSPORT_LET_ME_MOVE_PARAMETER_MATCHERS));
    public static final MethodTester MEANS_OF_TRANSPORT_TO_STRING_MT = new MethodTester(MEANS_OF_TRANSPORT_CT, "toString", minSim, Modifier.PUBLIC, String.class);
    public static final ClassTester<?>  EXTENDED_TRANSPORT_TYPE_CT =  new ClassTester<>("h05", "ExtendedTransportType", minSim, Modifier.PUBLIC | TestUtils.ENUM | Modifier.FINAL);

    public static final MethodTester TRANSPORT_TYPES_VALUES_MT = new MethodTester(TRANSPORT_TYPE_CT, "values", minSim, Modifier.PUBLIC, String[].class);




}
