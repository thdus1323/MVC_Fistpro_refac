package org.example.firstproject_refac.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.firstproject_refac.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    //글쓰기폼
    @GetMapping("/boards")
    public String writeBoardForm(){
        return "/boards/write";
    }


}
