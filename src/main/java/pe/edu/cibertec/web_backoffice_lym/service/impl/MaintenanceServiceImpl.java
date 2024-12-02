package pe.edu.cibertec.web_backoffice_lym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.web_backoffice_lym.dto.FilmDto;
import pe.edu.cibertec.web_backoffice_lym.entity.Film;
import pe.edu.cibertec.web_backoffice_lym.repository.FilmRepository;
import pe.edu.cibertec.web_backoffice_lym.service.MaintenanceService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;

    @Override
    public List<FilmDto> findAllFilms() {

        List<FilmDto> films = new ArrayList<FilmDto>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
           FilmDto filmDto = new FilmDto(film.getFilmId(),
                   film.getTitle(),
                   film.getLanguage().getName(),
                   film.getRentalDuration(),
                   film.getRentalRate());
            films.add(filmDto);
        });

        return films;

    }
}
