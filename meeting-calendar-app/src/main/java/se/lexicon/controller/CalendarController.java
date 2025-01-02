package se.lexicon.controller;

import se.lexicon.dao.MeetingCalendarDao;
import se.lexicon.dao.MeetingDao;
import se.lexicon.dao.UserDao;
import se.lexicon.exception.CalendarExceptionHandler;
import se.lexicon.model.MeetingCalendar;
import se.lexicon.model.User;
import se.lexicon.view.CalendarView;

public class CalendarController {

    //Dependencies
    private CalendarView view;
    private UserDao userDao;
    private MeetingDao meetingDao;
    private MeetingCalendarDao calendarDao;

    private String username;
    private boolean isLoggedIn;

    public CalendarController(UserDao userDao, MeetingDao meetingDao, MeetingCalendarDao calendarDao, CalendarView view) {
        this.view = view;
        this.userDao = userDao;
        this.meetingDao = meetingDao;
        this.calendarDao = calendarDao;
    }

    public void run() {
        while (true) {
            view.displayMenu();

            int choice = Integer.parseInt(view.promoteGetString());

            switch (choice) {
                case 0:
                    register();
                    break;
                case 1:
                    login();
                    break;
                case 2:
                    createCalendar();
                    break;
                case 3:
                    //todo: call meeting method
                    break;
                case 4:
                    //todo: call delete calendar method
                    break;
                case 5:
                    //todo: call display calendar method
                    break;
                case 6:
                    isLoggedIn = false;
                    username = null;
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    view.displayWarningMessage("Invalid choice. Please select a valid option.");
            }

        }


    }

    private void register() {
        String username = view.promoteUserFormRegister();

        try {
            User user = userDao.createUser(username);
            view.displaySuccessMessage("You have registered successfully. Password: " + user.getPassword());
        } catch (Exception e) {
            CalendarExceptionHandler.handleException(e);
        }
    }

    private void login() {
        view.displayInfoMessage("Let's sign in");

        User user = view.promoteUserFormSignIn();

        try {
            isLoggedIn = userDao.authenticate(user);
            username = user.getUsername();
            view.displaySuccessMessage("You have successfully logged in!");
        } catch (Exception e) {
            CalendarExceptionHandler.handleException(e);
        }
    }


    private void createCalendar() {
        if (!isLoggedIn) {
            view.displayWarningMessage("You need to login first.");
            return;
        }
        String calendarTitle = view.promoteCalenderForm();
        MeetingCalendar meetingCalendar = calendarDao.createMeetingCalendar(calendarTitle, username);
        System.out.println(meetingCalendar.meetingCalendarInfo());
    }


}
