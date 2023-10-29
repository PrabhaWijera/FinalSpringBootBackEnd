package com.example.prabhash.packagedetailsserver.repo;

import com.example.prabhash.packagedetailsserver.entity.PackageDetail_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageDetails_Repo extends JpaRepository<PackageDetail_entity,String> {

    @Query("SELECT p.packageID from PackageDetail_entity p order by p.packageID DESC ")
    List<Integer> getAllID();
}
