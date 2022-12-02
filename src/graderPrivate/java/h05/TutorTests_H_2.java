package h05;

import h05.transform.ClassTransformerTemplate;
import h05.transform.H3_4_Transformers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.sourcegrade.jagr.api.testing.TestCycle;
import org.sourcegrade.jagr.api.testing.extension.TestCycleResolver;
import org.tudalgo.algoutils.reflect.ClassTester;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;
import org.tudalgo.algoutils.tutor.general.assertions.Context;
import org.tudalgo.algoutils.tutor.general.assertions.expected.ExpectedObject;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.function.Function;

import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.*;

@TestForSubmission
public class TutorTests_H_2 {

    @Test
    public void test_enum() {
        H05_Tester.TRANSPORT_TYPE_CT.get().verify().assertEnumConstants(new String[]{"BICYCLE", "CAR", "VESSEL", "AIRCRAFT"});
    }

    @Test
    public void test_class() {
        Class<?> meansOfTransportClass = H05_Tester.MEANS_OF_TRANSPORT_CT.get().verify().findClass();
        assertEquals(1, meansOfTransportClass.getDeclaredConstructors().length, emptyContext(),
            result -> "Class should not have any explicitly declared constructors other than the default constructor");
    }

    @Test
    public void test_transport_type() {
        Field transport_type_field = H05_Tester.MEANS_OF_TRANSPORT_CT
            .get().resolve().resolveAttribute(H05_Tester.MEANS_OF_TRANSPORT_TRANSPORT_TYPE_AM.get());
        H05_Tester.MEANS_OF_TRANSPORT_CT.get().resolve().assertHasGetter(transport_type_field);
    }

    @Test
    public void test_let_me_move() {
        H05_Tester.MEANS_OF_TRANSPORT_LET_ME_MOVE_MT.get().verify();
    }

    private void checkMessage(String input) throws Throwable {
        Class<?> transportTypeClass = H05_Tester.TRANSPORT_TYPE_CT.get().verify().getTheClass();
        Constructor<?> constructor = transportTypeClass.getDeclaredConstructor(String.class, int.class);
        constructor.trySetAccessible();
        MethodHandle methodHandle = MethodHandles.lookup().unreflectConstructor(constructor);
        Object instance = transportTypeClass.cast(methodHandle.invoke(input, 357));

        Field transport_type_field = H05_Tester.MEANS_OF_TRANSPORT_CT
            .get().resolve().resolveAttribute(H05_Tester.MEANS_OF_TRANSPORT_TRANSPORT_TYPE_AM.get());
        Object obj = H05_Tester.MEANS_OF_TRANSPORT_CT.get().resolve().getNewRealInstance();
        ClassTester.setField(obj, transport_type_field, instance);

        String expected = MessageHelper_H_2.expectedName(input);
        Context context = contextBuilder().add("transportType", input).build();
        Assertions2.<String>testOfObjectBuilder()
            .expected(ExpectedObject.of(expected, MessageHelper_H_2::matchesFormat, Function.identity()))
            .build()
            .run(() -> (String) H05_Tester.MEANS_OF_TRANSPORT_TO_STRING_MT.get().resolveMethod().invoke(obj))
            .check(context, result -> "Expected and actual string differ at index " + getDifferenceIndex(expected, result.object()));
    }

    private int getDifferenceIndex(String expected, String actual) {
        if (actual == null) {
            return 0;
        }

        int i = 0;
        for (; i < expected.length(); i++) {
            if (i > actual.length() - 1 || actual.charAt(i) != expected.charAt(i)) {
                break;
            }
        }
        return i;
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/H2_T5.csv", numLinesToSkip = 1)
    public void test_message_normal(String input) throws Throwable {
        checkMessage(input);
    }

    @Test
    public void test_message_undefined() throws ReflectiveOperationException {
        Field transport_type_field = H05_Tester.MEANS_OF_TRANSPORT_CT
            .get().resolve().resolveAttribute(H05_Tester.MEANS_OF_TRANSPORT_TRANSPORT_TYPE_AM.get());
        Object instance = H05_Tester.MEANS_OF_TRANSPORT_CT.get().resolve().getNewRealInstance();
        ClassTester.setField(instance, transport_type_field, null);
        String s = (String) H05_Tester.MEANS_OF_TRANSPORT_TO_STRING_MT.get().resolveMethod().invoke(instance);

        Context context = contextBuilder()
            .add("transportType", null)
            .build();
        assertTrue(MessageHelper_H_2.matchesUndefined(s), context, result ->
            "Method toString does not return expected string if transportType is null");
    }

    @Test
    public void test_message_article() throws Throwable {
        String[] testvec = {"towel", "showel", "hovercraft", "unimog", "apple"};
        for (String testcase : testvec) {
            checkMessage(testcase);
        }
    }

    @Test
    public void test_message_special_char() throws Throwable {
        String[] testvec = {"elephan%$t", "st(i)ck"};
        for (String testcase : testvec) {
            checkMessage(testcase);
        }
    }

    @Test
    @ExtendWith(TestCycleResolver.class)
    public void test_message_only_char(TestCycle testCycle) {
        H3_4_Transformers.illegalInstruction = null;
        String className = H05_Tester.MEANS_OF_TRANSPORT_CT.get().findClass().getName();
        testCycle.getClassLoader().visitClass(className, new ClassTransformerTemplate(className, H3_4_Transformers.TRANSFORMER));

        assertNull(H3_4_Transformers.illegalInstruction, emptyContext(), result ->
            "Illegal instruction used: " + result.object());
    }
}
