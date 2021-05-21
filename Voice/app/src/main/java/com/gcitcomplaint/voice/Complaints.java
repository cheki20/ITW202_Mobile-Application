package com.gcitcomplaint.voice;

public class Complaints {
    private String complaint_title, complaint_type, description;

    public Complaints() {
    }

    public Complaints(String complaint_title, String complaint_type, String description) {
        this.complaint_title = complaint_title;
        this.complaint_type = complaint_type;
        this.description = description;
    }

    public String getComplaint_title() {
        return complaint_title;
    }

    public void setComplaint_title(String complaint_title) {
        this.complaint_title = complaint_title;
    }

    public String getComplaint_type() {
        return complaint_type;
    }

    public void setComplaint_type(String complaint_type) {
        this.complaint_type = complaint_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
