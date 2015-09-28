package com.dwview.profileviewer;

import com.dwview.profileviewer.representations.View;
import com.dwview.profileviewer.representations.ViewDataRequest;
import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Alberto on 2015-09-28.
 */
public class IntegrationTest {
    private static final String TMP_FILE = createTempFile();
    private static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("test-configuration.yaml");

    @ClassRule
    public static final DropwizardAppRule<ViewTrackerConfiguration> RULE = new DropwizardAppRule<>(
            ViewTrackerApplication.class, CONFIG_PATH,
            ConfigOverride.config("database.url", "jdbc:h2:" + TMP_FILE));

    private Client client;


    @Before
    public void setUp() throws Exception {
        client = ClientBuilder.newClient();
    }


    @After
    public void tearDown() throws Exception {
        client.close();
    }
    private static String createTempFile() {
        try {
            return File.createTempFile("test-example", null).getAbsolutePath();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void testPutViewer() throws Exception {
        final ViewDataRequest viewDataRequest = new ViewDataRequest(10);
        final Response response = client.target("http://localhost:" + RULE.getLocalPort() + "/view/1")
                .request()
                .put(Entity.json(viewDataRequest));
        assertThat(response.getStatus()).isEqualTo(Response.Status.CREATED.getStatusCode());
    }

    @Test
    public void testPostPerson() throws Exception {
        final List<View> views = client.target("http://localhost:" + RULE.getLocalPort() + "/views/1")
                .request()
                .get(new GenericType<List<View>>(){});
        assertThat(views).isNotEmpty();
        View view = views.get(0);
        assertThat(view.getViewerId()).isEqualTo(10);
        assertThat(view.getDateTime()).isNotNull();
    }
}
