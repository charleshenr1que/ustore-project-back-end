package com.charlesproject.ustoreproject.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlesproject.ustoreproject.model.entities.Item;
import com.charlesproject.ustoreproject.repository.ItemRepository;

@Service
public class ItensService {

	@Autowired
	private ItemRepository repository;

	public List<Item> findAll() {
		return repository.findAll();
	}

	public Map<String, BigDecimal> calculateUsageByRegion() {
		String[] regions = { "ap-south-1", "eu-west-1", "ap-northeast-2", "ap-northeast-1", "sa-east-1",
				"ap-southeast-1", "ap-southeast-2", "eu-central-1", "us-east-1", "us-east-2", "us-west-1",
				"us-west-2" };
		Map<String, BigDecimal> usageByRegion = new HashMap<>();

		for (String region : regions) {
			List<Item> itensRegion = findAll().stream().filter(item -> item.getProductRegion().contains(region))
					.collect(Collectors.toList());

			BigDecimal usageAmount = new BigDecimal(0);

			for (Item item : itensRegion) {
				usageAmount = usageAmount.add(item.getUsageAmount());
			}
			usageByRegion.put(region, usageAmount);
		}

		return usageByRegion;

	}

	public Map<String, BigDecimal> calculateCostByProductCode() {
		String[] productsCode = { "AmazonS3", "AWSDataTransfer", "AWSELB", "AmazonCloudWatch", "AWSCloudTrail",
				"AmazonEC2", "AWSQueueService" };
		Map<String, BigDecimal> costByProductCode = new HashMap<>();

		for (String productCode : productsCode) {
			List<Item> itensProductCode = findAll().stream()
					.filter(item -> item.getProductCode().contains(productCode)).collect(Collectors.toList());

			BigDecimal unblendedCost = new BigDecimal(0);

			for (Item item : itensProductCode) {
				unblendedCost = unblendedCost.add(item.getUnblendedCost());
			}
			costByProductCode.put(productCode, unblendedCost);
		}

		return costByProductCode;

	}

	public List<Map<String, BigDecimal>> costByDays() {

		List<Map<String, BigDecimal>> listCostByDays = repository.findAllDays();

		return listCostByDays;

	}
	
	public BigDecimal totalUnblendedCost() {
		BigDecimal totalUnblended = repository.findTotalUnblendedCost();
		
		return totalUnblended;
	}
	
	public List<Map<String, List<BigDecimal>>> costByDays2() {

		List<Map<String, List<BigDecimal>>> listCostByDays = repository.tableUsageType();

		return listCostByDays;

	}
	
	public BigDecimal totalUsage() {
		BigDecimal big = repository.totalUsage();
		return big;
		
	}
	
}
