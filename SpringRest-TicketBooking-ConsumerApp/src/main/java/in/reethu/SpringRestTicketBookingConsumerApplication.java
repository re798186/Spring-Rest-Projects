package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.reethu.service.ERailClientApp;

@SpringBootApplication
public class SpringRestTicketBookingConsumerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRestTicketBookingConsumerApplication.class, args);

		ERailClientApp bean = context.getBean(ERailClientApp.class);

		bean.invokeRestApi();	}

}
