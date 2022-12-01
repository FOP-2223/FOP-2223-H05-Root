package h05.transform;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.List;
import java.util.function.Function;

import static org.objectweb.asm.Opcodes.*;

public class H3_4_Transformers {

    private static final List<String> ALLOWED_METHODS = List.of(
        "org/sourcegrade/jagr/core/executor/TimeoutHandler#checkTimeout()V",
        "java/lang/String#<init>([C)V",
        "java/lang/String#valueOf([C)Ljava/lang/String;",
        "java/lang/String#charAt(I)C",
        "java/lang/String#length()I",
        "java/lang/String#toCharArray()[C",
        "java/lang/Enum#toString()Ljava/lang/String;",
        "java/lang/Enum#name()Ljava/lang/String;",
        "java/lang/Object#toString()Ljava/lang/String;"
    );
    public static String illegalInstruction = null;
    public static final Function<ClassWriter, ClassVisitor> TRANSFORMER = writer -> new ClassVisitor(ASM9, writer) {
        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            if (name.equals("toString") && descriptor.equals("()Ljava/lang/String;")) {
                return new MethodVisitor(ASM9, super.visitMethod(access, name, descriptor, signature, exceptions)) {
                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
                        String instruction = "%s#%s%s".formatted(owner, name, descriptor);
                        if (!owner.startsWith("h05") && !ALLOWED_METHODS.contains(instruction)) {
                            illegalInstruction = illegalInstruction == null ? instruction : illegalInstruction;
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
