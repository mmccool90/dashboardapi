package mccool.michelle.googlesearch.controller;

import mccool.michelle.googlesearch.models.Result;
import mccool.michelle.googlesearch.services.GoogleSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("mccool/search")
public class GoogleSearchController {
    private static Logger logger = LoggerFactory.getLogger(GoogleSearchController.class);
    private GoogleSearchService searchService;

    public GoogleSearchController(GoogleSearchService searchService) {
        this.searchService = searchService;
    }
    @GetMapping("")
    public ResponseEntity<Result> requestSearchResult(@RequestParam (name="query",required=false)String query){
        Optional<Result>response=searchService.requestDataFromApi(query);
        logger.info(response.toString());

        return new ResponseEntity(response, HttpStatus.OK);
    }


}
