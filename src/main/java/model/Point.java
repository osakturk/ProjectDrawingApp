package model;

public class Point {
    private Long id;
    private String level;
    private String address;
    private String label;
    private String loop;
    private String deviceType;
    private String analogValue;
    private String description;
    private String zoneInfo;
    private double xLocation;
    private double yLocation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getAnalogValue() {
        return analogValue;
    }

    public void setAnalogValue(String analogValue) {
        this.analogValue = analogValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getZoneInfo() {
        return zoneInfo;
    }

    public void setZoneInfo(String zoneInfo) {
        this.zoneInfo = zoneInfo;
    }

    @Override
    public String toString() {
        return "Point{" +
                ", address='" + address + '\'' +
                ", label='" + label + '\'' +
                ", loop='" + loop + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", zoneInfo='" + zoneInfo + '\'' +
                '}';
    }
}
