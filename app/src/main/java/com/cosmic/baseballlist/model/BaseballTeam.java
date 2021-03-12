package com.cosmic.baseballlist.model;

import java.io.Serializable;

public class BaseballTeam implements Serializable {

    private static final long serialVersionUID = -1213949467658913456L;

    private String team_name, hometown, stadium_name, record, stadium_url, description;

    public BaseballTeam() {

    }

    public BaseballTeam(String team_name, String hometown, String stadium_name, String record, String stadium_url, String description) {
        this.team_name = team_name;
        this.hometown = hometown;
        this.stadium_name = stadium_name;
        this.record = record;
        this.stadium_url = stadium_url;
        this.description = description;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getStadium_name() {
        return stadium_name;
    }

    public void setStadium_name(String stadium_name) {
        this.stadium_name = stadium_name;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getStadium_url() {
        return stadium_url;
    }

    public void setStadium_url(String stadium_url) {
        this.stadium_url = stadium_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BaseballTeam{" +
                "team_name='" + team_name + '\'' +
                ", hometown='" + hometown + '\'' +
                ", stadium_name='" + stadium_name + '\'' +
                ", record='" + record + '\'' +
                ", stadium_url='" + stadium_url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
