package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.action.UserAction;
import user.action.UserDeleteAction;
import user.action.UserInsertAction;
import user.action.UserSelectAction;
import user.action.UserUpdateAction;
import user.conf.SpringConfiguration;

@Component
public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring =  (HelloSpring) context.getBean("helloSpring");
		helloSpring.menu(context);
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		UserAction userAction =null;
		int num;
		
		while(true) {
			System.out.println("보기를 입력하세요");
			System.out.println(" 1. 입력");
			System.out.println(" 2. 출력");
			System.out.println(" 3. 수정");
			System.out.println(" 4. 삭제");
			System.out.println(" 5. 종료");
			num = scan.nextInt();
			
			if(num==5){
				break;
		
			}if(num==1) {
				userAction = (UserInsertAction) context.getBean("userInsertAction");
			}else if(num==2){
				userAction = (UserSelectAction) context.getBean("userSelectAction");
			}else if(num==3){
				userAction = (UserUpdateAction) context.getBean("userUpdateAction");
			}else if(num==4){
				userAction = (UserDeleteAction) context.getBean("userDeleteAction");
			}else{
				System.out.println("보기 안 숫자를 입력하세요.");
				continue;
			}				
			userAction.execute();
		}
	}
}
