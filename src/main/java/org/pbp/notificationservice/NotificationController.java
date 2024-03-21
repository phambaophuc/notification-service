package org.pbp.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/order/new-order")
    public void sendNewOrder(@RequestBody Object orderDto) {
        messagingTemplate.convertAndSend("/order/newOrder", orderDto);
    }

    @PostMapping("/order/update-status")
    public void sendUpdateStatus(@RequestBody Object orderDto) {
        messagingTemplate.convertAndSend("/order/updateStatus", orderDto);
    }
}
