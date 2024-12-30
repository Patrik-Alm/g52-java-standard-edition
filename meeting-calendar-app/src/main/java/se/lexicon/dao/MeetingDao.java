package se.lexicon.dao;

import se.lexicon.model.Meeting;

import java.util.Collection;
import java.util.Optional;

public interface MeetingDao {

    String CREATE_MEETING_SQL = "INSERT INTO meetings (title, start_at, end_at, _description, calendar_id) VALUES (?, ?, ?, ?, ?)";

    String FIND_BY_ID_SQL =
                    """
                    SELECT m.*, mc.username, mc.title AS calendar_title FROM meetings m
                    INNER JOIN meeting_calendars mc ON m.calendar_id = mc.id
                    WHERE m.id = ?
                    """;

    String FIND_ALL_BY_CALENDAR_ID_SQL = "SELECT * FROM meetings WHERE calendar_id = ?";

    String DELETE_MEETING_SQL = "DELETE FROM meetings WHERE id = ?";


    Meeting createMeeting(Meeting meeting);

    Optional<Meeting> findById(int meetingId);

    Collection<Meeting> findAllMeetingsByCalendarId(int calenderId);

    //More Find Methods?

    // Add methods for updating, deleting meeting as needed...

}
