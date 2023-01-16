package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.Message;
import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.ListingException;
import gg.astrub.astrub.exceptions.MessageException;
import gg.astrub.astrub.exceptions.UserException;

public interface MessageService {
    Message addMessage(String messageContent, Long userSenderId, Long userRecipientId, Long listingId) throws UserException, ListingException;
    void deleteMessage(Long messageId) throws MessageException;
}
