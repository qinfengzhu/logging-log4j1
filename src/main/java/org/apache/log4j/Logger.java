package org.apache.log4j;

import org.apache.log4j.spi.LoggerFactory;


/**
 * This is the central class in the log4j package. Most logging
 * operations, except configuration, are done through this class.
 * Log4j的核心操作类,除开配置所有的操作都在该类中
 */
public class Logger extends Category {

    /**
     * The fully qualified name of the Logger class. See also the
     * getFQCN method.
     * Logger日志类全局唯一名称
     */
    private static final String FQCN = Logger.class.getName();

    protected Logger(String name) {
        super(name);
    }

    /**
     * Retrieve a logger named according to the value of the
     * <code>name</code> parameter. If the named logger already exists,
     * then the existing instance will be returned. Otherwise, a new
     * instance is created.
     *
     * <p>By default, loggers do not have a set level but inherit it
     * from their neareast ancestor with a set level. This is one of the
     * central features of log4j.
     * 获取日志记录器,hierarchy 日志类是垂直继承冒泡查找Level、Appender、Layout
     *
     * @param name The name of the logger to retrieve.
     */
    static
    public Logger getLogger(String name) {
        return LogManager.getLogger(name);
    }

    /**
     * Shorthand for <code>getLogger(clazz.getName())</code>.
     * 根据类名称获取日志记录器,类名称中带 . ,日志层级关系可以通过. 进行识别
     */
    static
    public Logger getLogger(Class clazz) {
        return LogManager.getLogger(clazz.getName());
    }


    /**
     * Return the root logger for the current logger repository.
     * <p>
     * The {@link #getName Logger.getName()} method for the root logger always returns
     * string value: "root". However, calling
     * <code>Logger.getLogger("root")</code> does not retrieve the root
     * logger but a logger just under root named "root".
     * <p>
     * In other words, calling this method is the only way to retrieve the
     * root logger.
     * 获取根日志记录器,所有的日志记录器的祖先
     */
    public
    static Logger getRootLogger() {
        return LogManager.getRootLogger();
    }

    /**
     * Like {@link #getLogger(String)} except that the type of logger
     * instantiated depends on the type returned by the {@link
     * LoggerFactory#makeNewLoggerInstance} method of the
     * <code>factory</code> parameter.
     *
     * <p>This method is intended to be used by sub-classes.
     *
     * @param name    The name of the logger to retrieve.
     * @param factory A {@link LoggerFactory} implementation that will
     *                actually create a new Instance.
     * 获取日志记录器,根据日志工厂生成获得
     */
    public
    static Logger getLogger(String name, LoggerFactory factory) {
        return LogManager.getLogger(name, factory);
    }

    /**
     * Log a message object with the {@link org.apache.log4j.Level#TRACE TRACE} level.
     *
     * @param message the message object to log.
     * @see #debug(Object) for an explanation of the logic applied.
     * 记录跟踪信息
     */
    public void trace(Object message) {
        if (repository.isDisabled(Level.TRACE_INT)) {
            return;
        }

        if (Level.TRACE.isGreaterOrEqual(this.getEffectiveLevel())) {
            forcedLog(FQCN, Level.TRACE, message, null);
        }
    }

    /**
     * Log a message object with the <code>TRACE</code> level including the
     * stack trace of the {@link Throwable}<code>t</code> passed as parameter.
     *
     * <p>
     * See {@link #debug(Object)} form for more detailed information.
     * </p>
     *
     * @param message the message object to log.
     * @param t       the exception to log, including its stack trace.
     * 记录跟踪信息
     */
    public void trace(Object message, Throwable t) {
        if (repository.isDisabled(Level.TRACE_INT)) {
            return;
        }

        if (Level.TRACE.isGreaterOrEqual(this.getEffectiveLevel())) {
            forcedLog(FQCN, Level.TRACE, message, t);
        }
    }

    /**
     * Check whether this category is enabled for the TRACE  Level.
     *
     * @return boolean - <code>true</code> if this category is enabled for level
     * TRACE, <code>false</code> otherwise.
     * 检查日志记录器是否支持跟踪
     */
    public boolean isTraceEnabled() {
        if (repository.isDisabled(Level.TRACE_INT)) {
            return false;
        }

        return Level.TRACE.isGreaterOrEqual(this.getEffectiveLevel());
    }

}
