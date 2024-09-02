package org.example.firstproject_refac.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.firstproject_refac.dto.WriteDTO;
import org.example.firstproject_refac.entity.Board;
import org.example.firstproject_refac.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    //기능-글쓰기
    @PostMapping("/boards/write")
    public String writeBoard(WriteDTO writeDTO){  //dto로 받고
        log.info(writeDTO.toString());
        //엔티티로 변환
        Board board = writeDTO.toEntity();
        log.info(board.toString());
        //,리파지로 엔티티를 db에 저장
        Board savedBoard = boardRepository.save(board);
        log.info(savedBoard.toString());
        return "";
    }


}
