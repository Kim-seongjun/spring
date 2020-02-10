package com.board.icia.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.board.icia.dto.Board;
import com.board.icia.dto.Member;
import com.board.icia.dto.Reply;


public interface IBoardDao {

	List<Board> getBoardList(int pNum);

	List<Reply> getReplyList(Integer bNum);

	Board getContents(Integer bNum);
	
	@Select("SELECT COUNT(*) FROM BLIST_1")
	int getBoardCount();

	boolean replyInsert(Reply r);
	@Delete("DELETE FROM R WHERE R_BNUM=#{bNum}")
	boolean replyDelete(Integer bNum);
	@Delete("DELETE FROM B WHERE B_NUM=#{bNum}")
	boolean aticleDelete(Integer bNum);
	
	@Select("SELECT * FROM MEMBER")
	List<Member> getMemberList();
	
	//@Insert("INSERT INTO B VALUES(BOARD_SEQ.NEXTVAL,'#{b_title}','#{b_contents}','#{b_id}',default,default)")
	boolean boardWrite(Board board);

	
	boolean fileInsert(Map<String, String> fMap);

	@Select("SELECT BOARD_SEQ.CURRVAL FROM DUAL")
	int getCurBoardNum();

}
