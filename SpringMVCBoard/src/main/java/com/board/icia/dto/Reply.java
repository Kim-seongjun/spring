package com.board.icia.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.JsonAdapter;

import lombok.Data;
import lombok.experimental.Accessors;

@Alias("reply")
@Accessors(chain=true)
@Data
public class Reply {
	private int r_bnum; //원글 번호
	private int r_num; //댓글 번호
	private String r_contents; //댓글
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Timestamp r_date; //작성일
	private String r_id; //작성자
}
