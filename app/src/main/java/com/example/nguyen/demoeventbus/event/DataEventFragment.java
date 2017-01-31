package com.example.nguyen.demoeventbus.event;

/**
 * Created by NGUYEN on 1/31/2017.
 */

public class DataEventFragment {
    private String title;
    private String description;

    public DataEventFragment(String title, String decsription) {
        this.title = title;
        this.description = decsription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
