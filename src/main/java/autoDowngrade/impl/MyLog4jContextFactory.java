package autoDowngrade.impl;

import org.apache.logging.log4j.core.LifeCycle;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.impl.ContextAnchor;
import org.apache.logging.log4j.core.impl.Log4jContextFactory;

import java.net.URI;

/**
 * Created by wangyu21 on 2018/3/24.
 */
public class MyLog4jContextFactory extends Log4jContextFactory{

    @Override
    public LoggerContext getContext(String fqcn, ClassLoader loader, Object externalContext, boolean currentContext) {
        LoggerContext ctx = getSelector().getContext(fqcn, loader, currentContext);
        if(externalContext != null && ctx.getExternalContext() == null) {
            ctx.setExternalContext(externalContext);
        }

        if(ctx.getState() == LifeCycle.State.INITIALIZED) {
            ctx.start();
        }
        //ctx.getRootLogger().setLevel(Level.INFO);
        //ctx.getLogger(testLoginfo.class.getName()).setLevel(Level.INFO);
        return ctx;
    }

    @Override
    public LoggerContext getContext(String fqcn, ClassLoader loader, Object externalContext, boolean currentContext, URI configLocation, String name) {
        LoggerContext ctx = getSelector().getContext(fqcn, loader, currentContext, configLocation);
        if(externalContext != null && ctx.getExternalContext() == null) {
            ctx.setExternalContext(externalContext);
        }

        if(name != null) {
            ctx.setName(name);
        }

        if(ctx.getState() == LifeCycle.State.INITIALIZED) {
            if(configLocation == null && name == null) {
                ctx.start();
            } else {
                ContextAnchor.THREAD_CONTEXT.set(ctx);
                Configuration config = ConfigurationFactory.getInstance().getConfiguration(name, configLocation);
                ctx.start(config);
                ContextAnchor.THREAD_CONTEXT.remove();
            }
        }

        return ctx;
    }
}
