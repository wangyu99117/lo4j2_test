package autoDowngrade.impl;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.message.StringFormatterMessageFactory;
import org.apache.logging.log4j.simple.SimpleLoggerContextFactory;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.apache.logging.log4j.spi.Provider;
import org.apache.logging.log4j.spi.Terminable;
import org.apache.logging.log4j.status.StatusLogger;
import org.apache.logging.log4j.util.LoaderUtil;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.ProviderUtil;
import org.apache.logging.log4j.util.ReflectionUtil;

import java.net.URI;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MyLogManager {
    public static final String FACTORY_PROPERTY_NAME = "log4j2.loggerContextFactory";
    public static final String ROOT_LOGGER_NAME = "";
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final String FQCN = MyLogManager.class.getName();
    private static volatile LoggerContextFactory factory;

    protected MyLogManager() {
    }

    public static boolean exists(String name) {
        return getContext().hasLogger(name);
    }

    public static LoggerContext getContext() {
        try {
            return factory.getContext(FQCN, (ClassLoader)null, (Object)null, true);
        } catch (IllegalStateException var1) {
            LOGGER.warn(var1.getMessage() + " Using SimpleLogger");
            return (new SimpleLoggerContextFactory()).getContext(FQCN, (ClassLoader)null, (Object)null, true);
        }
    }

    public static LoggerContext getContext(boolean currentContext) {
        try {
            return factory.getContext(FQCN, (ClassLoader)null, (Object)null, currentContext, (URI)null, (String)null);
        } catch (IllegalStateException var2) {
            LOGGER.warn(var2.getMessage() + " Using SimpleLogger");
            return (new SimpleLoggerContextFactory()).getContext(FQCN, (ClassLoader)null, (Object)null, currentContext, (URI)null, (String)null);
        }
    }

    public static org.apache.logging.log4j.core.LoggerContext getUsedContext(boolean currentContext) {
        try {
            LoggerContext ctx = factory.getContext(FQCN, (ClassLoader)null, (Object)null, currentContext, (URI)null, (String)null);
            if(ctx instanceof  org.apache.logging.log4j.core.LoggerContext){
                return (org.apache.logging.log4j.core.LoggerContext)ctx;
            }

        } catch (IllegalStateException var2) {
            LOGGER.warn(var2.getMessage() + " Using SimpleLogger");
            //return (new SimpleLoggerContextFactory()).getContext(FQCN, (ClassLoader)null, (Object)null, currentContext, (URI)null, (String)null);
        }
        return null;
    }

    public static LoggerContext getContext(ClassLoader loader, boolean currentContext) {
        try {
            return factory.getContext(FQCN, loader, (Object)null, currentContext);
        } catch (IllegalStateException var3) {
            LOGGER.warn(var3.getMessage() + " Using SimpleLogger");
            return (new SimpleLoggerContextFactory()).getContext(FQCN, loader, (Object)null, currentContext);
        }
    }

    public static LoggerContext getContext(ClassLoader loader, boolean currentContext, Object externalContext) {
        try {
            return factory.getContext(FQCN, loader, externalContext, currentContext);
        } catch (IllegalStateException var4) {
            LOGGER.warn(var4.getMessage() + " Using SimpleLogger");
            return (new SimpleLoggerContextFactory()).getContext(FQCN, loader, externalContext, currentContext);
        }
    }

    public static LoggerContext getContext(ClassLoader loader, boolean currentContext, URI configLocation) {
        try {
            return factory.getContext(FQCN, loader, (Object)null, currentContext, configLocation, (String)null);
        } catch (IllegalStateException var4) {
            LOGGER.warn(var4.getMessage() + " Using SimpleLogger");
            return (new SimpleLoggerContextFactory()).getContext(FQCN, loader, (Object)null, currentContext, configLocation, (String)null);
        }
    }

    public static LoggerContext getContext(ClassLoader loader, boolean currentContext, Object externalContext, URI configLocation) {
        try {
            return factory.getContext(FQCN, loader, externalContext, currentContext, configLocation, (String)null);
        } catch (IllegalStateException var5) {
            LOGGER.warn(var5.getMessage() + " Using SimpleLogger");
            return (new SimpleLoggerContextFactory()).getContext(FQCN, loader, externalContext, currentContext, configLocation, (String)null);
        }
    }

    public static LoggerContext getContext(ClassLoader loader, boolean currentContext, Object externalContext, URI configLocation, String name) {
        try {
            return factory.getContext(FQCN, loader, externalContext, currentContext, configLocation, name);
        } catch (IllegalStateException var6) {
            LOGGER.warn(var6.getMessage() + " Using SimpleLogger");
            return (new SimpleLoggerContextFactory()).getContext(FQCN, loader, externalContext, currentContext, configLocation, name);
        }
    }

    protected static LoggerContext getContext(String fqcn, boolean currentContext) {
        try {
            return factory.getContext(fqcn, (ClassLoader)null, (Object)null, currentContext);
        } catch (IllegalStateException var3) {
            LOGGER.warn(var3.getMessage() + " Using SimpleLogger");
            return (new SimpleLoggerContextFactory()).getContext(fqcn, (ClassLoader)null, (Object)null, currentContext);
        }
    }

    protected static LoggerContext getContext(String fqcn, ClassLoader loader, boolean currentContext) {
        try {
            return factory.getContext(fqcn, loader, (Object)null, currentContext);
        } catch (IllegalStateException var4) {
            LOGGER.warn(var4.getMessage() + " Using SimpleLogger");
            return (new SimpleLoggerContextFactory()).getContext(fqcn, loader, (Object)null, currentContext);
        }
    }

    public static void shutdown() {
        shutdown(false);
    }

    public static void shutdown(boolean currentContext) {
        shutdown(getContext(currentContext));
    }

    public static void shutdown(LoggerContext context) {
        if(context != null && context instanceof Terminable) {
            ((Terminable)context).terminate();
        }

    }

    public static LoggerContextFactory getFactory() {
        return factory;
    }

    public static void setFactory(LoggerContextFactory factory) {
        factory = factory;
    }

    public static Logger getFormatterLogger() {
        return getFormatterLogger(ReflectionUtil.getCallerClass(2));
    }

    public static Logger getFormatterLogger(Class<?> clazz) {
        return getLogger((Class)(clazz != null?clazz:ReflectionUtil.getCallerClass(2)), (MessageFactory) StringFormatterMessageFactory.INSTANCE);
    }

    public static Logger getFormatterLogger(Object value) {
        return getLogger((Class)(value != null?value.getClass():ReflectionUtil.getCallerClass(2)), (MessageFactory)StringFormatterMessageFactory.INSTANCE);
    }

    public static Logger getFormatterLogger(String name) {
        return name == null?getFormatterLogger(ReflectionUtil.getCallerClass(2)):getLogger((String)name, (MessageFactory)StringFormatterMessageFactory.INSTANCE);
    }

    private static Class<?> callerClass(Class<?> clazz) {
        if(clazz != null) {
            return clazz;
        } else {
            Class candidate = ReflectionUtil.getCallerClass(3);
            if(candidate == null) {
                throw new UnsupportedOperationException("No class provided, and an appropriate one cannot be found.");
            } else {
                return candidate;
            }
        }
    }

    public static Logger getLogger() {
        return getLogger(ReflectionUtil.getCallerClass(2));
    }

    public static Logger getLogger(Class<?> clazz) {
        Class cls = callerClass(clazz);
        return getContext(cls.getClassLoader(), false).getLogger(cls.getName());
    }

    public static Logger getLogger(Class<?> clazz, MessageFactory messageFactory) {
        Class cls = callerClass(clazz);
        return getContext(cls.getClassLoader(), false).getLogger(cls.getName(), messageFactory);
    }

    public static Logger getLogger(MessageFactory messageFactory) {
        return getLogger(ReflectionUtil.getCallerClass(2), messageFactory);
    }

    public static Logger getLogger(Object value) {
        return getLogger(value != null?value.getClass():ReflectionUtil.getCallerClass(2));
    }

    public static Logger getLogger(Object value, MessageFactory messageFactory) {
        return getLogger(value != null?value.getClass():ReflectionUtil.getCallerClass(2), messageFactory);
    }

    public static Logger getLogger(String name) {
        return (Logger)(name != null?getContext(false).getLogger(name):getLogger(ReflectionUtil.getCallerClass(2)));
    }

    public static Logger getLogger(String name, MessageFactory messageFactory) {
        return (Logger)(name != null?getContext(false).getLogger(name, messageFactory):getLogger(ReflectionUtil.getCallerClass(2), messageFactory));
    }

    protected static Logger getLogger(String fqcn, String name) {
        return factory.getContext(fqcn, (ClassLoader)null, (Object)null, false).getLogger(name);
    }

    public static Logger getRootLogger() {
        return getLogger("");
    }

    static {
        PropertiesUtil managerProps = PropertiesUtil.getProperties();
        String factoryClassName = managerProps.getStringProperty("log4j2.loggerContextFactory");
        if(factoryClassName != null) {
            try {
                factory = (LoggerContextFactory) LoaderUtil.newCheckedInstanceOf(factoryClassName, LoggerContextFactory.class);
            } catch (ClassNotFoundException var8) {
                LOGGER.error("Unable to locate configured LoggerContextFactory {}", factoryClassName);
            } catch (Exception var9) {
                LOGGER.error("Unable to create configured LoggerContextFactory {}", factoryClassName, var9);
            }
        }

        if(factory == null) {
            TreeMap factories = new TreeMap();
            if(ProviderUtil.hasProviders()) {
                Iterator sb = ProviderUtil.getProviders().iterator();

                while(sb.hasNext()) {
                    Provider i$ = (Provider)sb.next();
                    Class entry = i$.loadLoggerContextFactory();
                    if(entry != null) {
                        try {
                            factories.put(i$.getPriority(), entry.newInstance());
                        } catch (Exception var7) {
                            LOGGER.error("Unable to create class {} specified in {}", entry.getName(), i$.getUrl().toString(), var7);
                        }
                    }
                }

                if(factories.isEmpty()) {
                    LOGGER.error("Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...");
                    factory = new SimpleLoggerContextFactory();
                } else if(factories.size() == 1) {
                    factory = (LoggerContextFactory)new MyLog4jContextFactory();
                    //factory = (LoggerContextFactory)factories.get(factories.lastKey());
                } else {
                    StringBuilder sb1 = new StringBuilder("Multiple logging implementations found: \n");
                    Iterator i$1 = factories.entrySet().iterator();

                    while(i$1.hasNext()) {
                        Entry entry1 = (Entry)i$1.next();
                        sb1.append("Factory: ").append(((LoggerContextFactory)entry1.getValue()).getClass().getName());
                        sb1.append(", Weighting: ").append(entry1.getKey()).append('\n');
                    }

                    factory = (LoggerContextFactory)factories.get(factories.lastKey());
                    sb1.append("Using factory: ").append(factory.getClass().getName());
                    LOGGER.warn(sb1.toString());
                }
            } else {
                LOGGER.error("Log4j2 could not find a logging implementation. Please add log4j-core to the classpath. Using SimpleLogger to log to the console...");
                factory = new SimpleLoggerContextFactory();
            }
        }

    }
}

