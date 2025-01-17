package org.apache.log4j.pattern;

/**
 * <p>PatternConverter is an abstract class that provides the
 * formatting functionality that derived classes need.
 *
 * <p>Conversion specifiers in a conversion patterns are parsed to
 * individual PatternConverters. Each of which is responsible for
 * converting an object in a converter specific manner.
 * 表达式转换器
 */
public abstract class PatternConverter {
    /**
     * Converter name.
     */
    private final String name;

    /**
     * Converter style name.
     */
    private final String style;

    /**
     * Create a new pattern converter.
     *
     * @param name  name for pattern converter.
     * @param style CSS style for formatted output.
     */
    protected PatternConverter(final String name, final String style) {
        this.name = name;
        this.style = style;
    }

    /**
     * Formats an object into a string buffer.
     *
     * @param obj        event to format, may not be null.
     * @param toAppendTo string buffer to which the formatted event will be appended.  May not be null.
     */
    public abstract void format(final Object obj, final StringBuffer toAppendTo);

    /**
     * This method returns the name of the conversion pattern.
     * <p>
     * The name can be useful to certain Layouts such as HTMLLayout.
     *
     * @return the name of the conversion pattern
     */
    public final String getName() {
        return name;
    }

    /**
     * This method returns the CSS style class that should be applied to
     * the LoggingEvent passed as parameter, which can be null.
     * <p>
     * This information is currently used only by HTMLLayout.
     *
     * @param e null values are accepted
     * @return the name of the conversion pattern
     */
    public String getStyleClass(Object e) {
        return style;
    }
}
