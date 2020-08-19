package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {

	void write(UserDTO userDTO);

	List<UserDTO> getUserList();

	Map<String, Object> getUser(String id);

	void modify(Map<String, Object> map);

	void delete(String id);
	
}
