package com.dwview.profileviewer;

import com.dwview.profileviewer.representations.View;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alberto on 2015-09-27.
 */
public class FilterBasedRules {

    public FilterBasedRules() {
    }

    public List<View> filterBasedOnLimitAndDays(List<View> views) {
        views = views.stream().filter(view ->
                (new DateTime(view.getDateTime())).isAfter(DateTime.now().minusDays(10)))
                .limit(10)
                .collect(Collectors.toList());
        return views;
    }

    public void sortBasedOnDateTime(List<View> views) {
        Collections.sort(views, (o1, o2) -> {
            DateTime o1Date = new DateTime(o1.getDateTime());
            DateTime o2Date = new DateTime(o1.getDateTime());
            return DateTimeComparator.getInstance().compare(o1Date, o2Date);
        });
    }
}
