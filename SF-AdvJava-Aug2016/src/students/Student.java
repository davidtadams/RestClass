package students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

@FunctionalInterface
interface StudentCriterion extends Criterion<Student> {
    //   boolean broken();

    boolean test(Student s);
}

public final class Student implements Comparable<Student> {

    private String name;
    private float gpa;
    private Set<String> courses;
//
//    public Student(String name, float gpa, String ... courses) {
//        if (name == null) throw new IllegalArgumentException("must have a name");
//        if (gpa < 0 || gpa > 4.0F) throw new IllegalArgumentException("invalid gpa");
//        this.name = name;
//        this.gpa = gpa;
//        this.courses = new HashSet<String>();
//        this.courses.addAll(Arrays.asList(courses));
//    }
//    

    private Student() {
    }

    public static Student getFromNameGpaCourses(String name, float gpa, String... courses) {
        if (name == null) {
            throw new IllegalArgumentException("must have a name");
        }
        if (gpa < 0 || gpa > 4.0F) {
            throw new IllegalArgumentException("invalid gpa");
        }
//        if (courses.length == 0) throw new IllegalArgumentException("Must take courses");
        Student self = new Student();
        self.name = name;
        self.gpa = gpa;
        self.courses = new HashSet<String>();
        self.courses.addAll(Arrays.asList(courses));
        return self;
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }

    public Set<String> getCourses() {
        return courses;
    }

    @Override
    final public boolean equals(Object other) {
        if (!(other instanceof Student)) {
            return false;
        }
        Student s2 = (Student) other;
//        String s = other.name;
        return this.name.equals(s2.name);
    }

    @Override
    final public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + ", courses=" + courses + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    private static final Comparator<Student> enthusiasmComparator
            = (o1, o2) -> o1.courses.size() - o2.courses.size();

    public static Comparator<Student> getEnthusiasmComparator() {
        return enthusiasmComparator;
    }
//    private static final Comparator<Student> gpaComparator = new
//             /*private static final class StudentGPAComparator implements*/ Comparator<Student>() {
//
//        @Override
//        public int compare(Student o1, Student o2) {
//            System.out.println("in anonymous comparator");
//            return new Float(o1.gpa).compareTo(o2.gpa);
//        }
//    };

    private static final Comparator<Student> gpaComparator
            = (o1, o2) -> Float.compare(o1.gpa, o2.gpa);

//    private static final Comparator<Student> gpaComparator = (Student o1, Student o2) -> /*{*/
//        /*return */new Float(o1.gpa).compareTo(o2.gpa)/*;*/
//    /*}*/;
//    private static final Comparator<Student> gpaComparator = /* new Comparator<Student>() {*/
//
//        /*@Override
//        public int compare*/(Student o1, Student o2) -> {
//            System.out.println("in lambda version 1 comparator");
//            return new Float(o1.gpa).compareTo(o2.gpa);
//        }
//    /*}*/;
    public static Comparator<Student> getGpaComparator() {
        return gpaComparator;
    }

//    private static final class StudentGPAComparator implements Comparator<Student> {
//
//        @Override
//        public int compare(Student o1, Student o2) {
//            System.out.println("in inner comparator");
//            return new Float(o1.gpa).compareTo(o2.gpa);
//        }
//    }
    public static StudentCriterion getSmartnessCriterion(float threshold) {
//         threshold++;
//        return new StudentCriterion() {
//            public boolean test(Student s) {
//                return s.getGpa() > threshold;
//            }
//        };
        return s->s.getGpa() > threshold;
    }

}
