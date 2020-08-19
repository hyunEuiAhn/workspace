package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
public class MessageBeanImpl implements MessageBean {
	@Value("Have a nice day!!")
	private String str;
	
	
	
//	public MessageBeanImpl(@Value("Have a nice day!!")String str) {
//		super();
//		this.str = str;
//	}

	@Override
	public void showPrintBefore() {
			System.out.println("showPrintBefore 메시지 = "+str);//핵심 관심 사항
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메시지"+str);
	}

	@Override
	public void display() {
		System.out.println("display 메시지"+str);
	}

	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메시지 = "+str);
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintAfter 메시지"+str);
	}

	@Override
	public String showPrint() {
		System.out.println("showPrint 메시지 = "+str);
		return "pitch";
	}

	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrint 메시지"+str);
	}
}
