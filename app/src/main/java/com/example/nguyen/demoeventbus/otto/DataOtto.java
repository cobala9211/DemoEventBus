package com.example.nguyen.demoeventbus.otto;

import java.io.Serializable;

/**
 * Created by NGUYEN on 1/30/2017.
 */

public class DataOtto implements Serializable {
    private String title;
    private int count;

    public DataOtto(String title, int count) {
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
