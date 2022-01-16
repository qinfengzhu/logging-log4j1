package org.apache.log4j.pattern;

import org.apache.log4j.spi.LoggingEvent;


/**
 * Formats a logger name.
 *
 * 日志名称模式转换器
 */
public final class LoggerPatternConverter extends NamePatternConverter {
  /**
   * Singleton.
   */
  private static final LoggerPatternConverter INSTANCE = new LoggerPatternConverter(null);

  /**
   * Private constructor.
   * @param options options, may be null.
   */
  private LoggerPatternConverter(final String[] options) {
    super("Logger", "logger", options);
  }

  /**
   * Obtains an instance of pattern converter.
   * @param options options, may be null.
   * @return instance of pattern converter.
   */
  public static LoggerPatternConverter newInstance(
    final String[] options) {
    if ((options == null) || (options.length == 0)) {
      return INSTANCE;
    }

    return new LoggerPatternConverter(options);
  }

  /**
   * {@inheritDoc}
   */
  public void format(final LoggingEvent event, final StringBuffer toAppendTo) {
    final int initialLength = toAppendTo.length();
    toAppendTo.append(event.getLoggerName());
    abbreviate(initialLength, toAppendTo);
  }
}
