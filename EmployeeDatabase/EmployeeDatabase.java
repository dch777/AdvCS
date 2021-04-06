import java.util.*;

public class EmployeeDatabase {

	private class Entry {

		int ID;
		Employee emp;
	
		public Entry(int ID, Employee emp) {
			this.ID = ID;
			this.emp = emp;
		}

		@Override
		public String toString() {
			return emp.name;
		}
	}

	private static Entry[] employees = new Entry[31];
	private static float load = 0;

	public void put(int key, Employee value) {
		int code = hashCode(key);
		if (load + 1.0 / employees.length >= 0.5) {
			doubleCapacity();
		}
		while (employees[code] != null || employees[code].ID != key) {
			code++;
		}
		employees[code] = new Entry(key, value);
		load++;
	}

	private void doubleCapacity() {
		Entry[] tmp = employees.clone();
		employees = new Entry[employees.length * 2];
		load = 0;
		for (int i = 0; i < tmp.length; i++) {
			put(tmp[i].ID, tmp[i].emp);
		}
	}

	public Employee get(int key) {
		int code = hashCode(key);
		while (employees[code] != null || employees[code].ID != key) {
			code++;
		}
		if (employees[code] == null) {
			return null;
		} else {
			return employees[code].emp;
		}
	}

	private static int hashCode(int key) {
		return key % employees.length;
	}

	//private static int hashCode(int key) {
	//	return key % employees.length
	//}
	
}
