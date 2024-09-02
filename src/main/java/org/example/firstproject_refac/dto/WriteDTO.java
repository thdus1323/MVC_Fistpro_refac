package org.example.firstproject_refac.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.example.firstproject_refac.entity.Board;

@AllArgsConstructor
@ToString
public class WriteDTO {
    private Long id;
    private String title;
    private String content;


    public Board toEntity() {
        return new Board(id, title, content);
    }
}
