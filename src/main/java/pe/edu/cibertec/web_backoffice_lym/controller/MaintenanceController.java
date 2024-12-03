package pe.edu.cibertec.web_backoffice_lym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.web_backoffice_lym.dto.FilmDetailsDto;
import pe.edu.cibertec.web_backoffice_lym.dto.FilmDto;
import pe.edu.cibertec.web_backoffice_lym.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {

        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";

    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailsDto filmDetailsDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailsDto);
        return "maintenance_detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailsDto filmDetailsDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailsDto);
        return "maintenance_edit";
    }

    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailsDto filmDetailsDto, Model model) {

        maintenanceService.updateFilm(filmDetailsDto);
        return "redirect:/maintenance/start";
    }

}
