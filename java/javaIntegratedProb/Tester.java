package javaIntegratedProb;
class Asset {
	//Implement your code here
	private String assetId;
	private String assetName;
	private String assetExpiry;
	public Asset(String assetId, String assetName, String assetExpiry) {
		this.setAssetId(assetId);
		this.assetName = assetName;
		this.assetExpiry = assetExpiry;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		String regex_asset = "[DSKLTPIPH]{3}[-][0-9]{6}(H|L|h|l)";
		if(assetId.matches(regex_asset)){
		this.assetId = assetId;
	}
}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetExpiry() {
		return assetExpiry;
	}
	public void setAssetExpiry(String assetExpiry) {
		this.assetExpiry = assetExpiry;
	}
	
	//Uncomment the code given below after implementing the class
	//Do not modify the code given below
	@Override
	public String toString() {
		return "Asset Id: "+getAssetId()+", Asset Name: "+getAssetName()+", Asset Expiry: "+getAssetExpiry();
	}
}

class Resources {
	//Implement your code here
	public static int getMonth(String month){
		String[] str_month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int index =1;
		for (String mon : str_month) {
			if(mon.equals(month)){
				return index;
			}
			index++;
		}
		return 0;
	}
}

class InvalidAssetsException extends Exception {

	public InvalidAssetsException(String message) {
			super(message);
	}
	//Implement your code here
	
	
}

class InvalidExperienceException extends Exception {

	public InvalidExperienceException(String message) {
		super(message);
	}
	//Implement your code here
	
}

abstract class Employee {
	//Implement your code here
	private String employeeId;
	private String employeeName;
	private double salary;
	private static int contractIdCounter;
	private static int permenantIdCounter;
	static {
		contractIdCounter=10000;
		permenantIdCounter=10000;
	}
	public Employee(String employeeName) {
		this.setEmployeeName(employeeName);
		if(this instanceof PermanentEmployee){
			permenantIdCounter++;
			this.employeeId="E"+permenantIdCounter;
		}
		if(this instanceof ContractEmployee){
			contractIdCounter++;
			this.employeeId="C"+contractIdCounter;
		}
	}
	public abstract void calculateSalary(float salaryFactor) ;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		String regex_employee = "[A-Z][a-z]{1,} [A-Z][a-zA-Z ]+";
		if(employeeName.matches(regex_employee)){
		this.employeeName = employeeName;}
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		if(salary>0){
			this.salary = salary;
		}else this.salary=0;
	}
	public static int getContractIdCounter() {
		return contractIdCounter;
	}
	public static void setContractIdCounter(int contractIdCounter) {
		Employee.contractIdCounter = contractIdCounter;
	}
	public static int getPermenantIdCounter() {
		return permenantIdCounter;
	}
	public static void setPermenantIdCounter(int permenantIdCounter) {
		Employee.permenantIdCounter = permenantIdCounter;
	}
	
	//Uncomment the code given below after implementing the class
	//Do not modify the code given below
	@Override
	public String toString() {
		return "Employee Id: "+getEmployeeId()+", Employee Name: "+getEmployeeName();
	}
}

class ContractEmployee extends Employee {
	public ContractEmployee(String employeeName, double wagePerHour) {
		super(employeeName);
		this.wagePerHour=wagePerHour;
	}

	//Implement your code here
	private double wagePerHour;
	
	public double getWagePerHour() {
		return wagePerHour;
	}

	public void setWagePerHour(double wagePerHour) {
		this.wagePerHour = wagePerHour;
	}

	@Override
	public void calculateSalary(float hoursWorked) {
		
		double salary_loc = wagePerHour*hoursWorked;
		if(hoursWorked<190){
			salary_loc-=((wagePerHour/2)*(190-hoursWorked));
		}else{
			salary_loc = wagePerHour*hoursWorked;
		}
		int salary_rounded =(int) Math.round(salary_loc);
		this.setSalary(salary_rounded);

	}
	
	//Uncomment the code given below after implementing the class
	//Do not modify the code given below
	@Override
	public String toString() {
		return "Employee Id: "+getEmployeeId()+", Employee Name: "+getEmployeeName()+", Wage Per Hour: "+getWagePerHour();
	}
}

