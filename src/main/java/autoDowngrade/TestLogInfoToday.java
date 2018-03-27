package autoDowngrade;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;

/**
 * Created by wangyu21 on 2018/3/27.
 */
public class TestLogInfoToday {

    public static void main(String[] args){
        LoggerContext ctx = (LoggerContext)LogManager.getContext(false);
        Logger root = ctx.getRootLogger();
        root.setLevel(Level.ERROR);
        org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestLogInfoToday.class);
        logger.info("测试全局");

    }

}
