package tech.kodika.gitfinder.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "repositories")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "author",
        "name",
        "url",
        "description",
        "language",
        "languageColor",
        "stars",
        "forks",
        "currentPeriodStars",
        "builtBy"
})
public class Repo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @JsonIgnore
    private int id;

    @Getter
    @Setter
    @JsonProperty("author")
    private String author;

    @Getter
    @Setter
    @JsonProperty("name")
    private String name;

    @Getter
    @Setter
    @JsonProperty("url")
    private String url;

    @Getter
    @Setter
    @JsonProperty("description")
    private String description;

    @Getter
    @Setter
    @JsonProperty("language")
    private String language;

    @Getter
    @Setter
    @JsonProperty("languageColor")
    private String languageColor;

    @Getter
    @Setter
    @JsonProperty("stars")
    private Integer stars;

    @Getter
    @Setter
    @JsonProperty("forks")
    private Integer forks;

    @Getter
    @Setter
    @JsonProperty("currentPeriodStars")
    private Integer currentPeriodStars;


    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(
            name = "repo_builtby",
            joinColumns = {@JoinColumn(name = "repo_id")},
            inverseJoinColumns = {@JoinColumn(name = "built_by_id")}
    )
    @Getter
    @Setter
    @JsonProperty("builtBy")
    private List<BuiltBy> builtBy = null;

    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

//    @JsonProperty("author")
//    public String getAuthor() {
//        return author;
//    }
//
//    @JsonProperty("author")
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    @JsonProperty("name")
//    public String getName() {
//        return name;
//    }
//
//    @JsonProperty("name")
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @JsonProperty("url")
//    public String getUrl() {
//        return url;
//    }
//
//    @JsonProperty("url")
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    @JsonProperty("description")
//    public String getDescription() {
//        return description;
//    }
//
//    @JsonProperty("description")
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @JsonProperty("language")
//    public String getLanguage() {
//        return language;
//    }
//
//    @JsonProperty("language")
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//    @JsonProperty("languageColor")
//    public String getLanguageColor() {
//        return languageColor;
//    }
//
//    @JsonProperty("languageColor")
//    public void setLanguageColor(String languageColor) {
//        this.languageColor = languageColor;
//    }
//
//    @JsonProperty("stars")
//    public Integer getStars() {
//        return stars;
//    }
//
//    @JsonProperty("stars")
//    public void setStars(Integer stars) {
//        this.stars = stars;
//    }
//
//    @JsonProperty("forks")
//    public Integer getForks() {
//        return forks;
//    }
//
//    @JsonProperty("forks")
//    public void setForks(Integer forks) {
//        this.forks = forks;
//    }
//
//    @JsonProperty("currentPeriodStars")
//    public Integer getCurrentPeriodStars() {
//        return currentPeriodStars;
//    }
//
//    @JsonProperty("currentPeriodStars")
//    public void setCurrentPeriodStars(Integer currentPeriodStars) {
//        this.currentPeriodStars = currentPeriodStars;
//    }
//
//
//    @JsonProperty("builtBy")
//    public List<BuiltBy> getBuiltBy() {
//        return builtBy;
//    }
//
//    @JsonProperty("builtBy")
//    public void setBuiltBy(List<BuiltBy> builtBy) {
//        this.builtBy = builtBy;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("author", author).append("name", name).append("url", url).append("description", description).append("language", language).append("languageColor", languageColor).append("stars", stars).append("forks", forks).append("currentPeriodStars", currentPeriodStars).append("builtBy", builtBy).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(author).append(builtBy).append(forks).append(additionalProperties).append(stars).append(description).append(currentPeriodStars).append(name).append(languageColor).append(language).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Repo) == false) {
            return false;
        }
        Repo rhs = ((Repo) other);
        return new EqualsBuilder().append(author, rhs.author).append(builtBy, rhs.builtBy).append(forks, rhs.forks).append(additionalProperties, rhs.additionalProperties).append(stars, rhs.stars).append(description, rhs.description).append(currentPeriodStars, rhs.currentPeriodStars).append(name, rhs.name).append(languageColor, rhs.languageColor).append(language, rhs.language).append(url, rhs.url).isEquals();
    }

}