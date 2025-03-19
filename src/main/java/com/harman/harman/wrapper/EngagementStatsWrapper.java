package com.harman.harman.wrapper;

public class EngagementStatsWrapper {

    private Integer impressions;
    private Integer views;

    public EngagementStatsWrapper(Integer impressions, Integer views) {
        this.impressions = impressions;
        this.views = views;
    }

    public long getImpressions() {
        return impressions;
    }

    public void setImpressions(Integer impressions) {
        this.impressions = impressions;
    }

    public long getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "EngagementStatsWrapper{" +
                "impressions=" + impressions +
                ", views=" + views +
                '}';
    }
}
