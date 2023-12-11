import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@MyFirstAnnotation(value = "hello")
@MySecondAnnotation(value = "what's up")
public class Main {

    @MyFirstAnnotation(value = "main")
    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<Person> cl = Person.class;

        Method[] methods = cl.getDeclaredMethods();
        Field firstField = cl.getDeclaredField("name");
        Field secondField = cl.getDeclaredField("surname");

        System.out.println(Arrays.toString(methods));

        System.out.println(firstField);
        System.out.println(firstField.getName());
        System.out.println(firstField.getType());
        System.out.println();

        System.out.println(secondField);
        System.out.println(secondField.getName());
        System.out.println(secondField.getType());
        System.out.println();


        Person john = new Person();
        System.out.println(john.getName());
        System.out.println();

        firstField.setAccessible(true);
        firstField.set(john, "John");

        secondField.setAccessible(true);
        secondField.set(john, "Wick");

        System.out.println(john.getName());
        System.out.println(john.getSurname());
        System.out.println();

        for (Method method : methods) {
            System.out.println(method);
            method.invoke(john);
        }

        Method die = cl.getDeclaredMethod("die");

        die.invoke(john);
    }
}