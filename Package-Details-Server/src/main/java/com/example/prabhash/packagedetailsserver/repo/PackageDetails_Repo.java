package com.example.prabhash.packagedetailsserver.repo;

import com.example.prabhash.packagedetailsserver.entity.PackageDetail_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageDetails_Repo extends JpaRepository<PackageDetail_entity,String> {
}
