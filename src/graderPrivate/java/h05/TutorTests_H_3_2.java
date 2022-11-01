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
    public void test_class(){
        H05_Tester.ELECTRIC_BOAT_CT.verify();
    }

    @Test
    public void test_attributes(){
        Field specificType_field = H05_Tester.ELECTRIC_BOAT_CT.resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_SPECIFIC_TYPE_AM);
        Field currentCharge_field = H05_Tester.ELECTRIC_BOAT_CT.resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM);
        Field capacity_field = H05_Tester.ELECTRIC_BOAT_CT.resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CAPACITY_AM);

        H05_Tester.ELECTRIC_BOAT_CT.resolve().assertHasGetter(specificType_field);
        H05_Tester.ELECTRIC_BOAT_CT.resolve().assertHasGetter(currentCharge_field);
        H05_Tester.ELECTRIC_BOAT_CT.resolve().assertHasGetter(capacity_field);
    }


    private void test_chargeable(byte n) throws InvocationTargetException, IllegalAccessException {
        Field specificType_field = H05_Tester.ELECTRIC_BOAT_CT.resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_SPECIFIC_TYPE_AM);
        Object instance = H05_Tester.ELECTRIC_BOAT_CT.resolve().resolveInstance();
        H05_Tester.ELECTRIC_BOAT_CT.setField(instance, specificType_field, n);

        boolean standardVoltageChargable = (boolean)H05_Tester.ELECTRICALLY_DRIVEN_STANDARD_VOLTAGE_CHARGEABLE_MT.resolveMethod().invoke(instance);
        boolean highVoltageChargable = (boolean)H05_Tester.ELECTRICALLY_DRIVEN_HIGH_VOLTAGE_CHARGEABLE_MT.resolveMethod().invoke(instance);

        assertEquals( n == 6 || n == 11 || n == 12 || n == 22, standardVoltageChargable, "standardVoltageChargeable liefert falschen Wert zurück.");
        assertEquals((n % 2 == 0) & ((n+1) % 3 == 0), highVoltageChargable, "highVoltageChargeable liefert falschen Wert zurück.");
    }

    @Test
    public void test_chargeable() throws InvocationTargetException, IllegalAccessException {
        byte[] testvec = new byte[]{6, 11, 12, 22, 21, 69, 70};
        for(byte testcase :testvec){
            test_chargeable(testcase);
        }
    }

    @Test
    public void test_chargeable_ternary(){
        // TODO
    }


    @Test
    public void test_letsGo(){
        //Field currentCharge_field = H05_Tester.ELECTRIC_BOAT_CT.resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM);
        //TODO

    }

    @Test
    public void test_letMeMove(){
        //TODO
    }

    @Test
    public void test_getAsInt() throws InvocationTargetException, IllegalAccessException {
        Field currentCharge_field = H05_Tester.ELECTRIC_BOAT_CT.resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM);
        Field capacity_field = H05_Tester.ELECTRIC_BOAT_CT.resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CAPACITY_AM);
        Object instance = H05_Tester.ELECTRIC_BOAT_CT.resolve().resolveInstance();
        int capacity = (int)H05_Tester.ELECTRIC_BOAT_CT.setFieldRandom(capacity_field);
        int currentCharge = (int)H05_Tester.ELECTRIC_BOAT_CT.setFieldRandom(currentCharge_field);

        int returned_value = ((IntSupplier)instance).getAsInt();
        assertEquals(capacity-currentCharge, returned_value, "getAsInt liefert nicht den korrekten Wert zurück.");
    }


    private void test_setSpecificType(byte specificType) throws InvocationTargetException, IllegalAccessException {
        Field specificType_field = H05_Tester.ELECTRIC_BOAT_CT.resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_SPECIFIC_TYPE_AM);
        Object instance = H05_Tester.ELECTRIC_BOAT_CT.resolve().resolveInstance();
        byte expected_old_specificType = (byte)H05_Tester.ELECTRIC_BOAT_CT.setFieldRandom(specificType_field);
        byte actual_old_specificType = (byte)H05_Tester.ELECTRIC_BOAT_SET_SPECIFIC_TYPE_MT.resolveMethod().invoke(instance, specificType);
        byte actual_new_specificType = (byte)H05_Tester.ELECTRIC_BOAT_CT.getFieldValue(specificType_field);
        assertEquals(Math.max(0, Math.min(30, specificType)), actual_new_specificType, "setSpecificType setzt den Wert des Attributs specificType nicht korrekt");
        assertEquals(expected_old_specificType, actual_old_specificType, "setSpecificType liefert nicht den alten Wert des Attributs specificType zurück.");
    }

    @Test
    public void test_setSpecificType() throws InvocationTargetException, IllegalAccessException {
        byte[] testvec = new byte[]{6, 11, 12, -100, 31, 30};
        for(byte testcase : testvec){
            test_setSpecificType(testcase);
        }
    }

    @Test
    public void test_setSpecificType_no_ternary(){
        // TODO
    }

    @Test
    public void test_constructor(){
        // TODO
    }


}
