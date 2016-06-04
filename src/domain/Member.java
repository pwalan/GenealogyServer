package domain;
public class Member {
    private int id;
    private String name;
    private String birthday;
    private String gender;
    private String partner;
    private String father;
    private String mother;
    private int uid;
    
	public Member() {
		super();
	}

	public Member(String name, String birthday, String gender, String partner, String father, String mother, int uid) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.partner = partner;
		this.father = father;
		this.mother = mother;
		this.uid = uid;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
    
}
