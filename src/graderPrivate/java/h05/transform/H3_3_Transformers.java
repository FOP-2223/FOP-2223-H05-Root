package h05.transform;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.objectweb.asm.Opcodes.*;

public class H3_3_Transformers {

    public static final Map<String, Boolean> MAP = new HashMap<>(Map.of(
        "standardVoltageChargeable()Z", false,
        "highVoltageChargeable()Z", false,
        "letsGo(BI)V", false,
        "getFuelType()Lh05/FuelType;", false,
        "getAverageConsumption(D)D", false
    ));
    public static final Function<ClassWriter, ClassVisitor> TRANSFORMER = writer -> new ClassVisitor(ASM9, writer) {
        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            String methodSignature = name + descriptor;
            if (MAP.containsKey(methodSignature)) {
                return new MethodVisitor(ASM9, super.visitMethod(access, name, descriptor, signature, exceptions)) {
                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
                        if (owner.equals("h05/HybridType1") && (name + descriptor).equals(methodSignature)) {
                            MAP.put(methodSignature, true);
                        }
                        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
                    }
                };
            } else {
                return super.visitMethod(access, name, descriptor, signature, exceptions);
            }
        }
    };
}
