package beans;
//download by http://www.codefans.net
public class Attend {
	public int id;//编号 
	public String name;//姓名
	public int actual; //出勤天数
	public String note;//评估
	public int takeoff;//请假天数
	public Attend(int id, String name, int actual, String note, int takeoff) {
		super();
		this.id = id;
		this.name = name;
		this.actual = actual;
		this.note = note;
		this.takeoff = takeoff;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getActual() {
		return actual;
	}
	public void setActual(int actual) {
		this.actual = actual;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getTakeoff() {
		return takeoff;
	}
	public void setTakeoff(int takeoff) {
		this.takeoff = takeoff;
	}

}
