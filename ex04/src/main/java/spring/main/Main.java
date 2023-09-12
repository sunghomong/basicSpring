package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.printer.MemberInfoPrinter;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;


public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = 
//				new AnnotationConfigApplicationContext(JavaConfig.class); // 자바코드를 읽어올때는 AnnotationConfig쩌구
//				new AnnotationConfigApplicationContext(ConfigPart1.class, ConfigPart2.class); // 자바코드를 읽어올때는 AnnotationConfig쩌구
		// 읽어와서 빈 객체를 생성하겠습니다~ 라는 의미 
//				new AnnotationConfigApplicationContext(ConfigPartMain.class);
//				new AnnotationConfigApplicationContext(JavaMainConfig.class);
				new GenericXmlApplicationContext("classpath:main-config.xml");
		
		MemberRegisterService regSvc =
				ctx.getBean("memberRegSvc",MemberRegisterService.class);
		
		MemberInfoPrinter info = 
				ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("hong@naver.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		
		regSvc.regist(regReq);
		
		info.printMemberInfo("hong@naver.com");
	}

}
