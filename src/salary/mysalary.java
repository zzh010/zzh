package salary;
//download by http://www.codefans.net
import java.sql.Date;

public class mysalary {
	int id;
	int salarybase;
	int bonus;
	int extrawage;
	int year;
	int month;
	public mysalary(int id, int salarybase, int bonus, int extrawage, int year,
			int month) {
		super();
		this.id = id;
		this.salarybase = salarybase;
		this.bonus = bonus;
		this.extrawage = extrawage;
		this.year = year;
		this.month = month;
	}
	public int getId() {
		return id;
	}
	public int getSalarybase() {
		return salarybase;
	}
	public int getBonus() {
		return bonus;
	}
	public int getExtrawage() {
		return extrawage;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
}
