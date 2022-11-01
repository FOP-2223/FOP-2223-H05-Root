package h05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.reflect.ClassTester;
import org.tudalgo.algoutils.reflect.MethodTester;
import org.tudalgo.algoutils.tutor.general.AlgoUtils;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.fail;

@TestForSubmission("h05")
public class TutorTests_H_1_1 {
    @Test
    public void test_interface(){
        H05_Tester.ELECTRICALLY_DRIVEN_CT.verify();
    }

    @Test
    public void test_methods(){
        H05_Tester.ELECTRICALLY_DRIVEN_STANDARD_VOLTAGE_CHARGEABLE_MT.verify();
        H05_Tester.ELECTRICALLY_DRIVEN_HIGH_VOLTAGE_CHARGEABLE_MT.verify();
        H05_Tester.ELECTRICALLY_DRIVEN_LETS_GO_MT.verify();
    }

}
