package io.riju;

import java.util.Date;

import javax.json.bind.annotation.JsonbProperty;

public class BlogPost {

    public Title title;
    public static class Title {
        public String rendered;
    }

    public Content content;
    public static class Content {
        public String rendered;
    }

    @JsonbProperty("country_code")
    public String countryCode;
    public String location;

    @JsonbProperty("jetpack_featured_media_url")
    public String featuredMediaUrl;

    @JsonbProperty("date")
    public Date created;

    public Integer id;
    
}