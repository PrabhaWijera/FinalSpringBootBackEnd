package com.example.prabhash.hotelserver.repo;

import com.example.prabhash.hotelserver.entity.Hotel_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Hotel_repo extends JpaRepository<Hotel_entity,String> {
}
