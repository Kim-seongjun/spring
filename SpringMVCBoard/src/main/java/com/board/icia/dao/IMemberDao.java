package com.board.icia.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.board.icia.dto.Member;

public interface IMemberDao {
	public boolean getLoginResult(Member mb);

	public boolean memberJoin(Member mb);

	public Member getMemberInfo(String m_id);

	public String getSecurityPwd(String m_id);

	public boolean hashMapTest(Map<String, String> hMap);

	public Map<String, String> hashMapTest2(String id);
		
}
