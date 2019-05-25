package model;
import java.util.List;

public class Panel {
    private int number;
    private String name;
    private List<Loop> loopList;
    private int nodeType;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loop> getLoopList() {
        return loopList;
    }

    public void setLoopList(List<Loop> loopList) {
        this.loopList = loopList;
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    @Override
    public String toString() {
        return "Panel{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", loopList=" + loopList +
                ", nodeType=" + nodeType +
                '}';
    }
}
