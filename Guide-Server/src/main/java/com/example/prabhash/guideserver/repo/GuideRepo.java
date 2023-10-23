package com.example.prabhash.guideserver.repo;

import com.example.prabhash.guideserver.entity.Guide_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuideRepo extends JpaRepository<Guide_entity,String> {
    Optional<Guide_entity> findByGuideName(String guideName);
}
