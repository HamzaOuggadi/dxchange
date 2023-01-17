package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.Message;
import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.ListingException;
import gg.astrub.astrub.exceptions.MessageException;
import gg.astrub.astrub.exceptions.UserException;

import java.util.List;

public interface MessageService {
    Message getMessageById(Long messageId) throws MessageException;
    List<Message> getMessagesByListingId(Long listingId) throws ListingException;
    List<Message> getReceivedMessagesByUserId(Long userId) throws UserException;
    List<Message> getSentMessagesByUserId(Long userId) throws UserException;
    Message addMessage(String messageContent, Long userSenderId, Long userRecipientId, Long listingId) throws UserException, ListingException;
    void deleteMessage(Long messageId) throws MessageException;
}
