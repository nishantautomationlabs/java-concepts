package com.nal.copyconstructor;

/**
 * Created by Nishant on 02-11-2018.
 */
public class Tool {

    public Tool(String name, String type) {
        this.name = name;
        this.type = type;
    }

    private String name;
    private String type;

    public Tool(Tool copy) {
        this.name = copy.name;
        this.type = copy.type;
    }

    public Tool() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