class PermanentEmployee extends Employee {
	//Implement your code here
	private double basicPay;
	private String[] salaryComponents;
	private float experience;
	private Asset[] assets;
	public PermanentEmployee(String employeeName, double basicPay, String[] salaryComponents, Asset[] assets) {
		super(employeeName);
		this.basicPay = basicPay;
		this.salaryComponents = salaryComponents;
		this.assets = assets;
	}
	public double calculateBonus(float experience) throws InvalidExperienceException{
		if (experience<2.5){
			throw new InvalidExperienceException("A minimum of 2.5 years is required for bonus!");
		}
		if(experience>=2.5 && experience<4){
			return 2550;
		}
		if(experience>=4 && experience<8){
			return 5000;
		}if(experience>=8 && experience<12){
			return 8750;
		}
		if(experience>=12)return 13000;
		return 0;
	}
	@Override
	public void calculateSalary(float experience) {
		this.experience=experience;
		double bonus_pay;
		try {
			bonus_pay = this.calculateBonus(experience);
		} catch (InvalidExperienceException e) {
			
			bonus_pay=0;
		}
		
		String DA_percent = this.salaryComponents[0].substring(3);
		double DA= Integer.parseInt(DA_percent);
		double DA_comp= this.basicPay*(DA/100);
		String HRA_percent = this.salaryComponents[1].substring(4);
		double HRA= Integer.parseInt(HRA_percent);
		double HRA_comp=this.basicPay*(HRA/100);
		double salary1=this.basicPay+DA_comp+HRA_comp+bonus_pay;
		int salaryInt =(int) Math.round(salary1);
		this.setSalary(salaryInt);

		
	}
	public Asset[] getAssetsByDate(String lastDate) throws InvalidAssetsException{
		int length=this.assets.length;
		int Last_month = Resources.getMonth(lastDate.substring(5, 8));
		String date= lastDate.substring(9);
		int Last_date = Integer.parseInt(date);
		String year= lastDate.substring(0,4);
		int Last_year = Integer.parseInt(year);
		Asset[] return_Assets=new Asset[length];
		int index=0;
		for (Asset i : this.assets) {
			int exp_month= Resources.getMonth(i.getAssetExpiry().substring(5,8));
			String date1 = i.getAssetExpiry().substring(9);
			int exp_date = Integer.parseInt(date1);
			String year1 = i.getAssetExpiry().substring(0,4);
			int exp_year = Integer.parseInt(year1);
			if(exp_year<Last_year) {
				return_Assets[index]=i;
				index++;
			}else if(exp_year>Last_year){
				continue;
			}else {
				if(exp_month<Last_month){
					return_Assets[index]=i;
					index++;
				}else if(exp_month>Last_month){
					continue;
				}else{
					if(exp_date<=Last_date){
						return_Assets[index]=i;
						index++;
					}
				}
			}
			
		}
		if(return_Assets[0]==null){
			throw new InvalidAssetsException("No assets found for the given criteria!");
		}
		System.out.println(return_Assets);
		return return_Assets;
		
	}
	public double getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}
	public String[] getSalaryComponents() {
		return salaryComponents;
	}
	public void setSalaryComponents(String[] salaryComponents) {
		this.salaryComponents = salaryComponents;
	}
	public float getExperience() {
		return experience;
	}
	public void setExperience(float experience) {
		this.experience = experience;
	}
	public Asset[] getAssets() {
		return assets;
	}
	public void setAssets(Asset[] assets) {
		this.assets = assets;
	}
	
	//Uncomment the code given below after implementing the class
	//Do not modify the code given below
	@Override
	public String toString() {
		return "Employee Id: "+getEmployeeId()+", Employee Name: "+getEmployeeName()+", Basic Pay: "+getBasicPay()+", Salary Components: "+getSalaryComponents()+", Assets: "+getAssets();
	}
}

