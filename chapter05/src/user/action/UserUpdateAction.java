package user.action;

import java.util.Map;
import java.util.Scanner;


import lombok.Setter;
import user.dao.UserDAO;

public class UserUpdateAction implements UserAction {
	@Setter
	private UserDAO userDAO;
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 아이디 입력 : ");
		String id = scan.next();
		
		Map<String, Object> map = userDAO.getUser(id);
		
		
		if(map==null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return;
		}
		System.out.println(map.get("NAME")+"\t"
				+map.get("ID")+"\t"
				+map.get("PWD"));
		
		System.out.println();
		System.out.println("수정할 이름 입력 : ");
		String name=scan.next();
		System.out.println("수정 할 비밍번호 입력 : ");
		String pwd=scan.next();
		
		map.put("name",name);
		map.put("pwd", pwd);
		
		userDAO.modify(map);
		System.out.println("수정 완료!!");

	}
}
