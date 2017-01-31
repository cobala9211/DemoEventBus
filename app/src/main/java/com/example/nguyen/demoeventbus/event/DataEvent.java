package com.example.nguyen.demoeventbus.event;

/**
 * Created by NGUYEN on 1/31/2017.
 */

public class DataEvent {
    private String title;
    private int count;

    public DataEvent(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
