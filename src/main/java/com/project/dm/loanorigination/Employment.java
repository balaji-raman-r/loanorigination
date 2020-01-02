package com.project.dm.loanorigination;

import java.math.BigDecimal;

public class Employment {
	
	private EmploymentType employmentType;
	private BigDecimal income;
	/**
	 * @return the employmentType
	 */
	public EmploymentType getEmploymentType() {
		return employmentType;
	}
	/**
	 * @param employmentType the employmentType to set
	 */
	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}
	/**
	 * @return the income
	 */
	public BigDecimal getIncome() {
		return income;
	}
	/**
	 * @param income the income to set
	 */
	public void setIncome(BigDecimal income) {
		this.income = income;
	}

}
