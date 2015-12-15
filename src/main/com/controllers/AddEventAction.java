package main.com.controllers;

import com.opensymphony.xwork2.ActionSupport;
import main.com.models.CallService;
import main.com.models.Call;
import main.com.models.Event;
import main.com.models.EventService;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by Alex on 12.12.2015.
 */
public class AddEventAction extends ActionSupport {
    private InputStream inputStream;
    private static Random rnd = new Random();

    public String execute() throws Exception {
        String[] evenTypes = {
                "EVENT_PICK_UP",
                "EVENT_DIAL",
                "EVENT_CALL_ESTABLISHED",
                "EVENT_CALL_END",
                "EVENT_HANG_UP",
        };

        int numberOfEvents = rnd.nextInt(5);
        int caller = this.getRandomNumber();
        int receiver = this.getRandomNumber();

        CallService cs = new CallService();
        Call call = new Call();
        call.setCaller(caller);
        call.setReceiver(receiver);
        cs.insertCall(call);

        EventService es = new EventService();
        Event e = new Event();
        for (int i = 0; i < numberOfEvents; i++) {
            e.setRecordEventId(evenTypes[i]);
            e.setCallId(call.getRecordId());
            es.insertEvent(e);
        }

        if (numberOfEvents == 0) {
            e.setRecordEventId(evenTypes[4]);
            e.setCallId(call.getRecordId());
            es.insertEvent(e);
        }

        inputStream = new ByteArrayInputStream("success".getBytes("UTF-8"));
        return SUCCESS;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    private int getRandomNumber() {
        int[][] phoneRange = {
            {300000, 399999}, {500000, 599999}, {800000, 899999}
        };

        int range = rnd.nextInt(3);
        return rnd.nextInt(phoneRange[range][1] - phoneRange[range][0]) + phoneRange[range][0];
    }
}
