package com.example.prabhash.guideserver.repo;

import com.example.prabhash.guideserver.entity.Guide_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepo extends JpaRepository<Guide_entity,String> {
}
