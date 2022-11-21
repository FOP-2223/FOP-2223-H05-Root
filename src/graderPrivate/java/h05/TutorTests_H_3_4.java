package h05;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission
public class TutorTests_H_3_4 {
    @Test
    public void test_HybridType3_class() {
        H05_Tester.HYBRID_TYPE_3_CT.get().verify();
    }

    @Test
    public void test_HybridType3_attributes_get_set() {
        //Attributes
        H05_Tester.HYBRID_TYPE_3_CT.get().resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_3_FUEL_TYPE_AM.get());
        H05_Tester.HYBRID_TYPE_3_CT.get().resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_3_AVERAGE_CONSUMPTION_AM.get());
        H05_Tester.HYBRID_TYPE_3_CT.get().resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_3_HIGH_VOLTAGE_CHARGEABLE_TYPE_AM.get());
        H05_Tester.HYBRID_TYPE_3_CT.get().resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_3_STANDARD_VOLTAGE_CHARGEABLE_AM.get());
        H05_Tester.HYBRID_TYPE_3_CT.get().resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_3_PREFERRED_DRIVE_TYPE_AM.get());

        fail("Not implemented");
    }

    @Test
    public void test_HybridType3_togglePreferredDriveType() throws InvocationTargetException, IllegalAccessException {
        var hybrid3 = H05_Tester.HYBRID_TYPE_3_CT.get().resolve();
        var instance = hybrid3.resolveInstance();
        var driveType_field = hybrid3.resolveAttribute(H05_Tester.HYBRID_TYPE_3_PREFERRED_DRIVE_TYPE_AM.get());
        var toggle = H05_Tester.HYBRID_TYPE_3_TOGGLE_PREFERRED_DRIVE_TYPE_MT.get().resolveMethod();

        var initial = hybrid3.setFieldRandom(driveType_field);
        toggle.invoke(instance);
        var one_toggled = hybrid3.getFieldValue(driveType_field);
        toggle.invoke(instance);
        var twice_toggled = hybrid3.getFieldValue(driveType_field);

        assertEquals(initial, twice_toggled);
        assertNotEquals(initial, one_toggled);
    }

    @Test
    public void test_HybridType3_togglePreferredDriveType_ternary() {
        fail("Not implemented: getPreferredDriveType uses ternary");
    }
}
