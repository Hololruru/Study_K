package com.demoweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demoweb.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

	List<BoardEntity> findAllByOrderByBoardNoDesc();
	
	@Query(value = "SELECT * FROM tbl_board ORDER BY board_no DESC LIMIT :from, :count",
		   nativeQuery = true)
	List<BoardEntity> findAllWithPage(@Param("from") int from, @Param("count") int count);	
	long countBy();
	
	BoardEntity findByBoardNo(int boardNo);	
	
}
