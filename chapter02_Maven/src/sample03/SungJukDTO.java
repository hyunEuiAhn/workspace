package sample03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class SungJukDTO{
	@Value("홍길동")
	private String name;
	@Value("95")
	private int kor;
	@Value("100")
	private int eng;
	@Value("97")
	private int math;
	private int tot;
	private double avg;
	
	@Override
	public String toString() {
		return name+"\t"
			  +kor+"\t"
			  +eng+"\t"
			  +math+"\t"
			  +tot+"\t"
			  +String.format("%.2f", avg);
	}
	
}
