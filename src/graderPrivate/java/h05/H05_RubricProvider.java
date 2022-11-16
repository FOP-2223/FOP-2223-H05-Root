package h05;

import org.sourcegrade.jagr.api.rubric.Criterion;
import org.sourcegrade.jagr.api.rubric.Grader;
import org.sourcegrade.jagr.api.rubric.JUnitTestRef;
import org.sourcegrade.jagr.api.rubric.Rubric;
import org.sourcegrade.jagr.api.rubric.RubricProvider;

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
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_3.class.getMethod(
                    "test_enum")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H1_3_T2 = Criterion.builder()
        .shortDescription("Das Interface HybridVehicle ist korrekt deklariert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_3.class.getMethod(
                    "test_interface")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H1_3_T3 = Criterion.builder()
        .shortDescription("Die Methode getPreferredDriveType ist korrekt deklariert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_1_3.class.getMethod(
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
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_message_only_char")))
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
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_message_only_char")))
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
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod(
                    "test_message_only_char")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H2 = Criterion.builder()
        .shortDescription("H2 | Klasse MeansOfTransport")
        .addChildCriteria(H2_T1, H2_T2, H2_T3, H2_T4, H2_T5, H2_T6, H2_T7)
        .build();

    public static final Criterion H3_1_T1 = Criterion.builder()
        .shortDescription("Die Klasse FuelDrivenVehicle ist korrekt deklariert, erweitert MeansOfTransport und implementiert FuelDriven.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod(
                    "test_class")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_1_T2 = Criterion.builder()
        .shortDescription("Das Attribut fuelType der Klasse FuelDrivenVehicle und die dazugehörige Getter-Methode getFuelType sind korrekt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod(
                    "test_getFuelType")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_1_T3 = Criterion.builder()
        .shortDescription("Die Methode getAverageConsumption ist korrekt implementiert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod(
                    "test_getAverageConsumption")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_1_T4 = Criterion.builder()
        .shortDescription("Das Attribut fillingLevel der Klasse FuelDrivenVehicle, die dazugehörige Getter-Methode getFillingLevel und die Methode fillUp sind korrekt umgesetzt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod(
                    "test_filling")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_1_T5 = Criterion.builder()
        .shortDescription("Die Methode letMeMove ist korrekt umgesetzt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod(
                    "test_letMeMove")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_1_T6 = Criterion.builder()
        .shortDescription("Der Konstruktor der Klasse FuelDrivenVehicle ist korrekt umgesetzt.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod(
                    "test_constructor")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_1 = Criterion.builder()
        .shortDescription("H3.1 | FuelDriven durch FuelDrivenVehicle implementieren")
        .addChildCriteria(H3_1_T1, H3_1_T6, H3_1_T2, H3_1_T3, H3_1_T4, H3_1_T5)
        .build();

    public static final Criterion H3_2_T1 = Criterion.builder()
        .shortDescription("Die Klasse ElectricBoat ist korrekt deklariert, erweitert MeansOfTransport und implementiert ElectricallyDriven und IntSupplier.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod(
                    "test_class")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_2_T2 = Criterion.builder()
        .shortDescription("ElectricBoat besitzt die Attribute specificType, currentCharge und capacity und jeweils eine get-Methode.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod(
                    "test_attributes")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_2_T3 = Criterion.builder()
        .shortDescription("Die Klasse ElectricBoat setzt die Methoden standardVoltageChargable und highVoltageChargable korrekt um.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod(
                    "test_chargeable")))
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod(
                    "test_chargeable_ternary")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_2_T4 = Criterion.builder()
        .shortDescription("Die Klasse ElectricBoat setzt die Methoden letsGo und letMeMove korrekt um.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod(
                    "test_letsGo")))
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod(
                    "test_letMeMove")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_2_T5 = Criterion.builder()
        .shortDescription("ElectricBoat setzt die Methode getAsInt von IntSupplier korrekt um.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod(
                    "test_getAsInt")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_2_T6 = Criterion.builder()
        .shortDescription("Die Klasse ElectricBoat setzt die Methode setSpecificType korrekt um.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod(
                    "test_setSpecificType")))
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod(
                    "test_setSpecificType_no_ternary")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_2_T7 = Criterion.builder()
        .shortDescription("Der Konstruktor der Klasse ElectricBoat ist korrekt implementiert.")
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod(
                    "test_constructor")))
                .pointsPassedMax()
                .pointsFailedMin()
                .build())
        .build();

    public static final Criterion H3_2 = Criterion.builder()
        .shortDescription("H3.2 | ElectricallyDriven durch ElectricBoat implementieren")
        .addChildCriteria(H3_2_T1, H3_2_T2, H3_2_T3, H3_2_T4, H3_2_T5, H3_2_T6, H3_2_T7)
        .build();

    public static final Criterion H3_3 = Criterion.builder()
        .shortDescription("H3.3 | FuelDriven und ElectricallyDriven zugleich implementieren")
        .addChildCriteria()
        .build();

    public static final Criterion H3_4 = Criterion.builder()
        .shortDescription("H3.4 | HybridVehicle implementieren")
        .addChildCriteria()
        .build();

    public static final Criterion H3 = Criterion.builder()
        .shortDescription("H3 | Abgeleitete / Implementierende Klassen")
        .addChildCriteria(H3_1, H3_2)
        .build();
    public static final Rubric RUBRIC = Rubric.builder()
        .title("H05")
        .addChildCriteria(H1, H2, H3)
        .build();

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }
}
