package org.apache.log4j.or;

/**
 * The default Renderer renders objects by calling their
 * <code>toString</code> method.
 *
 * 默认对象渲染器
 */
class DefaultRenderer implements ObjectRenderer {

    DefaultRenderer() {
    }

    /**
     * Render the object passed as parameter by calling its
     * <code>toString</code> method.
     * 渲染默认调用对象的toString方法
     */
    public String doRender(final Object o) {
        try {
            return o.toString();
        } catch (Exception ex) {
            return ex.toString();
        }
    }
}  
