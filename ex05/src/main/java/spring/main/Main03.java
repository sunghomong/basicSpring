package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.bean.Client2;
import spring.config.JavaConfig;

public class Main03 {

	public static void main(String[] args) {

		// 스프링 설정 파일을 읽어와서 스프링 컨테이너를 초기화 하는 단계
		// 1) 설정파일에 등록된 빈 객체 생성
		// 2) 각 빈 객체의 의존 주입
		// 3) 각 빈 객체의 초기화
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// 이미 스프링 컨테이너에 만들어진 빈 객체를 사용하기 위해서 불러오는 과정
		Client2 client2 = ctx.getBean("client2", Client2.class);

		// 실제 빈 객체를 활용
		client2.send();

		// 스프링 컨테이너를 종료
		// => 4) 컨테이너 내부에 생성된 빈 객체가 전부 소멸
		ctx.close();

	}

}
