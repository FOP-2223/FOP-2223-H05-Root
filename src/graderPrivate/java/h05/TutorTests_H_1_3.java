package h05;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

@TestForSubmission
public class TutorTests_H_1_3 {

    @Test
    public void test_enum() {
        H05_Tester.FUEL_TYPE_CT.get().verify();
        String[] enum_constants = {"FUEL_BASED", "ELECTRICAL"};
        H05_Tester.FUEL_TYPE_CT.get().assertEnumConstants(enum_constants);
    }

    @Test
    public void test_interface() {
        H05_Tester.FUEL_DRIVEN_CT.get().verify();
    }

    @Test
    public void test_methods() {
        H05_Tester.HYBRID_VEHICLE_GET_PREFERRED_DRIVE_TYPE_MT.get().verify();
    }
}
