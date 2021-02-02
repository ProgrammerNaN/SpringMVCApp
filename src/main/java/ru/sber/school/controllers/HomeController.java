package ru.sber.school.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import ru.sber.school.Entities.ApiResponse;
import ru.sber.school.Entities.Film;

import java.util.List;

@Controller
public class HomeController {

    public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private static final String TOKEN = "8a09ce24d78eb1e2d482c4e6996d8ede";

    private RestTemplate restTemplate;

    private int pageNumber = 1;

    @Autowired
    public HomeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String showFilms(Model model) {
        ApiResponse apiResponse = restTemplate.getForObject(String.format("https://api.kinopoisk.cloud/movies/all/page/%d/token/%s", pageNumber, TOKEN), ApiResponse.class);
        List<Film> films = apiResponse.getFilms();
        model.addAttribute("films", films);
        logger.info("Пользователь зашел на домашнюю страницу");
        return "home/home";
    }

}
