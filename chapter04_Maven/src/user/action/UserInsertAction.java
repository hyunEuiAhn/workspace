package user.action;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Component
public class UserInsertAction implements UserAction {
	@Autowired	//@Component로 연결 돼 있는 걸 알아서 잡아온다.
	private UserDTO userDTO;
	@Autowired
	private UserDAO userDAO;
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름 입력 :");
		String name=scan.next();
		System.out.println("아이디 입력 :");
		String id=scan.next();
		System.out.println("비밀번호 입력 :");
		String pwd=scan.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		userDAO.write(userDTO);
		
		System.out.println("데이터를 저장하였습니다.");
	}

}
