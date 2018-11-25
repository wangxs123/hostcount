package cn.shuangbofu.demo.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

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
}
