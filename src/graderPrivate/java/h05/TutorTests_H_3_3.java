package h05;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestForSubmission
public class TutorTests_H_3_3 {

    @Test
    public void test_HybridType1_class() {
        H05_Tester.HYBRID_TYPE_1_CT.verify();
    }

    @Test
    public void test_HybridType1_attributes() {
        H05_Tester.HYBRID_TYPE_1_CT.resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_1_FUEL_TYPE_AM);
        H05_Tester.HYBRID_TYPE_1_CT.resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_1_AVERAGE_CONSUMPTION_AM);
        H05_Tester.HYBRID_TYPE_1_CT.resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_1_HIGH_VOLTAGE_CHARGEABLE_TYPE_AM);
        H05_Tester.HYBRID_TYPE_1_CT.resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_1_STANDARD_VOLTAGE_CHARGEABLE_AM);
    }

    @Test
    public void test_HybridType1_get_set() {
        fail("Not implemented");
    }

    @Test
    public void test_HybridType2_class() {
        H05_Tester.HYBRID_TYPE_2_CT.verify();
    }

    @Test
    public void test_HybridType2_hybrid_Object() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        var hybridObject_field = H05_Tester.HYBRID_TYPE_2_CT.resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_2_HYBRID_OBJECT_AM);
        hybridObject_field.setAccessible(true);

        var constructor = H05_Tester.HYBRID_TYPE_2_CT.resolve().resolveConstructor(H05_Tester.HYBRID_TYPE_2_CONSTRUCTOR_PARAMETER_MATCHERS);
        Object instance = constructor.newInstance();
        Object hybridObject = hybridObject_field.get(instance);
        assertNotEquals(null, hybridObject, "hybridObject wird nicht im Konstructor gesetzt.");
    }

    @Test
    public void test_HybridType2_forwarding() {
        fail("Not implemented");
    }

}
