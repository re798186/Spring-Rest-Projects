package in.reethu.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.reethu.response.CurrencyResponse;

@Service("service")
public class CurrencyService {

	private static final String REST_END_POINT = "http://localhost:8080/SpringRest-CurrencyConverter-ProviderApp/api/currency/getCurrencyExchangeCost/from/USD/to/INR";

	public void invokeRestApiSync(String from, String to) {
		// Sending Synchronous request
		WebClient webClient = WebClient.create();
		System.out.println("***Synchronous: Rescall started ******");
		CurrencyResponse response = webClient.
				get().
				uri(REST_END_POINT, from, to).
				accept(MediaType.APPLICATION_JSON).
				retrieve().
				bodyToMono(CurrencyResponse.class).
				block();

		System.out.println(response);
		System.out.println("****Synchronous: Restcall ended ******");
	}

	public void invokeRestApiASync(String from, String to) {

		// Sending Synchronous request
		WebClient webClient = WebClient.create();
		System.out.println("***ASynchronous: Restcall started ******");
		webClient.
			get().
			uri(REST_END_POINT, from, to).
			accept(MediaType.APPLICATION_JSON).
			retrieve().
			bodyToMono(CurrencyResponse.class).
			subscribe(CurrencyService::myResponse);

		System.out.println("****ASynchronous: Restcall ended ******");
	}

	public static void myResponse(CurrencyResponse response) {
		System.out.println(response);
		//use repsonse object as per the needs[push to Apache-kafka]
	}

}
