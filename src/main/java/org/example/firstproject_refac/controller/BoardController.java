package org.example.firstproject_refac.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.firstproject_refac.dto.WriteDTO;
import org.example.firstproject_refac.entity.Board;
import org.example.firstproject_refac.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    //글쓰기폼
    @GetMapping("/boards/writeForm")
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
        return "redirect:/boards/" + savedBoard.getId();
    }

    //글 조회_낱개로 상세보기
    @GetMapping("/boards/{id}")
    public String detail(@PathVariable Long id, Model model){
        log.info("id = " + id);
        //db에 id 조회해서 해당 글 가져와
        Board boardEntity = boardRepository.findById(id).orElse(null);
        //가져온 데이터 모델에 등록
        model.addAttribute("boardEntity", boardEntity);
        //모델 통해 뷰 페이지 반환
        return "boards/detail";
    }

    //글 조회_목록보기
    @GetMapping("/boards")
    public String index(Model model){
        //db에서 모든 boards 가져오기
        List<Board> boardEntityList =boardRepository.findAll();
        //가져온 boards 묶음을 모델에 등록
        model.addAttribute("boardEntityList", boardEntityList);
        //모델을 통해 뷰 페이지 반환
        return "boards/index";
    }

    //수정하기 폼
    @GetMapping("boards/{id}/updateForm")
    public String updateForm(@PathVariable Long id, Model model){
        //수정할 데이터 가져오기
        Board boardEntity = boardRepository.findById(id).orElse(null);

        // 모델에 넣기
        model.addAttribute("boardEntity", boardEntity);

        //뷰 페이지 반환
        return "boards/update";
    }

    //수정하기
    @PostMapping("/boards/edit")
    public String edit(WriteDTO writeDTO){
        log.info(writeDTO.toString());
        //dto를 엔티티로 변환
        Board boardEntity = writeDTO.toEntity();
        log.info(boardEntity.toString());

        //엔티티를 db에 저장
            //db에서 기존 데이터 가져오기
                Board entityB = boardRepository.findById(boardEntity.getId()).orElse(null);
            //기존 데이터 값 갱신
                if (entityB != null){
                    boardRepository.save(boardEntity);
                }
        //수정된 해당 페이지로 리다이렉트
        return "redirect:/boards/"+boardEntity.getId();
    }

}
