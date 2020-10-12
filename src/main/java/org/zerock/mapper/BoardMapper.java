package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	public List<BoardVO> getListWithpaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	public BoardVO read(Long bno);
	
	public int update(BoardVO board);
	
	public int delete(Long bno);
	
	public int insertSelectKey(BoardVO vo);
	
	public void updateReplyCount(@Param("bno") Long bno, @Param("uc") int uc); 
	
}
