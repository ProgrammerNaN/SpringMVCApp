package ru.sber.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyFilmsController {

    @GetMapping("/my-films")
    public String myFilms(){
        return "myFilms/listMyFilms";
    }

    @GetMapping("/my-films/{id}")
    public String film(@PathVariable Long id, Model model){
        model.addAttribute("filmId", id);
        return "myFilms/myFilm";
    }

}
