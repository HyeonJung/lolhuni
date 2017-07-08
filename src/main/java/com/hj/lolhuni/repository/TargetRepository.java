package com.hj.lolhuni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hj.lolhuni.model.Target;
import com.hj.lolhuni.model.TargetPk;

public interface TargetRepository extends JpaRepository<Target, TargetPk> {

	List<Target> findBySummonerId(long summonerId);
}
