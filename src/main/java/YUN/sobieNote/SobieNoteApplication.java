package YUN.sobieNote;

import YUN.sobieNote.Member.Controller.MemberController;
import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Configuration
public class SobieNoteApplication {

	private static final Logger logger = LoggerFactory.getLogger(SobieNoteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SobieNoteApplication.class, args);

		// Environment 객체로 application.properties 값 가져오기
		logger.info("Main Start");
		logger.info("server start at :  http://localhost:8080");


	}


}