class Admin {
	//Implement your code here
	public void generateSalarySlip(Employee[] employees, float[] salaryFactor){
		int index =0;
		for (Employee emp : employees) {
			emp.calculateSalary(salaryFactor[index]);
			index++;
		}
	}
	public int generateAssetsReport(Employee[] employees, String lastDate){
		int assetCount=0;
		for (Employee emp : employees) {
			if(emp instanceof PermanentEmployee){
				PermanentEmployee pemp = (PermanentEmployee) emp;
				try {
					Asset[] return_assets = pemp.getAssetsByDate(lastDate);
					int length=return_assets.length;
					for (Asset asset2 : return_assets) {
						if(asset2!=null) {
							assetCount++;
					}
				}

				} catch (InvalidAssetsException e) {
					return -1;
				}}
		}
		return assetCount;
	}
	public String[] generateAssetsReport(Employee[] employees, char assetCategory){
		int length = employees.length*3;
		assetCategory= Character.toUpperCase(assetCategory);
		String[] assetIDs = new String[length];
		int index =0;
		for (Employee emp : employees) {
			if(emp instanceof PermanentEmployee){
				PermanentEmployee emp1= (PermanentEmployee) emp;
			for (Asset asset : emp1.getAssets()) {
				String Id= asset.getAssetId();
				char ch= Id.charAt(0);
				ch= Character.toUpperCase(ch);
				if(ch==assetCategory){
					assetIDs[index]=Id;
					index++;
				}
			}
		}
		}
		String[] finalAssetIds = new String[index];
		int index1=0;
		for (String str : assetIDs) {
			if(str!=null){
			finalAssetIds[index1]=str;
			index1++;}
		}
		return assetIDs;

	} 
		
	

}

