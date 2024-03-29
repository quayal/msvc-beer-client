//package dev.adriangrzebyk.msvcbeerclient.web.config;
//
//import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
//import org.apache.http.impl.nio.client.HttpAsyncClients;
//import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
//import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
//import org.apache.http.impl.nio.reactor.IOReactorConfig;
//import org.apache.http.nio.client.HttpAsyncClient;
//import org.apache.http.nio.reactor.IOReactorException;
//import org.springframework.boot.web.client.RestTemplateCustomizer;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
//import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
////@Component
//public class NIORestTemplateCustomizer implements RestTemplateCustomizer {
//
//	private ClientHttpRequestFactory clientHttpRequestFactory() throws IOReactorException {
//		final DefaultConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(IOReactorConfig.custom()
//				.setConnectTimeout(3000)
//				.setIoThreadCount(4)
//				.setSoTimeout(3000)
//				.build());
//
//		final PoolingNHttpClientConnectionManager connectionManager = new PoolingNHttpClientConnectionManager(ioReactor);
//		connectionManager.setDefaultMaxPerRoute(100);
//		connectionManager.setMaxTotal(1000);
//
//		CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.custom()
//				.setConnectionManager(connectionManager)
//				.build();
//
//		return new OkHttp3ClientHttpRequestFactory(httpAsyncClient);
//	}
//
//	public void customize(RestTemplate restTemplate) {
//		try {
//			restTemplate.setRequestFactory(clientHttpRequestFactory());
//		} catch (IOReactorException e) {
//			e.printStackTrace();
//		}
//	}
//}
