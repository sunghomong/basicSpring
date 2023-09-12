package spring.printer;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberInfoPrinter {
	
	@Autowired
	private MemberDao memDao;  // 스프링이 만든 객체를 넣어준다!
	@Autowired
	private MemberPrinter printer;
	
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
//
//	public void setPrinter(MemberPrinter printer) {
//		this.printer = printer;
//	}

	public void printMemberInfo(String email) {// 회원 한명에 대한 정보를 출력하는 메서드
//		MemberDao dao = MemberDao.getInstance();
		
		Member member = memDao.selectByEmail(email); 
	
		if(member == null) {
			System.out.println("데이터 없음 \n ");
			return;
		}
	
		printer.print(member);

	}
}






