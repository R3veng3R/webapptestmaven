package main.com.controllers;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import main.com.models.Event;
import main.com.models.EventService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Alex on 13.12.2015.
 */
public class AjaxController extends ActionSupport {
    private InputStream inputStream;
    private int id;
    private List<Event> events;

    public String execute() throws Exception {
        EventService es = new EventService();
        events = es.getEventsByCallId(this.id);

        Gson gson = new Gson();
        String json = gson.toJson(events);

        inputStream = new ByteArrayInputStream(json.getBytes("UTF-8"));
        return SUCCESS;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
