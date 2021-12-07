package telran.imagga.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import telran.imagga.dto.ResponseDto;

public class ImaggaTagAppl {
	final static String TOKEN = "Basic YWNjX2U5OWY4ZWY1NzA5NmUxNjoxMWEwOWQ2NjhkZGNlNGYxOTdmMzZjMzA1NzAxMTAyOQ==";
	static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		String HttpUrl = "https://api.imagga.com/v2/tags";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(HttpUrl )
				.queryParam("image_url", "https://docs.imagga.com/static/images/docs/sample/japan-605234_1280.jpg")
				.queryParam("language", "ru")
				.queryParam("limit", 3);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", TOKEN);
		RequestEntity<String> requestEntity = new RequestEntity<String>(headers, HttpMethod.GET, builder.build().toUri());
		ResponseEntity<ResponseDto> responseEntity = restTemplate.exchange(requestEntity, ResponseDto.class);
		responseEntity.getBody().getResult().getTags().forEach(System.out::println);

	}

}
