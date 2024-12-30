package se.lexicon;

import se.lexicon.dao.MeetingCalendarDao;
import se.lexicon.dao.UserDao;
import se.lexicon.dao.db.MysqlConnection;
import se.lexicon.dao.impl.MeetingCalendarDaoImpl;
import se.lexicon.dao.impl.UserDaoImpl;
import se.lexicon.exception.CalendarExceptionHandler;
import se.lexicon.model.MeetingCalendar;
import se.lexicon.model.User;
import se.lexicon.util.ConsoleColors;

import java.sql.Connection;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Connection connection = MysqlConnection.getConnection();

        UserDao userDao = new UserDaoImpl(connection);
        MeetingCalendarDao calendarDao = new MeetingCalendarDaoImpl(connection);

//        User user = new User("root");
//        System.out.println(user.userInfo());


//        MeetingCalendar calendar = new MeetingCalendar("Java Group 52", user.getUsername());
//
//        LocalDateTime startTime = LocalDateTime.parse("2024-12-27T09:00");
//        Meeting lecture = new Meeting("Meeting Calendar App - Part 2", startTime, startTime.plusHours(3) ,"Implementing MYSQL Connections and more");
//        Meeting lecture2 = new Meeting("Meeting Calendar App - Part 3", startTime.plusDays(3), startTime.plusDays(3).plusHours(3) ,"Implementing Patterns");
//
//        calendar.addMeeting(lecture);
//        calendar.addMeeting(lecture2);
//
//        System.out.println(lecture.meetingInfo());


        //System.out.println(calendar.meetingCalendarInfo());
        //calendar.getMeetings().forEach((m) -> System.out.println(m.meetingInfo()));

//        UserDao userDao = new UserDaoImpl();
//
//        Optional<User> foo = userDao.findByUserName("foo");
//
//        foo.ifPresent(u -> System.out.println(u.userInfo()));


//        login(userDao);
//        register(userDao);


        createMeetingCalendar(calendarDao);


    }

    private static void createMeetingCalendar(MeetingCalendarDao calendarDao) {
        //Create a calendar for foo user.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a title: ");
        String title = scanner.nextLine();
        String username = "foo"; // Hardcoded  TODO - Only allow while logged in first.

        MeetingCalendar meetingCalendar = calendarDao.createMeetingCalendar(title, username);

        System.out.println(meetingCalendar.meetingCalendarInfo());
    }

    private static void register(UserDao userDao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a username: ");
        String username = scanner.nextLine();

        User user = userDao.createUser(username);

        System.out.println(user.userInfo());
        System.out.println("--------------------------");
    }

    private static void login(UserDao userDao) {
        System.out.println(ConsoleColors.BLUE +"Hello, Let's sign in" + ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        User user = new User(username, password);


        try{
            boolean is_authenticated = userDao.authenticate(user);
            if (is_authenticated){
                System.out.println(ConsoleColors.GREEN + "You have successfully logged in!" + ConsoleColors.RESET);
            }

        }catch (Exception e){
            CalendarExceptionHandler.handleException(e);
        }
    }
}