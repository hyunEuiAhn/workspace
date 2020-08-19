package sample04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component("messageBeanImpl2")
public class MessageBeanImpl implements MessageBean {
	private String name;
	private String phone;
	private Outputter outputter;
	
	public MessageBeanImpl(@Value("홍길동")String name) {
		System.out.println(" MessageBeanImpl(String name)");
		this.name = name;
	}
	
	@Autowired
	public void setPhone(@Value("010-1234-555")String phone) {
		System.out.println(" setPhone(String phone)");
		this.phone = phone;
	}

	@Autowired
	public void setOutputter(Outputter outputter) {
		System.out.println(" setOutputter(Outputter outputter)");
		this.outputter = outputter;
	}

	@Override
	public void helloCall() {
		System.out.println(" helloCall()");
		outputter.output("이름: "+name+"\t"+"핸드폰: "+phone);
	}

}
