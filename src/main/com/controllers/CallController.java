package main.com.controllers;

import com.opensymphony.xwork2.ActionSupport;
import main.com.models.Call;
import main.com.models.CallService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 12.12.2015.
 */
public class CallController extends ActionSupport {
    private List<Call> calls;
    private CallService callService;

    public String execute() throws Exception {
        calls = new ArrayList<Call>();
        calls = callService.getAllCalls();

       return SUCCESS;
    }

//    public List<Call> getCalls() {
//        return calls;
//    }
//
//    public void setCalls(List<Call> calls) {
//        this.calls = calls;
//    }

    public CallService getCallService() {
        return callService;
    }

    public void setCallService(CallService callService) {
        this.callService = callService;
    }
}
