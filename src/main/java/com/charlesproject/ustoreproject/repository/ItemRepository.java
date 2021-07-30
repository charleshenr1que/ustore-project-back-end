package com.charlesproject.ustoreproject.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.charlesproject.ustoreproject.model.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query(value = "SELECT CAST(usage_start_date AS DATE), SUM(unblended_cost) FROM tb_itens GROUP BY CAST(usage_start_date AS DATE) ORDER BY 1", nativeQuery = true)
	List<Map<String, BigDecimal>> findAllDays();
	
	@Query(value = "SELECT SUM(unblended_cost) FROM tb_itens", nativeQuery=true)
	BigDecimal findTotalUnblendedCost();
	
	@Query(value = "SELECT usage_type, SUM(unblended_cost) as unblended_cost, SUM(usage_amount) as usage_amount FROM tb_itens GROUP BY usage_type order by 2", nativeQuery = true)
	List<Map<String, List<BigDecimal>>> tableUsageType ();
	
	@Query(value = "SELECT sum(usage_amount) FROM tb_itens", nativeQuery = true)
	BigDecimal totalUsage();

}

