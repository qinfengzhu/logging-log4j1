package org.apache.log4j;

import org.apache.log4j.spi.LoggerFactory;

/**
 * 默认日志构建工厂
 * 工厂模式
 */
class DefaultCategoryFactory implements LoggerFactory {

    DefaultCategoryFactory() {
    }

    public Logger makeNewLoggerInstance(String name) {
        return new Logger(name);
    }
}
