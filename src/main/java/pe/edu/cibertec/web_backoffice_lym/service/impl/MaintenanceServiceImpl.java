package pe.edu.cibertec.web_backoffice_lym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.web_backoffice_lym.dto.FilmDetailsDto;
import pe.edu.cibertec.web_backoffice_lym.dto.FilmDto;
import pe.edu.cibertec.web_backoffice_lym.entity.Film;
import pe.edu.cibertec.web_backoffice_lym.repository.FilmRepository;
import pe.edu.cibertec.web_backoffice_lym.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public FilmDetailsDto findFilmById(int id) {
        Optional<Film> optional = filmRepository.findById(id);
        return optional.map((film) -> new FilmDetailsDto(film.getFilmId(),
                film.getTitle(),
                film.getDescription(),
                film.getReleaseYear(),
                film.getLanguage().getLanguageId(),
                film.getLanguage().getName(),
                film.getRentalDuration(),
                film.getRentalRate(),
                film.getLength(),
                film.getReplacementCost(),
                film.getRating(),
                film.getSpecialFeatures(),
                film.getLastUpdate())
        ).orElse(null);
    }

    @Override
    public Boolean updateFilm(FilmDetailsDto filmDetailsDto) {
        Optional<Film> optional = filmRepository.findById(filmDetailsDto.filmId());
        return optional.map(
                film -> {
                    film.setTitle(filmDetailsDto.title());
                    film.setDescription(filmDetailsDto.description());
                    film.setReleaseYear(filmDetailsDto.releaseYear());
                    film.setRentalDuration(filmDetailsDto.rentalDuration());
                    film.setRentalRate(filmDetailsDto.rentalRate());
                    film.setLength(filmDetailsDto.length());
                    film.setReplacementCost(filmDetailsDto.replacementCost());
                    film.setRating(filmDetailsDto.rating());
                    film.setSpecialFeatures(filmDetailsDto.specialFeatures());
                    film.setLastUpdate(new Date());
                    filmRepository.save(film);
                    return true;
                }
        ).orElse(false);
    }


}
