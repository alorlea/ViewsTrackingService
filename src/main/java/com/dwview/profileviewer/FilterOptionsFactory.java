package com.dwview.profileviewer;

import com.dwview.profileviewer.transform.FilterBasedRules;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.setup.Environment;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by Alberto on 2015-09-27.
 */
public class FilterOptionsFactory {
    @Valid
    @NotNull
    private int numberOfDaysAgeLimitation;
    @Valid
    @NotNull
    private int listLimit;

    @JsonProperty
    public int getNumberOfDaysAgeLimitation() {
        return numberOfDaysAgeLimitation;
    }

    @JsonProperty
    public void setNumberOfDaysAgeLimitation(int numberOfDaysAgeLimitation) {
        this.numberOfDaysAgeLimitation = numberOfDaysAgeLimitation;
    }

    @JsonProperty
    public int getListLimit() {
        return listLimit;
    }

    @JsonProperty
    public void setListLimit(int listLimit) {
        this.listLimit = listLimit;
    }

    public FilterBasedRules build(Environment environment) {
        FilterBasedRules filterBasedRules = new FilterBasedRules(getNumberOfDaysAgeLimitation(), getListLimit());
        return filterBasedRules;
    }
}
