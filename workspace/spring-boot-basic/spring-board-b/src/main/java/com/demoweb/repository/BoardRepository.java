package com.demoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoweb.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

}
