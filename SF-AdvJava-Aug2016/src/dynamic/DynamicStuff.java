package dynamic;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DynamicStuff {

    public static void main(String[] args) throws Throwable {
//        System.setSecurityManager(new SecurityManager());
//        FileOutputStream fos = new FileOutputStream("test");
//        String config = "newpackage.NewClass";
        String config = "dynamic.RunStuffHere";
        Class cl = Class.forName(config);
        System.out.println("Found class with name: " + cl.getName());
        Object target = cl.newInstance();

        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            SetThis annot = f.getAnnotation(SetThis.class);
            if (annot != null) {
                f.setAccessible(true);
                f.set(target, annot.value());
            }
        }

        Method[] methods = cl.getMethods();
        for (Method m : methods) {
            System.out.println("Method found: " + m);
            RunThis annot = m.getAnnotation(RunThis.class);
            if (annot != null) {
                System.out.println("ANNOTATION FOUND!");
                Object o = m.invoke(target);
                if (o != null) {
                    System.out.println("invocation returned " + o);
                }
            }
        }
    }
}
