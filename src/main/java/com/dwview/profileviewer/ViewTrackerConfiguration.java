package com.dwview.profileviewer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;

/**
 * Created by alberto on 2015-09-25.
 */
public class ViewTrackerConfiguration extends Configuration{
    @JsonProperty
    @NotEmpty
    private String message;
    @JsonProperty
    @Max(10)
    private int messageRepetitions;
    public String getMessage() {
        return message;
    }
    public int getMessageRepetitions() {
        return messageRepetitions;
    }
    @JsonProperty
    private String additionalMessage = "This is optional";
    public String getAdditionalMessage() {
        return additionalMessage;
    }
}
