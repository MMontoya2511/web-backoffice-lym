package pe.edu.cibertec.web_backoffice_lym.service;

import pe.edu.cibertec.web_backoffice_lym.dto.FilmDetailsDto;
import pe.edu.cibertec.web_backoffice_lym.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> findAllFilms();

    FilmDetailsDto findFilmById(int id);

    Boolean updateFilm(FilmDetailsDto filmDetailsDto);



}
