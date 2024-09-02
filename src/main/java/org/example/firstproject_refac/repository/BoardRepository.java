package org.example.firstproject_refac.repository;

import org.example.firstproject_refac.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BoardRepository extends CrudRepository<Board, Long> {
    //글쓰기

    //목록조회

    @Override
    ArrayList<Board> findAll();
}
