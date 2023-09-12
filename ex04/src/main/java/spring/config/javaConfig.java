package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;
import spring.service.MemberRegisterService;

@Configuration
public class javaConfig { // 스프링 빈 설정파일
	
//	<bean id="dao" class="spring.dao.MemberDao" />
//		MemberDao memberDao = new MemberDao();	
	
	@Bean // 빈으로 역할을 한다.
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
//	<bean id="memberRegSvc" class="spring.service.MemberRegisterService">
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao()); // 생성자 주입
	}
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter(); 
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
//		MemberInfoPrinter kjanbfksjd = new MemberInfoPrinter();
//		kjanbfksjd(memberDao()); // Setter 메서드 주입
//		kjanbfksjd(printer());
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		
		return infoPrinter;
	}
	
	
	
	
	
	
	
	
}
