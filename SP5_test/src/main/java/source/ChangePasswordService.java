package source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import exception.MemberNotFoundException;

@Component
public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;
	
	@Transactional
	public void changePassword(String email, String oldPassword, String newPassword) {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotFoundException("");
		}
		
		member.changePassword(oldPassword, newPassword);
		
		memberDao.update(member);
		
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
