package org.zerock.domain;

import lombok.Data;

@Data
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private Criteria cri;
	private int total;
	
	private int realEnd;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = endPage - 9;
		
		this.realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));	
		
		if(this.endPage >= this.realEnd) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
	}
	
	
	public static void main(String[] args) {
		Criteria cri = new Criteria();
		cri.setPageNum(13);
		cri.setAmount(10);
		int total = 153;
		PageDTO page = new PageDTO(cri, total);
		
		System.out.println(page.toString());
		
	}
	
	
	
}
