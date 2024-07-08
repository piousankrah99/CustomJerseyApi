package Primesniper.SniperJersey;

import lombok.*;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResponseObject {
    private int statusCode;
    private String message;
    private Object data;
    private ZonedDateTime timeStamp;
}
