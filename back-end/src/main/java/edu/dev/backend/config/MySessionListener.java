package edu.dev.backend.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Create By  @林俊杰
 * 2022/3/27 12:45
 *
 * @version 1.0
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
    public void sessionCreate(HttpSessionEvent sessionEvent) {
        MySessionContext.addSession(sessionEvent.getSession());
    }

    public void sessionDestroy(HttpSessionEvent sessionEvent) {
        MySessionContext.removeSession(sessionEvent.getSession());
    }
}
