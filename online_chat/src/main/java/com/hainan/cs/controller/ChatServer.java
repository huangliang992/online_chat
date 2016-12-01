package com.hainan.cs.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author shiyanlou
 *
 */
@Controller
@RequestMapping(value="/websocket")
@ServerEndpoint("/websocket")
public class ChatServer {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");    // 日期格式化

    @OnOpen
    public void open(Session session) {
    }


    @RequestMapping
    @OnMessage
    public void getMessage(String message, Session session) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.append("message", message);
        jsonObject.put("date", DATE_FORMAT.format(new Date()));
        for (Session openSession : session.getOpenSessions()) {
            jsonObject.put("isSelf", openSession.equals(session));
            openSession.getAsyncRemote().sendText(jsonObject.toString());
        }
    }

    @OnClose
    public void close() {
    }

    @OnError
    public void error(Throwable t) {
    }
}