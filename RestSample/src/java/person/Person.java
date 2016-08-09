package person;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    public Person() {};
    
    public Integer id;
    public String firstName;
    public String lastName;
}
