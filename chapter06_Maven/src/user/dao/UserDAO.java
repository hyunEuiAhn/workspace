package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {
	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList();
	
	public UserDTO checkId(String id);
	
	public void modify(UserDTO userDTO);
	
	public void delete(String id);
	
//	public Map<String, String> getUser(String id);
	
}
