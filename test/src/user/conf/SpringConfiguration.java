package user.conf;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration	//xml처럼 미리 읽어라!! 환경 설정을 잡아주는 역할
public class SpringConfiguration {
	
	//@Bean	//method 부분에 있는 걸 생성시키는 역할(Component랑 같은 역할을 하지만 메소드를 생성)
	@Bean(name="dataSource", destroyMethod="close")
	public BasicDataSource getBasicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		basicDataSource.setUsername("java");
		basicDataSource.setPassword("itbank");
		basicDataSource.setMaxTotal(20);
		basicDataSource.setMaxIdle(3);
		return basicDataSource;
	}
}
