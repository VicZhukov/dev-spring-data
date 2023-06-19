package ua.goit.vic.note;


import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Note {
    private long id;
    private String title;
    private String content;
}
