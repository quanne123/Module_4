package com.example.hom_thu_dien_tu.service;

import com.example.hom_thu_dien_tu.model.MailBox;
import com.example.hom_thu_dien_tu.repository.IMailBoxRepository;
import com.example.hom_thu_dien_tu.repository.MailBoxRepository;
import org.springframework.stereotype.Service;

@Service
public class MailboxService implements IMailBoxService{
    private IMailBoxRepository mailBoxRepository = new MailBoxRepository();;

    @Override
    public MailBox mailBox() {
        return mailBoxRepository.mailbox();
    }

    @Override
    public void editMailBox(MailBox mailBox) {
        mailBoxRepository.updateMailBox(mailBox);
    }
}
