package se.lexicon.dao.impl;

import se.lexicon.dao.MeetingDao;
import se.lexicon.model.Meeting;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MeetingDaoImpl implements MeetingDao {


    @Override
    public Meeting createMeeting(Meeting meeting) {
        return null;// TODO - Implement Method
    }

    @Override
    public Optional<Meeting> findById(int meetingId) {
        return Optional.empty();// TODO - Implement Method
    }

    @Override
    public Collection<Meeting> findAllMeetingsByCalendarId(int calenderId) {
        return List.of();// TODO - Implement Method
    }
}
