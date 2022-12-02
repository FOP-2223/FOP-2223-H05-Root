package h05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.sourcegrade.jagr.api.testing.SourceFile;
import org.sourcegrade.jagr.api.testing.TestCycle;
import org.sourcegrade.jagr.api.testing.extension.TestCycleResolver;
import org.tudalgo.algoutils.reflect.ClassTester;
import org.tudalgo.algoutils.tutor.general.assertions.Context;
import spoon.Launcher;
import spoon.reflect.code.CtConditional;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.*;

@TestForSubmission
public class TutorTests_H_3_4 {
    @Test
    public void test_HybridType3_class() {
        H05_Tester.HYBRID_TYPE_3_CT.get().verify();
    }

    @Test
    public void test_HybridType3_attributes_get_set() throws InvocationTargetException, IllegalAccessException {
        var hybrid_type_3 = H05_Tester.HYBRID_TYPE_3_CT.get().resolve();

        var standardVoltageChargeable_field = hybrid_type_3.resolveAttribute(H05_Tester.HYBRID_TYPE_3_STANDARD_VOLTAGE_CHARGEABLE_AM.get());
        standardVoltageChargeable_field.trySetAccessible();
        var highVoltageChargeable_field = hybrid_type_3.resolveAttribute(H05_Tester.HYBRID_TYPE_3_HIGH_VOLTAGE_CHARGEABLE_AM.get());
        highVoltageChargeable_field.trySetAccessible();
        var fuelType_field = hybrid_type_3.resolveAttribute(H05_Tester.HYBRID_TYPE_3_FUEL_TYPE_AM.get());
        fuelType_field.trySetAccessible();
        var averageConsumption_field = hybrid_type_3.resolveAttribute(H05_Tester.HYBRID_TYPE_3_AVERAGE_CONSUMPTION_AM.get());
        averageConsumption_field.trySetAccessible();


        var instance = hybrid_type_3.resolveInstance();
        var expected_standardVoltageChargeable = hybrid_type_3.setFieldRandom(standardVoltageChargeable_field);
        var expected_highVoltageChargeable = hybrid_type_3.setFieldRandom(highVoltageChargeable_field);
        var expected_fuelType = hybrid_type_3.setFieldRandom(fuelType_field);
        var expected_averageConsumption = hybrid_type_3.setFieldRandom(averageConsumption_field);

        var actual_standardVoltageChargeable = H05_Tester.ELECTRICALLY_DRIVEN_STANDARD_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        var actual_highVoltageChargeable = H05_Tester.ELECTRICALLY_DRIVEN_HIGH_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        var actual_fuelType = H05_Tester.FUEL_DRIVEN_GET_FUEL_TYPE_MT.get().resolveMethod().invoke(instance);
        var speed = ThreadLocalRandom.current().nextDouble();
        var actual_averageConsumption = H05_Tester.FUEL_DRIVEN_GET_AVERAGE_CONSUMPTION_MT.get().resolveMethod().invoke(instance, speed);

        // check Getter
        Context context = contextBuilder()
            .add("standardVoltageChargeable", expected_standardVoltageChargeable)
            .add("highVoltageChargeable", expected_highVoltageChargeable)
            .add("fuelType", expected_fuelType)
            .add("averageConsumption", expected_averageConsumption)
            .build();
        assertEquals(expected_standardVoltageChargeable, actual_standardVoltageChargeable, context, result ->
            "Method standardVoltageChargeable did not return the expected value");
        assertEquals(expected_highVoltageChargeable, actual_highVoltageChargeable, context, result ->
            "Method highVoltageChargeable did not return the expected value");
        assertEquals(expected_fuelType, actual_fuelType, context, result ->
            "Method getFuelType did not return the expected value");
        assertEquals(expected_averageConsumption, actual_averageConsumption, context, result ->
            "Method getAverageConsumption did not return the expected value");

        //check Toggle
        H05_Tester.HYBRID_TYPE_3_TOGGLE_STANDARD_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        assertNotEquals(expected_standardVoltageChargeable, hybrid_type_3.getFieldValue(standardVoltageChargeable_field), context, result ->
            "Field standardVoltageChargeable did not have expected value after invoking toggleStandardVoltageChargeable once");
        H05_Tester.HYBRID_TYPE_3_TOGGLE_STANDARD_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        assertEquals(expected_standardVoltageChargeable, hybrid_type_3.getFieldValue(standardVoltageChargeable_field), context, result ->
            "Field standardVoltageChargeable did not have expected value after invoking toggleStandardVoltageChargeable twice");

        H05_Tester.HYBRID_TYPE_3_TOGGLE_HIGH_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        assertNotEquals(expected_highVoltageChargeable, hybrid_type_3.getFieldValue(highVoltageChargeable_field), context, result ->
            "Field highVoltageChargeable did not have expected value after invoking toggleHighVoltageChargeable once");
        H05_Tester.HYBRID_TYPE_3_TOGGLE_HIGH_VOLTAGE_CHARGEABLE_MT.get().resolveMethod().invoke(instance);
        assertEquals(expected_highVoltageChargeable, hybrid_type_3.getFieldValue(highVoltageChargeable_field), context, result ->
            "Field highVoltageChargeable did not have expected value after invoking toggleHighVoltageChargeable twice");

        //check Setter
        Object new_averageConsumption = ClassTester.getRandomValue(averageConsumption_field.getType());
        context = contextBuilder()
            .add("averageConsumption (parameter)", new_averageConsumption)
            .build();
        H05_Tester.HYBRID_TYPE_3_SET_AVERAGE_CONSUMPTION_MT.get().resolveMethod().invoke(instance, new_averageConsumption);
        assertEquals(new_averageConsumption, hybrid_type_3.getFieldValue(averageConsumption_field), context, result ->
            "setAverageConsumption did not set averageConsumption to the expected value");

        Object new_fuelType = ClassTester.getRandomValue(fuelType_field.getType());
        context = contextBuilder()
            .add("fuelType (parameter)", new_fuelType)
            .build();
        H05_Tester.HYBRID_TYPE_3_SET_FUEL_TYPE_MT.get().resolveMethod().invoke(instance, new_fuelType);
        assertEquals(new_fuelType, hybrid_type_3.getFieldValue(fuelType_field), context, result ->
            "setFuelType did not set fuelType to the expected value");
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

        Context context = contextBuilder()
            .add("preferredDriveType", initial)
            .build();
        assertNotEquals(initial, one_toggled, context, result ->
            "Field getPreferredDriveType did not have the expected value after invoking togglePreferredDriveType once");
        assertEquals(initial, twice_toggled, context, result ->
            "Field getPreferredDriveType did not have the expected value after invoking togglePreferredDriveType twice");
    }

    @Test
    @ExtendWith(TestCycleResolver.class)
    public void test_HybridType3_togglePreferredDriveType_ternary(TestCycle testCycle) {
        String className = H05_Tester.HYBRID_TYPE_3_CT.get().verify().findClass().getName().replace(".", "/");
        SourceFile sourceFile = testCycle.getSubmission().getSourceFile(className + ".java");
        CtClass<?> hybridType3CtClass = Launcher.parseClass(sourceFile.getContent());

        String methodName = H05_Tester.HYBRID_TYPE_3_TOGGLE_PREFERRED_DRIVE_TYPE_MT.get().resolveMethod().getName();
        List<CtElement> togglePreferredDriveTypeCtElements = hybridType3CtClass.getMethodsByName(methodName).stream()
            .filter(ctMethod -> ctMethod.getParameters().size() == 0)
            .findAny()
            .get()
            .getElements(element -> element instanceof CtConditional<?>);

        assertTrue(togglePreferredDriveTypeCtElements.size() > 0, emptyContext(), result ->
            "Method togglePreferredDriveType did not use ternary operator");
    }
}
