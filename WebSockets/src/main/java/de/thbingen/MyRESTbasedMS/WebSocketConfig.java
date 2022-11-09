package de.thbingen.MyRESTbasedMS;

import de.thbingen.MyRESTbasedMS.adapters.out.WebsocketNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

  @Autowired
  private WebsocketNotification myWebSocketController;

  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(myWebSocketController, "/listen");
  }
}



