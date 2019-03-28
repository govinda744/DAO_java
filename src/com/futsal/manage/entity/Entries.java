package com.futsal.manage.entity;

public class Entries {

    private int id;
    private String teamName;
    private int startTime;
    private int endTime;
    private String contact;
    private int futsalId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getFutsalId() {
        return futsalId;
    }

    public void setFutsalId(int futsalId) {
        this.futsalId = futsalId;
    }
}
