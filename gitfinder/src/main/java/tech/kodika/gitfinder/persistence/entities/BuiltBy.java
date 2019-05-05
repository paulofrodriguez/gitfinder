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
@Table(name = "builtby")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "username",
        "href",
        "avatar"
})
public class BuiltBy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Getter
    @Setter
    private int Id;

    @Getter
    @Setter
    @JsonProperty("username")
    private String username;

    @Getter
    @Setter
    @JsonProperty("href")
    private String href;

    @Getter
    @Setter
    @JsonProperty("avatar")
    private String avatar;

    @Transient
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Getter
    @Setter
    @ManyToMany(mappedBy = "builtBy")
    private List<Repo> repo;

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("username", username).append("href", href).append("avatar", avatar).append("additionalProperties", additionalProperties).toString();

    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(username).append(additionalProperties).append(avatar).append(href).toHashCode();

    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {

            return true;

        }

        if ((other instanceof BuiltBy) == false) {

            return false;
        }

        BuiltBy rhs = ((BuiltBy) other);

        return new EqualsBuilder().append(username, rhs.username).append(additionalProperties, rhs.additionalProperties).append(avatar, rhs.avatar).append(href, rhs.href).isEquals();
    }

}