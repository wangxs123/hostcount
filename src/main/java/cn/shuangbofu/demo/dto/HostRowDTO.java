package cn.shuangbofu.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class HostRowDTO {

    private String url;

    @JsonProperty("name")
    private String name;

    @JsonProperty("source_name")
    private String sourceName;

    @JsonProperty("source_type")
    private String sourceType;

    private String class1;

    private String subclass1;

    private String subclass2;
}
