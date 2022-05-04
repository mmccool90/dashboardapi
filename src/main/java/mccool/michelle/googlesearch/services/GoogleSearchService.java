package mccool.michelle.googlesearch.services;


import mccool.michelle.googlesearch.models.Result;

import java.util.Optional;

public interface GoogleSearchService {
    Optional<Result> requestDataFromApi(String query);
}
