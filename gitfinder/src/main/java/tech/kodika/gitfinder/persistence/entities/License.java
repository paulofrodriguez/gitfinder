
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
@Table(name = "license")
public class License {

    @Id
    @SerializedName("key")
    @Expose
    @Getter
    @Setter
    public String key;
    @SerializedName("name")
    @Expose
    @Getter
    @Setter
    public String name;
    @SerializedName("spdx_id")
    @Expose
    @Getter
    @Setter
    public String spdxId;
    @SerializedName("url")
    @Expose
    @Getter
    @Setter
    public String url;
    @SerializedName("node_id")
    @Expose
    @Getter
    @Setter
    public String nodeId;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("key", key).append("name", name).append("spdxId", spdxId).append("url", url).append("nodeId", nodeId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(nodeId).append(spdxId).append(name).append(url).append(key).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof License) == false) {
            return false;
        }
        License rhs = ((License) other);
        return new EqualsBuilder().append(nodeId, rhs.nodeId).append(spdxId, rhs.spdxId).append(name, rhs.name).append(url, rhs.url).append(key, rhs.key).isEquals();
    }

}
