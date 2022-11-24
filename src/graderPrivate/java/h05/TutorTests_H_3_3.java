package h05;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission
public class TutorTests_H_3_3 {

    @Test
    public void test_HybridType1_class() {
        H05_Tester.HYBRID_TYPE_1_CT.get().verify();
    }

    @Test
    public void test_HybridType1_attributes() {
        H05_Tester.HYBRID_TYPE_1_CT.get().resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_1_FUEL_TYPE_AM.get());
        H05_Tester.HYBRID_TYPE_1_CT.get().resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_1_AVERAGE_CONSUMPTION_AM.get());
        H05_Tester.HYBRID_TYPE_1_CT.get().resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_1_HIGH_VOLTAGE_CHARGEABLE_TYPE_AM.get());
        H05_Tester.HYBRID_TYPE_1_CT.get().resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_1_STANDARD_VOLTAGE_CHARGEABLE_AM.get());
    }

    @Test
    public void test_HybridType1_get_set() throws InvocationTargetException, IllegalAccessException {
        var hybrid_type_1 = H05_Tester.HYBRID_TYPE_1_CT.get().resolve();

        var standardVoltageChargeable_field = hybrid_type_1.resolveAttribute(H05_Tester.HYBRID_TYPE_1_STANDARD_VOLTAGE_CHARGEABLE_AM.get());
        standardVoltageChargeable_field.setAccessible(true);
        var highVoltageChargeable_field = hybrid_type_1.resolveAttribute(H05_Tester.HYBRID_TYPE_1_HIGH_VOLTAGE_CHARGEABLE_TYPE_AM.get());
        highVoltageChargeable_field.setAccessible(true);
        var fuelType_field = hybrid_type_1.resolveAttribute(H05_Tester.HYBRID_TYPE_1_FUEL_TYPE_AM.get());
        fuelType_field.setAccessible(true);
        var averageConsumption_field = hybrid_type_1.resolveAttribute(H05_Tester.HYBRID_TYPE_1_AVERAGE_CONSUMPTION_AM.get());
        averageConsumption_field.setAccessible(true);


        var instance = hybrid_type_1.resolveInstance();
        var expected_standardVoltageChargeable = hybrid_type_1.setFieldRandom(standardVoltageChargeable_field);
        var expected_highVoltageChargeable = hybrid_type_1.setFieldRandom(highVoltageChargeable_field);
        var expected_fuelType = hybrid_type_1.setFieldRandom(fuelType_field);
        var expected_averageConsumption = hybrid_type_1.setFieldRandom(averageConsumption_field);

        var actual_standardVoltageChargeable = H05_Tester.ELECTRICALLY_DRIVEN_STANDARD_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        var actual_highVoltageChargeable = H05_Tester.ELECTRICALLY_DRIVEN_HIGH_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        var actual_fuelType = H05_Tester.FUEL_DRIVEN_GET_FUEL_TYPE_MT.get().resolveMethod().invoke(instance);
        var speed = ThreadLocalRandom.current().nextDouble();
        var actual_averageConsumption = H05_Tester.FUEL_DRIVEN_GET_AVERAGE_CONSUMPTION_MT.get().resolveMethod().invoke(instance, speed);

        // check Getter
        assertEquals(expected_standardVoltageChargeable, actual_standardVoltageChargeable, "standardVoltageChargeable liefert nicht den korrekten Attributwert zurück.");
        assertEquals(expected_highVoltageChargeable, actual_highVoltageChargeable, "highVoltageChargeable liefert nicht den korrekten Attributwert zurück.");
        assertEquals(expected_fuelType, actual_fuelType, "getFuelType liefert nicht den korrekten Attributwert zurück.");
        assertEquals(expected_averageConsumption, actual_averageConsumption, "getAverageConsumption liefert nicht den korrekten Attributwert zurück.");


        //check Toggle
        H05_Tester.HYBRID_TYPE_1_TOGGLE_STANDARD_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        assertNotEquals(expected_standardVoltageChargeable, hybrid_type_1.getFieldValue(standardVoltageChargeable_field));
        H05_Tester.HYBRID_TYPE_1_TOGGLE_STANDARD_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        assertEquals(expected_standardVoltageChargeable, hybrid_type_1.getFieldValue(standardVoltageChargeable_field));

        H05_Tester.HYBRID_TYPE_1_TOGGLE_HIGH_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        assertNotEquals(expected_highVoltageChargeable, hybrid_type_1.getFieldValue(highVoltageChargeable_field));
        H05_Tester.HYBRID_TYPE_1_TOGGLE_HIGH_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        assertEquals(expected_highVoltageChargeable, hybrid_type_1.getFieldValue(highVoltageChargeable_field));


        //check Setter
        Object new_averageConsumption = hybrid_type_1.getRandomValue(averageConsumption_field.getType());
        H05_Tester.HYBRID_TYPE_1_SET_AVERAGE_CONSUMPTION_MT.get().resolveMethod().invoke(instance, new_averageConsumption);
        assertEquals(new_averageConsumption, hybrid_type_1.getFieldValue(averageConsumption_field), "setAverageConsumption funktioniert nicht korrekt.");

        Object new_fuelType = hybrid_type_1.getRandomValue(fuelType_field.getType());
        H05_Tester.HYBRID_TYPE_1_SET_FUEL_TYPE_MT.get().resolveMethod().invoke(instance, new_fuelType);
        assertEquals(new_fuelType, hybrid_type_1.getFieldValue(fuelType_field), "setFuelType funktioniert nicht korrekt.");
    }

    @Test
    public void test_HybridType2_class() {
        H05_Tester.HYBRID_TYPE_2_CT.get().verify();
    }

    @Test
    public void test_HybridType2_hybrid_Object() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        var hybridObject_field =
            H05_Tester.HYBRID_TYPE_2_CT.get().resolve().resolveAttribute(H05_Tester.HYBRID_TYPE_2_HYBRID_OBJECT_AM.get());
        hybridObject_field.setAccessible(true);

        var constructor =
            H05_Tester.HYBRID_TYPE_2_CT.get().resolve().resolveConstructor(H05_Tester.HYBRID_TYPE_2_CONSTRUCTOR_PARAMETER_MATCHERS.get());
        Object instance = constructor.newInstance();
        Object hybridObject = hybridObject_field.get(instance);
        assertNotEquals(null, hybridObject, "hybridObject wird nicht im Konstruktor gesetzt.");
    }

    @Test
    public void test_HybridType2_forwarding() {
        fail("Not implemented: Hybrid2 calls Hybrid1");
    }

}
