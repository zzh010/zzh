package beans;
//download by http://www.codefans.net
public class Attend {
	public int id;//��� 
	public String name;//����
	public int actual; //��������
	public String note;//����
	public int takeoff;//�������
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
