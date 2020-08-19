package user.action;

import java.util.List;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectAction implements UserAction {
	@Setter
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
