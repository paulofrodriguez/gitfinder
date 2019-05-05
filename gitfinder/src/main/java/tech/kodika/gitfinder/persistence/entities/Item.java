
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {


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

    @SerializedName("name")
    @Expose
    @Getter
    @Setter
    public String name;

    @SerializedName("full_name")
    @Expose
    @Getter
    @Setter
    public String fullName;

    @SerializedName("private")
    @Expose
    @Getter
    @Setter
    public Boolean _private;

    @OneToOne
    @SerializedName("owner")
    @Expose
    @Getter
    @Setter
    public Owner owner;

    @SerializedName("html_url")
    @Expose
    @Getter
    @Setter
    public String htmlUrl;

    @SerializedName("description")
    @Expose
    @Getter
    @Setter
    public String description;

    @SerializedName("fork")
    @Expose
    @Getter
    @Setter
    public Boolean fork;

    @SerializedName("url")
    @Expose
    @Getter
    @Setter
    public String url;

    @SerializedName("forks_url")
    @Expose
    @Getter
    @Setter
    public String forksUrl;

    @SerializedName("keys_url")
    @Expose
    @Getter
    @Setter
    public String keysUrl;

    @SerializedName("collaborators_url")
    @Expose
    @Getter
    @Setter
    public String collaboratorsUrl;

    @SerializedName("teams_url")
    @Expose
    @Getter
    @Setter
    public String teamsUrl;

    @SerializedName("hooks_url")
    @Expose
    @Getter
    @Setter
    public String hooksUrl;

    @SerializedName("issue_events_url")
    @Expose
    @Getter
    @Setter
    public String issueEventsUrl;

    @SerializedName("events_url")
    @Expose
    @Getter
    @Setter
    public String eventsUrl;

    @SerializedName("assignees_url")
    @Expose
    @Getter
    @Setter
    public String assigneesUrl;

    @SerializedName("branches_url")
    @Expose
    @Getter
    @Setter
    public String branchesUrl;

    @SerializedName("tags_url")
    @Expose
    @Getter
    @Setter
    public String tagsUrl;

    @SerializedName("blobs_url")
    @Expose
    @Getter
    @Setter
    public String blobsUrl;

    @SerializedName("git_tags_url")
    @Expose
    @Getter
    @Setter
    public String gitTagsUrl;

    @SerializedName("git_refs_url")
    @Expose
    @Getter
    @Setter
    public String gitRefsUrl;

    @SerializedName("trees_url")
    @Expose
    @Getter
    @Setter
    public String treesUrl;

    @SerializedName("statuses_url")
    @Expose
    @Getter
    @Setter
    public String statusesUrl;

    @SerializedName("languages_url")
    @Expose
    @Getter
    @Setter
    public String languagesUrl;

    @SerializedName("stargazers_url")
    @Expose
    @Getter
    @Setter
    public String stargazersUrl;

    @SerializedName("contributors_url")
    @Expose
    @Getter
    @Setter
    public String contributorsUrl;

    @SerializedName("subscribers_url")
    @Expose
    @Getter
    @Setter
    public String subscribersUrl;

    @SerializedName("subscription_url")
    @Expose
    @Getter
    @Setter
    public String subscriptionUrl;

    @SerializedName("commits_url")
    @Expose
    @Getter
    @Setter
    public String commitsUrl;

    @SerializedName("git_commits_url")
    @Expose
    @Getter
    @Setter
    public String gitCommitsUrl;

    @SerializedName("comments_url")
    @Expose
    @Getter
    @Setter
    public String commentsUrl;

    @SerializedName("issue_comment_url")
    @Expose
    @Getter
    @Setter
    public String issueCommentUrl;

    @SerializedName("contents_url")
    @Expose
    @Getter
    @Setter
    public String contentsUrl;

    @SerializedName("compare_url")
    @Expose
    @Getter
    @Setter
    public String compareUrl;

    @SerializedName("merges_url")
    @Expose
    @Getter
    @Setter
    public String mergesUrl;

    @SerializedName("archive_url")
    @Expose
    @Getter
    @Setter
    public String archiveUrl;

    @SerializedName("downloads_url")
    @Expose
    @Getter
    @Setter
    public String downloadsUrl;

    @SerializedName("issues_url")
    @Expose
    @Getter
    @Setter
    public String issuesUrl;

    @SerializedName("pulls_url")
    @Expose
    @Getter
    @Setter
    public String pullsUrl;

    @SerializedName("milestones_url")
    @Expose
    @Getter
    @Setter
    public String milestonesUrl;

    @SerializedName("notifications_url")
    @Expose
    @Getter
    @Setter
    public String notificationsUrl;

    @SerializedName("labels_url")
    @Expose
    @Getter
    @Setter
    public String labelsUrl;

    @SerializedName("releases_url")
    @Expose
    @Getter
    @Setter
    public String releasesUrl;

    @SerializedName("deployments_url")
    @Expose
    @Getter
    @Setter
    public String deploymentsUrl;

    @SerializedName("created_at")
    @Expose
    @Getter
    @Setter
    public String createdAt;

    @SerializedName("updated_at")
    @Expose
    @Getter
    @Setter
    public String updatedAt;

    @SerializedName("pushed_at")
    @Expose
    @Getter
    @Setter
    public String pushedAt;

    @SerializedName("git_url")
    @Expose
    @Getter
    @Setter
    public String gitUrl;

    @SerializedName("ssh_url")
    @Expose
    @Getter
    @Setter
    public String sshUrl;

    @SerializedName("clone_url")
    @Expose
    @Getter
    @Setter
    public String cloneUrl;

    @SerializedName("svn_url")
    @Expose
    @Getter
    @Setter
    public String svnUrl;

    @SerializedName("homepage")
    @Expose
    @Getter
    @Setter
    public String homepage;

    @SerializedName("size")
    @Expose
    @Getter
    @Setter
    public Integer size;

    @SerializedName("stargazers_count")
    @Expose
    @Getter
    @Setter
    public Integer stargazersCount;

    @SerializedName("watchers_count")
    @Expose
    @Getter
    @Setter
    public Integer watchersCount;

    @SerializedName("language")
    @Expose
    @Getter
    @Setter
    public String language;

    @SerializedName("has_issues")
    @Expose
    @Getter
    @Setter
    public Boolean hasIssues;

    @SerializedName("has_projects")
    @Expose
    @Getter
    @Setter
    public Boolean hasProjects;

    @SerializedName("has_downloads")
    @Expose
    @Getter
    @Setter
    public Boolean hasDownloads;

    @SerializedName("has_wiki")
    @Expose
    @Getter
    @Setter
    public Boolean hasWiki;

    @SerializedName("has_pages")
    @Expose
    @Getter
    @Setter
    public Boolean hasPages;

    @SerializedName("forks_count")
    @Expose
    @Getter
    @Setter
    public Integer forksCount;

    @SerializedName("mirror_url")
    @Expose
    @Getter
    @Setter
    public String mirrorUrl;

    @SerializedName("archived")
    @Expose
    @Getter
    @Setter
    public Boolean archived;

    @SerializedName("disabled")
    @Expose
    @Getter
    @Setter
    public Boolean disabled;

    @SerializedName("open_issues_count")
    @Expose
    @Getter
    @Setter
    public Integer openIssuesCount;

    @OneToOne
    @SerializedName("license")
    @Expose
    @Getter
    @Setter
    public License license;

    @SerializedName("forks")
    @Expose
    @Getter
    @Setter
    public Integer forks;

    @SerializedName("open_issues")
    @Expose
    @Getter
    @Setter
    public Integer openIssues;

    @SerializedName("watchers")
    @Expose
    @Getter
    @Setter
    public Integer watchers;

    @SerializedName("default_branch")
    @Expose
    @Getter
    @Setter
    public String defaultBranch;

    @SerializedName("score")
    @Expose
    @Getter
    @Setter
    public Double score;

    @Override
    public String toString() {

        return new ToStringBuilder(this).append("id", id).append("nodeId", nodeId).append("name", name).append("fullName", fullName).append("_private", _private).append("owner", owner).append("htmlUrl", htmlUrl).append("description", description).append("fork", fork).append("url", url).append("forksUrl", forksUrl).append("keysUrl", keysUrl).append("collaboratorsUrl", collaboratorsUrl).append("teamsUrl", teamsUrl).append("hooksUrl", hooksUrl).append("issueEventsUrl", issueEventsUrl).append("eventsUrl", eventsUrl).append("assigneesUrl", assigneesUrl).append("branchesUrl", branchesUrl).append("tagsUrl", tagsUrl).append("blobsUrl", blobsUrl).append("gitTagsUrl", gitTagsUrl).append("gitRefsUrl", gitRefsUrl).append("treesUrl", treesUrl).append("statusesUrl", statusesUrl).append("languagesUrl", languagesUrl).append("stargazersUrl", stargazersUrl).append("contributorsUrl", contributorsUrl).append("subscribersUrl", subscribersUrl).append("subscriptionUrl", subscriptionUrl).append("commitsUrl", commitsUrl).append("gitCommitsUrl", gitCommitsUrl).append("commentsUrl", commentsUrl).append("issueCommentUrl", issueCommentUrl).append("contentsUrl", contentsUrl).append("compareUrl", compareUrl).append("mergesUrl", mergesUrl).append("archiveUrl", archiveUrl).append("downloadsUrl", downloadsUrl).append("issuesUrl", issuesUrl).append("pullsUrl", pullsUrl).append("milestonesUrl", milestonesUrl).append("notificationsUrl", notificationsUrl).append("labelsUrl", labelsUrl).append("releasesUrl", releasesUrl).append("deploymentsUrl", deploymentsUrl).append("createdAt", createdAt).append("updatedAt", updatedAt).append("pushedAt", pushedAt).append("gitUrl", gitUrl).append("sshUrl", sshUrl).append("cloneUrl", cloneUrl).append("svnUrl", svnUrl).append("homepage", homepage).append("size", size).append("stargazersCount", stargazersCount).append("watchersCount", watchersCount).append("language", language).append("hasIssues", hasIssues).append("hasProjects", hasProjects).append("hasDownloads", hasDownloads).append("hasWiki", hasWiki).append("hasPages", hasPages).append("forksCount", forksCount).append("mirrorUrl", mirrorUrl).append("archived", archived).append("disabled", disabled).append("openIssuesCount", openIssuesCount).append("license", license).append("forks", forks).append("openIssues", openIssues).append("watchers", watchers).append("defaultBranch", defaultBranch).append("score", score).toString();

    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(releasesUrl).append(notificationsUrl).append(pushedAt).append(gitTagsUrl).append(score).append(contentsUrl).append(blobsUrl).append(issueEventsUrl).append(htmlUrl).append(nodeId).append(_private).append(commentsUrl).append(hooksUrl).append(description).append(commitsUrl).append(labelsUrl).append(assigneesUrl).append(mergesUrl).append(fork).append(compareUrl).append(stargazersUrl).append(gitRefsUrl).append(deploymentsUrl).append(watchersCount).append(openIssuesCount).append(mirrorUrl).append(homepage).append(url).append(size).append(keysUrl).append(milestonesUrl).append(gitCommitsUrl).append(downloadsUrl).append(pullsUrl).append(issueCommentUrl).append(owner).append(forksUrl).append(hasProjects).append(language).append(statusesUrl).append(eventsUrl).append(openIssues).append(teamsUrl).append(sshUrl).append(contributorsUrl).append(stargazersCount).append(tagsUrl).append(id).append(hasIssues).append(archived).append(createdAt).append(name).append(treesUrl).append(cloneUrl).append(issuesUrl).append(license).append(gitUrl).append(forksCount).append(watchers).append(subscriptionUrl).append(svnUrl).append(archiveUrl).append(hasPages).append(languagesUrl).append(updatedAt).append(collaboratorsUrl).append(forks).append(hasDownloads).append(subscribersUrl).append(branchesUrl).append(fullName).append(hasWiki).append(disabled).append(defaultBranch).toHashCode();

    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {

            return true;

        }
        if ((other instanceof Item) == false) {

            return false;

        }

        Item rhs = ((Item) other);

        return new EqualsBuilder().append(releasesUrl, rhs.releasesUrl).append(notificationsUrl, rhs.notificationsUrl).append(pushedAt, rhs.pushedAt).append(gitTagsUrl, rhs.gitTagsUrl).append(score, rhs.score).append(contentsUrl, rhs.contentsUrl).append(blobsUrl, rhs.blobsUrl).append(issueEventsUrl, rhs.issueEventsUrl).append(htmlUrl, rhs.htmlUrl).append(nodeId, rhs.nodeId).append(_private, rhs._private).append(commentsUrl, rhs.commentsUrl).append(hooksUrl, rhs.hooksUrl).append(description, rhs.description).append(commitsUrl, rhs.commitsUrl).append(labelsUrl, rhs.labelsUrl).append(assigneesUrl, rhs.assigneesUrl).append(mergesUrl, rhs.mergesUrl).append(fork, rhs.fork).append(compareUrl, rhs.compareUrl).append(stargazersUrl, rhs.stargazersUrl).append(gitRefsUrl, rhs.gitRefsUrl).append(deploymentsUrl, rhs.deploymentsUrl).append(watchersCount, rhs.watchersCount).append(openIssuesCount, rhs.openIssuesCount).append(mirrorUrl, rhs.mirrorUrl).append(homepage, rhs.homepage).append(url, rhs.url).append(size, rhs.size).append(keysUrl, rhs.keysUrl).append(milestonesUrl, rhs.milestonesUrl).append(gitCommitsUrl, rhs.gitCommitsUrl).append(downloadsUrl, rhs.downloadsUrl).append(pullsUrl, rhs.pullsUrl).append(issueCommentUrl, rhs.issueCommentUrl).append(owner, rhs.owner).append(forksUrl, rhs.forksUrl).append(hasProjects, rhs.hasProjects).append(language, rhs.language).append(statusesUrl, rhs.statusesUrl).append(eventsUrl, rhs.eventsUrl).append(openIssues, rhs.openIssues).append(teamsUrl, rhs.teamsUrl).append(sshUrl, rhs.sshUrl).append(contributorsUrl, rhs.contributorsUrl).append(stargazersCount, rhs.stargazersCount).append(tagsUrl, rhs.tagsUrl).append(id, rhs.id).append(hasIssues, rhs.hasIssues).append(archived, rhs.archived).append(createdAt, rhs.createdAt).append(name, rhs.name).append(treesUrl, rhs.treesUrl).append(cloneUrl, rhs.cloneUrl).append(issuesUrl, rhs.issuesUrl).append(license, rhs.license).append(gitUrl, rhs.gitUrl).append(forksCount, rhs.forksCount).append(watchers, rhs.watchers).append(subscriptionUrl, rhs.subscriptionUrl).append(svnUrl, rhs.svnUrl).append(archiveUrl, rhs.archiveUrl).append(hasPages, rhs.hasPages).append(languagesUrl, rhs.languagesUrl).append(updatedAt, rhs.updatedAt).append(collaboratorsUrl, rhs.collaboratorsUrl).append(forks, rhs.forks).append(hasDownloads, rhs.hasDownloads).append(subscribersUrl, rhs.subscribersUrl).append(branchesUrl, rhs.branchesUrl).append(fullName, rhs.fullName).append(hasWiki, rhs.hasWiki).append(disabled, rhs.disabled).append(defaultBranch, rhs.defaultBranch).isEquals();
    }

}
