package com.charlesproject.ustoreproject.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_itens")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	private String lineItemId;
	@Column(precision = 27, scale = 10)
	private BigDecimal unblendedRate;
	@Column(precision = 27, scale = 10)
	private BigDecimal unblendedCost;
	private Date usageStartDate;
	private Date usageEndDate;
	private String productCode;
	private String operation;
	private String usageType;
	@Column(precision = 27, scale = 10)
	private BigDecimal usageAmount;
	private String productRegion;

	public Item() {

	}

	public Item(Long id, String lineItemId, BigDecimal unblendedRate, BigDecimal unblendedCost, Date usageStartDate,
			Date usageEndDate, String productCode, String operation, String usageType, BigDecimal usageAmount,
			String productRegion) {
		super();
		this.id = id;
		this.lineItemId = lineItemId;
		this.unblendedRate = unblendedRate;
		this.unblendedCost = unblendedCost;
		this.usageStartDate = usageStartDate;
		this.usageEndDate = usageEndDate;
		this.productCode = productCode;
		this.operation = operation;
		this.usageType = usageType;
		this.usageAmount = usageAmount;
		this.productRegion = productRegion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLineItemId() {
		return lineItemId;
	}

	public void setLineItemId(String lineItemId) {
		this.lineItemId = lineItemId;
	}

	public BigDecimal getUnblendedRate() {
		return unblendedRate;
	}

	public void setUnblendedRate(BigDecimal unblendedRate) {
		this.unblendedRate = unblendedRate;
	}

	public BigDecimal getUnblendedCost() {
		return unblendedCost;
	}

	public void setUnblendedCost(BigDecimal unblendedCost) {
		this.unblendedCost = unblendedCost;
	}

	public Date getUsageStartDate() {
		return usageStartDate;
	}

	public void setUsageStartDate(Date usageStartDate) {
		this.usageStartDate = usageStartDate;
	}

	public Date getUsageEndDate() {
		return usageEndDate;
	}

	public void setUsageEndDate(Date usageEndDate) {
		this.usageEndDate = usageEndDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getUsageType() {
		return usageType;
	}

	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}

	public BigDecimal getUsageAmount() {
		return usageAmount;
	}

	public void setUsageAmount(BigDecimal usageAmount) {
		this.usageAmount = usageAmount;
	}

	public String getProductRegion() {
		return productRegion;
	}

	public void setProductRegion(String productRegion) {
		this.productRegion = productRegion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lineItemId, operation, productCode, unblendedCost, unblendedRate, usageAmount,
				usageEndDate, usageStartDate, usageType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(id, other.id) && Objects.equals(lineItemId, other.lineItemId)
				&& Objects.equals(operation, other.operation) && Objects.equals(productCode, other.productCode)
				&& Objects.equals(unblendedCost, other.unblendedCost)
				&& Objects.equals(unblendedRate, other.unblendedRate) && Objects.equals(usageAmount, other.usageAmount)
				&& Objects.equals(usageEndDate, other.usageEndDate)
				&& Objects.equals(usageStartDate, other.usageStartDate) && Objects.equals(usageType, other.usageType);
	}

	@Override
	public String toString() {
		return "Itens [id=" + id + ", lineItemId=" + lineItemId + ", unblendedRate=" + unblendedRate
				+ ", unblendedCost=" + unblendedCost + ", usageStartDate=" + usageStartDate + ", usageEndDate="
				+ usageEndDate + ", productCode=" + productCode + ", operation=" + operation + ", usageType="
				+ usageType + "]";
	}

}
