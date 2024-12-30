package se.lexicon.view;

import se.lexicon.model.Meeting;
import se.lexicon.model.MeetingCalendar;
import se.lexicon.model.User;
import se.lexicon.util.ConsoleColors;

import java.util.List;

public interface CalendarView {

    default void displayMenu() {
        System.out.println("Calender Options");
        System.out.println("0. Register");
        System.out.println("1. Login");
        System.out.println("2. Add Calendar");
        System.out.println("3. Add Meeting");
        System.out.println("4. Add Delete Meeting");
        System.out.println("5. Display Calendar Meeting");
        System.out.println("6. Logout");
        System.out.println("7. Exit");

        System.out.println("Enter your choice: ");

        //... Options for edit, reschedule and more...

    }

    //Display data by printing it out in Console
    void displayUser(User user);
    void displayCalendar(MeetingCalendar meetingCalendar);
    void displayCalendar(List<MeetingCalendar> meetingCalendar);

    void displayMeeting(Meeting meetingList);
    void displayMeeting(List<Meeting> meetingList);


    default void displayInfoMessage(String message) {
        System.out.println(ConsoleColors.BLUE + message + ConsoleColors.RESET);
    }

    default void displaySuccessMessage(String message) {
        System.out.println(ConsoleColors.GREEN + message + ConsoleColors.RESET);
    }

    default void displayErrorMessage(String message) {
        System.out.println(ConsoleColors.RED + message + ConsoleColors.RESET);
    }

    default void displayWarningMessage(String message) {
        System.out.println(ConsoleColors.YELLOW + message + ConsoleColors.RESET);
    }


    //Asks user for input
    String promoteGetString();

    Meeting promoteMeetingForm();
    String promoteCalenderForm();
    String promoteUserFormRegister();
    User promoteUserFormSignIn();
}
