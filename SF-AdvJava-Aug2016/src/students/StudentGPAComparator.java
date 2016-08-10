package students;

import java.util.Comparator;

public final class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        System.out.println("in standalone comparator");
        return new Float(o1.getGpa()).compareTo(o2.getGpa());
    }
}
