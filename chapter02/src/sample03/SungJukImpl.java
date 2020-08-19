package sample03;


import java.util.Scanner;

import org.springframework.lang.NonNull;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SungJukImpl implements SungJuk {
	@NonNull
	private SungJukDTO sungJukDTO;
	
	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath());
	}
	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getTot()/3.0);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균");
		System.out.println(sungJukDTO.getName()+"\t"
						  +sungJukDTO.getKor()+"\t"
						  +sungJukDTO.getEng()+"\t"
						  +sungJukDTO.getMath()+"\t"
						  +sungJukDTO.getTot()+"\t"
						  +String.format("%.2f", sungJukDTO.getAvg()));
	}

	@Override
	public void modify() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력 : ");
		sungJukDTO.setName(sc.next());

		System.out.println("국어 입력 : ");
		sungJukDTO.setKor(sc.nextInt());

		System.out.println("영어 입력 : ");
		sungJukDTO.setEng(sc.nextInt());

		System.out.println("수학 입력 : ");
		sungJukDTO.setMath(sc.nextInt());
		
		calcTot();
		calcAvg();
		display();
	}

}
