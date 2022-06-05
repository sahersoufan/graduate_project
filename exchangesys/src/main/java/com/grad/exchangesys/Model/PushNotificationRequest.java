package com.grad.exchangesys.Model;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class PushNotificationRequest {

	
	private String title;
    private String message;
    private String topic;
    private String token;
    
    public PushNotificationRequest(String title, String messageBody, String topicName) {
        this.title = title;
        this.message = messageBody;
        this.topic = topicName;
    }
}
