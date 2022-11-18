package h05;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.function.IntSupplier;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission
public class TutorTests_H_3_2 {

    @Test
    public void test_class() {
        H05_Tester.ELECTRIC_BOAT_CT.get().verify();
    }

    @Test
    public void test_attributes() {
        Field specificType_field =
            H05_Tester.ELECTRIC_BOAT_CT.get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_SPECIFIC_TYPE_AM.get());
        Field currentCharge_field =
            H05_Tester.ELECTRIC_BOAT_CT.get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM.get());
        Field capacity_field = H05_Tester.ELECTRIC_BOAT_CT.get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CAPACITY_AM.get());

        H05_Tester.ELECTRIC_BOAT_CT.get().resolve().assertHasGetter(specificType_field);
        H05_Tester.ELECTRIC_BOAT_CT.get().resolve().assertHasGetter(currentCharge_field);
        H05_Tester.ELECTRIC_BOAT_CT.get().resolve().assertHasGetter(capacity_field);
    }

    private void test_chargeable(byte n) throws InvocationTargetException, IllegalAccessException {
        Field specificType_field =
            H05_Tester.ELECTRIC_BOAT_CT.get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_SPECIFIC_TYPE_AM.get());
        Object instance = H05_Tester.ELECTRIC_BOAT_CT.get().resolve().resolveInstance();
        H05_Tester.ELECTRIC_BOAT_CT.get().setField(instance, specificType_field, n);

        boolean standardVoltageChargable =
            (boolean) H05_Tester.ELECTRICALLY_DRIVEN_STANDARD_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        boolean highVoltageChargable =
            (boolean) H05_Tester.ELECTRICALLY_DRIVEN_HIGH_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);

        assertEquals(n == 6 || n == 11 || n == 12 || n == 22, standardVoltageChargable, "standardVoltageChargeable liefert falschen Wert zurück.");
        assertEquals((n % 2 == 0) & ((n + 1) % 3 == 0), highVoltageChargable, "highVoltageChargeable liefert falschen Wert zurück.");
    }

    @Test
    public void test_chargeable() throws InvocationTargetException, IllegalAccessException {
        byte[] testvec = new byte[]{6, 11, 12, 22, 21, 69, 70};
        for (byte testcase : testvec) {
            test_chargeable(testcase);
        }
    }

    @Test
    public void test_chargeable_return() {
        fail("Not implemented: *VolatgeChargeable only return");
    }

    @Test
    public void test_letsGo() throws InvocationTargetException, IllegalAccessException {
        Field currentCharge_field = H05_Tester.ELECTRIC_BOAT_CT.get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM.get());
        currentCharge_field.setAccessible(true);
        Field capacity_field = H05_Tester.ELECTRIC_BOAT_CT.get().assureClassResolved().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CAPACITY_AM.get());
        capacity_field.setAccessible(true);
        Object instance = H05_Tester.ELECTRIC_BOAT_CT.get().assureClassResolved().resolveInstance();

        int[] capacity_TV = {1};
        int[] currentCharge_TV = {2};
        byte[] additionalChargeVolume_TV = {3};

        for (int i = 0; i < capacity_TV.length; i++){
            //H05_Tester.ELECTRIC_BOAT_CT.get().assureClassResolved().setField(currentCharge_field, currentCharge_TV[i]);
            //H05_Tester.ELECTRIC_BOAT_CT.get().assureClassResolved().setField(capacity_field, capacity_TV[i]);

            currentCharge_field.set(instance, currentCharge_TV[i]);
            capacity_field.set(instance, capacity_TV[i]);

            H05_Tester.ELECTRICALLY_DRIVEN_LETS_GO_MT.get().resolveMethod().invoke(instance, additionalChargeVolume_TV[i], 0);

            int expected_currentCharge = Math.min(capacity_TV[i], currentCharge_TV[i] + additionalChargeVolume_TV[i]);
            int actual_currentCharge = (int)currentCharge_field.get(instance);
            assertEquals(expected_currentCharge, actual_currentCharge, "currentCharge entspricht nicht dem erwarteten Wert!");
        }

        //TODO check if let me move was called
        fail("Not implemented: check letMeMove calles");
    }


    private void singleLetMeMoveTest(int currentCharge, int distance) throws IllegalAccessException, InvocationTargetException {
        Field currentCharge_field = H05_Tester.ELECTRIC_BOAT_CT.get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM.get());
        currentCharge_field.setAccessible(true);
        Object instance = H05_Tester.ELECTRIC_BOAT_CT.get().assureClassResolved().resolveInstance();

        currentCharge_field.set(instance, currentCharge);
        int actual_return = (int)H05_Tester.MEANS_OF_TRANSPORT_LET_ME_MOVE_MT.get().resolveMethod().invoke(instance, distance);
        int actual_currentCharge = (int)currentCharge_field.get(instance);

        int expected_currentCharge = Math.max(0, currentCharge - Math.min(distance / 100, 1));
        int expected_return = currentCharge - expected_currentCharge;

        assertEquals(expected_currentCharge, actual_currentCharge, "currentCharge ist nicht korrekt berechnet.");
        assertEquals(expected_return, actual_return, "Der Rückgabewert ist nicht korrekt");
    }


    @Test
    public void test_letMeMove() throws InvocationTargetException, IllegalAccessException {
        singleLetMeMoveTest(10, 10);
    }

    @Test
    public void test_getAsInt() throws InvocationTargetException, IllegalAccessException {
        var electric_boat = H05_Tester.ELECTRIC_BOAT_CT.get().resolve();
        Field currentCharge_field =
            electric_boat.resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM.get());
        Field capacity_field =
            electric_boat.resolveAttribute(H05_Tester.ELECTRIC_BOAT_CAPACITY_AM.get());

        Object instance = electric_boat.resolveInstance();

        int capacity = (int) electric_boat.setFieldRandom(capacity_field);
        int currentCharge = (int) electric_boat.setFieldRandom(currentCharge_field);

        int returned_value = ((IntSupplier) instance).getAsInt();
        assertEquals(capacity - currentCharge, returned_value, "getAsInt liefert nicht den korrekten Wert zurück.");
    }

    private void test_setSpecificType(byte specificType) throws InvocationTargetException, IllegalAccessException { // TODO: Same hier, resolve erstellt neue instance
        var electric_boat = H05_Tester.ELECTRIC_BOAT_CT.get().resolve();
        Field specificType_field =
            H05_Tester.ELECTRIC_BOAT_CT.get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_SPECIFIC_TYPE_AM.get());
        Object instance = electric_boat.resolveInstance();
        byte expected_old_specificType = (byte) electric_boat.setFieldRandom(specificType_field);
        byte actual_old_specificType = (byte) H05_Tester.ELECTRIC_BOAT_SET_SPECIFIC_TYPE_MT.get().resolveMethod().invoke(instance,
            specificType);
        byte actual_new_specificType = (byte) electric_boat.getFieldValue(specificType_field);
        assertEquals(Math.max(0, Math.min(30, specificType)), actual_new_specificType, "setSpecificType setzt den Wert des Attributs specificType nicht korrekt");
        assertEquals(expected_old_specificType, actual_old_specificType, "setSpecificType liefert nicht den alten Wert des Attributs specificType zurück.");
    }

    @Test
    public void test_setSpecificType() throws InvocationTargetException, IllegalAccessException {
        byte[] testvec = new byte[]{6, 11, 12, -100, 31, 30};
        for (byte testcase : testvec) {
            test_setSpecificType(testcase);
        }
    }

    @Test
    public void test_setSpecificType_no_ternary() {
        fail("Not implemented: setSpecificType does not use ternary");
    }

    @Test
    public void test_constructor() {
        var electric_boat = H05_Tester.ELECTRIC_BOAT_CT.get().resolve();
        var constructor = electric_boat.resolveConstructor(H05_Tester.ELECTRIC_BOAT_CONSTRUCTOR_PARAMETER_MATCHERS.get());

        fail("Not implemented");

    }
}
