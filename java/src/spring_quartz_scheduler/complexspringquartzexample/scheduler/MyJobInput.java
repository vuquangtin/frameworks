package complexspringquartzexample.scheduler;

import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class MyJobInput {

	private List<String> processData;

	public List<String> getProcessData() {
		return processData;
	}

	public void setProcessData(List<String> processData) {
		this.processData = processData;
	}
}