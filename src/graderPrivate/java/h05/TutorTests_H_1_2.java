package h05;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

@TestForSubmission("h05")
public class TutorTests_H_1_2 {

    @Test
    public void test_enum(){
        H05_Tester.FUEL_TYPE_CT.verify();
        String[] enum_constants = {"GASOLINE", "DIESEL", "LPG"};
        H05_Tester.FUEL_TYPE_CT.assertEnumConstants(enum_constants);
    }

    @Test
    public void test_interface(){
        H05_Tester.FUEL_DRIVEN_CT.verify();
    }

    @Test
    public void test_methods(){
        H05_Tester.FUEL_DRIVEN_GET_FUEL_TYPE_MT.verify();
        H05_Tester.FUEL_DRIVEN_GET_AVERAGE_CONSUMPTION_MT.verify();
    }
}
