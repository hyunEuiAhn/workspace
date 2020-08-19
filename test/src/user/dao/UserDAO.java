package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {
	public void write(Map <String,String> map);
	
	public UserDTO checkId(String id);

	public UserDTO login(Map<String, String> map);
	
}
