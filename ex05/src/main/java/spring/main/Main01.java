package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.bean.Client;

public class Main01 {
	
	{
		// 초기화 블록
	}

	public static void main(String[] args) {

		// 스프링 설정 파일을 읽어와서 스프링 컨테이너를 초기화 하는 단계
		// 1) 설정파일에 등록된 빈 객체 생성
		// 2) 각 빈 객체의 의존 주입
		// 3) 각 빈 객체의 초기화
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		// 이미 스프링 컨테이너에 만들어진 빈 객체를 사용하기 위해서 불러오는 과정
		Client client = ctx.getBean("client",Client.class);

		// 실제 빈 객체를 활용
		client.send();
		
		// 스프링 컨테이너를 종료
		//		=> 4) 컨테이너 내부에 생성된 빈 객체가 전부 소멸
		ctx.close();
		
	}

}
