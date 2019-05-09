package model;

import java.util.Date;

public class Alarm {
    private Long id;
    private String level;
    private String label;
    private Date setTime;
    private String xLocation;
    private String yLocation;
    private Long projectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getSetTime() {
        return setTime;
    }

    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }

    public String getxLocation() {
        return xLocation;
    }

    public void setxLocation(String xLocation) {
        this.xLocation = xLocation;
    }

    public String getyLocation() {
        return yLocation;
    }

    public void setyLocation(String yLocation) {
        this.yLocation = yLocation;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
