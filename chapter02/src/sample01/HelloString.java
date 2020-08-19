package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloString {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean bean = (MessageBean) context.getBean("messageBeanImpl");
		bean.sayHello();
		bean.sayHello("참외",10000);
		bean.sayHello("수박",15000,1);
		((AbstractApplicationContext) context).close();
	}
}