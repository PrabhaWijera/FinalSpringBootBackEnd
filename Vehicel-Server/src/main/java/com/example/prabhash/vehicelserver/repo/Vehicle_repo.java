package com.example.prabhash.vehicelserver.repo;

import com.example.prabhash.vehicelserver.entity.Vehicle_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Vehicle_repo extends JpaRepository<Vehicle_entity,String> {
}
