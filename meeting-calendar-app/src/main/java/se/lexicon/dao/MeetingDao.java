package se.lexicon.dao;

import se.lexicon.model.Meeting;

import java.util.Collection;
import java.util.Optional;

public interface MeetingDao {

    String CREATE_MEETING_SQL = "";

    String FIND_BY_ID_SQL = "";

    String FIND_ALL_BY_CALENDAR_ID_SQL = "";

    String DELETE_MEETING_SQL = "";


    Meeting createMeeting(Meeting meeting);

    Optional<Meeting> findById(int meetingId);

    Collection<Meeting> findAllMeetingsByCalendarId(int calenderId);

    //More Find Methods?

    // Add methods for updating, deleting meeting as needed...

}
