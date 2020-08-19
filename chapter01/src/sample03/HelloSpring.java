package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationConte		//src 안에 xml 파일을 읽어와라 
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
			
		MessageBean bean = (MessageBean)context.getBean("messageBean");	//getBean이 object 형으로 가져오기 때문에 형변환이 필요하다.
		bean.sayHello("Spring");
		System.out.println();
		
		MessageBean bean2 = context.getBean("messageBean", MessageBean.class);
		bean2.sayHello("Spring");
		System.out.println();
		
		MessageBean bean3 = (MessageBean)context.getBean("mb");	//getBean이 object 형으로 가져오기 때문에 형변환이 필요하다.
		bean3.sayHello("Spring");
		System.out.println();
		
		//((AbstractApplicationContext) context).close();
		((ConfigurableApplicationContext)context).close();	//warning이 발생했을 때 close()로 닫아주면 없어진다.
		
	}
}
//xml에 생성한 클래스를 새롭게 new로 생성하는 게 아니라 싱글톤으로한 번만 생성을 한다.
//new로 새롭게 생성을 하려면 xml에 scope="prototype"를 추가하면 됨.