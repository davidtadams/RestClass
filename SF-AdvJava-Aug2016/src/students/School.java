package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SmartnessCriterion implements StudentCriterion {

    private float threshold;

    public SmartnessCriterion(float threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(Student s) {
        return s.getGpa() > threshold;
    }

}

@FunctionalInterface
interface Criterion<E> {
    boolean test(E s);
}
public class School {

    public static <E> List<E> getByCriterion(Collection<E> input,
            Criterion<E> criterion) {
        List<E> output = new ArrayList<>();
        for (E s : input) {
            if (criterion.test(s)) {
                output.add(s);
            }
        }
        return output;
    }

    public static List<Student> getStudentsByCriterion(Collection<Student> input,
            StudentCriterion criterion) {
        List<Student> output = new ArrayList<>();
        for (Student s : input) {
            if (criterion.test(s)) {
                output.add(s);
            }
        }
        return output;
    }

    public static List<Student> getEnthusiasticStudents(Collection<Student> input, int threshold) {
        List<Student> output = new ArrayList<>();
        for (Student s : input) {
            if (s.getCourses().size() > threshold) {
                output.add(s);
            }
        }
        return output;
    }

    public static List<Student> getSmartStudents(Collection<Student> input, float threshold) {
        List<Student> output = new ArrayList<>();
        for (Student s : input) {
            if (s.getGpa() > threshold) {
                output.add(s);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Set<Student> roster = new HashSet<>();
        Set<Student> safeToPassAround = Collections.unmodifiableSet(roster);

        roster.addAll(Arrays.asList(
                Student.getFromNameGpaCourses("Fred", 3.2F, "Math", "Physics"),
                Student.getFromNameGpaCourses("Jim", 2.9F, "Art", "Journalism"),
                Student.getFromNameGpaCourses("Sheila", 4.0F, "Math", "Physics", "Astronomy"),
                Student.getFromNameGpaCourses("Alan", 4.0F)
        ));

        System.out.println("All school " + roster);

        List<Student> list = new ArrayList<>();
        list.addAll(roster);

        System.out.println("Fred is a student? "
                + roster.contains(Student.getFromNameGpaCourses("Fred", 3.2F, "Math", "Physics"))
        );

        System.out.println("Fred is in list? "
                + list.contains(Student.getFromNameGpaCourses("Fred", 3.2F, "Math", "Physics"))
        );

//        System.out.println("Unsorted: " + list);        
//        Collections.sort(list);
        list.sort(null);
//        System.out.println("Sorted: " + list);   
//        
////        list.sort(new Student.StudentGPAComparator());
//        list.sort(Student.getGpaComparator());
//        System.out.println("Sorted by gpa: " + list);   
//        
//        System.out.println("-----------------------------");
//        System.out.println("Smart students: " + getSmartStudents(safeToPassAround, 3.0F));
//
//        System.out.println("-----------------------------");
//        System.out.println("Enthusiastic students: " + getEnthusiasticStudents(safeToPassAround, 2));

//        System.out.println("-----------------------------");
//        System.out.println("Smarter students: " + getStudentsByCriterion(safeToPassAround,
//                new SmartnessCriterion(3.2F)));
//        System.out.println("-----------------------------");
//        System.out.println("Smarter students: " + getStudentsByCriterion(safeToPassAround,
//                s -> {
//                    return s.getGpa() > 3.2F;
//                }));
//        System.out.println("-----------------------------");
//        float t = 3.2F;
//        System.out.println("Smarter students: " + getStudentsByCriterion(safeToPassAround,
//                Student.getSmartnessCriterion(t)));


        System.out.println("-----------------------------");
        System.out.println("Smarter students: " + getByCriterion(safeToPassAround,
                Student.getSmartnessCriterion(3.2F)));

    }
}
