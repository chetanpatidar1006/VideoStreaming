package com.harman.harman.repository;


import com.harman.harman.model.VideoDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoDetailRepo   extends JpaRepository<VideoDetail, Integer>  , JpaSpecificationExecutor<VideoDetail > {
}
