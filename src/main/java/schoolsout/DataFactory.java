package schoolsout;

import schoolsout.models.Course;
import schoolsout.models.Gender;
import schoolsout.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DataFactory {

    public static List<Course> getCourses() {

        Course course0 = new Course("Java EE", " Java EE offers a rich enterprise software platform and with over 20 compliant Java EE implementations to choose from.", "01", "https://blogs.sap.com/wp-content/uploads/2017/07/JavaEE.png", true, null);
        Course course1 = new Course("Boxing", " Boxing is a combat sport in which two people, usually wearing protective gloves and other protective equipment such as hand wraps and mouthguards, throw punches at each other for a predetermined amount of time in a boxing ring.", "02", "https://upload.wikimedia.org/wikipedia/commons/2/2a/Boxing_Tournament_in_Aid_of_King_George%27s_Fund_For_Sailors_at_the_Royal_Naval_Air_Station%2C_Henstridge%2C_Somerset%2C_July_1945_A29806.jpg", true, null);
        Course course2 = new Course("Wrestling", "Wrestling is a combat sport involving grappling-type techniques such as clinch fighting, throws and takedowns, joint locks, pins and other grappling holds. ", "03", "https://upload.wikimedia.org/wikipedia/commons/8/84/Wrestling_at_the_2016_Summer_Olympics%2C_Gazyumov_vs_Andriitsev_6.jpg", true, null);
        Course course3 = new Course("UFC", "Ultimate Fighting Championship (UFC) is de grootste mixed-martial-artsorganisatie ter wereld.", "04", "https://upload.wikimedia.org/wikipedia/commons/a/aa/UFC_74_Respect_Bout.jpg", true, null);
        Course course4 = new Course("Judo", "Judo (Japans: 柔道, じゅうどう, jūdō[1]) is een van oorsprong Japanse zelfverdedigingskunst, die rond 1882 werd ontworpen door Jigoro Kano.", "05", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Jigoro_Kano_and_Kyuzo_Mifune.jpg/260px-Jigoro_Kano_and_Kyuzo_Mifune.jpg", true, null);
        Course course5 = new Course("Krav Maga", "Krav maga (Hebreeuws: קרב מגע, contactgevecht) is een verdedigingskunst die zijn oorsprong heeft in Tsjecho-Slowakije en Israël. ", "06", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Krav_Maga_Marines.jpg/1280px-Krav_Maga_Marines.jpg", true, null);
        Course course6 = new Course("Thai Box", "Thai boxing (or Muay Thai) is a combat sport (martial art) that has been developed in Thailand. It is known also as \"the art of eight limbs\", because both hands, elbows, knees, and legs can be used to attack an opponent.", "07", "https://blogs.sap.com/wp-content/uploads/2017/07/JavaEE.png", true, null);
        Course course7 = new Course("Kick Box", "Kickboxing is a group of stand-up combat sports based on kicking and punching, historically developed from karate mixed with boxing.", "08", "https://blogs.sap.com/wp-content/uploads/2017/07/JavaEE.png", true, null);

        return new ArrayList<>(List.of(course0, course1, course2, course3, course4, course5, course6, course7));
    }

    public static List<Person> getStudents(List<Course> courses) {
        List<Person> people = new ArrayList<>();
        for (String person : peeps) {
            String[] arr = person.split("_");

            Course course = courses.get(ThreadLocalRandom.current().nextInt(0, courses.size()));
            List<Course> history = new ArrayList<>();

            for(Course c : courses){
                if(!c.equals(course)) history.add(c);
            }

            people.add(
                    new Person()
                    .setFirstName(arr[0])
                    .setFamilyName(arr[1])
                    .setGender(Gender.valueOf(arr[2]))
                    .setCourseActive(course)
                    .setCourseHistory(history)
            );
        }

        return people;
    }

    static String[] peeps = new String[]{
            "Morty_Rick_MALE",
            "Lord_Kek_OTHER",
            "Nani_Poonani_MALE",
            "Tupac_Shakur_MALE",
            "Biggie_Smalls_MALE",
            "Scarlet_Johansson_FEMALE",
            "I_AM_GROOT_OTHER",
            "Spongebob_Squarespace_OTHER",
            "Nero_GoodBoi_MALE",
            "Tosca_GoodGirl_FEMALE",
            "Saul_Goodman_MALE"
    };

}
