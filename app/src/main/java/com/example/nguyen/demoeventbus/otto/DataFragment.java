package com.example.nguyen.demoeventbus.otto;

/**
 * Created by NGUYEN on 1/31/2017.
 */

public class DataFragment {
    private String title;
    private String description;

    public DataFragment(String title, String description) {
        this.title = title;
        this.description = description;
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
