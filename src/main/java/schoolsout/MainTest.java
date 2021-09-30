package schoolsout;

import schoolsout.daos.CourseDAO;
import schoolsout.daos.ExamDAO;
import schoolsout.daos.ModuleDAO;
import schoolsout.daos.PersonDAO;
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
        PersonDAO personDAO = new PersonDAO(emf);

        CourseDAO courseDAO = new CourseDAO(emf);
        List<Course> courseFromDB = courseDAO.findAll();
        courseFromDB.forEach(System.out::println);

        ModuleDAO moduleDAO = new ModuleDAO(emf);
        List<Module> moduleFromDB = moduleDAO.findAll();
        moduleFromDB.forEach(System.out::println);

        ExamDAO examDAO = new ExamDAO(emf);
        List<Exam> examFromDB = examDAO.findAll();
        moduleFromDB.forEach(System.out::println);



        Person person0 = new Person("Morty", "Rick", Gender.MALE, person.getCourse());
        Person person1 = new Person("Lord", "Kek", Gender.OTHER, person.getCourse());
        Person person2 = new Person("Nani", "Poonani", Gender.MALE, person.getCourse());
        Person person3 = new Person("Tupac", "Shakur", Gender.MALE, person.getCourse());
        Person person4 = new Person("Biggie", "Smalls", Gender.MALE, person.getCourse());
        Person person5 = new Person("Scarlet", "Johansson", Gender.FEMALE, person.getCourse());
        Person person6 = new Person("I AM ", "GROOT", Gender.OTHER, person.getCourse());
        Person person7 = new Person("Spongebob ", "Squarespace", Gender.OTHER, person.getCourse());
        Person person8 = new Person("Nero ", "GoodBoi", Gender.MALE, person.getCourse());
        Person person9 = new Person("Tosca ", "GoodGirl", Gender.FEMALE, person.getCourse());
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




        Module module0 = new Module("Hoofdstuk 1","Welcome to the world of Java programming! ", person.getCourse(),examFromDB.subList(0,77) );
        Module module1 = new Module("Hoofdstuk 2","Programming languages enable humans to write instructions that a computer can perform.", person.getCourse(),examFromDB.subList(0,7) );
        Module module2 = new Module("Hoofdstuk 3","With precise instructions, computers coordinate applications and systems that run the modern world.", person.getCourse(),examFromDB.subList(0,7) );
        Module module3 = new Module("Hoofdstuk 4","Having some fun, stimulating your mind, gaining an edge at work, or even starting a career in software engineering", person.getCourse(),examFromDB.subList(0,7) );
        Module module4 = new Module("Hoofdstuk 5","Just like knowing your why is the first step of any journey, defining your one big goal is the first step towards achieving it.", person.getCourse(),examFromDB.subList(0,7) );
        Module module5 = new Module("Hoofdstuk 6","Once you’ve defined your goal, you need to visualize it. Take a deep breath and imagine yourself working towards that goal. ", person.getCourse(),examFromDB.subList(0,7) );
        Module module6 = new Module("Hoofdstuk 7","Imagine what it feels like. See what the end looks like. Visualization might seem silly at first, but research has shown that you can improve any skill just by visualizing yourself practicing it. ", person.getCourse(),examFromDB.subList(0,77) );
        Module module7 = new Module("Hoofdstuk 8","Your coding journey doesn’t differ from that of any other beginner. You need a clear plan if you want to reach the destination.", person.getCourse(),examFromDB.subList(0,7) );

        moduleDAO.save(module0);
        moduleDAO.save(module1);
        moduleDAO.save(module2);
        moduleDAO.save(module3);
        moduleDAO.save(module4);
        moduleDAO.save(module5);
        moduleDAO.save(module6);
        moduleDAO.save(module7);




        Course course0 = new Course("Java EE"," Java EE offers a rich enterprise software platform and with over 20 compliant Java EE implementations to choose from.","01","https://blogs.sap.com/wp-content/uploads/2017/07/JavaEE.png",true,moduleFromDB.subList(0,7));
        Course course1 = new Course("Boxing"," Boxing is a combat sport in which two people, usually wearing protective gloves and other protective equipment such as hand wraps and mouthguards, throw punches at each other for a predetermined amount of time in a boxing ring.","02","https://upload.wikimedia.org/wikipedia/commons/2/2a/Boxing_Tournament_in_Aid_of_King_George%27s_Fund_For_Sailors_at_the_Royal_Naval_Air_Station%2C_Henstridge%2C_Somerset%2C_July_1945_A29806.jpg",true,moduleFromDB.subList(0,7));
        Course course2 = new Course("Wrestling","Wrestling is a combat sport involving grappling-type techniques such as clinch fighting, throws and takedowns, joint locks, pins and other grappling holds. ","03","https://upload.wikimedia.org/wikipedia/commons/8/84/Wrestling_at_the_2016_Summer_Olympics%2C_Gazyumov_vs_Andriitsev_6.jpg",true,moduleFromDB.subList(0,7));
        Course course3 = new Course("UFC","Ultimate Fighting Championship (UFC) is de grootste mixed-martial-artsorganisatie ter wereld.","04","https://upload.wikimedia.org/wikipedia/commons/a/aa/UFC_74_Respect_Bout.jpg",true,moduleFromDB.subList(0,7));
        Course course4 = new Course("Judo","Judo (Japans: 柔道, じゅうどう, jūdō[1]) is een van oorsprong Japanse zelfverdedigingskunst, die rond 1882 werd ontworpen door Jigoro Kano.","05","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Jigoro_Kano_and_Kyuzo_Mifune.jpg/260px-Jigoro_Kano_and_Kyuzo_Mifune.jpg",true,moduleFromDB.subList(0,7));
        Course course5 = new Course("Krav Maga","Krav maga (Hebreeuws: קרב מגע, contactgevecht) is een verdedigingskunst die zijn oorsprong heeft in Tsjecho-Slowakije en Israël. ","06","https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Krav_Maga_Marines.jpg/1280px-Krav_Maga_Marines.jpg",true,moduleFromDB.subList(0,7));
        Course course6 = new Course("Thai Box","Thai boxing (or Muay Thai) is a combat sport (martial art) that has been developed in Thailand. It is known also as \"the art of eight limbs\", because both hands, elbows, knees, and legs can be used to attack an opponent.","07","https://blogs.sap.com/wp-content/uploads/2017/07/JavaEE.png",true,moduleFromDB.subList(0,7));
        Course course7 = new Course("Kick Box","Kickboxing is a group of stand-up combat sports based on kicking and punching, historically developed from karate mixed with boxing.","08","https://blogs.sap.com/wp-content/uploads/2017/07/JavaEE.png",true,moduleFromDB.subList(0,7));

        courseDAO.save(course0);
        courseDAO.save(course1);
        courseDAO.save(course2);
        courseDAO.save(course3);
        courseDAO.save(course4);
        courseDAO.save(course5);
        courseDAO.save(course6);
        courseDAO.save(course7);



        Exam exam0 = new Exam("Fundamentals Test","you noobs are going down", LocalDate.of(2022,8,07),77,100,moduleFromDB.get(0));
        Exam exam1 = new Exam("Boxing Test","2 Sparring rounds boxing 40%", LocalDate.of(2022,8,07),77,100,moduleFromDB.get(1));
        Exam exam2 = new Exam("Wrestling Test","2 Sparring Rounds wrestling 50%", LocalDate.of(2022,8,07),77,100,moduleFromDB.get(2));
        Exam exam3 = new Exam("UFC Test","4 Sparring rounds UFC 30%", LocalDate.of(2022,8,07),77,100,moduleFromDB.get(3));
        Exam exam4 = new Exam("Judo Test","3 Throws, 4 Defense counter-attacks 70%", LocalDate.of(2022,8,07),77,100,moduleFromDB.get(4));
        Exam exam5 = new Exam("Krav Maga Test","3 Techniques 100%, 4 Counter-Attacks 30%", LocalDate.of(2022,8,07),77,100,moduleFromDB.get(5));
        Exam exam6 = new Exam("Thai Box Test","4 High Kicks 80%, 2 Sparring rounds 50%", LocalDate.of(2022,8,07),77,100,moduleFromDB.get(6));
        Exam exam7 = new Exam("Kick Box Test","3 High Kicks 80%, 2 Elbows 100%, 2 Throws 50%, 1 Sparring round 70%", LocalDate.of(2022,8,07),77,100,moduleFromDB.get(7));

        examDAO.save(exam0);
        examDAO.save(exam1);
        examDAO.save(exam2);
        examDAO.save(exam3);
        examDAO.save(exam4);
        examDAO.save(exam5);
        examDAO.save(exam6);
        examDAO.save(exam7);




        List<Person> personsFromDB = personDAO.findAll();
        personsFromDB.forEach(System.out::println);




    }
}