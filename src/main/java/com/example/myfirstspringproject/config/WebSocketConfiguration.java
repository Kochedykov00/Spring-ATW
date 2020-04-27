package com.example.myfirstspringproject.config;

import com.example.myfirstspringproject.handlers.AuthHandshakeHandler;
import com.example.myfirstspringproject.handlers.WebSocketMessagesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Autowired
    private WebSocketMessagesHandler handler;

    @Autowired
    private AuthHandshakeHandler handshakeHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(handler, "/chat").setHandshakeHandler(handshakeHandler);
    }
}

