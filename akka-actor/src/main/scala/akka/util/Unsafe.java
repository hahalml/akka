/**
 * Copyright (C) 2009-2016 Lightbend Inc. <http://www.lightbend.com>
 */
package akka.util;

import java.lang.reflect.Field;

/**
 * INTERNAL API
 */
public final class Unsafe {
    public final static sun.misc.Unsafe instance;

    static {
        try {
            sun.misc.Unsafe found = null;
            for (Field field : sun.misc.Unsafe.class.getDeclaredFields()) {
                if (field.getType() == sun.misc.Unsafe.class) {
                    field.setAccessible(true);
                    found = (sun.misc.Unsafe) field.get(null);
                    break;
                }
            }
            if (found == null) throw new IllegalStateException("Can't find instance of sun.misc.Unsafe");
            else instance = found;
        } catch (Throwable t) {
            throw new ExceptionInInitializerError(t);
        }
    }
}
