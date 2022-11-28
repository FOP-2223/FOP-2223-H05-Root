package h05;

import h05.transform.ClassTransformerTemplate;
import h05.transform.H3_2_Transformers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.opentest4j.AssertionFailedError;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.sourcegrade.jagr.api.testing.SourceFile;
import org.sourcegrade.jagr.api.testing.TestCycle;
import org.sourcegrade.jagr.api.testing.extension.TestCycleResolver;
import org.tudalgo.algoutils.reflect.ClassTester;
import org.tudalgo.algoutils.tutor.general.assertions.Context;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.function.IntSupplier;
import java.util.regex.Pattern;

import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.*;

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
        Field specificType_field = H05_Tester.ELECTRIC_BOAT_CT
            .get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_SPECIFIC_TYPE_AM.get());
        Object instance = H05_Tester.ELECTRIC_BOAT_CT.get().resolve().resolveInstance();
        ClassTester.setField(instance, specificType_field, n);

        boolean standardVoltageChargeable = (boolean) H05_Tester.ELECTRICALLY_DRIVEN_STANDARD_VOLTAGE_CHARGEABLE_MT
            .get().resolveMethod().invoke(instance);
        boolean highVoltageChargeable = (boolean) H05_Tester.ELECTRICALLY_DRIVEN_HIGH_VOLTAGE_CHARGEABLE_MT
            .get().resolveMethod().invoke(instance);

        Context context = contextBuilder()
            .add("specificType", n)
            .build();
        assertEquals(n == 6 || n == 11 || n == 12 || n == 22, standardVoltageChargeable, context, result ->
            "standardVoltageChargeable returns an unexpected value");
        assertEquals((n % 2 == 0) & ((n + 1) % 3 == 0), highVoltageChargeable, context, result ->
            "highVoltageChargeable returns an unexpected value");
    }

    @Test
    public void test_chargeable() throws InvocationTargetException, IllegalAccessException {
        byte[] testvec = new byte[]{6, 11, 12, 22, 21, 69, 70};
        for (byte testcase : testvec) {
            test_chargeable(testcase);
        }
    }

    @Test
    @ExtendWith(TestCycleResolver.class)
    public void test_chargeable_return(TestCycle testCycle) {
        SourceFile sourceFile = testCycle.getSubmission().getSourceFile("h05/ElectricBoat.java");
        if (sourceFile == null) {
            throw new AssertionFailedError("Source file h05/ElectricBoat.java was not found in submission");
        }

        String submissionContent = sourceFile.getContent();
        boolean b1 = Pattern.compile(".*standardVoltageChargeable\\s*?\\(\\s*?\\)\\s*?\\{\\s*?return.*?;\\s*?}.*")
            .matcher(submissionContent)
            .find();
        boolean b2 = Pattern.compile(".*highVoltageChargeable\\s*?\\(\\s*?\\)\\s*?\\{\\s*?return.*?;\\s*?}.*")
            .matcher(submissionContent)
            .find();

        assertTrue(b1, emptyContext(), result ->
            "Method standardVoltageChargeable does not have exactly one statement (a single return statement)");
        assertTrue(b2, emptyContext(), result ->
            "Method highVoltageChargeable does not have exactly one statement (a single return statement)");

        H3_2_Transformers.STANDARD_VOLTAGE_ILLEGAL_INSN = false;
        H3_2_Transformers.HIGH_VOLTAGE_ILLEGAL_INSN = false;

        testCycle.getClassLoader().visitClass("h05.ElectricBoat", new ClassTransformerTemplate("", H3_2_Transformers.CHARGEABLE_TRANSFORMER));
        if (H3_2_Transformers.STANDARD_VOLTAGE_ILLEGAL_INSN) {
            fail(emptyContext(), result -> "Illegal instructions used in method standardVoltageChargeable");
        }
        if (H3_2_Transformers.HIGH_VOLTAGE_ILLEGAL_INSN) {
            fail(emptyContext(), result -> "Illegal instructions used in method highVoltageChargeable");
        }
    }

    @Test
    @ExtendWith(TestCycleResolver.class)
    public void test_letsGo(TestCycle testCycle) throws InvocationTargetException, IllegalAccessException {
        Field currentCharge_field = H05_Tester.ELECTRIC_BOAT_CT
            .get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM.get());
        currentCharge_field.trySetAccessible();
        Field capacity_field = H05_Tester.ELECTRIC_BOAT_CT
            .get().assureClassResolved().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CAPACITY_AM.get());
        capacity_field.trySetAccessible();
        Object instance = H05_Tester.ELECTRIC_BOAT_CT.get().assureClassResolved().resolveInstance();

        int[] capacity_TV = {1};
        int[] currentCharge_TV = {2};
        byte[] additionalChargeVolume_TV = {3};

        for (int i = 0; i < capacity_TV.length; i++) {
            //H05_Tester.ELECTRIC_BOAT_CT.get().assureClassResolved().setField(currentCharge_field, currentCharge_TV[i]);
            //H05_Tester.ELECTRIC_BOAT_CT.get().assureClassResolved().setField(capacity_field, capacity_TV[i]);

            currentCharge_field.set(instance, currentCharge_TV[i]);
            capacity_field.set(instance, capacity_TV[i]);

            H05_Tester.ELECTRICALLY_DRIVEN_LETS_GO_MT.get().resolveMethod().invoke(instance, additionalChargeVolume_TV[i], 0);

            int expected_currentCharge = Math.min(capacity_TV[i], currentCharge_TV[i] + additionalChargeVolume_TV[i]);
            int actual_currentCharge = (int) currentCharge_field.get(instance);

            Context context = contextBuilder()
                .add("additionalChargeVolume", additionalChargeVolume_TV[i])
                .add("distance", 0)
                .build();
            assertEquals(expected_currentCharge, actual_currentCharge, context, result ->
                "currentCharge does not match the expected value");
        }

        H3_2_Transformers.LET_ME_MOVE_INVOKED = false;
        testCycle.getClassLoader()
            .visitClass("h05.ElectricBoat", new ClassTransformerTemplate("", H3_2_Transformers.LET_ME_MOVE_TRANSFORMER));
        if (!H3_2_Transformers.LET_ME_MOVE_INVOKED) {
            fail(emptyContext(), result -> "Method letsGo did not invoke letMeMove");
        }
    }


    private void singleLetMeMoveTest(int currentCharge, int distance) throws IllegalAccessException, InvocationTargetException {
        Field currentCharge_field = H05_Tester.ELECTRIC_BOAT_CT
            .get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM.get());
        currentCharge_field.trySetAccessible();
        Object instance = H05_Tester.ELECTRIC_BOAT_CT.get().assureClassResolved().resolveInstance();

        currentCharge_field.set(instance, currentCharge);
        int actual_return = (int) H05_Tester.MEANS_OF_TRANSPORT_LET_ME_MOVE_MT.get().resolveMethod().invoke(instance, distance);
        int actual_currentCharge = (int) currentCharge_field.get(instance);

        int expected_currentCharge = Math.max(0, currentCharge - Math.min(distance / 100, 1));
        int expected_return = currentCharge - expected_currentCharge;

        Context context = contextBuilder()
            .add("currentCharge", currentCharge)
            .add("distance", distance)
            .build();
        assertEquals(expected_currentCharge, actual_currentCharge, context, result ->
            "currentCharge is not calculated correctly");
        assertEquals(expected_return, actual_return, context, result ->
            "the return value is incorrect");
    }


    @Test
    public void test_letMeMove() throws InvocationTargetException, IllegalAccessException {
        singleLetMeMoveTest(10, 10);
    }

    @Test
    public void test_getAsInt() throws InvocationTargetException, IllegalAccessException {
        var electric_boat = H05_Tester.ELECTRIC_BOAT_CT.get().resolve();
        Field currentCharge_field = electric_boat.resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM.get());
        Field capacity_field = electric_boat.resolveAttribute(H05_Tester.ELECTRIC_BOAT_CAPACITY_AM.get());
        Object instance = electric_boat.resolveInstance();

        int currentCharge = (int) electric_boat.setFieldRandom(currentCharge_field);
        int capacity = (int) electric_boat.setFieldRandom(capacity_field);
        int returned_value = ((IntSupplier) instance).getAsInt();

        Context context = contextBuilder()
            .add("currentCharge", currentCharge)
            .add("capacity", capacity)
            .build();
        assertEquals(capacity - currentCharge, returned_value, context, result ->
            "getAsInt did not return the expected value");
    }

    private void test_setSpecificType(byte specificType) throws InvocationTargetException, IllegalAccessException { // TODO: Same hier, resolve erstellt neue instance
        var electric_boat = H05_Tester.ELECTRIC_BOAT_CT.get().resolve();
        Field specificType_field = H05_Tester.ELECTRIC_BOAT_CT
            .get().resolve().resolveAttribute(H05_Tester.ELECTRIC_BOAT_SPECIFIC_TYPE_AM.get());
        Object instance = electric_boat.resolveInstance();
        byte expected_old_specificType = (byte) electric_boat.setFieldRandom(specificType_field);
        byte actual_old_specificType = (byte) H05_Tester.ELECTRIC_BOAT_SET_SPECIFIC_TYPE_MT
            .get().resolveMethod().invoke(instance, specificType);
        byte actual_new_specificType = (byte) electric_boat.getFieldValue(specificType_field);

        Context context = contextBuilder()
            .add("old specificType", expected_old_specificType)
            .add("specificType parameter", specificType)
            .build();
        assertEquals((byte) Math.max(0, Math.min(30, specificType)), actual_new_specificType, context, result ->
            "setSpecificType did not update the specificType field");
        assertEquals(expected_old_specificType, actual_old_specificType, context, result ->
            "setSpecificType did not return the field's old value");
    }

    @Test
    public void test_setSpecificType() throws InvocationTargetException, IllegalAccessException {
        byte[] testvec = new byte[]{6, 11, 12, -100, 31, 30};
        for (byte testcase : testvec) {
            test_setSpecificType(testcase);
        }
    }

    @Test
    @ExtendWith(TestCycleResolver.class)
    public void test_setSpecificType_no_ternary(TestCycle testCycle) {
        SourceFile sourceFile = testCycle.getSubmission().getSourceFile("h05/ElectricBoat.java");
        if (sourceFile == null) {
            throw new AssertionFailedError("Source file h05/ElectricBoat.java was not found in submission");
        }

        boolean ternaryUsed = Pattern.compile(".*setSpecificType\\s*?\\(.*?\\)\\s*?\\{[^}]*?\\?[^}]*?:[^}]*?}.*")
            .matcher(sourceFile.getContent())
            .find();
        assertFalse(ternaryUsed, emptyContext(), result ->
            "Ternary operator used in setSpecificType");
    }


    private void test_constructor_single(int currentCharge, int capacity) throws ReflectiveOperationException {
        var electric_boat = H05_Tester.ELECTRIC_BOAT_CT.get().resolve();
        var means_of_transport = H05_Tester.MEANS_OF_TRANSPORT_CT.get().resolve();

        var currentCharge_field = electric_boat.resolveAttribute(H05_Tester.ELECTRIC_BOAT_CURRENT_CHARGE_AM.get());
        currentCharge_field.trySetAccessible();
        var capacity_field = electric_boat.resolveAttribute(H05_Tester.ELECTRIC_BOAT_CAPACITY_AM.get());
        capacity_field.trySetAccessible();
        var transportType_field = means_of_transport.resolveAttribute(H05_Tester.MEANS_OF_TRANSPORT_TRANSPORT_TYPE_AM.get());
        transportType_field.trySetAccessible();

        var constructor = electric_boat.resolveConstructor(H05_Tester.ELECTRIC_BOAT_CONSTRUCTOR_PARAMETER_MATCHERS.get());

        Object instance = constructor.newInstance((byte) 0, currentCharge, capacity);

        int expected_capacity = Math.min(0, capacity);
        int expected_currentCharge = Math.min(expected_capacity, Math.max(0, currentCharge));
        Object expected_transportType = null;

        int actual_capacity = (int) capacity_field.get(instance);
        int actual_currentCharge = (int) currentCharge_field.get(instance);
        var actual_transportType = transportType_field.get(instance);

        Context context = contextBuilder()
            .add("specificType", 0)
            .add("currentCharge", currentCharge)
            .add("capacity", capacity)
            .build();
        assertEquals(expected_capacity, actual_capacity, context, result ->
            "Field capacity was not set to the expected value");
        assertEquals(expected_currentCharge, actual_currentCharge, context, result ->
            "Field currentCharge was not set to the expected value");
        assertEquals("VESSEL", actual_transportType.toString(), context, result ->
            "Field transportType was not set to the expected value");
        //TODO: Nicht so clean
    }


    @Test
    public void test_constructor() throws ReflectiveOperationException {
        int[] currentCharge_TV = new int[]{10, 3, 33};
        int[] capacity_TV = new int[]{10, 1, -42};

        for (int i = 0; i < currentCharge_TV.length; i++) {
            test_constructor_single(currentCharge_TV[i], capacity_TV[i]);
        }
    }

    @Test
    @ExtendWith(TestCycleResolver.class)
    public void test_constructor_calls_setSpecificType(TestCycle testCycle) {
        H3_2_Transformers.SET_SPECIFIC_TYPE_INVOKED = false;
        testCycle.getClassLoader()
            .visitClass("h05.ElectricBoat", new ClassTransformerTemplate("", H3_2_Transformers.SET_SPECIFIC_TYPE_TRANSFORMER));

        assertTrue(H3_2_Transformers.SET_SPECIFIC_TYPE_INVOKED, emptyContext(), result ->
            "Method setSpecificType was not invoked in constructor of ElectricBoat");
    }
}
