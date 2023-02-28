package com.example.hom_thu_dien_tu.service;

import com.example.hom_thu_dien_tu.model.MailBox;

public interface IMailBoxService {
    MailBox mailBox();
    void editMailBox(MailBox mailBox);
}
