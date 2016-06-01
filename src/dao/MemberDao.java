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
	
	public List<Member> queryByRid(int uid){
		return (List<Member>)getHibernateTemplate()
				.find("from Member m where m.uid=?",uid);
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
