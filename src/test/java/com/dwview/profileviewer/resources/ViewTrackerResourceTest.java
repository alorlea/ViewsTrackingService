package com.dwview.profileviewer.resources;

import com.dwview.profileviewer.resources.ViewTrackerResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;

public class ViewTrackerResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ViewTrackerResource())
            .build();
}