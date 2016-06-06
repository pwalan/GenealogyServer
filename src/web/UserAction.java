package web;

import com.opensymphony.xwork2.ActionSupport;

import domain.User;
import service.UserService;

/**
 * 用户的相关操作
 * @author AlanP
 *
 */
public class UserAction extends ActionSupport{
	private int uid;
	private int id;
	private String username;
	private String passwd;
	private String head;
	private String status;
	private String data;
	
	private String name;
	private String birthday;
	private String gender;
	private String father;
	private String mother;
	private String partner;
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
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
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 登录
	 */
	public String login(){
		setUsername(getUsername());
		setPasswd(getPasswd());
		System.out.println(username+" with "+passwd);
		
		if(username == null || passwd == null) {
			setStatus("failed");
			setUid(0);
			setHead("");
		}else{
			User user=userService.login(username, passwd);
			if(user==null){
				setStatus("faild");
				setUid(0);
				setHead("");
			}else{
				setStatus("succeed");
				setUid(user.getUid());
				setHead(user.getHead());
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 注册
	 */
	public String register(){
		setUsername(getUsername());
		setPasswd(getPasswd());
		setHead(getHead());
		System.out.println(username+" with "+passwd+" head:"+head);
		
		if(username==null||passwd==null){
			setStatus("failed");
		}else{
			if(userService.register(username, passwd, head)){
				setStatus("succeed");
			}else{
				setStatus("failed");
			}
		}	
		return SUCCESS;
	}
	
	/**
	 * 添加成员
	 */
	public String addMember(){
		setData(userService.addMember(getName(), getBirthday(), getGender(), getPartner(), getFather(), getMother(), getUid()));
		return SUCCESS;
	}
	
	/**
	 * 获取成员
	 */
	public String getMembers(){
		setData(userService.getMembers(getUid()));
		return SUCCESS;
	}
	
	/**
	 * 更新成员
	 */
	public String updateMember(){
		setData(userService.updateMember(getName(), getBirthday(), getGender(), getPartner(), getFather(), getMother(), getUid()));
		return SUCCESS;
	}
	
	/**
	 * 删除成员
	 * @return
	 */
	public String deleteMember(){
		setData(userService.deleteMember(getUid(), getName()));
		return SUCCESS;
	}
}
