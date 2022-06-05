package com.grad.exchangesys.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grad.exchangesys.Model.PushNotificationReponse;
import com.grad.exchangesys.Model.PushNotificationRequest;
import com.grad.exchangesys.Services.PushNotificationService;

@RestController
@RequestMapping(value = "api/notify")
public class PushNotificationController {

	
	private PushNotificationService pushNotificationService;

    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }
    
    
    @PostMapping("/notification/topic")
    public ResponseEntity sendNotification(@RequestBody PushNotificationRequest request) {
    	
        pushNotificationService.sendPushNotificationWithoutData(request);
        
        return new ResponseEntity<>(new PushNotificationReponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
    	
        pushNotificationService.sendPushNotificationToToken(request);
        
        return new ResponseEntity<>(new PushNotificationReponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @PostMapping("/notification/data")
    public ResponseEntity sendDataNotification(@RequestBody PushNotificationRequest request) {
    	
        pushNotificationService.sendPushNotification(request);
        
        return new ResponseEntity<>(new PushNotificationReponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @GetMapping("/notification")
    public ResponseEntity sendSampleNotification() {
    	
        pushNotificationService.sendSamplePushNotification();
        
        return new ResponseEntity<>(new PushNotificationReponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
}
