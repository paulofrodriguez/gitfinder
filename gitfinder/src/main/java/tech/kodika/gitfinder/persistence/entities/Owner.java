
package tech.kodika.gitfinder.persistence.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {

    @SerializedName("login")
    @Expose
    @Getter
    @Setter
    public String login;
    @Id
    @SerializedName("id")
    @Expose
    @Getter
    @Setter
    public Integer id;
    @SerializedName("node_id")
    @Expose
    @Getter
    @Setter
    public String nodeId;
    @SerializedName("avatar_url")
    @Expose
    @Getter
    @Setter
    public String avatarUrl;
    @SerializedName("gravatar_id")
    @Expose
    @Getter
    @Setter
    public String gravatarId;
    @SerializedName("url")
    @Expose
    @Getter
    @Setter
    public String url;
    @SerializedName("html_url")
    @Expose
    @Getter
    @Setter
    public String htmlUrl;
    @SerializedName("followers_url")
    @Expose
    @Getter
    @Setter
    public String followersUrl;
    @SerializedName("following_url")
    @Expose
    @Getter
    @Setter
    public String followingUrl;
    @SerializedName("gists_url")
    @Expose
    @Getter
    @Setter
    public String gistsUrl;
    @SerializedName("starred_url")
    @Expose
    @Getter
    @Setter
    public String starredUrl;
    @SerializedName("subscriptions_url")
    @Expose
    @Getter
    @Setter
    public String subscriptionsUrl;
    @SerializedName("organizations_url")
    @Expose
    @Getter
    @Setter
    public String organizationsUrl;
    @SerializedName("repos_url")
    @Expose
    @Getter
    @Setter
    public String reposUrl;
    @SerializedName("events_url")
    @Expose
    @Getter
    @Setter
    public String eventsUrl;
    @SerializedName("received_events_url")
    @Expose
    @Getter
    @Setter
    public String receivedEventsUrl;
    @SerializedName("type")
    @Expose
    @Getter
    @Setter
    public String type;
    @SerializedName("site_admin")
    @Expose
    @Getter
    @Setter
    public Boolean siteAdmin;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("login", login).append("id", id).append("nodeId", nodeId).append("avatarUrl", avatarUrl).append("gravatarId", gravatarId).append("url", url).append("htmlUrl", htmlUrl).append("followersUrl", followersUrl).append("followingUrl", followingUrl).append("gistsUrl", gistsUrl).append("starredUrl", starredUrl).append("subscriptionsUrl", subscriptionsUrl).append("organizationsUrl", organizationsUrl).append("reposUrl", reposUrl).append("eventsUrl", eventsUrl).append("receivedEventsUrl", receivedEventsUrl).append("type", type).append("siteAdmin", siteAdmin).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(eventsUrl).append(siteAdmin).append(gistsUrl).append(type).append(gravatarId).append(subscriptionsUrl).append(url).append(followersUrl).append(id).append(reposUrl).append(htmlUrl).append(nodeId).append(receivedEventsUrl).append(avatarUrl).append(followingUrl).append(organizationsUrl).append(login).append(starredUrl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Owner) == false) {
            return false;
        }
        Owner rhs = ((Owner) other);
        return new EqualsBuilder().append(eventsUrl, rhs.eventsUrl).append(siteAdmin, rhs.siteAdmin).append(gistsUrl, rhs.gistsUrl).append(type, rhs.type).append(gravatarId, rhs.gravatarId).append(subscriptionsUrl, rhs.subscriptionsUrl).append(url, rhs.url).append(followersUrl, rhs.followersUrl).append(id, rhs.id).append(reposUrl, rhs.reposUrl).append(htmlUrl, rhs.htmlUrl).append(nodeId, rhs.nodeId).append(receivedEventsUrl, rhs.receivedEventsUrl).append(avatarUrl, rhs.avatarUrl).append(followingUrl, rhs.followingUrl).append(organizationsUrl, rhs.organizationsUrl).append(login, rhs.login).append(starredUrl, rhs.starredUrl).isEquals();
    }

}
