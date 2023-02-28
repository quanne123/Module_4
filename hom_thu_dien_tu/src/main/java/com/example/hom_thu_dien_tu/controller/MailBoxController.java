package com.example.hom_thu_dien_tu.controller;

import com.example.hom_thu_dien_tu.model.MailBox;
import com.example.hom_thu_dien_tu.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/")
public class MailBoxController {
    @Autowired
     IMailBoxService mailBoxService;

    @GetMapping("showForm")
    public String showForm(Model model){
        model.addAttribute("mailBox",mailBoxService.mailBox());
        if (mailBoxService.mailBox().getSpamFilter()){
            model.addAttribute("spamFilter","Disable spams filter");
        }
        return "/boxMail";
    }

    @GetMapping("/updateMail")

    public String showUpdate(Model model){
        model.addAttribute("mailBox",mailBoxService.mailBox());
        model.addAttribute("languages", Arrays.asList("English","VietNamese","Spanish","japanese"));
        model.addAttribute("pageSize",Arrays.asList(25,50,75,100));
        return "/update";
    }

    @PostMapping("/updateMail")
    public String updateMail(@ModelAttribute MailBox mailBox, RedirectAttributes redirectAttributes){
        this.mailBoxService.editMailBox(mailBox);
        redirectAttributes.addAttribute("msg","Update success");
        return "redirect:/showMail";
    }
}
