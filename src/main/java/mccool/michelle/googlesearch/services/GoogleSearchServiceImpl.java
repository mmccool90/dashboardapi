package mccool.michelle.googlesearch.services;

import lombok.extern.slf4j.Slf4j;
import mccool.michelle.googlesearch.models.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Optional;

    @Service
    @Slf4j
    public class GoogleSearchServiceImpl implements GoogleSearchService {

        private RestTemplate restTemplate;
        @Value("${googlesearch.api.host}")
        private String host;
        @Value("${googlesearch.api.key}")
        private String key;

        private Logger logger = LoggerFactory.getLogger(GoogleSearchServiceImpl.class);

        public GoogleSearchServiceImpl (){
            this.restTemplate = new RestTemplate();
        }
        @Override
        public Optional<Result> requestDataFromApi(String query) {
            try {
                String uri = "https://google-search3.p.rapidapi.com/api/v1/search/q=elon+musk";
                String queryUrl = String.format(uri, query);
                HttpHeaders headers = new HttpHeaders();
                headers.set("X-RapidAPI-Host", host);
                headers.set("X-RapidAPI-Key", key);
                HttpEntity<String> entity = new HttpEntity<>(headers);
                ResponseEntity<Result> response = restTemplate.exchange(queryUrl, HttpMethod.GET, entity, Result.class);
                Result results = response.getBody();
                logger.info(results.toString());
                return Optional.of(results);
            } catch (HttpClientErrorException ex) {
                return Optional.empty();
            }
        }
    }
