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

        List<Course> courses = DataFactory.getCourses();



        for (Course course : courses) {
            courseDAO.save(course);
        }

        System.out.println("saving courses");


        List<Course> courseFromDB = courseDAO.findAll();

        System.out.println("fetching courses");


        List<Person> students = DataFactory.getStudents(courseFromDB);
        students.forEach(personDAO::save);






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

        List<Course> courseHistory = course;



    }
}