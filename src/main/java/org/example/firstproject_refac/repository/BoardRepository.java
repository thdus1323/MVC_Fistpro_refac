package org.example.firstproject_refac.repository;

import org.example.firstproject_refac.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
