package com.dwview.profileviewer;

import com.dwview.profileviewer.resources.ViewTrackerResource;
import com.dwview.profileviewer.resources.ViewsTrackerResource;
import com.dwview.profileviewer.storage.MockDataStoreImplementation;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Alberto on 2015-09-25.
 *
 */
public class App extends Application<ViewTrackerConfiguration>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<ViewTrackerConfiguration> configurationBootstrap){}
    @Override
    public void run(ViewTrackerConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Method App#run() called");
        MockDataStoreImplementation mockDataStoreImplementation =new MockDataStoreImplementation();
        final ViewsTrackerResource viewsTrackerResource = new ViewsTrackerResource(mockDataStoreImplementation);
        final ViewTrackerResource viewTrackerResource = new ViewTrackerResource(mockDataStoreImplementation);

        environment.jersey().register(viewTrackerResource);
        environment.jersey().register(viewsTrackerResource);
    }
}
