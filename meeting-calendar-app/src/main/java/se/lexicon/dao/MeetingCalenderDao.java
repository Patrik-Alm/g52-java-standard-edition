package se.lexicon.dao;

import se.lexicon.model.MeetingCalendar;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MeetingCalenderDao {

    String CREATE_MEETING_CALENDAR_SQL = "";

    String FIND_BY_ID_SQL = "";

    String FIND_BY_USERNAME_SQL ="";

    String FIND_BY_TITLE_SQL = "";

    String FIND_All_CALENDERS_BY_USERNAME = "";

    String DELETE_CALENDAR_SQL = "";


    MeetingCalendar createMeetingCalendar(String title, String username);

    Optional<MeetingCalendar> findById(int calenderId);

    Collection<MeetingCalendar> findByUsername(String username);

    Optional<MeetingCalendar> findByTitle(String title);

    List<MeetingCalendar> getAllMeetingCalendarsByUsername(String username);

    boolean deleteCalendar(int calenderId);

    // Add methods for updating calendars as needed...
}
