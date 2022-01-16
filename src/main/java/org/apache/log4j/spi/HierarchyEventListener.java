package org.apache.log4j.spi;

import org.apache.log4j.Appender;
import org.apache.log4j.Category;

/**
 * 层级时间监听器
 */
public interface HierarchyEventListener {
    /**
     * 添加日志、附件器事件
     *
     * @param cat      日志
     * @param appender 附加器
     */
    void addAppenderEvent(Category cat, Appender appender);

    /**
     * 移除日志、附加器事件
     * @param cat 日志
     * @param appender 附加器
     */
    void removeAppenderEvent(Category cat, Appender appender);
}
