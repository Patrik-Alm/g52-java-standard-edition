package se.lexicon.view;

import se.lexicon.model.Meeting;
import se.lexicon.model.MeetingCalendar;
import se.lexicon.model.User;

import java.util.List;
import java.util.Scanner;

public class CalendarViewConsoleUI implements CalendarView {
    @Override
    public void displayUser(User user) {
        // TODO - IMPLEMENT
    }

    @Override
    public void displayCalendar(MeetingCalendar meetingCalendar) {
        // TODO - IMPLEMENT
    }

    @Override
    public void displayCalendar(List<MeetingCalendar> meetingCalendar) {
        // TODO - IMPLEMENT
    }

    @Override
    public void displayMeeting(Meeting meetingList) {
        // TODO - IMPLEMENT
    }

    @Override
    public void displayMeeting(List<Meeting> meetingList) {
        // TODO - IMPLEMENT
    }

    @Override
    public String promoteGetString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return input;
    }

    @Override
    public Meeting promoteMeetingForm() {
        return null;  // TODO - IMPLEMENT
    }

    @Override
    public String promoteCalenderForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Calendar Title: ");
        String title = scanner.nextLine();
        return title;
    }

    @Override
    public String promoteUserFormRegister() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a username: ");
        String username = scanner.nextLine();
        return username;
    }

    @Override
    public User promoteUserFormSignIn() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        return new User(username, password);
    }
}
