package org.apache.log4j.spi;


/**
 * 日志仓库选择器接口
 */
public interface RepositorySelector {

  /**
     Returns a {@link LoggerRepository} depending on the
     context. Implementors must make sure that a valid (non-null)
     LoggerRepository is returned.
  */
  public
  LoggerRepository getLoggerRepository();
}

