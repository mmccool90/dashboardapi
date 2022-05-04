package mccool.michelle.googlesearch.models;

import java.util.List;

public class Result {
    private List<SearchResult>results;

    public Result() {
    }

    public List<SearchResult> getResults() {
        return results;
    }

    public void setResults(List<SearchResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Result{" +
                "results=" + results +
                '}';
    }
}
