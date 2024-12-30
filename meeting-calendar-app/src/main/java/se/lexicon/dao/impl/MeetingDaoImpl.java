package se.lexicon.dao.impl;

import se.lexicon.dao.MeetingDao;
import se.lexicon.exception.MySQLException;
import se.lexicon.model.Meeting;
import se.lexicon.model.MeetingCalendar;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MeetingDaoImpl implements MeetingDao {


    private Connection connection;

    public MeetingDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Meeting createMeeting(Meeting meeting) {
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(CREATE_MEETING_SQL, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, meeting.getTitle());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(meeting.getStartTime()));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(meeting.getEndTime()));
            preparedStatement.setString(4, meeting.getDescription());
            preparedStatement.setInt(5, meeting.getMeetingCalendar().getId());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                String errorMessage = "Creating meeting failed, no rows affected.";
                throw new MySQLException(errorMessage);
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int meetingId = generatedKeys.getInt(1);
                    //meeting.setId(meetingId); // create setId to set meeting id and reuse the meeting data
                    new Meeting(meetingId, meeting.getTitle(), meeting.getStartTime(), meeting.getEndTime(), meeting.getDescription(), meeting.getMeetingCalendar());
                    return meeting;
                } else {
                    String errorMessage = "Creating meeting failed, no ID obtained.";
                    throw new MySQLException(errorMessage);
                }
            }
        } catch (SQLException e) {
            String errorMessage = "Error occurred while creating a meeting";
            throw new MySQLException(errorMessage, e);
        }
    }

    @Override
    public Optional<Meeting> findById(int id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int meetingId = resultSet.getInt("id");
                String title = resultSet.getString("title");
                Timestamp startTime = resultSet.getTimestamp("start_at");
                Timestamp endTime = resultSet.getTimestamp("end_at");
                String description = resultSet.getString("_description");
                int calendarId = resultSet.getInt("calendar_id");

                String calendarTitle = resultSet.getString("calendar_title");
                String calendarUsername = resultSet.getString("username");

                 LocalDateTime startDateTime = startTime.toLocalDateTime();
                 LocalDateTime endDateTime = endTime.toLocalDateTime();

                return Optional.of(new Meeting (meetingId,title, startDateTime,endDateTime,description
                        ,new MeetingCalendar(calendarId,calendarTitle,calendarUsername)));

            }

        }catch (SQLException e){
            String errorMessage = "Error occurred while finding meeting by id: " + id;
        }

        return Optional.empty();
    }

    @Override
    public Collection<Meeting> findAllMeetingsByCalendarId(int calendarId) {
        List<Meeting> meetings = new ArrayList<>();
        try (

                PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_CALENDAR_ID_SQL);

        ) {
            preparedStatement.setInt(1, calendarId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    int meetingId = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    Timestamp startTime = resultSet.getTimestamp("start_at");
                    Timestamp endTime = resultSet.getTimestamp("end_at");
                    String description = resultSet.getString("_description");

                    LocalDateTime startDateTime = startTime.toLocalDateTime();
                    LocalDateTime endDateTime = endTime.toLocalDateTime();

                    Meeting meeting = new Meeting(meetingId, title, startDateTime, endDateTime, description);

                    meetings.add(meeting);
                }
            }


        } catch (SQLException e) {
            String errorMessage = "Error occurred while retrieving all meetings";
            throw new MySQLException(errorMessage, e);
        }
        return meetings;
    }
}
