package schoolsout;

import schoolsout.daos.*;
import schoolsout.models.*;
import schoolsout.models.Module;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");

        Person person = new Person();
        CourseDAO courseDAO = new CourseDAO(emf);
        ModuleDAO moduleDAO = new ModuleDAO(emf);
        ExamDAO examDAO = new ExamDAO(emf);
        PersonDAO personDAO = new PersonDAO(emf);
        UserDAO userDAO = new UserDAO(emf);


        Person person0 = new Person("Morty", "Rick", Gender.MALE, person.getCourse());
        Person person1 = new Person("Lord", "Kek", Gender.OTHER, person.getCourse());
        Person person2 = new Person("Nani", "Poonani", Gender.MALE, person.getCourse());
        Person person3 = new Person("Tupac", "Shakur", Gender.MALE, person.getCourse());
        Person person4 = new Person("Biggie", "Smalls", Gender.MALE, person.getCourse());
        Person person5 = new Person("Scarlet", "Johansson", Gender.FEMALE, person.getCourse());
        Person person6 = new Person("I AM ", "GROOT", Gender.OTHER, person.getCourse());
        Person person7 = new Person("Spongebob ", "Squarespace", Gender.OTHER, person.getCourse());
        Person person8 = new Person("Nero", "GoodBoi", Gender.MALE, person.getCourse());
        Person person9 = new Person("Tosca", "GoodGirl", Gender.FEMALE, person.getCourse());
        Person person10 = new Person("Saul", "Goodman", Gender.MALE, person.getCourse());

        personDAO.save(person0);
        personDAO.save(person1);
        personDAO.save(person2);
        personDAO.save(person3);
        personDAO.save(person4);
        personDAO.save(person5);
        personDAO.save(person6);
        personDAO.save(person7);
        personDAO.save(person8);
        personDAO.save(person9);
        personDAO.save(person10);



        Course course0 = new Course("Java EE"," Java EE offers a rich enterprise software platform and with over 20 compliant Java EE implementations to choose from.","01","https://blogs.sap.com/wp-content/uploads/2017/07/JavaEE.png",true,null,List<Course>.setCourseHistory(Course.class););
        Course course1 = new Course("Boxing"," Boxing is a combat sport in which two people, usually wearing protective gloves and other protective equipment such as hand wraps and mouthguards, throw punches at each other for a predetermined amount of time in a boxing ring.","02","https://upload.wikimedia.org/wikipedia/commons/2/2a/Boxing_Tournament_in_Aid_of_King_George%27s_Fund_For_Sailors_at_the_Royal_Naval_Air_Station%2C_Henstridge%2C_Somerset%2C_July_1945_A29806.jpg",true,null);
        Course course2 = new Course("Wrestling","Wrestling is a combat sport involving grappling-type techniques such as clinch fighting, throws and takedowns, joint locks, pins and other grappling holds. ","03","https://upload.wikimedia.org/wikipedia/commons/8/84/Wrestling_at_the_2016_Summer_Olympics%2C_Gazyumov_vs_Andriitsev_6.jpg",true,null);
        Course course3 = new Course("UFC","Ultimate Fighting Championship (UFC) is de grootste mixed-martial-artsorganisatie ter wereld.","04","https://upload.wikimedia.org/wikipedia/commons/a/aa/UFC_74_Respect_Bout.jpg",true,null);
        Course course4 = new Course("Judo","Judo (Japans: 柔道, じゅうどう, jūdō[1]) is een van oorsprong Japanse zelfverdedigingskunst, die rond 1882 werd ontworpen door Jigoro Kano.","05","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Jigoro_Kano_and_Kyuzo_Mifune.jpg/260px-Jigoro_Kano_and_Kyuzo_Mifune.jpg",true,null);
        Course course5 = new Course("Krav Maga","Krav maga (Hebreeuws: קרב מגע, contactgevecht) is een verdedigingskunst die zijn oorsprong heeft in Tsjecho-Slowakije en Israël. ","06","https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Krav_Maga_Marines.jpg/1280px-Krav_Maga_Marines.jpg",true,null);
        Course course6 = new Course("Thai Box","Thai boxing (or Muay Thai) is a combat sport (martial art) that has been developed in Thailand. It is known also as \"the art of eight limbs\", because both hands, elbows, knees, and legs can be used to attack an opponent.","07","https://blogs.sap.com/wp-content/uploads/2017/07/JavaEE.png",true,null);
        Course course7 = new Course("Kick Box","Kickboxing is a group of stand-up combat sports based on kicking and punching, historically developed from karate mixed with boxing.","08","https://blogs.sap.com/wp-content/uploads/2017/07/JavaEE.png",true,null);

        courseDAO.save(course0);
        courseDAO.save(course1);
        courseDAO.save(course2);
        courseDAO.save(course3);
        courseDAO.save(course4);
        courseDAO.save(course5);
        courseDAO.save(course6);
        courseDAO.save(course7);
        System.out.println("saving courses");

        List<Course> courseFromDB = courseDAO.findAll();
