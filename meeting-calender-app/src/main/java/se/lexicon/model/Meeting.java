package se.lexicon.model;

import java.time.LocalDateTime;

/*
    Constructors
    title, start, end, description
    title, start, end, description, calendar

    id, title, start, end, description, calendar

    - Validate that meeting end is not before start.

     */
public class Meeting {
    private int id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String description;
    private MeetingCalendar meetingCalendar;


    public Meeting(String title, LocalDateTime startTime, LocalDateTime endTime, String description) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.timeValidation();
    }

    public Meeting(int id, String title, LocalDateTime startTime, LocalDateTime endTime, String description, MeetingCalendar meetingCalendar) {
        this(title, startTime, endTime, description);
        this.id = id;
        this.meetingCalendar = meetingCalendar;
    }

    public Meeting(String title, LocalDateTime startTime, LocalDateTime endTime, String description, MeetingCalendar meetingCalendar) {
        this(title, startTime, endTime, description);
        this.meetingCalendar = meetingCalendar;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MeetingCalendar getMeetingCalendar() {
        return meetingCalendar;
    }

    public void setMeetingCalendar(MeetingCalendar meetingCalendar) {
        this.meetingCalendar = meetingCalendar;
    }

    public String meetingInfo() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Meeting Info: ").append('\n');
        sb.append("id: ").append(id).append('\n');
        sb.append("title: ").append(title).append('\n');
        sb.append("StartTime: ").append(startTime).append('\n');
        sb.append("EndTime:  ").append(endTime).append('\n');
        sb.append("Description: ").append(description).append('\n');
        sb.append("Calendar: ").append((meetingCalendar != null) ? meetingCalendar.meetingCalendarInfo() :" ").append('\n');
        return sb.toString();
    }
    private void timeValidation(){
        if (this.endTime.isBefore(this.startTime)) throw new IllegalArgumentException(("End time must be before the start time."));
        if(this.startTime.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("the meeting should start at the future ");
    }
}
