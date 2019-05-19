package model;

import java.util.List;

public class Loop {
    private String loopNumber;
    private String address;
    private String loopName;
    private List<Point> points;

    public String getLoopNumber() {
        return loopNumber;
    }

    public void setLoopNumber(String loopNumber) {
        this.loopNumber = loopNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoopName() {
        return loopName;
    }

    public void setLoopName(String loopName) {
        this.loopName = loopName;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
