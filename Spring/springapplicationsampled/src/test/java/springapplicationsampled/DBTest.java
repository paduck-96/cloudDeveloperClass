package springapplicationsampled;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class DBTest {
	@Autowired
	private DataSource dataSource;

	@Test
	public void testConnection() {
		try {
			Connection con = dataSource.getConnection();
			System.out.print(con);
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
