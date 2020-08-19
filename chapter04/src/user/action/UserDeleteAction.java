package user.action;

import java.util.Map;
import java.util.Scanner;

import lombok.Setter;
import user.dao.UserDAO;

public class UserDeleteAction implements UserAction {
	@Setter
	private UserDAO userDAO;
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 아이디 입력 : ");
		String id = scan.next();
		
		
		Map<String, Object> map = userDAO.getUser(id);
		
		if(map==null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return;
		}
		
		userDAO.delete(id);
		
		System.out.println("아이디를 삭제했습니다.");
	}

}
