package se.lexicon.dao;

import se.lexicon.model.MeetingCalendar;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MeetingCalendarDao {

    String CREATE_MEETING_CALENDAR_SQL = "INSERT INTO meeting_calendars (title, username) VALUES(?,?)";

    String FIND_BY_ID_SQL = "SELECT * FROM meeting_calendars WHERE id=?";

    String FIND_BY_USERNAME_SQL ="SELECT * FROM meeting_calendars WHERE username = ?";

    String FIND_BY_TITLE_SQL = "SELECT * FROM meeting_calendars WHERE title = ?";

    String DELETE_CALENDAR_BY_ID_SQL = "DELETE FROM meeting_calendars WHERE id = ?";


    MeetingCalendar createMeetingCalendar(String title, String username);

    Optional<MeetingCalendar> findById(int calenderId);

    Collection<MeetingCalendar> findByUsername(String username);

    Optional<MeetingCalendar> findByTitle(String title);

    List<MeetingCalendar> getAllMeetingCalendarsByUsername(String username);

    boolean deleteCalendar(int calenderId);

    // Add methods for updating calendars as needed...
}
