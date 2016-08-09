package person;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    public Person() {};

    public Person(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Integer id;
    public String firstName;
    public String lastName;
}
