package service;

import java.util.List;

import dao.MemberDao;
import dao.UserDao;
import domain.Member;
import domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import utils.Time;

/**
 * 用户服务
 * 
 * @author AlanP
 *
 */
public class UserService {
	private UserDao userDao;
	private MemberDao memberDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	/**
	 * 登录
	 * 
	 * @param username
	 * @param passwd
	 * @return
	 */
	public User login(String username, String passwd) {
		List<User> userlist = userDao.queryByUserName(username);
		User user = new User();
		if (userlist == null) {
			return user;
		} else {
			user = userlist.get(0);
			if (user.getPasswd().equals(passwd)) {
				return user;
			}
		}
		return user;
	}

	/**
	 * 注册
	 * 
	 * @param username
	 * @param passwd
	 * @param head
	 * @return
	 */
	public boolean register(String username, String passwd, String head) {
		List<User> userlist = userDao.queryByUserName(username);
		if (userlist.size() > 0) {
			return false;
		} else {
			userDao.save(new User(username, passwd, "1", head, "0"));
			return true;
		}
	}

	/**
	 * 添加成员
	 * 
	 * @param name
	 * @param birthday
	 * @param gender
	 * @param partner
	 * @param father
	 * @param mother
	 * @param uid
	 * @return
	 */
	public String addMember(String name, String birthday, String gender, String partner, String father, String mother,
			int uid) {
		Member member = new Member(name, birthday, gender, partner, father, mother, uid);
		memberDao.save(member);
		return "add";
	}

	/**
	 * 获取成员列表
	 * 
	 * @param uid
	 * @return
	 */
	public String getMemberlist(int uid) {
		List<Member> mlist = memberDao.queryByUid(uid);
		JSONArray ja = new JSONArray();
		for (int i = 0; i < mlist.size(); i++) {
			JSONObject jo = new JSONObject();
			Member m = mlist.get(i);
			jo.put("id", m.getId());
			jo.put("name", m.getName());
			jo.put("age", Time.getAge(m.getBirthday()));

			ja.add(jo);
		}
		return ja.toString();
	}

	/**
	 * 获取成员详情
	 */
	public String getMember(int id) {
		Member m = memberDao.get(id);
		JSONObject jo = new JSONObject();
		jo.put("id", m.getId());
		jo.put("name", m.getName());
		jo.put("birthday", m.getBirthday());
		jo.put("gender", m.getGender());
		jo.put("partner", m.getPartner());
		jo.put("father", m.getFather());
		jo.put("mother", m.getMother());
		return jo.toString();
	}

	/**
	 * 更新成员信息
	 * 
	 * @param name
	 * @param birthday
	 * @param gender
	 * @param partner
	 * @param father
	 * @param mother
	 * @param uid
	 * @return
	 */
	public String updateMember(String name, String birthday, String gender, String partner, String father,
			String mother, int uid) {
		List<Member> mlist = memberDao.queryByUidAndName(uid, name);
		Member m = new Member();
		if (mlist.size() > 0) {
			m = mlist.get(0);
			m.setBirthday(birthday);
			m.setGender(gender);
			m.setPartner(partner);
			m.setFather(father);
			m.setMother(mother);
			memberDao.update(m);
			return "updated";
		}
		return "failed";
	}

	/**
	 * 删除成员
	 * 
	 * @param uid
	 * @param name
	 * @return
	 */
	public String deleteMember(int uid, String name) {
		List<Member> mlist = memberDao.queryByUidAndName(uid, name);
		Member m = new Member();
		if (mlist.size() > 0) {
			m = mlist.get(0);
			memberDao.delete(m);
			return "deleted";
		}
		return "failed";
	}

	/**
	 * 获取用户添加的所有成员详情
	 * 
	 * @param uid
	 * @return
	 */
	public String getUserMembers(int uid) {
		List<Member> mlist = memberDao.queryByUid(uid);
		JSONArray ja = new JSONArray();
		for (int i = 0; i < mlist.size(); i++) {
			JSONObject jo = new JSONObject();
			Member m = mlist.get(i);
			jo.put("id", m.getId());
			jo.put("name", m.getName());
			jo.put("birthday", m.getBirthday());
			jo.put("gender", m.getGender());
			jo.put("partner", m.getPartner());
			jo.put("father", m.getFather());
			jo.put("mother", m.getMother());

			ja.add(jo);
		}
		return ja.toString();
	}

	/**
	 * 更新是否公开家谱
	 * 
	 * @param uid
	 * @return
	 */
	public String updatePublish(int uid) {
		User user = userDao.get(uid);
		if (user.getIsPublish().equals("0")) {
			user.setIsPublish("1");
			userDao.update(user);
			return "publish";
		} else {
			user.setIsPublish("0");
			userDao.update(user);
			return "cancle";
		}
	}
	
	/**
	 * 获取公开家谱的用户列表
	 * @return
	 */
	public String getPublishList(){
		List<User> ulist=userDao.queryPublish();
		JSONArray ja = new JSONArray();
		for(int i=0;i<ulist.size();i++){
			JSONObject jo = new JSONObject();
			User user=ulist.get(i);
			jo.put("uid", user.getUid());
			jo.put("username", user.getUsername());
			jo.put("head", user.getHead());
			ja.add(jo);
		}
		return ja.toString();
	}
}
