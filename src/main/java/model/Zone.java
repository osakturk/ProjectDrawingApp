package model;

public class Zone {
    private String zoneNo;
    private String zoneInfo;

    public String getZoneId() {
        return zoneNo;
    }

    public void setZoneId(String zoneNo) {
        this.zoneNo = zoneNo;
    }

    public String getZoneInfo() {
        return zoneInfo;
    }

    public void setZoneInfo(String zoneInfo) {
        this.zoneInfo = zoneInfo;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "zoneNo='" + zoneNo + '\'' +
                ", zoneInfo='" + zoneInfo + '\'' +
                '}';
    }
}
