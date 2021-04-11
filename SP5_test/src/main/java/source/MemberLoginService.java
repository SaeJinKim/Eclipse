package source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import exception.DuplicateMemberException;
import exception.MemberNotFoundException;

@Component
public class MemberLoginService {
	
	@Autowired
	private MemberDao memberdao;
	
	public MemberLoginService(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
	public MemberLoginService() {
		
	}
	
	@Transactional
	public Member login(LoginRequest loginRequest) {
		Member member = memberdao.selectByEmail_Pass(loginRequest.getEmail(), loginRequest.getPassword());
		if(member == null) {
			throw new MemberNotFoundException("no member"+loginRequest.getEmail());
		}
		
		return member;
	}
}
