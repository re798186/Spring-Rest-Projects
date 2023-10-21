package in.reethu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.reethu.service.CurrencyService;

@SpringBootApplication
public class SpringRestCurrencyConverterConsumerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringRestCurrencyConverterConsumerApplication.class, args);

		CurrencyService bean = context.getBean("service", CurrencyService.class);

		String to = "INR";
		String from = "USD";
		
		
		bean.invokeRestApiSync(from, to);

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		
		bean.invokeRestApiASync(from, to);	}

}
