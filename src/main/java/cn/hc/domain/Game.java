package cn.hc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "game")
public class Game implements Serializable {
    @Id
    private String id;

    private String name;

    private String enName;

    private String developer;

    private Float score;

    private Integer sales;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

}
