package user.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Component
public class UserSelectAction implements UserAction {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		List<UserDTO> list = userDAO.getUserList();
		
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t"
								+userDTO.getId()+"\t"
								+userDTO.getPwd());
		}
	}
}
