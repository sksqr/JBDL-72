package org.gfg.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class HelloHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String msg = "Hello from "+Thread.currentThread().getName();
        exchange.sendResponseHeaders(200, msg.length());
        exchange.getResponseBody().write(msg.getBytes());
    }
}
