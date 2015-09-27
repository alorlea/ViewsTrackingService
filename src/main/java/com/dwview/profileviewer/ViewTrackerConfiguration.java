package com.dwview.profileviewer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by alberto on 2015-09-25.
 */
public class ViewTrackerConfiguration extends Configuration{

    @Valid
    @NotNull
    private FilterOptionsFactory filterRules = new FilterOptionsFactory();

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.database = dataSourceFactory;
    }

    @JsonProperty("filterRules")
    public FilterOptionsFactory getFilterRules() {
        return filterRules;
    }

    @JsonProperty("filterRules")
    public void setFilterRules(FilterOptionsFactory filterRules) {
        this.filterRules = filterRules;
    }

    public DataSourceFactory getDatabase() {
        return database;
    }

    public void setDatabase(DataSourceFactory database) {
        this.database = database;
    }
}
