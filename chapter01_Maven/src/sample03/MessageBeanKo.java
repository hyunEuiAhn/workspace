package sample03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component	//MessageBeanKo를 Component로 선언하겠다.
@Component("messageBean")	//bean이름이 다를 때에는 괄호 안에 이름을 작성해 줘야 됨
@Scope("prototype")	//new로 실행하게 생
public class MessageBeanKo implements MessageBean {
	private int num;
	
	public MessageBeanKo() { 
		System.out.println("MessageBeanKo 생성자");
	}
	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num="+num);
		System.out.println("안녕하세요 "+name+"!!!");
	}
}
