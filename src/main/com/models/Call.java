package main.com.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alex on 12.12.2015.
 */
public class Call {

    private int recordId;
    private String recordDate;
    private int caller;
    private int receiver;
    private String eventName;

    @Override
    public String toString() {
        return "Call{" +
                "recordId=" + recordId +
                ", recordDate='" + recordDate + '\'' +
                ", caller=" + caller +
                ", receiver=" + receiver +
                ", eventName='" + eventName + '\'' +
                '}';
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getRecordDate() throws ParseException {
        Date temp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(this.recordDate);
        String formatted = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(temp);
        return formatted;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public int getCaller() {
        return caller;
    }

    public void setCaller(int caller) {
        this.caller = caller;
    }

    public String getReceiver() {
        if (this.receiver == 0)
            return "";

        return Integer.toString(this.receiver);
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
