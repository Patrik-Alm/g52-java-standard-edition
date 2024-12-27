package se.lexicon.dao.impl;

import se.lexicon.dao.MeetingCalendarDao;
import se.lexicon.model.MeetingCalendar;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MeetingCalendarDaoImpl implements MeetingCalendarDao {
    @Override
    public MeetingCalendar createMeetingCalendar(String title, String username) {
        return null;// TODO - Implement Method
    }

    @Override
    public Optional<MeetingCalendar> findById(int calenderId) {
        return Optional.empty();// TODO - Implement Method
    }

    @Override
    public Collection<MeetingCalendar> findByUsername(String username) {
        return List.of();// TODO - Implement Method
    }

    @Override
    public Optional<MeetingCalendar> findByTitle(String title) {
        return Optional.empty();// TODO - Implement Method
    }

    @Override
    public List<MeetingCalendar> getAllMeetingCalendarsByUsername(String username) {
        return List.of();// TODO - Implement Method
    }

    @Override
    public boolean deleteCalendar(int calenderId) {
        return false;// TODO - Implement Method
    }
}
