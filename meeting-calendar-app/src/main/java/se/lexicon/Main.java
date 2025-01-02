package se.lexicon;

import se.lexicon.controller.CalendarController;
import se.lexicon.dao.MeetingCalendarDao;
import se.lexicon.dao.MeetingDao;
import se.lexicon.dao.UserDao;
import se.lexicon.dao.db.MysqlConnection;
import se.lexicon.dao.impl.MeetingCalendarDaoImpl;
import se.lexicon.dao.impl.MeetingDaoImpl;
import se.lexicon.dao.impl.UserDaoImpl;
import se.lexicon.view.CalendarView;
import se.lexicon.view.CalendarViewConsoleUI;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = MysqlConnection.getConnection();

        UserDao userDao = new UserDaoImpl(connection);
        MeetingDao meetingDao = new MeetingDaoImpl(connection);
        MeetingCalendarDao calendarDao = new MeetingCalendarDaoImpl(connection);

        CalendarView calendarView = new CalendarViewConsoleUI();
        CalendarController calendarController = new CalendarController(userDao, meetingDao, calendarDao, calendarView);

        calendarController.run();
    }

}