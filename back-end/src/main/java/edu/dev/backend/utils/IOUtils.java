package edu.dev.backend.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Create By  @林俊杰
 * 2022/3/17 21:07
 * 关闭对象，连接
 * @version 1.0
 */
public class IOUtils {
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
