package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;

@Configuration
public class ConfigPartSub {

	@Autowired
	private ConfigPartMain partmain; // ConfigPartMain의 내용을 읽어온다.
	
	@Autowired
	private MemberDao memberDao; // 가지고 있는 빈중에서 MemberDao 객체를 주입받는다.
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean MemberInfoPrinter infoPrinter() {
		 MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		 infoPrinter.setMemDao(partmain.memberDao());
		 infoPrinter.setMemDao(memberDao);
		 
		 return infoPrinter;
	}
}
