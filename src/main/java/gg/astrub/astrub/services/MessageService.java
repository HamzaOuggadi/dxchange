package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.Message;
import gg.astrub.astrub.entities.User;

public interface MessageService {
    Message sendMessage(String messageContent, User userSender, User userRecipient, Listing listing);
    void deleteMessage(Long messageId);
}
