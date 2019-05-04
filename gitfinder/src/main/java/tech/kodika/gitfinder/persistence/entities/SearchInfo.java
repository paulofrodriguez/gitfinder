
package tech.kodika.gitfinder.persistence.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "searchInfo")
public class SearchInfo {

    @SerializedName("total_count")
    @Expose
    @Getter
    @Setter
    public Integer totalCount;
    @SerializedName("incomplete_results")
    @Expose
    @Getter
    @Setter
    public Boolean incompleteResults;
    @SerializedName("items")
    @Expose
    @Getter
    @Setter
    public List<Item> items = null;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("totalCount", totalCount).append("incompleteResults", incompleteResults).append("items", items).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(items).append(totalCount).append(incompleteResults).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SearchInfo) == false) {
            return false;
        }
        SearchInfo rhs = ((SearchInfo) other);
        return new EqualsBuilder().append(items, rhs.items).append(totalCount, rhs.totalCount).append(incompleteResults, rhs.incompleteResults).isEquals();
    }

}
