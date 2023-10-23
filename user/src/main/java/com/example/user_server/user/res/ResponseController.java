package com.example.user_server.user.res;

import ch.qos.logback.core.spi.ConfigurationEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ResponseController {

    private int stateCode;

    private String message;

    private Object data;


}