class Tester{
    public static void main(String[] args) {
    	Admin admin = new Admin();
    	
    	Asset asset1 = null;
    	Asset asset2 = null;
    	Asset asset3 = null;
    	Asset asset4 = null;
    	Asset asset5 = null;
    	Asset asset6 = null;
    	Asset asset7 = null;
    	Asset asset8 = null;
    	Asset asset9 = null;
    	Asset asset10 = null;
    	
    	PermanentEmployee permanentEmployee1 = null;
    	PermanentEmployee permanentEmployee2 = null;
    	PermanentEmployee permanentEmployee3 = null;
    	PermanentEmployee permanentEmployee4 = null;
    	PermanentEmployee permanentEmployee5 = null;
		
		ContractEmployee contractEmployee1 = null;
		ContractEmployee contractEmployee2 = null;
		
		Employee[] employees = null;
		float[] salaryFactor = null;
		
		try {
			asset1 = new Asset("DSK-876761L", "Dell-Desktop", "2020-Dec-01");
	    	asset2 = new Asset("DSK-876762L", "Acer-Desktop", "2021-Mar-31");
	    	asset3 = new Asset("DSK-876763L", "Dell-Desktop", "2022-Jun-12");
	    	asset4 = new Asset("LTP-987123H", "Dell-Laptop", "2021-Dec-31");
	    	asset5 = new Asset("LTP-987124h", "Dell-Laptop", "2021-Sep-20");
	    	asset6 = new Asset("LTP-987125L", "HP-Laptop", "2022-Oct-25");
	    	asset7 = new Asset("LTP-987126l", "HP-Laptop", "2021-Oct-02");
	    	asset8 = new Asset("IPH-110110h", "VoIP", "2021-Dec-12");
	    	asset9 = new Asset("IPH-1101201h", "VoIP", "2020-Dec-31");
	    	asset10 = new Asset("IPH-110130h", "VoIP", "2020-Nov-30");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Details of all available assets");
		System.out.println();
		
		try {
			Asset[] assets = { asset1, asset2, asset3, asset4, asset5, asset6, asset7, asset8, asset9, asset10 };
			int counter = 1;
			for (Asset asset : assets) {
				System.out.println("Details of asset"+counter++);
				System.out.println("\tAsset Id: "+asset.getAssetId());
				System.out.println("\tAsset Name: "+asset.getAssetName());
				System.out.println("\tAsset Valid Till: "+asset.getAssetExpiry());
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Correcting all the invalid assetIds");
		System.out.println();
		
		try {
			asset9.setAssetId("IPH-110120h");
			System.out.println("Details of asset9");
			System.out.println("\tAsset Id: "+asset9.getAssetId());
			System.out.println("\tAsset Name: "+asset9.getAssetName());
			System.out.println("\tAsset Valid Till: "+asset9.getAssetExpiry());
			System.out.println();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			permanentEmployee1 = new PermanentEmployee("Roger Fed", 15500.0, new String[] {"DA-50","HRA-40"}, new Asset[] {asset1, asset10});
			permanentEmployee2 = new PermanentEmployee("Serena W", 14000.0, new String[] {"DA-40","HRA-40"}, new Asset[] {asset6, asset9});
			permanentEmployee3 = new PermanentEmployee("James Peter", 18500.0, new String[] {"DA-50","HRA-45"}, new Asset[] {asset4});
			permanentEmployee4 = new PermanentEmployee("Catherine Maria", 20000.0, new String[] {"DA-50","HRA-45"}, new Asset[] {asset2, asset5});
			permanentEmployee5 = new PermanentEmployee("Jobin Nick", 21000.0, new String[] {"DA-50","HRA-50"}, null);

			contractEmployee1 = new ContractEmployee("Rafael N", 70);			
			contractEmployee2 = new ContractEmployee("Ricky Neol", 72.5);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		System.out.println("Initiating salary calculation...");
		
		try {
			employees = new Employee[] { permanentEmployee1, permanentEmployee2, permanentEmployee3, permanentEmployee4, permanentEmployee5,
					contractEmployee1, contractEmployee2 };
			salaryFactor = new float[] { 3.9f, 2.3f, 4f, 8.1f, 12.5f, 189, 211 };
			
			admin.generateSalarySlip(employees, salaryFactor);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		permanentEmployee5.setSalary(-1);
		
		System.out.println();
		System.out.println("Details of employees");
		System.out.println();
		
		try {
			int pCounter = 1, cCounter = 1;
			for (Employee employee : employees) {
				if (employee instanceof PermanentEmployee) {
					PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
					System.out.println("Details of permanentEmployee"+pCounter++);
					System.out.println("\tEmployee Id: "+permanentEmployee.getEmployeeId());
					System.out.println("\tEmployee Name: "+permanentEmployee.getEmployeeName());
					System.out.println("\tSalary: "+permanentEmployee.getSalary());	
					System.out.println("\tExperience: "+permanentEmployee.getExperience());	
					System.out.print("\tAssets Allocated: ");
					if (permanentEmployee.getAssets() != null) {
						for (Asset asset : permanentEmployee.getAssets()) {
							System.out.print(asset.getAssetId()+" ");
						}
						System.out.println();
					}
					else
						System.out.println("No assets allocated!");
				}
				else {
					System.out.println("Details of contractEmployee"+cCounter++);
					System.out.println("\tEmployee Id: "+employee.getEmployeeId());
					System.out.println("\tEmployee Name: "+employee.getEmployeeName());
					System.out.println("\tSalary: "+employee.getSalary());
				}
				System.out.println();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();	
		System.out.println("Reports");
		System.out.println();
		
		try {
			
			employees = new Employee[] { permanentEmployee1, permanentEmployee2, permanentEmployee3, permanentEmployee4,
					contractEmployee1, contractEmployee2 };
			
			int assetCount = admin.generateAssetsReport(employees, "2021-Dec-31");
			if (assetCount >= 0)
				System.out.println("Number of allocated assets expiring on or before 2021-Dec-31: "+assetCount);
			else
				System.out.println("Sorry, report cannot be generated!");
			
			System.out.println();
			
			assetCount = admin.generateAssetsReport(employees, "2020-Sep-30");
			if (assetCount >= 0)
				System.out.println("Number of allocated assets expiring on or before 2020-Sep-30: "+assetCount);
			else
				System.out.println("Sorry, report cannot be generated!");
						
			System.out.println();
			
			
			String[] desktopAssetIds = admin.generateAssetsReport(employees, 'D');

			System.out.println("All the allocated desktop assets");
			for (String assetId : desktopAssetIds) {
				if (assetId != null)
					System.out.println("\t"+assetId);
			}
			
			System.out.println();
			
			String[] laptopAssetIds = admin.generateAssetsReport(employees, 'L');
			
			System.out.println("All the allocated laptop assets");
			for (String assetId : laptopAssetIds) {
				if (assetId != null)
					System.out.println("\t"+assetId);
			}
			
			System.out.println();
			
		
			String[] voipAssetIds = admin.generateAssetsReport(employees, 'i');
			
			System.out.println("All the allocated VoIP assets");
			for (String assetId : voipAssetIds) {
				if (assetId != null)
					System.out.println("\t"+assetId);
			}
			
			System.out.println();
					
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
}
