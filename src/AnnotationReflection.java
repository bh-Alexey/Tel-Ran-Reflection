import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AnnotationReflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Person person = new Person();
        Class<? extends Person> personClass = person.getClass();

        Constructor<?>[] constructors = personClass.getConstructors();
        Constructor<?> constructor = constructors[0];

        Object object = constructor.newInstance();
        Person generatedPerson = (Person) object;

        System.out.println("--------------------------");
        System.out.println(generatedPerson);
        System.out.println("--------------------------");

        Field[] fields = personClass.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(MyFirstAnnotation.class)) {
                    if (field.getName().equals("city")) {
                        field.setAccessible(true);
                        field.set(person, "New York");
                    }
                    else {
                        field.setAccessible(true);
                        field.set(person, "John");
                    }

                }
                if (annotation.annotationType().equals(MySecondAnnotation.class)) {
                    field.setAccessible(true);
                    field.set(person, "Wick");
                }
            }
        }

        System.out.println(person.getName());
        System.out.println(person.getSurname());
        System.out.println(person.getCity());
    }
}
