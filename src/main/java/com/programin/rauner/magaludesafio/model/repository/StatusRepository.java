package com.programin.rauner.magaludesafio.model.repository;

import com.programin.rauner.magaludesafio.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
