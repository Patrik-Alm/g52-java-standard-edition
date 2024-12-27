package se.lexicon;

import se.lexicon.dao.UserDao;
import se.lexicon.dao.db.MysqlConnection;
import se.lexicon.dao.impl.UserDaoImpl;
import se.lexicon.exception.CalendarExceptionHandler;
import se.lexicon.model.User;
import se.lexicon.util.ConsoleColors;

import java.util.Optional;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

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

        System.out.println(ConsoleColors.BLUE +"Hello" + ConsoleColors.RESET);

        try{
            DriverManager.getConnection(MysqlConnection.JDBC_URL, MysqlConnection.JDBC_USER,"ewrqw");
        }catch (SQLException e){
            CalendarExceptionHandler.handleException(e);
        }


        UserDao userDao = new UserDaoImpl();

        Optional<User> foo = userDao.findByUserName("foo");

        foo.ifPresent(u -> System.out.println(u.userInfo()));



    }
}