package gg.astrub.astrub.web;


import gg.astrub.astrub.entities.Message;
import gg.astrub.astrub.exceptions.ListingException;
import gg.astrub.astrub.exceptions.MessageException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.services.MessageServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Need to test every endpoint before Spring Security and Authentication */

@RestController
@AllArgsConstructor
public class MessageController {
    private MessageServiceImpl messageService;
    @GetMapping("/messages/{messageId}") /* Tested => OK */
    public Message getMessageById(@PathVariable Long messageId) throws MessageException {
        return messageService.getMessageById(messageId);
    }
    @GetMapping("/messages/ByListingId/{listingId}")
    public List<Message> getMessagesByListingId(@PathVariable Long listingId) throws ListingException {
        return messageService.getMessagesByListingId(listingId);
    }
    @GetMapping("/messages/receivedMessagesByUserId/{userId}")
    public List<Message> getReceivedMessagesByUserId(@PathVariable Long userId) throws UserException {
        return messageService.getReceivedMessagesByUserId(userId);
    }

    @GetMapping("/messages/sentMessagesByUserId/{userId}")
    public List<Message> getSentMessagesByUserId(@PathVariable Long userId) throws UserException {
        return messageService.getSentMessagesByUserId(userId);
    }

    @PostMapping("/messages/sendMessage/{messageContent}/{userSenderId}/{userRecipientId}/{listingId}")
    public void sendMessage(@PathVariable String messageContent,
                            @PathVariable Long userSenderId,
                            @PathVariable Long userRecipientId,
                            @PathVariable Long listingId) throws ListingException, UserException {
        messageService.addMessage(messageContent, userSenderId, userRecipientId, listingId);
    }
    @DeleteMapping("/messages/deleteMessageById/{messageId}")
    public void deleteMessageById(@PathVariable Long messageId) throws MessageException {
        messageService.deleteMessage(messageId);
    }
}
