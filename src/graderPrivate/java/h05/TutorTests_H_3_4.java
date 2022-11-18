package h05;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import static org.junit.jupiter.api.Assertions.fail;

@TestForSubmission
public class TutorTests_H_3_4 {
    @Test
    public void test_HybridType3_class() {
        H05_Tester.HYBRID_TYPE_3_CT.verify();
    }

    @Test
    public void test_HybridType3_attributes_get_set() {
        //Attributes
        H05_Tester.HYBRID_TYPE_3_CT.resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_3_FUEL_TYPE_AM);
        H05_Tester.HYBRID_TYPE_3_CT.resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_3_AVERAGE_CONSUMPTION_AM);
        H05_Tester.HYBRID_TYPE_3_CT.resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_3_HIGH_VOLTAGE_CHARGEABLE_TYPE_AM);
        H05_Tester.HYBRID_TYPE_3_CT.resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_3_STANDARD_VOLTAGE_CHARGEABLE_AM);
        H05_Tester.HYBRID_TYPE_3_CT.resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_3_PREFERRED_DRIVE_TYPE_AM);

        fail("Not implemented");
    }

    @Test
    public void test_HybridType3_getPreferredDriveType() {
        fail("Not implemented");
    }

    @Test
    public void test_HybridType3_getPreferredDriveType_ternary() {
        fail("Not implemented");
    }
}
