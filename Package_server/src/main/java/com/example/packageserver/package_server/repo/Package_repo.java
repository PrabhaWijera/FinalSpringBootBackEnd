package com.example.packageserver.package_server.repo;

import com.example.packageserver.package_server.entity.Package_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Package_repo extends JpaRepository<Package_entity,String> {
}
