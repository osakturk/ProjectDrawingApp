package model;

import java.util.Date;
import java.util.List;

public class Project {
    private Long   id;
    private String name;
    private Date   createDate;
    private Integer status;
    private List<Panel> panelList;
    private byte[] xmlFile;
    private byte[] planImage;

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

    public List<Panel> getPanelList() {
        return panelList;
    }

    public void setPanelList(List<Panel> panelList) {
        this.panelList = panelList;
    }

    public byte[] getXmlFile() {
        return xmlFile;
    }

    public void setXmlFile(byte[] xmlFile) {
        this.xmlFile = xmlFile;
    }

    public byte[] getPlanImage() {
        return planImage;
    }

    public void setPlanImage(byte[] planImage) {
        this.planImage = planImage;
    }
}
