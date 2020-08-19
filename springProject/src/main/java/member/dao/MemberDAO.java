package member.dao;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberDAO {

	MemberDTO isExistId(String id);

	List<ZipcodeDTO> getZipcodeList(Map<String, String> map);

	void write(MemberDTO memberDTO);

	MemberDTO login(Map<String, String> map);

}
