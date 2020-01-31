package com.board.icia.dao;

import com.board.icia.dto.Member;

public interface IMemberDao {
	public boolean getLoginResult(Member mb);

	public boolean memberJoin(Member mb);

	public Member getMemberInfo(String m_id);

	public String getSecurityPwd(String m_id);
}
