package h05.transform;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.function.Function;

import static org.objectweb.asm.Opcodes.*;

public class H3_2_Transformers {

    public static boolean STANDARD_VOLTAGE_ILLEGAL_INSN = false;
    public static boolean HIGH_VOLTAGE_ILLEGAL_INSN = false;
    public static final Function<ClassWriter, ClassVisitor> CHARGEABLE_TRANSFORMER = writer -> new ClassVisitor(ASM9, writer) {
        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            final String methodName = name;
            if (name.matches("(standard|high)VoltageChargeable") && descriptor.equals("()V")) {
                return new MethodVisitor(ASM9, super.visitMethod(access, name, descriptor, signature, exceptions)) {
                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
                        if (methodName.equals("standardVoltageChargeable")) {
                            STANDARD_VOLTAGE_ILLEGAL_INSN = true;
                        } else if (methodName.equals("highVoltageChargeable")) {
                            HIGH_VOLTAGE_ILLEGAL_INSN = true;
                        }
                        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
                    }
                };
            } else {
                return super.visitMethod(access, name, descriptor, signature, exceptions);
            }
        }
    };

    public static boolean LET_ME_MOVE_INVOKED = false;
    public static final Function<ClassWriter, ClassVisitor> LET_ME_MOVE_TRANSFORMER = writer -> new ClassVisitor(ASM9, writer) {
        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            if (name.equals("letsGo") && descriptor.equals("(BI)V")) {
                return new MethodVisitor(ASM9, super.visitMethod(access, name, descriptor, signature, exceptions)) {
                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
                        if (owner.equals("h05/ElectricBoat") && name.equals("letMeMove") && descriptor.equals("(I)I")) {
                            LET_ME_MOVE_INVOKED = true;
                        }
                        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
                    }
                };
            } else {
                return super.visitMethod(access, name, descriptor, signature, exceptions);
            }
        }
    };

    public static boolean SET_SPECIFIC_TYPE_INVOKED = false;
    public static final Function<ClassWriter, ClassVisitor> SET_SPECIFIC_TYPE_TRANSFORMER = writer -> new ClassVisitor(ASM9, writer) {
        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            if (name.equals("<init>") && descriptor.equals("(BII)V")) {
                return new MethodVisitor(ASM9, super.visitMethod(access, name, descriptor, signature, exceptions)) {
                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
                        if (owner.equals("h05/ElectricBoat") && name.equals("setSpecificType") && descriptor.equals("(B)B")) {
                            SET_SPECIFIC_TYPE_INVOKED = true;
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
