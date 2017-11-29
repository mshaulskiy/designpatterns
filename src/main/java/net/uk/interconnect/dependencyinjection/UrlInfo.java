package net.uk.interconnect.dependencyinjection;


public class UrlInfo {

    // We've seen this helper class before. We'll use it to store the data for each url

    private String url;
    private String headline;
    private String summary;

    public UrlInfo(String url) {
        this.setUrl(url);
        this.setHeadline(url);
        this.setSummary("");
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
