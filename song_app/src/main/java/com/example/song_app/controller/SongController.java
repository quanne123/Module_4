package com.example.song_app.controller;

import com.example.song_app.model.Song;
import com.example.song_app.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String showSongList(Model model){
        model.addAttribute("songList",songService.showAll());
        return "list";
    }
    @GetMapping("/showCreate")
    public String showFormCreate(Model model){
        model.addAttribute("song",new Song());
        return "/create";
    }

    @PostMapping("/validate")
    public String validateSong(@Validated @ModelAttribute Song song, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            songService.createSong(song);
            return "redirect:/songs";
        }
    }

    @GetMapping("formEdit/{id}")
    public String formEdit(@PathVariable Integer id, Model model){
        model.addAttribute("song",songService.findById(id));
        return "edit";
    }

    @PostMapping("/editSong")
    public String editSong(@ModelAttribute Song song,BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "edit";
        }else {
            songService.updateSong(song);
            return "redirect:/songs";
        }
    }
}