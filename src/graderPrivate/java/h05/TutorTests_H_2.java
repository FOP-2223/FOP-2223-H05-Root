package h05;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@TestForSubmission
public class TutorTests_H_2 {

    @Test
    public void test_enum(){
        H05_Tester.TRANSPORT_TYPE_CT.verify();
        String[] enum_constants = {"BICYCLE", "CAR", "VESSEL", "PLANE"};
        H05_Tester.TRANSPORT_TYPE_CT.assertEnumConstants(enum_constants);
    }

    @Test
    public void test_class(){
        H05_Tester.MEANS_OF_TRANSPORT_CT.verify();
        // TODO: check Constructor
    }

    @Test
    public void test_transport_type(){
        Field transport_type_field = H05_Tester.MEANS_OF_TRANSPORT_CT.resolve().resolveAttribute(H05_Tester.MEANS_OF_TRANSPORT_TRANSPORT_TYPE_AM);
        H05_Tester.MEANS_OF_TRANSPORT_CT.resolve().assertHasGetter(transport_type_field);
    }

    @Test
    public void test_let_me_move(){
        H05_Tester.MEANS_OF_TRANSPORT_LET_ME_MOVE_MT.verify();
    }

    private void check_message(String name) throws Throwable{
        check_message(name, false);
    }

    private void check_message(String name, boolean identical)throws Throwable{

        Class transportTypeClass = H05_Tester.TRANSPORT_TYPE_CT.getTheClass();
        Constructor c = transportTypeClass.getDeclaredConstructor(String.class, int.class);
        c.setAccessible(true);
        MethodHandle h = MethodHandles.lookup().unreflectConstructor(c);
        Object t = transportTypeClass.cast(h.invoke(name, 357));

        Field transport_type_field = H05_Tester.MEANS_OF_TRANSPORT_CT.resolve().resolveAttribute(H05_Tester.MEANS_OF_TRANSPORT_TRANSPORT_TYPE_AM);
        var obj = H05_Tester.MEANS_OF_TRANSPORT_CT.getNewRealInstance();
        H05_Tester.MEANS_OF_TRANSPORT_CT.resolve().setField(obj, transport_type_field, t);

        String s = null;
        try {
            s = (String)H05_Tester.MEANS_OF_TRANSPORT_TO_STRING_MT.resolveMethod().invoke(obj ,null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String actual = MessageHelper_H_2.match_format(s);
        assertEquals(MessageHelper_H_2.match_format(MessageHelper_H_2.expected_name(name)), actual);
    }


    @Test
    public void test_message_normal() throws Throwable{
        String[] testvec = {"towel", "showel", "hovercraft"};
        for(String testcase : testvec) {
            check_message(testcase);
        }
    }

    @Test
    public void test_message_undefined(){
        Field transport_type_field = H05_Tester.MEANS_OF_TRANSPORT_CT.resolve().resolveAttribute(H05_Tester.MEANS_OF_TRANSPORT_TRANSPORT_TYPE_AM);
        var obj = H05_Tester.MEANS_OF_TRANSPORT_CT.getNewRealInstance();
        H05_Tester.MEANS_OF_TRANSPORT_CT.resolve().setField(obj, transport_type_field, null);
        String s = null;
        try {
            s = (String)H05_Tester.MEANS_OF_TRANSPORT_TO_STRING_MT.resolveMethod().invoke( obj,null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        String name = MessageHelper_H_2.match_format(s);
        assertEquals("undefined", name.toLowerCase(Locale.ROOT), "TransportType null does not return undefined for toString");
    }

    @Test
    public void test_message_article() throws Throwable{
        String[] testvec = {"towel", "showel", "hovercraft", "unimog", "apple"};
        for(String testcase : testvec) {
            check_message(testcase, true);
        }
    }

    @Test
    public void test_message_special_char() throws Throwable{
        String[] testvec = {"elephan%$t", "st(i)ck"};
        for(String testcase : testvec) {
            check_message(testcase);
        }
    }

    @Test
    public void test_message_only_char(){
        // TODO
    }

}
