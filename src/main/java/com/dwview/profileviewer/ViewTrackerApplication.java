package com.dwview.profileviewer;

import com.dwview.profileviewer.db.ViewDAO;
import com.dwview.profileviewer.health.ApplicationHealthCheck;
import com.dwview.profileviewer.representations.View;
import com.dwview.profileviewer.resources.ViewTrackerResource;
import com.dwview.profileviewer.resources.ViewsTrackerResource;
import com.dwview.profileviewer.util.FilterBasedRules;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Alberto on 2015-09-25.
 *
 */
public class ViewTrackerApplication extends Application<ViewTrackerConfiguration>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ViewTrackerApplication.class);

    public static void main( String[] args ) throws Exception {
        new ViewTrackerApplication().run(args);
    }

    private final HibernateBundle<ViewTrackerConfiguration> hibernate =
            new HibernateBundle<ViewTrackerConfiguration>(View.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(ViewTrackerConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<ViewTrackerConfiguration> configurationBootstrap){
        configurationBootstrap.addBundle(hibernate);
    }
    @Override
    public void run(ViewTrackerConfiguration configuration, Environment environment) throws Exception {
        LOGGER.info("Method App#run() called");
        final ViewDAO viewDAO = new ViewDAO(hibernate.getSessionFactory());
        final FilterBasedRules filterBasedRules = new FilterBasedRules();
        final ViewsTrackerResource viewsTrackerResource = new ViewsTrackerResource(viewDAO,filterBasedRules);
        final ViewTrackerResource viewTrackerResource = new ViewTrackerResource(viewDAO);

        environment.healthChecks().register("ViewTrackerService", new ApplicationHealthCheck());
        environment.jersey().register(viewTrackerResource);
        environment.jersey().register(viewsTrackerResource);
    }
}
