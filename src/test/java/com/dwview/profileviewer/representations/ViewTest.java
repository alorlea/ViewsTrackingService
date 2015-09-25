package com.dwview.profileviewer.representations;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class ViewTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serializeToJSON() throws Exception{
        final View view = new View(10);
        assertThat(MAPPER.writeValueAsString(view)).isEqualTo(fixture("fixtures/view.json"));
    }

    @Test
    public void deserializeFromJSON() throws Exception{
        final View view = new View(10);
        assertThat(MAPPER.readValue(fixture("fixtures/view.json"),View.class));
    }

}