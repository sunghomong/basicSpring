package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.dao.MemberDao;
import spring.service.MemberRegisterService;
//@Import({ConfigPartSub.class, ConfigPart2.class})
@Import(ConfigPartSub.class)
@Configuration
public class ConfigPartMain {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao()); // dao 객체 주입이 필요하다.
														// 생성자 주입
	}
}
