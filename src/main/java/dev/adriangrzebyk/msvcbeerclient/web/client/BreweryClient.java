package dev.adriangrzebyk.msvcbeerclient.web.client;

import dev.adriangrzebyk.msvcbeerclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

	private final String BEER_PATH_V1 = "/api/v1/beer/";
	private String apihost;
	private final RestTemplate restTemplate;

	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public BeerDto getBeerById(UUID uuid) {
		return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid, BeerDto.class);
	}

	public URI saveNewBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
	}

	public void updateBeer(UUID uuid, BeerDto beerDto) {
		restTemplate.put(apihost + BEER_PATH_V1 + uuid, beerDto);
	}

	public void setApihost(String apihost) {
		this.apihost = apihost;
	}

	public void deleteBeer(UUID uuid) {
		restTemplate.delete(apihost + BEER_PATH_V1 + uuid);
	}
}
