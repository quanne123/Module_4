package com.example.bookborrow.controller;


import com.example.bookborrow.exception.InvalidCodeException;
import com.example.bookborrow.exception.OutOfBookException;
import com.example.bookborrow.model.Book;
import com.example.bookborrow.model.History;
import com.example.bookborrow.service.impl.BookService;
import com.example.bookborrow.service.impl.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService booksService;
    private HistoryService historyService;

    @GetMapping(value = "/show-list")
    public String showList(Model model) {
        List<Book> bookList = booksService.showList();
        History history = new History();
        model.addAttribute("bookList", bookList);
        model.addAttribute("history", history);
        return "/list";
    }

    @GetMapping(value ="/borrow-book/{id}")
    public String borrowBook(@PathVariable("id") int id, RedirectAttributes redirectAttributes) throws OutOfBookException {
        Integer code = booksService.borrowBooks(id);
        String message;
        if (code != null && code != -1){
            message = "Mượn sách thành công!!";
        } else {
            message = "Mượn sách thất bại!!";
        }
        redirectAttributes.addFlashAttribute("message", message);
        redirectAttributes.addFlashAttribute("code", code);
        return "redirect:/show-list";
    }

    @PostMapping(value = "/return-book")
    public String returnBook(History history, RedirectAttributes redirectAttributes) throws InvalidCodeException {
        boolean check = booksService.returnBooks(history.getCode());
        String message;
        if (check) {
            message = "Trả sách thành công!!";
        } else {
            message = "Trả thất bại, mời nhập lại!";
        }
        redirectAttributes.addFlashAttribute("massage", message);
        return "redirect:/show-list";
    }
}
