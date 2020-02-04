package com.board.icia.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.board.icia.dto.Board;
import com.board.icia.dto.Reply;


public interface IBoardDao {

	List<Board> getBoardList(int pNum);

	List<Reply> getReplyList(Integer bNum);

	Board getContents(Integer bNum);
	
	@Select("SELECT COUNT(*) FROM BLIST_1")
	int getBoardCount();

}
