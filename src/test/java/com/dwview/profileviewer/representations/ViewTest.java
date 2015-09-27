package com.dwview.profileviewer.representations;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Alberto on 2015-09-26.
 */
public class ViewTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private DateTime localDateTime;
    @Before
    public void setup(){
        localDateTime = new DateTime("2004-12-14T06:39:45.618+01:00");
    }

    @Test
    public void serializeToJSON() throws Exception{
        final View view = new View(10, 10,localDateTime);
        assertThat(MAPPER.writeValueAsString(view)).isEqualTo(fixture("fixtures/view.json"));
    }

    @Test
    public void deserializeFromJSON() throws Exception{
        final View view = new View(10, 10,localDateTime);
        assertThat(MAPPER.readValue(fixture("fixtures/view.json"),View.class));
    }
}
