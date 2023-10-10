package vo;

public class UserVO {
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", userId=" + userId + ", name=" + name + ", gender=" + gender + ", city=" + city
				+ "]";
	}

	private int id;
	private String userId;
	private String name;
	private String gender;
	private String city;
	
	public UserVO() {
		
	}

	public UserVO(int id, String userId, String name, String gender, String city) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getCity() {
		return city;
	}
	
}
