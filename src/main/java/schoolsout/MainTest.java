package schoolsout;

import schoolsout.daos.*;
import schoolsout.models.*;
import schoolsout.models.Module;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {

    public static void main(String[] args) {

        /*generateData();*/


        ModuleDAO moduleDAO = new ModuleDAO();
        ExamDAO examDAO = new ExamDAO();
        PersonDAO personDAO = new PersonDAO();
        CourseDAO courseDAO = new CourseDAO();
        GradeDAO gradeDAO = new GradeDAO();

        Person byId = personDAO.findById(177);
        List<Grade> grades = DataFactory.gradePerson(byId);

        grades.forEach(gradeDAO::save);

        List<Grade> gradeList = gradeDAO.findAll();
        gradeList.stream()
                .map(Grade::getGradeValue)
                .collect(Collectors.toList())
                .forEach(System.out::println);



       /* System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<Module> moduleFromDB = moduleDAO.findAll();
        moduleFromDB.forEach(System.out::println);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<Exam> examFromDB = examDAO.findAll();
        examFromDB.forEach(System.out::println);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<Person> personsFromDB = personDAO.findAll();
        personsFromDB.forEach(System.out::println);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        List<Exam> subExamFromDB = examDAO.findAll();
        subExamFromDB.forEach(e -> System.out.println(e.getSubExams()));
*/
       /* List<Course> coursesFromDb = courseDAO.findAll();
        for (int i = 0; i < coursesFromDb.size(); i++) {
            Course course = coursesFromDb.get(i);
            if (i % 2 == 0) {
                course.setActive(false);
                courseDAO.update(course);

            }

            System.out.println(courseDAO.findAllActiveCourses());


        }*/
/*
    static void generateData(){
        //SET ddl to create
        CourseDAO courseDAO = new CourseDAO();
        UserDAO userDAO = new UserDAO();

        List<Course> courses = DataFactory.getCourses();



        for (Course course : courses) {
            List<Module> modules = DataFactory.getModules(course);
            course.setModules(modules);
            courseDAO.save(course);
        }

        System.out.println("saving courses");



        List<Course> courseFromDB = courseDAO.findAll();
        courseFromDB.forEach(System.out::println);

        List<Person> students = DataFactory.getStudents(courseFromDB);

        List<User> users = DataFactory.getUsers(students);





                System.out.println("saving Users");
        for (User user : users) {
            userDAO.save(user);
        }
*/


    }
}