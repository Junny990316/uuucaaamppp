package vo;

import java.sql.Date;

public class CustomerVO {
	@Override
	public String toString() {
		return "CustomerVO [id=" + id + ", name=" + name + ", email=" + email + ",age=" + age + ", addr=" + addr + ", entryDate=" + entryDate
				+ "]";
	}

	private int id;
	private String name;
	private String email;
	private int age;
	private String addr;
	private Date entryDate;
	
	public CustomerVO() {
		
	}

	public CustomerVO(int id, String name, String email, int age, String addr, Date entryDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.addr = addr;
		this.entryDate = entryDate;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public String getAddr() {
		return addr;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	
}
