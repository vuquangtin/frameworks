package complexspringquartzexample.client;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class MainClient {

	public static void main(String[] args) throws IOException {
		String config = new java.io.File(".").getCanonicalPath()
				+ "/src/main/java/spring.xml";
		List<String> lines = Files.readAllLines(new java.io.File(config).toPath());
		lines.forEach(System.out::println);
		System.out.println(new java.io.File(config).toString());

		new ClassPathXmlApplicationContext(config);

	}

}
