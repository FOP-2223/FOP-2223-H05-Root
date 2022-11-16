package h05;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission
public class TutorTests_H_3_1 {

    @Test
    public void test_class() {
        H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().verify();
    }

    @Test
    public void test_getFuelType() {
        Field fuel_type_field =
            H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().resolveAttribute(H05_Tester.FUEL_DRIVEN_VEHICLE_FUEL_TYPE_AM.get());
        H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().assertHasGetter(fuel_type_field);
    }

    private void test_getAverageConsumption(int speed) throws InvocationTargetException, IllegalAccessException {
        final double EPSILON = 0.0001;
        Object instance = H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().getNewRealInstance();
        double actual_consumption = (double) H05_Tester.FUEL_DRIVEN_GET_AVERAGE_CONSUMPTION_MT.get().resolveMethod().invoke(instance
            , speed);
        double expected_consumption = Math.max(0, Math.min(0.1 * speed, 20));
        assertEquals(expected_consumption, actual_consumption, EPSILON, "Rückgabewert von getAverageConsumption nicht korrekt!");
    }

    @Test
    public void test_getAverageConsumption() throws InvocationTargetException, IllegalAccessException {
        int[] testvec = new int[]{-10, 0, 2, 50, 200, 1000};
        for (int testcase : testvec) {
            test_getAverageConsumption(testcase);
        }
    }

    private void test_fill_up(int fillValue) throws InvocationTargetException, IllegalAccessException {
        Field filling_level_field =
            H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().resolveAttribute(H05_Tester.FUEL_DRIVEN_VEHICLE_FILLING_LEVEL_AM.get());
        Object instance = H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().getNewRealInstance();
        int filling_level_before = ThreadLocalRandom.current().nextInt();
        H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().setField(instance, filling_level_field, filling_level_before);
        H05_Tester.FUEL_DRIVEN_VEHICLE_FILL_UP_MT.get().resolveMethod().invoke(instance, fillValue);
        int filling_level_after = (int) H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().getFieldValue(instance,
            filling_level_field);
        assertEquals(filling_level_before + Math.max(0, fillValue), filling_level_after, "Methode fillUp funktioniert nicht korrekt");
    }

    @Test
    public void test_filling() throws InvocationTargetException, IllegalAccessException {
        //Attribut und Getter
        Field filling_level_field =
            H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().resolveAttribute(H05_Tester.FUEL_DRIVEN_VEHICLE_FILLING_LEVEL_AM.get());
        H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().assertHasGetter(filling_level_field);

        //Fill UP
        int[] testvec = new int[]{-10, 10, 100, 0};
        for (int testcase : testvec) {
            test_fill_up(testcase);
        }
    }

    private void test_letMeMove(int distance) throws InvocationTargetException, IllegalAccessException {
        Field filling_level_field =
            H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().resolveAttribute(H05_Tester.FUEL_DRIVEN_VEHICLE_FILLING_LEVEL_AM.get());
        Object instance = H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().getNewRealInstance();
        int filling_level_before = 10;
        H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().setField(instance, filling_level_field, filling_level_before);

        int returned_value = (int) H05_Tester.MEANS_OF_TRANSPORT_LET_ME_MOVE_MT.get().resolveMethod().invoke(instance, distance);
        int actual_filling_level_after = (int) H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolve().getFieldValue(instance,
            filling_level_field);

        int reduceBy;
        if (distance < 0) {
            reduceBy = 0;
        } else if (distance < 10 * filling_level_before) {
            reduceBy = distance / 10;
        } else {
            reduceBy = filling_level_before;
        }

        assertEquals(filling_level_before - reduceBy, actual_filling_level_after, "Methode letMeMove reduziert fillingLevel nicht korrekt");
        assertEquals(reduceBy / 10, returned_value, "Der Rückgabewert der Methode letMeMove ist nicht korrekt!");
    }

    @Test
    public void test_letMeMove() throws InvocationTargetException, IllegalAccessException {
        int[] testvec = new int[]{-100, 0, 10, 50, 200};
        for (int testcase : testvec) {
            test_letMeMove(testcase);
        }
    }

    private void test_constructor(int fuelType, int transportType, int fillingLevel) throws Throwable {
        Constructor constructor =
            H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolveConstructor(new ArrayList<>(Arrays.asList(H05_Tester.FUEL_DRIVEN_VEHICLE_CONSTRUCTOR_PARAMETER_MATCHERS.get())));

        Class fuelTypeClass = H05_Tester.FUEL_TYPE_CT.get().getTheClass();
        Constructor c_fuelType = fuelTypeClass.getDeclaredConstructor(String.class, int.class);
        c_fuelType.setAccessible(true);
        MethodHandle h_fuelType = MethodHandles.lookup().unreflectConstructor(c_fuelType);
        Object fuelType_obj = fuelTypeClass.cast(h_fuelType.invoke("dummy", fuelType));

        Class transportTypeClass = H05_Tester.TRANSPORT_TYPE_CT.get().getTheClass();
        Constructor c_transportType = transportTypeClass.getDeclaredConstructor(String.class, int.class);
        c_transportType.setAccessible(true);
        MethodHandle h_transportType = MethodHandles.lookup().unreflectConstructor(c_transportType);
        Object transportType_obj = transportTypeClass.cast(h_transportType.invoke("dummy", transportType));

        Object instance = constructor.newInstance(fuelType_obj, transportType_obj, fillingLevel);

        Field fuelType_field =
            H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolveAttribute(H05_Tester.FUEL_DRIVEN_VEHICLE_FUEL_TYPE_AM.get());
        fuelType_field.setAccessible(true);
        Object actual_fuelType = H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().getFieldValue(instance, fuelType_field);

        Field transportType_field =
            H05_Tester.MEANS_OF_TRANSPORT_CT.get().resolveAttribute(H05_Tester.MEANS_OF_TRANSPORT_TRANSPORT_TYPE_AM.get());
        transportType_field.setAccessible(true);
        Object actual_transportType = H05_Tester.MEANS_OF_TRANSPORT_CT.get().getFieldValue(instance, transportType_field);

        Field fillingLevel_field =
            H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().resolveAttribute(H05_Tester.FUEL_DRIVEN_VEHICLE_FILLING_LEVEL_AM.get());
        fillingLevel_field.setAccessible(true);
        int actual_filling_level = (int) H05_Tester.FUEL_DRIVEN_VEHICLE_CT.get().getFieldValue(instance, fillingLevel_field);

        assertEquals(fuelType_obj, actual_fuelType, "Konstruktor von FuelDrivenVehicle setzt fuelType nicht korrekt.");
        assertEquals(transportType_obj, actual_transportType, "Konstruktor von FuelDrivenVehicle setzt transportType nicht korrekt.");
        assertEquals(fillingLevel, actual_filling_level, "Konstruktor von FuelDrivenVehicle setzt fillingLevel nicht korrekt.");
    }

    @Test
    public void test_constructor() throws Throwable {
        int[][] testvec = new int[][]{
            {0, 1, 10},
            {1, 0, 999}
        };
        for (int[] testcase : testvec) {
            test_constructor(testcase[0], testcase[1], testcase[2]);
        }
    }
}
