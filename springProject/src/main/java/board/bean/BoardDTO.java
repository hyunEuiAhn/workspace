package board.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@Component
public class BoardDTO {
	private String id;
	private String name;
	private String email;
	private String subject;
	private String content;
	private int seq;
	private int ref;
	private int lev;
	private int step;
	private int reply;
	private int hit;
	private int pseq;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
	private Date logtime;

}