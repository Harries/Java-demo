package com.et;

import com.deepoove.poi.data.NumberingRenderData;

public class ExperienceData {
    private String company;
    private String department;
    private String time;
    private String position;
    private NumberingRenderData responsibility;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public NumberingRenderData getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(NumberingRenderData responsibility) {
        this.responsibility = responsibility;
    }

}