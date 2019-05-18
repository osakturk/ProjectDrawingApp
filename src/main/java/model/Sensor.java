package model;

import java.util.Date;

public class Sensor {

    private Long id;
    private String level;
    private String label;
    private String description;
    private String address;
    private String loopNumber;
    private String analogValue;
    private Date setTime;
    private double xLocation;
    private double yLocation;
    private Long projectId;
    private int type;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getxLocation() {
        return xLocation;
    }

    public void setxLocation(double xLocation) {
        this.xLocation = xLocation;
    }

    public double getyLocation() {
        return yLocation;
    }

    public void setyLocation(double yLocation) {
        this.yLocation = yLocation;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoopNumber() {
        return loopNumber;
    }

    public void setLoopNumber(String loopNumber) {
        this.loopNumber = loopNumber;
    }

    public String getAnalogValue() {
        return analogValue;
    }

    public void setAnalogValue(String analogValue) {
        this.analogValue = analogValue;
    }
}
