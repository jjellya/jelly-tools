package edu.dev.backend.config;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Create By  @林俊杰
 * 2022/3/27 12:45
 *
 * @version 1.0
 */
public class MySessionContext {
    private static Map<String, HttpSession> sessionHashMap = new HashMap<>();
    public static synchronized void addSession(HttpSession session) {
        if (session != null) {
            sessionHashMap.put(session.getId(), session);
        }
    }

    public static synchronized void removeSession(HttpSession session) {
        if (session != null) {
            sessionHashMap.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String sessionId) {
        return sessionHashMap.get(sessionId);
    }

}
