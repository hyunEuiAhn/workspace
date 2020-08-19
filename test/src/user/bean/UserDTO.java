package user.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserDTO {
	private String id;
	private String name;
	private String pwd;
	private String email1;
	private String email2;
}
