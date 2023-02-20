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
    @GetMapping("/messages/ByListingId/{listingId}") /* Tested => OK */
    public List<Message> getMessagesByListingId(@PathVariable Long listingId) throws ListingException {
        return messageService.getMessagesByListingId(listingId);
    }
    @GetMapping("/messages/receivedMessagesByUserId/{userId}") /* Tested => OK */
    public List<Message> getReceivedMessagesByUserId(@PathVariable Long userId) throws UserException {
        return messageService.getReceivedMessagesByUserId(userId);
    }

    @GetMapping("/messages/sentMessagesByUserId/{userId}") /* Tested => OK */
    public List<Message> getSentMessagesByUserId(@PathVariable Long userId) throws UserException {
        return messageService.getSentMessagesByUserId(userId);
    }

    @PostMapping("/messages/sendMessage") /* Tested => OK */
    public void sendMessage(@RequestParam String messageContent,
                            @RequestParam Long userSenderId,
                            @RequestParam Long userRecipientId,
                            @RequestParam Long listingId) throws ListingException, UserException {
        messageService.addMessage(messageContent, userSenderId, userRecipientId, listingId);
    }
    @DeleteMapping("/messages/deleteMessageById/{messageId}") /* Tested => OK */
    public void deleteMessageById(@PathVariable Long messageId) throws MessageException {
        messageService.deleteMessage(messageId);
    }
}
