package com.charlesproject.ustoreproject.resources;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charlesproject.ustoreproject.model.entities.Item;
import com.charlesproject.ustoreproject.repository.ItemRepository;
import com.charlesproject.ustoreproject.services.ItensService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/itens")
public class ItemController {

	@Autowired
	private ItensService service;
	

	@GetMapping
	public ResponseEntity<List<Item>> findAll() {
		List<Item> item = service.findAll();

		return ResponseEntity.ok().body(item);
	}

	@GetMapping("/cost-by-product-code")
	public ResponseEntity<Map<String, BigDecimal>> costByProductCode() {
		Map<String, BigDecimal> costByProductCode = service.calculateCostByProductCode();

		return ResponseEntity.ok().body(costByProductCode);

	}

	@GetMapping("/usage-regions")
	public ResponseEntity<Map<String, BigDecimal>> usageRegions() {
		Map<String, BigDecimal> usageByRegion = service.calculateUsageByRegion();

		return ResponseEntity.ok().body(usageByRegion);

	}

	@GetMapping("/cost-by-days")
	public ResponseEntity<List<Map<String, BigDecimal>>> costByDays() {
		List<Map<String, BigDecimal>> listCostByDays = service.costByDays();

		return ResponseEntity.ok().body(listCostByDays);
	}
	
	@GetMapping("/total-unblended-cost")
	public ResponseEntity<BigDecimal> totalUnblendedCost() {
		BigDecimal totalUnblendedCost = service.totalUnblendedCost();

		return ResponseEntity.ok().body(totalUnblendedCost);
	}
	
	@GetMapping("/table-service")
	public ResponseEntity<List<Map<String, List<BigDecimal>>>> tableService() {
		List<Map<String, List<BigDecimal>>> table = service.costByDays2();

		return ResponseEntity.ok().body(table);
	}
	
	@GetMapping("/total-usage")
	public ResponseEntity<BigDecimal> totalUsage(){
		BigDecimal big = service.totalUsage();
		
		return ResponseEntity.ok().body(big);
		
	}
}
