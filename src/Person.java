public class Person {

    @MyFirstAnnotation(value = "hello")
    private String name;

    @MySecondAnnotation(value = "what's up")
    private String surname;
    @MyFirstAnnotation(value = "hello")
    private String city;

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public void die() {
        System.out.println("Died");
    }
}
