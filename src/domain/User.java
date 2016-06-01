package domain;

public class User {
    private int uid;
    private String username;
    private String passwd;
    private String type;
    private String head;
    private String isPublish;
    
	public User() {
		super();
	}

	public User(String username, String passwd, String type, String head,String isPublish) {
		super();
		this.username = username;
		this.passwd = passwd;
		this.type = type;
		this.head = head;
		this.isPublish=isPublish;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}

}
