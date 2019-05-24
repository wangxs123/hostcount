package cn.demo.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
/**
 * @author
 */
@Entity
@Data
@Table(name="excel_tab")
public class HostRow {

    public HostRow() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String excelId;

    @CreatedDate
    @Column(name = "update_date")
    private Date updateDate;

    private String regex;

    private String hostType;

    private String host;

    private String name;

    private String sourceName;

    private String sourceType;

    private String class1;

    private String subclass1;

    private String subclass2;

    private Integer status;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExcelId() {
        return excelId;
    }

    public void setExcelId(String excelId) {
        this.excelId = excelId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getHostType() {
        return hostType;
    }

    public void setHostType(String hostType) {
        this.hostType = hostType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getSubclass1() {
        return subclass1;
    }

    public void setSubclass1(String subclass1) {
        this.subclass1 = subclass1;
    }

    public String getSubclass2() {
        return subclass2;
    }

    public void setSubclass2(String subclass2) {
        this.subclass2 = subclass2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
