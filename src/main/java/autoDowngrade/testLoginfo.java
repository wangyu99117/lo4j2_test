package autoDowngrade;


import autoDowngrade.impl.MyLogManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

/**
 * Created by wangyu21 on 2018/3/23.
 */
public class TestLoginfo {

    private static Logger log = MyLogManager.getLogger(TestLoginfo.class);
    private static LoggerContext ctx =  MyLogManager.getUsedContext(false);

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        ctx.getRootLogger().setLevel(Level.INFO);
        ctx.getLogger(TestLoginfo.class.getName()).setLevel(Level.INFO);
        /*System.out.println("----------" +testLoginfo.class.getName() + "-----");

        boolean loggerEnable2 = MyLogManager.getContext(false).hasLogger(testLoginfo.class.getName());
        Logger l = MyLogManager.getContext(false).getLogger(testLoginfo.class.getName());
        l.error("---------!" + loggerEnable2 + "----");
        l.error("---------!" + l.equals(log) + " =====----");
        boolean loggerEnable3 = MyLogManager.getContext(MyLogManager.class.getClassLoader(), false).hasLogger(testLoginfo.class.getName());

        boolean loggerEnable = MyLogManager.getContext().hasLogger(testLoginfo.class.getName());
        Logger logger = MyLogManager.getContext().getLogger(testLoginfo.class.getName());
        System.out.println("----------" +loggerEnable + "-----");*/
        while(i < 100000){
            log.info("////" +i + "---------test----");
            System.out.println("////" +i + "----------" +log.isInfoEnabled() + "-----");
            log.error("////" +i + "---------error----");
            if(log.isInfoEnabled()){
                ctx.getRootLogger().setLevel(Level.ERROR);
                ctx.getLogger(TestLoginfo.class.getName()).setLevel(Level.ERROR);
            }else{
                ctx.getRootLogger().setLevel(Level.INFO);
                ctx.getLogger(TestLoginfo.class.getName()).setLevel(Level.INFO);
            }
            Thread.sleep(5000);
            i ++;
        }

    }
}
