package h05;

import org.sourcegrade.jagr.api.rubric.*;

@RubricForSubmission("h05")
public class H05_RubricProvider implements RubricProvider {
    public static final Criterion H1_1_T1 = Criterion.builder()
        .shortDescription("Das Interface ElectricallyDriven ist korrekt deklariert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_1.class.getMethod(
                    "test_interface")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H1_1_T2 = Criterion.builder()
        .shortDescription("Die Methoden standardVoltageChargeable, highVoltageChargeable und letsGo sind korrekt deklariert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_1.class.getMethod(
                    "test_methods")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H1_1 = Criterion.builder()
        .shortDescription("H1.1 | Interface ElectricallyDriven")
        .addChildCriteria(H1_1_T1, H1_1_T2)
        .build();

    public static final Criterion H1_2_T1 = Criterion.builder()
        .shortDescription("Das Enum FuelType ist korrekt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_2.class.getMethod(
                    "test_enum")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H1_2_T2 = Criterion.builder()
        .shortDescription("Das Interface FuelDriven ist korrekt deklariert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_2.class.getMethod(
                    "test_interface")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H1_2_T3 = Criterion.builder()
        .shortDescription("Die Methoden getFuelType und getAverageConsumption sind korrekt deklariert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_2.class.getMethod(
                    "test_methods")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H1_2 = Criterion.builder()
        .shortDescription("H1.2 | Interface FuelDriven")
        .addChildCriteria(H1_2_T1, H1_2_T2, H1_2_T3)
        .build();

    public static final Criterion H1_3_T1 = Criterion.builder()
        .shortDescription("Das Enum DriveType ist korrekt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_2.class.getMethod(
                    "test_enum")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H1_3_T2 = Criterion.builder()
        .shortDescription("Das Interface HybridVehicle ist korrekt deklariert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_2.class.getMethod(
                    "test_interface")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H1_3_T3 = Criterion.builder()
        .shortDescription("Die Methode getPreferredDriveType ist korrekt deklariert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_2.class.getMethod(
                    "test_methods")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H1_3 = Criterion.builder()
        .shortDescription("H1.3 | Interface HybridVehicle")
        .addChildCriteria(H1_3_T1, H1_3_T2, H1_3_T3)
        .build();


    public static final Criterion H1 = Criterion.builder()
        .shortDescription("H1 | Drei Interfaces")
        .addChildCriteria(H1_1, H1_2, H1_3)
        .build();


    public static final Criterion H2_T1 = Criterion.builder()
        .shortDescription("Das Enum TransportType ist korrekt deklariert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_enum")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H2_T2 = Criterion.builder()
        .shortDescription("Die Klasse MeansOfTransport ist korrekt deklariert und abstrakt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_class")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H2_T3 = Criterion.builder()
        .shortDescription("Das Attribut transportType ist korrekt deklariert und die Getter-Methode getTransportType ist korrekt umgesetzt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_transport_type")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H2_T4 = Criterion.builder()
        .shortDescription("Die Methode letMeMove ist korrekt deklariert und abstrakt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_let_me_move")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H2_T5 = Criterion.builder()
        .shortDescription("Die Methode toString funktioniert für einfache Fälle erkennbar korrekt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_message_normal")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H2_T6 = Criterion.builder()
        .shortDescription("Die Methode toString funktioniert auch für null erkennbar korrekt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_message_undefined")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H2_T7 = Criterion.builder()
        .shortDescription("Die Methode toString funktioniert in allen Fällen erkennbar korrekt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_message_article")))
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_message_special_char")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H2 = Criterion.builder()
        .shortDescription("H2 | Klasse MeansOfTransport")
        .addChildCriteria(H2_T1, H2_T2, H2_T3, H2_T4, H2_T5, H2_T6, H2_T7)
        .build();


    public static final Rubric RUBRIC = Rubric.builder()
        .title("H05")
        .addChildCriteria(H1, H2)
        .build();

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }
}
