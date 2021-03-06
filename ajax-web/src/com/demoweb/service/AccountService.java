package com.demoweb.service;

import java.util.List;

import com.demoweb.common.Util;
import com.demoweb.dao.MemberDao;
import com.demoweb.vo.MemberVO;

public class AccountService {
	
	private MemberDao memberDao = new MemberDao();

	public MemberVO findMemberByIdAndPasswd(String id, String passwd){
		
		String hashedPasswd = Util.getHashedString(passwd, "SHA-256");
	
		//MemberDao memberDao = new MemberDao();
		MemberVO member =
				memberDao.selectMemberByIdAndPasswd(id, hashedPasswd);
		return member;
	}
	
	public MemberVO findMemberById(String id){
	
		//MemberDao memberDao = new MemberDao();
		MemberVO member = memberDao.selectMemberById(id);
		return member;
	}

	public void register(MemberVO member) {

		//패스워드 암호화 처리
		String hashedPasswd = 
				Util.getHashedString(member.getPasswd(), "SHA-256");
		member.setPasswd(hashedPasswd);
				
		
		//MemberDao memberDao = new MemberDao();
		memberDao.insertMember(member);
		
	}

	public List<String> findIdsById(String id) {
		List<String> ids = memberDao.selectIdsById(id);
		return ids;
	}
	
}






