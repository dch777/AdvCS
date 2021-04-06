public class Tester {
	public static void main(String[] args) {
		EmployeeDatabase employees = new EmployeeDatabase();
		employees.put(12345, new Employee("testing", 32));
		employees.put(12409, new Employee("testing2", 45));
		employees.put(12349, new Employee("testing3", 29));
		employees.put(12346, new Employee("testing4", 8));
		System.out.println(employees.get(12345).name);
	}
}
