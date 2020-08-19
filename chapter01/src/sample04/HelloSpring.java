package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpring {

	public static void main(String[] args) {
		int x=25;
		int y=36;
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc bean;
		bean = (Calc)context.getBean("add");
		bean.calculate(x, y);
		
		bean = context.getBean("mul", Calc.class);
		bean.calculate(x, y);
		
		((AbstractApplicationContext) context).close();
	}
}
