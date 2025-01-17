package org.apache.log4j;

/**
 * CategoryKey is a wrapper for String that apparently accellerated
 * hash table lookup in early JVM's.
 *
 * 日志关键键,用于在日志层级中查找对应的日志
 */
class CategoryKey {

    String name;
    int hashCache;

    CategoryKey(String name) {
        this.name = name;
        hashCache = name.hashCode();
    }

    final
    public int hashCode() {
        return hashCache;
    }

    final
    public boolean equals(Object rArg) {
        if (this == rArg)
            return true;

        if (rArg != null && CategoryKey.class == rArg.getClass())
            return name.equals(((CategoryKey) rArg).name);
        else
            return false;
    }
}
