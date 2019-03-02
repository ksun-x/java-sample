package sk.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EventHandler implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("Received event:" + event);
	}
}
