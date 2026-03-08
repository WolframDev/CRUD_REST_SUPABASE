package co.edu.poli.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
        .ignoreIfMissing()
        .load();
		String dbUser = dotenv.get("DB_USER_SUPABASE", System.getenv("DB_USER_SUPABASE"));
		String dbPwd = dotenv.get("DB_PWD_SUPABASE", System.getenv("DB_PWD_SUPABASE"));

		System.setProperty("DB_USER_SUPABASE", dbUser);
		System.setProperty("DB_PWD_SUPABASE", dbPwd);
		SpringApplication.run(ExampleApplication.class, args);
	}

}
