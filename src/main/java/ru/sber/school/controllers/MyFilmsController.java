package ru.sber.school.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MyFilmsController {

    public static final Logger logger = LoggerFactory.getLogger(MyFilmsController.class);

    @GetMapping("/my-films")
    public String myFilms(){

        logger.info("Пользователь зашел на страницу просмотра всех фильмов");

        return "myFilms/listMyFilms";
    }

    @GetMapping("/my-films/{id}")
    public String film(@PathVariable Long id, Model model){

        logger.info("Пользователь зашел на страницу фильма с идентификатором: {}", id);

        model.addAttribute("filmId", id);
        return "myFilms/myFilm";
    }

}
