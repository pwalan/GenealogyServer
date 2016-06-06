package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import domain.Member;

/**
 * 对成员操作的实现
 * @author AlanP
 *
 */
public class MemberDao extends HibernateDaoSupport{
	
	public List<Member> queryByUid(int uid){
		return (List<Member>)getHibernateTemplate()
				.find("from Member m where m.uid=? order by m.birthday",uid);
	}
	
	public List<Member> queryByUidAndName(int uid, String name){
		return (List<Member>)getHibernateTemplate()
				.find("from Member m where m.uid="+uid+" and m.name='"+name+"'");
	}
	
	public Member get(int id){
		return getHibernateTemplate().get(Member.class, id);
	}
	
	public Integer save(Member member) {
		return (Integer)getHibernateTemplate().save(member);
	}
	
	public void update(Member member) {
		getHibernateTemplate().update(member);
	}
	
	public void delete(Member member) {
		getHibernateTemplate().delete(member);
	}
}
