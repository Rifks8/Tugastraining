package com.example.demo.dao;

import com.example.demo.entity.TugasEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TugasDao extends JpaRepository<TugasEntity, Long> {

    @Query("SELECT j FROM tugasEntity j WHERE (:username IS NULL OR lower(j.username) LIKE lower(:username) )")
    Page<TugasEntity> findByNama(String username, Pageable page);

}
