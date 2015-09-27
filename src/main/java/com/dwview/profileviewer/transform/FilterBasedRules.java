package com.dwview.profileviewer.transform;

import com.dwview.profileviewer.representations.View;
import org.joda.time.DateTime;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alberto on 2015-09-27.
 */
public class FilterBasedRules {
    public final int numberOfDaysAgeLimitation;
    public final int listMaxLimit;
    public FilterBasedRules(int numberOfDaysAgeLimitation, int listMaxLimit) {
        this.numberOfDaysAgeLimitation = numberOfDaysAgeLimitation;
        this.listMaxLimit = listMaxLimit;
    }

    public List<View> filterBasedOnLimitAndDays(List<View> views) {
        views = views.stream().filter(view ->
                (new DateTime(view.getDateTime())).isAfter(DateTime.now().minusDays(numberOfDaysAgeLimitation)))
                .limit(listMaxLimit)
                .collect(Collectors.toList());
        return views;
    }
}
