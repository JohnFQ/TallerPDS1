package co.com.poli.pds.proyectos.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProjectTaskServiceMockTest {
	
	@Autowired
	private ProjectTaskService projectTaskService;
	
	@Test
	public void test_AllHoursxStatus() {
		
	}
}
