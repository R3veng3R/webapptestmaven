package main.com.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alex on 13.12.2015.
 */
public class Event {
    private int recordId;
    private String recordEventId;
    private String eventName;
    private String recordDate;
    private int callId;

    @Override
    public String toString() {
        return "Event{" +
                "recordId=" + recordId +
                ", recordEventId='" + recordEventId + '\'' +
                ", recordDate='" + recordDate + '\'' +
                '}';
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getRecordEventId() {
        return recordEventId;
    }

    public void setRecordEventId(String recordEventId) {
        this.recordEventId = recordEventId;
    }

    public String getRecordDate() throws ParseException {
        Date temp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(this.recordDate);
        String formatted = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(temp);
        return formatted;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }
}
