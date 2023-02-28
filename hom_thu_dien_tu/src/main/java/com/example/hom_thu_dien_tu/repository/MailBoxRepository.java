package com.example.hom_thu_dien_tu.repository;

import com.example.hom_thu_dien_tu.model.MailBox;
import org.springframework.stereotype.Repository;

@Repository
public class MailBoxRepository implements IMailBoxRepository{
    private static MailBox mailBox;
    static {
        mailBox = new MailBox("VietNamese",25,true,"Ironman");
    }
    @Override
    public MailBox mailbox() {
        return mailBox;
    }

    @Override
    public void updateMailBox(MailBox newMailBox) {
        mailBox.setLanguages(newMailBox.getLanguages());
        mailBox.setPageSize(newMailBox.getPageSize());
        mailBox.setSpamFilter(newMailBox.getSpamFilter());
        mailBox.setSignature(newMailBox.getSignature());
    }
}
