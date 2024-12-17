package se.lexicon;

import se.lexicon.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static se.lexicon.db.MySQLConnection.getConnection;

public class JDBCExamples {
    public static void main(String[] args) {
            ex4();
    }

    // Task: Find all Students
    public static void ex1() {

        String sql = "SELECT * FROM students";
        List<Student> studentList = new ArrayList<>();

        try (
                Connection connection = getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {

            while (resultSet.next()) {

                int studentId = resultSet.getInt("student_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                LocalDate createDate = resultSet.getDate("created_at").toLocalDate();

                Student student = new Student(studentId, firstName, lastName, age, email, createDate);

                studentList.add(student);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        studentList.forEach(System.out::println);

    }

    // Task: Get Student by an id
    // Step 0: Prep method
    // Step 1: create DB Connection
    // Step 2: create PreparedStatement
    // Step 3: execute Query
    // Step 4: Get data from ResultSet, convert data to a Student object
    // Step 5: Close all used Resources
    public static void ex2() {

        int studentId = 3; //Bob
        Student student = null;
        String sql = "SELECT * FROM students WHERE student_id = ?";


        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, studentId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    int student_id = resultSet.getInt("student_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");
                    LocalDate createDate = resultSet.getDate("created_at").toLocalDate();

                    student = new Student(student_id, firstName, lastName, age, email, createDate);

                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }// Will close all resources -> ResultSet, PreparedStatement, Connection

        System.out.println(student);
    }


    // Task: Create a student + return generated key (student_id)
    public static void ex3() {

        Student student = new Student("Test", "Testsson",20,"test@testsson.te");

        String sql = "INSERT INTO students (first_name, last_name, age, email) VALUES(?,?,?,?)";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ){
            preparedStatement.setString(1,student.getFirstName());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setString(4,student.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();


            if (rowsAffected > 0 ){
                System.out.println("Student was added!");
            }

            try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()){

                if (generatedKeys.next()){
                    int generatedStudentIdKey = generatedKeys.getInt(1);
                    System.out.println("generatedStudentIdKey = " + generatedStudentIdKey);
                }

            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }



    // Task: Create a student + assign the student to a course
    // Bonus: Transaction
    public static void ex4() {

        Student student = new Student("Test", "Testsson",20,"test@testsson.te");
        int courseId = 3; // Computer Science
//        int courseId = 40; // ?
        String insertQueryStudent = "INSERT INTO students (first_name, last_name, age, email) VALUES(?,?,?,?)";
        String insertQueryCourseRelationship = "INSERT INTO student_courses (student_id, course_id) VALUES (?,?)";
        int generatedStudentId = 0;

        Connection connection = getConnection();
        //Create (Persist) Student
        try(
            PreparedStatement preparedStatement = connection.prepareStatement(insertQueryStudent, PreparedStatement.RETURN_GENERATED_KEYS)
        ){
            connection.setAutoCommit(false);

            preparedStatement.setString(1,student.getFirstName());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setString(4,student.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0 ){
                System.out.println("Student created successfully!");
            }else{
                System.out.println("Student was NOT created successfully");
                throw new RuntimeException("Insert Operation in Student table failed!"); // connection.rollback();
            }

            try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()){
                if (generatedKeys.next()){
                    generatedStudentId = generatedKeys.getInt(1);
                    System.out.println("GeneratedKey is: " + generatedStudentId);
                }
            }

            // Assign Relationship between Student and Group
            try(PreparedStatement preparedStatementRelationship = connection.prepareStatement(insertQueryCourseRelationship)){

                preparedStatementRelationship.setInt(1, generatedStudentId);
                preparedStatementRelationship.setInt(2, courseId);

                int insertedRows = preparedStatementRelationship.executeUpdate();

                if (insertedRows > 0){
                    System.out.println("Assigned relationship was successfully done!");
                }else{
                    throw new RuntimeException("Insert Operation in (student_courses) table failed!"); // connection.rollback();
                }


            }

            //Commit - Save changes to a database.
            connection.commit();


        } catch (SQLException | RuntimeException ex){
            try{
                connection.rollback();
            }catch (SQLException e){
                e.printStackTrace();
            }

            ex.printStackTrace();
        }finally {
            try{
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }

    }


}
