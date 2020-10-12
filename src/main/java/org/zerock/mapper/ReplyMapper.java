package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
	
	public int insert(ReplyVO vo);
	
	public int update(ReplyVO vo);
	
	public int delete(@Param("rno") Long rno);
	
	public ReplyVO read(Long rno);
	
}