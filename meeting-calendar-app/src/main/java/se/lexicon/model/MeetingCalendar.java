package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;

/*
    Constructors
    title
    username, title
    id, username, title

    - Prevent returning a null list
    - Prevent adding null meeting
*/
public class MeetingCalendar {

    private int id;
    private String title;
    private String username;
    private List<Meeting> meetings;


    public MeetingCalendar(int id, String title, String username) {
        this(title, username);
        this.id = id;
    }
    public MeetingCalendar(String title, String username) {
        this(title);
        this.username = username;
    }
    public MeetingCalendar(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Meeting> getMeetings() {
        if (meetings == null) {meetings = new ArrayList<>();}
        return meetings;
    }

    public void addMeeting(Meeting meeting){
        if (meetings == null){meetings = new ArrayList<>();}
        if (meeting == null) throw new IllegalArgumentException("meeting is null");

        meeting.setMeetingCalendar(this);
        meetings.add(meeting);
    }
    public void addMeeting(List<Meeting> meetings){} // TODO - Impl


    public void removeMeeting(Meeting meeting){
        if (meetings == null) throw new IllegalArgumentException("Meetings was null");
        if (meeting == null) throw new IllegalArgumentException("meeting is null");

        meetings.remove(meeting);
        meeting.setMeetingCalendar(null); // TODO - Question? allow orphan meetings?
    }

    public void removeMeeting(List<Meeting> meetings){} // TODO - Impl

    public String meetingCalendarInfo() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MeetingCalender Info: ").append('\n');
        sb.append("id: ").append(id).append('\n');
        sb.append("title: ").append(title).append('\n');
        sb.append("username: ").append(username).append('\n');
        //sb.append("meetings ").append(meetings).append('\n'); // TODO - Try Recursive behavior - No
        return sb.toString();
    }



}
