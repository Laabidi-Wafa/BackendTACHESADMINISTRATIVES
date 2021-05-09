package com.stagepfe.cni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.stagepfe.cni.models.DemandePermis;



public interface DemandePermisRepository extends JpaRepository<DemandePermis, Long>{
	List<DemandePermis> findByUserId(Long userId);
}
