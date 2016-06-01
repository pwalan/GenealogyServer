package service;

import java.util.List;

import dao.MemberDao;
import dao.UserDao;
import domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import utils.Time;

/**
 * 用户服务
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
	 * @param username
	 * @param passwd
	 * @return
	 */
	public User Login(String username, String passwd){
		List<User> userlist=userDao.queryByUserName(username);
		User user=new User();
		if(userlist==null){
			return user;
		}else{
			user=userlist.get(0);
			if(user.getPasswd().equals(passwd)){
				return user;
			}
		}
		return user;
	}
	
	/**
	 * 注册
	 * @param username
	 * @param passwd
	 * @param head
	 * @return
	 */
	public boolean Register(String username, String passwd, String head){
		List<User> userlist=userDao.queryByUserName(username);
		if(userlist.size()>0){
			return false;
		}else{
			userDao.save(new User(username, passwd, "1", head,"0"));
			return true;
		}
	}
	
}
