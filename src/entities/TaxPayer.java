package entities;

public class TaxPayer {

	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer() {		
	}
	
	public TaxPayer(Double salaryIncome, 
			Double servicesIncome, 
			Double capitalIncome, 
			Double healthSpending,
			Double educationSpending) {
		
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public Double salaryTax() {
		
		double tax = 0.0;
		double monthlySalary = this.getSalaryIncome() / 12;
		
		if (monthlySalary < 3000.0) {
			tax = 0.0; 
		}
		else if (monthlySalary >= 3000.00 && monthlySalary < 5000.00) {
			tax = this.getSalaryIncome() * 0.10;
		}
		else {
			tax = this.getSalaryIncome() * 0.20;
		}
		
		return tax;
	}
	
	public Double servicesTax() {
		return this.getServicesIncome() * 0.15;
	}
	
	public Double capitalTax() {
		return this.getCapitalIncome() * 0.20;
	}
	
	public Double grossTax() {
		return this.salaryTax() + this.servicesTax() + this.capitalTax();
	}
	
	public Double taxRebate() {
		Double grossTax = this.grossTax();
		Double spendings = this.healthSpending + this.educationSpending;
		
		if (spendings < (grossTax * 0.30)) {
			return spendings;
		}
		else {
			return grossTax * 0.30;
		}
	}
	
	public Double netTax() {
		return this.grossTax() - this.taxRebate();
	}
}
