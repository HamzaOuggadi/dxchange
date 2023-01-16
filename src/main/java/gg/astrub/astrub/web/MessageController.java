package gg.astrub.astrub.web;


import gg.astrub.astrub.services.MessageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {
    private MessageServiceImpl messageService;

}
