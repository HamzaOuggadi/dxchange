package gg.astrub.astrub.services;

import gg.astrub.astrub.entities.Listing;
import gg.astrub.astrub.entities.Message;
import gg.astrub.astrub.entities.User;
import gg.astrub.astrub.exceptions.ListingException;
import gg.astrub.astrub.exceptions.MessageException;
import gg.astrub.astrub.exceptions.UserException;
import gg.astrub.astrub.repositories.ListingRepository;
import gg.astrub.astrub.repositories.MessageRepository;
import gg.astrub.astrub.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@AllArgsConstructor
@Transactional
public class MessageServiceImpl implements MessageService{

    private MessageRepository messageRepository;
    private UserRepository userRepository;
    private ListingRepository listingRepository;
    @Override
    public Message addMessage(String messageContent, Long userSenderId, Long userRecipientId, Long listingId) throws UserException, ListingException {

        User userSender = userRepository.findById(userSenderId).orElseThrow(()-> new UserException("User Not Found!"));

        User userRecipient = userRepository.findById(userRecipientId).orElseThrow(()-> new UserException("User Not Found!"));

        Listing listing = listingRepository.findById(listingId).orElseThrow(()-> new ListingException("Listing Not Found!"));

        Message message = Message.builder()
                .messageContent(messageContent)
                .messageDate(new Date())
                .listing(listing)
                .userSender(userSender)
                .userRecipient(userRecipient)
                .messageDeleted(false)
                .messageViewed(false)
                .build();
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Long messageId) throws MessageException {
        Message message = messageRepository.findById(messageId).orElseThrow(()-> new MessageException("Message Not Found!"));
    }
}
