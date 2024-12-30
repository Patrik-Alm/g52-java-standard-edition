package se.lexicon.view;

import se.lexicon.model.Meeting;
import se.lexicon.model.MeetingCalendar;
import se.lexicon.model.User;

import java.util.List;

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
        return "";  // TODO - IMPLEMENT
    }

    @Override
    public Meeting promoteMeetingForm() {
        return null;  // TODO - IMPLEMENT
    }

    @Override
    public String promoteCalenderForm() {
        return "";  // TODO - IMPLEMENT
    }

    @Override
    public String promoteUserFormRegister() {
        return "";  // TODO - IMPLEMENT
    }

    @Override
    public User promoteUserFormSignIn() {
        return null;  // TODO - IMPLEMENT
    }
}