//        courseFromDB.forEach(System.out::println);
        System.out.println("fetching courses");


        Course courseFromDB1 = courseFromDB.get(1);
        Course courseFromDB5 = courseFromDB.get(5);
        Course courseFromDB0 = courseFromDB.get(0);
        Course courseFromDB2 = courseFromDB.get(2);
        Course courseFromDB3 = courseFromDB.get(3);
        Course courseFromDB4 = courseFromDB.get(4);
        Course courseFromDB6 = courseFromDB.get(6);


        Module module0 = new Module("Hoofdstuk 1","Welcome to the world of Java programming! ", courseFromDB0, null);
        Module module1 = new Module("Hoofdstuk 2","Programming languages enable humans to write instructions that a computer can perform.", courseFromDB5,null);
        Module module2 = new Module("Hoofdstuk 3","With precise instructions, computers coordinate applications and systems that run the modern world.", courseFromDB0,null );
        Module module3 = new Module("Hoofdstuk 4","Having some fun, stimulating your mind, gaining an edge at work, or even starting a career in software engineering", courseFromDB2,null );
        Module module4 = new Module("Hoofdstuk 5","Just like knowing your why is the first step of any journey, defining your one big goal is the first step towards achieving it.", courseFromDB3,null );
        Module module5 = new Module("Hoofdstuk 6","Once you’ve defined your goal, you need to visualize it. Take a deep breath and imagine yourself working towards that goal. ", courseFromDB4,null);
        Module module6 = new Module("Hoofdstuk 7","Imagine what it feels like. See what the end looks like. Visualization might seem silly at first, but research has shown that you can improve any skill just by visualizing yourself practicing it. ", courseFromDB5,null );
        Module module7 = new Module("Hoofdstuk 8","Your coding journey doesn’t differ from that of any other beginner. You need a clear plan if you want to reach the destination.", courseFromDB6,null );

        System.out.println("smartsaving modules");

        System.out.println(module0);
        module0 = moduleDAO.smartSave(module0);
        System.out.println(module0);
        module1 = moduleDAO.smartSave(module1);
        module2 = moduleDAO.smartSave(module2);
        module3 = moduleDAO.smartSave(module3);
        module4 = moduleDAO.smartSave(module4);
        module5 = moduleDAO.smartSave(module5);
        module6 = moduleDAO.smartSave(module6);
        module7 = moduleDAO.smartSave(module7);

        Exam exam0 = new Exam("Fundamentals Exam","you noobs are going down", LocalDate.of(2022,8,07),77,100,module0);
        Exam exam1 = new Exam("Boxing Exam","2 Sparring rounds boxing 40%", LocalDate.of(2022,8,07),77,100,module1);
        Exam exam2 = new Exam("Wrestling Exam","2 Sparring Rounds wrestling 50%", LocalDate.of(2022,8,07),77,100,module2);
        Exam exam3 = new Exam("UFC Exam","4 Sparring rounds UFC 30%", LocalDate.of(2022,8,07),77,100,module3);
        Exam exam4 = new Exam("Judo Exam","3 Throws, 4 Defense counter-attacks 70%", LocalDate.of(2022,8,07),77,100,module4);
        Exam exam5 = new Exam("Krav Maga Exam","3 Techniques 100%, 4 Counter-Attacks 30%", LocalDate.of(2022,8,07),77,100,module5);
        Exam exam6 = new Exam("Thai Box Exam","4 High Kicks 80%, 2 Sparring rounds 50%", LocalDate.of(2022,8,07),77,100,module6);
        Exam exam7 = new Exam("Kick Box Exam","3 High Kicks 80%, 2 Elbows 100%, 2 Throws 50%, 1 Sparring round 70%", LocalDate.of(2022,8,07),77,100,module7);

        List<Exam> exams = List.of(exam0,exam1,exam3,exam4,exam5,exam6,exam7);
        module0.setExams(exams.subList(1,6));
        module1.setExams(exams.subList(1,3));
        module2.setExams(exams.subList(3,5));
        module3.setExams(exams.subList(1,5));
        module4.setExams(exams.subList(1,4));
        module5.setExams(exams.subList(4,5));
        module6.setExams(exams.subList(1,6));
        module7.setExams(exams.subList(2,4));

        moduleDAO.update(module0);
        moduleDAO.update(module1);
        moduleDAO.update(module2);
        moduleDAO.update(module3);
        moduleDAO.update(module4);
        moduleDAO.update(module5);
        moduleDAO.update(module6);
        moduleDAO.update(module7);

        List<Module> moduleFromDB = moduleDAO.findAll();

        module0 = moduleFromDB.get(0);
        module1 = moduleFromDB.get(1);
        module2 = moduleFromDB.get(2);
        module3 = moduleFromDB.get(3);
        module4 = moduleFromDB.get(4);
        module5 = moduleFromDB.get(5);
        module6 = moduleFromDB.get(6);
        module7 = moduleFromDB.get(7);


        courseFromDB0.setModules(List.of(module2));
        courseFromDB2.setModules(List.of(module3));
        courseFromDB5.setModules(List.of(module1,module6));
        courseFromDB4.setModules(List.of(module5));
        courseFromDB1.setModules(List.of(module0));
        courseFromDB6.setModules(List.of(module7));

        System.out.println("updating courses");

        courseDAO.update(courseFromDB0);
        courseDAO.update(courseFromDB1);
        courseDAO.update(courseFromDB2);
        courseDAO.update(courseFromDB4);
        courseDAO.update(courseFromDB5);
        courseDAO.update(courseFromDB6);

        User user0 = new User("Morty","Jassica",true,person0);
        User user1 = new User("Lord","Iamthelord",true,person1);
        User user2 = new User("Nani","Poonani",true,person2);
        User user3 = new User("Tupac","thuglife",true,person3);
        User user4 = new User("Biggie","kickinthedoor",true,person4);
        User user5 = new User("Scarlet","blackwidow",true,person5);
        User user6 = new User("GROOT","iamgroot",true,person6);
        User user7 = new User("Spongebob","krabbypatty",true,person7);
        User user8 = new User("Nero","Mero",true,person8);
        User user9 = new User("Tosca","cutiee",true,person9);
        User user10 = new User("Saul","isallgoodman",true,person10);

        userDAO.save(user0);
        userDAO.save(user1);
        userDAO.save(user2);
        userDAO.save(user3);
        userDAO.save(user4);
        userDAO.save(user5);
        userDAO.save(user6);
        userDAO.save(user7);
        userDAO.save(user8);
        userDAO.save(user9);
        userDAO.save(user10);

       userDAO.update(user1.setLogin("test3 test"));

        moduleFromDB.forEach(System.out::println);

        List<Exam> examFromDB = examDAO.findAll();
        moduleFromDB.forEach(System.out::println);

        List<Person> personsFromDB = personDAO.findAll();
        personsFromDB.forEach(System.out::println);



    }
}