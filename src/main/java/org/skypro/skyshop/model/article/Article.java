package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class Article implements Searchable {
    private final UUID id;
    private final String title;
    private final String body;

    public Article(UUID id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return title;
    }

    @JsonIgnore
    public String getSearchTerm() {
        return title + " " + body;
    }

    @JsonIgnore
    public String getContentType() {
        return "ARTICLE";
    }

    public String getBody() {
        return body;
    }
}
