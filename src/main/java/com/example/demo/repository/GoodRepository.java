package com.example.demo.repository;

import com.example.demo.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GoodRepository extends JpaRepository<Good, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update t_good set num = num -1 where id = ?1", nativeQuery = true)
    void num1(Integer gid);
}
