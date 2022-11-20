package h05;

import org.sourcegrade.jagr.api.rubric.*;

import java.util.function.Function;
import java.util.regex.Pattern;

public class H05_RubricProvider implements RubricProvider {

    private static final Function<String, String> CODE_TAGIFY = s -> Pattern.compile("\\[\\[\\[(.+?)]]]")
        .matcher(s)
        .replaceAll(matchResult -> "\\\\<code\\\\>%s\\\\</code\\\\>".formatted(matchResult.group(1)));

    private static Criterion makeSimpleCriterion(String shortDescription, JUnitTestRef... jUnitTestRefs) {
        return Criterion.builder()
            .shortDescription(CODE_TAGIFY.apply(shortDescription))
            .grader(Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.and(jUnitTestRefs))
                .pointsFailedMin()
                .pointsPassedMax()
                .build())
            .build();
    }

    public static final Criterion H1_1_T1 = makeSimpleCriterion(
        "Das Interface [[[ElectricallyDriven]]] ist korrekt deklariert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_1_1.class.getMethod("test_interface")));

    public static final Criterion H1_1_T2 = makeSimpleCriterion(
        "Die Methoden [[[standardVoltageChargeable]]], [[[highVoltageChargeable]]] und [[[letsGo]]] sind korrekt deklariert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_1_1.class.getMethod("test_methods")));

    public static final Criterion H1_1 = Criterion.builder()
        .shortDescription(CODE_TAGIFY.apply("H1.1 | Interface [[[ElectricallyDriven]]]"))
        .addChildCriteria(H1_1_T1, H1_1_T2)
        .build();

    public static final Criterion H1_2_T1 = makeSimpleCriterion(
        "Das Enum [[[FuelType]]] ist korrekt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_1_2.class.getMethod("test_enum")));

    public static final Criterion H1_2_T2 = makeSimpleCriterion(
        "Das Interface [[[FuelDriven]]] ist korrekt deklariert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_1_2.class.getMethod("test_interface")));

    public static final Criterion H1_2_T3 = makeSimpleCriterion(
        "Die Methoden [[[getFuelType]]] und [[[getAverageConsumption]]] sind korrekt deklariert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_1_2.class.getMethod("test_methods")));

    public static final Criterion H1_2 = Criterion.builder()
        .shortDescription(CODE_TAGIFY.apply("H1.2 | Interface [[[FuelDriven]]]"))
        .addChildCriteria(H1_2_T1, H1_2_T2, H1_2_T3)
        .build();

    public static final Criterion H1_3_T1 = makeSimpleCriterion(
        "Das Enum [[[DriveType]]] ist korrekt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_1_3.class.getMethod("test_enum")));

    public static final Criterion H1_3_T2 = makeSimpleCriterion(
        "Das Interface [[[HybridVehicle]]] ist korrekt deklariert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_1_3.class.getMethod("test_interface")));

    public static final Criterion H1_3_T3 = makeSimpleCriterion(
        "Die Methode [[[getPreferredDriveType]]] ist korrekt deklariert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_1_3.class.getMethod("test_methods")));

    public static final Criterion H1_3 = Criterion.builder()
        .shortDescription(CODE_TAGIFY.apply("H1.3 | Interface [[[HybridVehicle]]]"))
        .addChildCriteria(H1_3_T1, H1_3_T2, H1_3_T3)
        .build();

    public static final Criterion H1 = Criterion.builder()
        .shortDescription("H1 | Drei Interfaces")
        .addChildCriteria(H1_1, H1_2, H1_3)
        .build();

    public static final Criterion H2_T1 = makeSimpleCriterion(
        "Das Enum [[[TransportType]]] ist korrekt deklariert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_enum")));

    public static final Criterion H2_T2 = makeSimpleCriterion(
        "Die Klasse [[[MeansOfTransport]]] ist korrekt deklariert und abstrakt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_class")));

    public static final Criterion H2_T3 = makeSimpleCriterion(
        "Das Attribut [[[transportType]]] ist korrekt deklariert und die Getter-Methode [[[getTransportType]]] ist korrekt umgesetzt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_transport_type")));

    public static final Criterion H2_T4 = makeSimpleCriterion(
        "Die Methode [[[letMeMove]]] ist korrekt deklariert und abstrakt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_let_me_move")));

    public static final Criterion H2_T5 = makeSimpleCriterion(
        "Die Methode [[[toString]]] funktioniert für einfache Fälle erkennbar korrekt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_message_normal", String.class))
        /*JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_message_only_char"))*/);

    public static final Criterion H2_T6 = makeSimpleCriterion(
        "Die Methode [[[toString]]] funktioniert auch für null erkennbar korrekt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_message_undefined")),
        JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_message_only_char")));

    public static final Criterion H2_T7 = makeSimpleCriterion(
        "Die Methode [[[toString]]] funktioniert in allen Fällen erkennbar korrekt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_message_article")),
        JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_message_special_char")),
        JUnitTestRef.ofMethod(() -> TutorTests_H_2.class.getMethod("test_message_only_char")));

    public static final Criterion H2 = Criterion.builder()
        .shortDescription(CODE_TAGIFY.apply("H2 | Klasse [[[MeansOfTransport]]]"))
        .addChildCriteria(H2_T1, H2_T2, H2_T3, H2_T4, H2_T5, H2_T6, H2_T7)
        .build();

    public static final Criterion H3_1_T1 = makeSimpleCriterion(
        "Die Klasse [[[FuelDrivenVehicle]]] ist korrekt deklariert, erweitert [[[MeansOfTransport]]] und implementiert [[[FuelDriven]]].",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod("test_class")));

    public static final Criterion H3_1_T2 = makeSimpleCriterion(
        "Das Attribut [[[fuelType]]] der Klasse [[[FuelDrivenVehicle]]] und die dazugehörige Getter-Methode [[[getFuelType]]] sind korrekt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod("test_getFuelType")));

    public static final Criterion H3_1_T3 = makeSimpleCriterion(
        "Die Methode [[[getAverageConsumption]]] ist korrekt implementiert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod("test_getAverageConsumption")));

    public static final Criterion H3_1_T4 = makeSimpleCriterion(
        "Das Attribut [[[fillingLevel]]] der Klasse [[[FuelDrivenVehicle]]], "
            + "die dazugehörige Getter-Methode [[[getFillingLevel]]] und die Methode [[[fillUp]]] sind korrekt umgesetzt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod("test_filling")));

    public static final Criterion H3_1_T5 = makeSimpleCriterion(
        "Die Methode [[[letMeMove]]] ist korrekt umgesetzt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod("test_letMeMove")));

    public static final Criterion H3_1_T6 = makeSimpleCriterion(
        "Der Konstruktor der Klasse [[[FuelDrivenVehicle]]] ist korrekt umgesetzt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_1.class.getMethod("test_constructor")));

    public static final Criterion H3_1 = Criterion.builder()
        .shortDescription(CODE_TAGIFY.apply("H3.1 | [[[FuelDriven]]] durch [[[FuelDrivenVehicle]]] implementieren"))
        .addChildCriteria(H3_1_T1, H3_1_T6, H3_1_T2, H3_1_T3, H3_1_T4, H3_1_T5)
        .build();

    public static final Criterion H3_2_T1 = makeSimpleCriterion(
        "Die Klasse [[[ElectricBoat]]] ist korrekt deklariert, erweitert [[[MeansOfTransport]]] und "
            + "implementiert [[[ElectricallyDriven]]] und [[[IntSupplier]]].",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod("test_class")));

    public static final Criterion H3_2_T2 = makeSimpleCriterion(
        "[[[ElectricBoat]]] besitzt die Attribute [[[specificType]]], [[[currentCharge]]] und [[capacity]] und jeweils eine get-Methode.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod("test_attributes")));

    public static final Criterion H3_2_T3 = makeSimpleCriterion(
        "Die Klasse [[[ElectricBoat]]] setzt die Methoden [[[standardVoltageChargable]]] und [[[highVoltageChargable]]] korrekt um.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod("test_chargeable")),
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod("test_chargeable_return")));

    public static final Criterion H3_2_T4 = makeSimpleCriterion(
        "Die Klasse [[[ElectricBoat]]] setzt die Methoden [[[letsGo]]] und [[[letMeMove]]] korrekt um.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod("test_letsGo")),
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod("test_letMeMove")));

    public static final Criterion H3_2_T5 = makeSimpleCriterion(
        "[[[ElectricBoat]]] setzt die Methode [[[getAsInt]]] von [[[IntSupplier]]] korrekt um.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod("test_getAsInt")));

    public static final Criterion H3_2_T6 = makeSimpleCriterion(
        "Die Klasse [[[ElectricBoat]]] setzt die Methode [[[setSpecificType]]] korrekt um.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod("test_setSpecificType")),
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod("test_setSpecificType_no_ternary")));

    public static final Criterion H3_2_T7 = makeSimpleCriterion(
        "Der Konstruktor der Klasse [[[ElectricBoat]]] ist korrekt implementiert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_2.class.getMethod("test_constructor")));

    public static final Criterion H3_2 = Criterion.builder()
        .shortDescription(CODE_TAGIFY.apply("H3.2 | [[[ElectricallyDriven]]] durch [[[ElectricBoat]]] implementieren"))
        .addChildCriteria(H3_2_T1, H3_2_T2, H3_2_T3, H3_2_T4, H3_2_T5, H3_2_T6, H3_2_T7)
        .build();


    public static final Criterion H3_3_T1 = makeSimpleCriterion(
        "Die Klasse [[[HybridType]]] ist erkennbar korrekt definiert und implementiert [[[FuelDriven]]] und [[[ElectricallyDriven]]]",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_3.class.getMethod("test_HybridType1_class")));

    public static final Criterion H3_3_T2 = makeSimpleCriterion(
        "Die Attribute von Klasse [[[HybridType1]]] sind korrekt als Klassenattribute deklariert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_3.class.getMethod("test_HybridType1_attributes")));

    public static final Criterion H3_3_T3 = makeSimpleCriterion(
        "Alle zu implementierenden Methoden sind korrekt umgesetzt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_3.class.getMethod("test_HybridType1_get_set")));

    public static final Criterion H3_3_T4 = makeSimpleCriterion(
        "Die Klasse [[[HybridType2]]] ist korrekt deklariert, erweitert [[[MeansOfTransport]]] und implementiert [[[FuelDriven]]] und [[[ElectricallyDriven]]].",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_3.class.getMethod("test_HybridType2_class")));

    public static final Criterion H3_3_T5 = makeSimpleCriterion(
        "Die Klasse [[[HybridType2]]] besitzt ein Objekt [[[hybridObject]]] von Typ [[[HybridType1]]] und erzeugt dieses im Konstruktor.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_3.class.getMethod("test_HybridType2_hybrid_Object")));

    public static final Criterion H3_3_T6 = makeSimpleCriterion(
        "Alle zu implementierenden Methoden funktionieren korrekt und leiten die Aufrufe an [[[hybridObject]]] weiter.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_3.class.getMethod("test_HybridType2_forwarding")));

    public static final Criterion H3_3 = Criterion.builder()
        .shortDescription(CODE_TAGIFY.apply("H3.3 | [[[FuelDriven]]] und [[[ElectricallyDriven]]] zugleich implementieren"))
        .addChildCriteria(H3_3_T1, H3_3_T2, H3_3_T3, H3_3_T4, H3_3_T5, H3_3_T6)
        .build();

    public static final Criterion H3_4_T1 = makeSimpleCriterion(
        "Die Klasse [[[HybridObject3]]] ist korrekt deklariert und implementiert [[[HybridVehicle]]]",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_4.class.getMethod("test_HybridType3_class")));

    public static final Criterion H3_4_T2 = makeSimpleCriterion(
        "Die Attribute, sowie Getter und Setter und alle weiteren zu implementierenden Methoden "
            + "(bis auf [[[getPreferredDriveType]]]) sind erkennbar korrekt umgesetzt.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_4.class.getMethod("test_HybridType3_attributes_get_set")));

    public static final Criterion H3_4_T3 = makeSimpleCriterion(
        "Die Methode [[[getPreferredDriveType]]] ist in [[[HybridType3]]] korrekt unter Nutzung des Bedingungsoperators realisiert.",
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_4.class.getMethod("test_HybridType3_getPreferredDriveType")),
        JUnitTestRef.ofMethod(() -> TutorTests_H_3_4.class.getMethod("test_HybridType3_getPreferredDriveType_ternary")));

    public static final Criterion H3_4 = Criterion.builder()
        .shortDescription(CODE_TAGIFY.apply("H3.4 | [[[HybridVehicle]]] implementieren"))
        .addChildCriteria(H3_4_T1, H3_4_T2, H3_4_T3)
        .build();

    public static final Criterion H3 = Criterion.builder()
        .shortDescription("H3 | Abgeleitete / Implementierende Klassen")
        .addChildCriteria(H3_1, H3_2, H3_3, H3_4)
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
