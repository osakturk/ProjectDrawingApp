package model;

import java.util.Date;
import java.util.List;

public class Project {
    private Long   id;
    private String name;
    // image ??
    /**
     * We need to learn how can we create an image properties ? Is this only location or not?
     * */
    private Date   createDate;
    private Integer status;
    private List<Alarm> alarmList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Alarm> getAlarmList() {
        return alarmList;
    }

    public void setAlarmList(List<Alarm> alarmList) {
        this.alarmList = alarmList;
    }
}
