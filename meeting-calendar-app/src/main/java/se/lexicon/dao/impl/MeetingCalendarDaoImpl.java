package se.lexicon.dao.impl;

import se.lexicon.dao.MeetingCalendarDao;
import se.lexicon.exception.MySQLException;
import se.lexicon.model.MeetingCalendar;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MeetingCalendarDaoImpl implements MeetingCalendarDao {

    private Connection connection;

    public MeetingCalendarDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public MeetingCalendar createMeetingCalendar(String title, String username) {

        try(PreparedStatement preparedStatement = connection.prepareStatement(CREATE_MEETING_CALENDAR_SQL, Statement.RETURN_GENERATED_KEYS)){

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, username);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                String errorMessage = "Creating calendar failed, no rows affected";
                throw new MySQLException(errorMessage);
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()){
                int generatedId = generatedKeys.getInt(1);
                MeetingCalendar meetingCalendar = new MeetingCalendar(generatedId,title, username);
                return meetingCalendar;
            }else {
                String errorMessage = "Created Calendar failed, No ID obtained";
                throw new MySQLException(errorMessage);
            }

        }catch (SQLException e){
            throw new MySQLException("An error occurred while creating calendar", e);
        }
    }

    @Override
    public Optional<MeetingCalendar> findById(int calendarId) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {

            preparedStatement.setInt(1, calendarId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String title = resultSet.getString("title");
                    return Optional.of(new MeetingCalendar(calendarId, username, title));
                }
            }

        } catch (SQLException e) {
            String errorMessage = "Error occurred while finding MeetingCalendar by ID: " + calendarId;
            throw new MySQLException(errorMessage, e);
        }

        return Optional.empty();
    }

    @Override
    public Collection<MeetingCalendar> findByUsername(String username) {
        List<MeetingCalendar> calendars = new ArrayList<>();

        try (

                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERNAME_SQL)
        ) {

            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    calendars.add(new MeetingCalendar(id, username, title));
                }
            }

        } catch (SQLException e) {
            String errorMessage = "Error occurred while finding MeetingCalendars by username: " + username;
            throw new MySQLException(errorMessage, e);
        }
        return calendars;
    }

    @Override
    public Optional<MeetingCalendar> findByTitle(String title) {
        MeetingCalendar calendar = null;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_TITLE_SQL)) {

            preparedStatement.setString(1, title);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    calendar = new MeetingCalendar(id, username, title);
                }
            }

        } catch (SQLException e) {
            String errorMessage = ("Error occurred while finding MeetingCalendar by title: " + title);
            throw new MySQLException(errorMessage, e);
        }

        return Optional.ofNullable(calendar);
    }

    @Override
    public List<MeetingCalendar> getAllMeetingCalendarsByUsername(String username) {
        List<MeetingCalendar> calendars = new ArrayList<>();
        try (

                PreparedStatement preparedStatement = connection.prepareStatement(MeetingCalendarDao.FIND_BY_USERNAME_SQL);
        ) {

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String _username = resultSet.getString("username");
                String title = resultSet.getString("title");
                MeetingCalendar calendar = new MeetingCalendar(id, _username, title);
                calendars.add(calendar);
            }

        } catch (SQLException e) {
            String errorMessage = "Error occurred while getting all MeetingCalendars";
            throw new MySQLException(errorMessage, e);
        }

        return calendars;
    }

    @Override
    public boolean deleteCalendar(int calenderId) {
        return false;// TODO - Implement Method
    }
}
