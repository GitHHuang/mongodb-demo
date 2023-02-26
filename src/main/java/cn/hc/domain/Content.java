package cn.hc.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "content")
public class Content implements Serializable {
    @Id
    private String id;

    private String title;

    private String desc;

    private String author;

    private Integer count;
}
