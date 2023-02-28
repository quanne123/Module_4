package com.example.hom_thu_dien_tu.repository;

import com.example.hom_thu_dien_tu.model.MailBox;

public interface IMailBoxRepository {
    MailBox mailbox();
    void updateMailBox(MailBox mailBox);
}
