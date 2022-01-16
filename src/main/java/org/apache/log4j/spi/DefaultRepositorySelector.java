package org.apache.log4j.spi;

/**
 * 日志仓库选择器
 */
public class DefaultRepositorySelector implements RepositorySelector {

    final LoggerRepository repository;

    /**
     * LoggerManager 中的仓库，默认为 Hierarchy
     *
     * @param repository
     */
    public DefaultRepositorySelector(LoggerRepository repository) {
        this.repository = repository;
    }

    public LoggerRepository getLoggerRepository() {
        return repository;
    }
}

