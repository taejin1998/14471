package com.back;

public class Rq {

    private String action;

    public Rq(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        action = cmdBits[0];
    }

    public String getAction() {
        return action;
    }
}
