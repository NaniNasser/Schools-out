package schoolsout;

import schoolsout.models.*;
import schoolsout.models.Module;

import java.math.BigDecimal;
import java.time.LocalDate;
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

            for (Course c : courses) {
                if (!c.equals(course)) history.add(c);
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

    public static List<Module> getModules(Course course) {
        List<Module> modules = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Module m = new Module()
                    .setCourse(course)
                    .setName(course.getName() + " - Hoofdstuk " + (i + 1))
                    .setDescription(descriptions[ThreadLocalRandom.current().nextInt(0, descriptions.length)]);

            m.setExams(getExams(m));

            modules.add(m);
        }


        return modules;
    }

    private static List<Exam> getExams(Module module) {
        List<Exam> exams = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            Exam exam = new Exam()
                    .setName(module.getName() + " - Exam " + (i + 1))
                    .setDescription(descriptions[random.nextInt(0, descriptions.length)])
                    .setModule(module)
                    .setTotal(random.nextInt(1, 11) * 10)
                    .setWeight(random.nextInt(5) + 1)
                    .setDate(LocalDate.now().minusDays(random.nextInt(1, 77)));
            exam.setSubExams(getSubExams(exam));
            exams.add(exam);
        }


        return exams;
    }

    private static List<Exam> getSubExams(Exam examGroup) {
        List<Exam> subExams = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            Exam subExam = new Exam()

                    .setDescription(descriptions[random.nextInt(0, descriptions.length)])
                    .setExamGroup(examGroup)
                    .setTotal(random.nextInt(1, 7) * 10)
                    .setWeight(random.nextInt(7) + 1)
                    .setDate(LocalDate.now().minusDays(random.nextInt(1, 5)))
                    .setName(examGroup.getName() + " - SubExam " + (i + 1));
            subExams.add(subExam);

        }
        return subExams;
    }


    public static List<User> getUsers(List<Person> people) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            User user = getUser(person);
            users.add(user);
        }

        return users;
    }

    static User getUser(Person person) {
        StringBuilder sb = new StringBuilder((person.getFirstName()));
        return new User()
                .setLogin(person.getFirstName() + "." + person.getFamilyName())
                .setActive(Math.random() > 0.5)
                .setPasswordHash(sb.reverse().toString())
                .setPerson(person);
    }

    public static List<Grade> gradePerson(Person person) {
        List<Grade> grades = new ArrayList<>();

        if(person == null) return grades;

        Course course = person.getCourseActive();
        if (course != null) {
            List<Module> modules = course.getModules();
            for (int i = 0; i < modules.size(); i++) {
                Module module = modules.get(i);
                List<Exam> exams = module.getExams();
                for (int j = 0; j < exams.size(); j++) {
                    Exam exam = exams.get(j);
                    grades.addAll(getGrades(person, exam));
                }
            }

        }
        return grades;
    }

    public static List<Grade> getGrades(Person person, Exam exam) {
        List<Grade> grades = new ArrayList<>();
        List<Exam> subExams = exam.getSubExams();

        if (subExams != null && subExams.size() > 0) {
            for (int i = 0; i < subExams.size(); i++) {
                grades.addAll(getGrades(person, subExams.get(i)));
            }
        } else {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            Grade grade = new Grade()
                    .setPerson(person)
                    .setExam(exam)
                    .setDate(exam.getDate())
                    .setGradeValue(BigDecimal.valueOf(random.nextDouble(0.3 , 0.7) * exam.getTotal()));
            grades.add(grade);

        }

        return grades;
    }



    static String[] peeps = new String[]{
            "Morty_Rick_MALE",
            "Lord_Kek_OTHER",
            "Nani_Poonani_MALE",
            "Tupac_Shakur_MALE",
            "Biggie_Smalls_MALE",
            "Scarlet_Johansson_FEMALE",
            "I_AM GROOT_OTHER",
            "Spongebob_Squarespace_OTHER",
            "Nero_GoodBoi_MALE",
            "Tosca_GoodGirl_FEMALE",
            "Saul_Goodman_MALE"
    };

    private static String[] descriptions = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Enim sed faucibus turpis in. Venenatis tellus in metus vulputate eu scelerisque felis imperdiet. Odio ut sem nulla pharetra diam sit amet nisl. Magna fringilla urna porttitor rhoncus dolor purus. Id neque aliquam vestibulum morbi. Non nisi est sit amet facilisis magna etiam. Dolor sit amet consectetur adipiscing elit duis. Nisl nunc mi ipsum faucibus vitae aliquet nec ullamcorper. Purus faucibus ornare suspendisse sed. Ornare massa eget egestas purus. Euismod quis viverra nibh cras pulvinar mattis. Consectetur adipiscing elit duis tristique sollicitudin nibh sit amet commodo. Nisi lacus sed viverra tellus in hac habitasse platea. Amet porttitor eget dolor morbi. Etiam erat velit scelerisque in dictum. Ultrices tincidunt arcu non sodales. Tortor at auctor urna nunc id cursus.",
            "Curabitur gravida arcu ac tortor dignissim convallis. Mi in nulla posuere sollicitudin. Tortor condimentum lacinia quis vel eros donec ac odio. Feugiat nibh sed pulvinar proin gravida hendrerit. Ipsum dolor sit amet consectetur. Orci nulla pellentesque dignissim enim sit. Ac turpis egestas sed tempus urna et. Sit amet mauris commodo quis imperdiet massa tincidunt nunc pulvinar. Commodo ullamcorper a lacus vestibulum sed arcu non odio euismod. Interdum velit laoreet id donec. Adipiscing enim eu turpis egestas pretium. Duis at tellus at urna condimentum mattis. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit. Pharetra vel turpis nunc eget lorem dolor sed.",
            "Egestas congue quisque egestas diam in. Porttitor rhoncus dolor purus non enim praesent. A cras semper auctor neque vitae tempus quam pellentesque. Consectetur lorem donec massa sapien faucibus et molestie ac feugiat. Libero volutpat sed cras ornare arcu dui vivamus arcu. Nullam non nisi est sit amet facilisis magna. Odio ut sem nulla pharetra diam sit. Pretium lectus quam id leo in vitae turpis. Est ullamcorper eget nulla facilisi etiam dignissim diam. Eget magna fermentum iaculis eu non diam phasellus vestibulum lorem.",
            "Eget gravida cum sociis natoque penatibus et. Morbi non arcu risus quis varius quam quisque id. A cras semper auctor neque vitae tempus. Vitae elementum curabitur vitae nunc. Tempor orci dapibus ultrices in iaculis. Scelerisque mauris pellentesque pulvinar pellentesque. Varius duis at consectetur lorem donec massa sapien faucibus. Bibendum ut tristique et egestas quis ipsum. Sed elementum tempus egestas sed sed risus pretium. Nunc mattis enim ut tellus elementum sagittis vitae. Non pulvinar neque laoreet suspendisse interdum consectetur libero. Lacus suspendisse faucibus interdum posuere lorem ipsum dolor sit. Amet luctus venenatis lectus magna fringilla urna porttitor rhoncus. Enim tortor at auctor urna nunc id cursus metus aliquam. Eget gravida cum sociis natoque penatibus et. Mauris ultrices eros in cursus turpis massa.",
            "Euismod nisi porta lorem mollis aliquam ut porttitor. Facilisis leo vel fringilla est. Ultrices gravida dictum fusce ut placerat orci nulla pellentesque. Eu nisl nunc mi ipsum faucibus vitae aliquet. Risus sed vulputate odio ut enim. Imperdiet sed euismod nisi porta lorem mollis aliquam ut. Aliquam faucibus purus in massa tempor. Suspendisse potenti nullam ac tortor vitae purus faucibus ornare suspendisse. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. Sit amet venenatis urna cursus. Praesent semper feugiat nibh sed pulvinar. Non pulvinar neque laoreet suspendisse interdum consectetur libero id. Dignissim sodales ut eu sem integer vitae justo eget. Dui sapien eget mi proin sed libero. Posuere lorem ipsum dolor sit amet consectetur. In cursus turpis massa tincidunt dui ut ornare lectus. Sit amet purus gravida quis blandit. Et malesuada fames ac turpis."
    };

}
