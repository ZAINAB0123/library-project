package ru.itgirl.library_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.library_project.dto.AutorDto;
import ru.itgirl.library_project.service.AutorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AutorService autorService;
    @GetMapping("/author/{id}")
    AutorDto getAuthorById(@PathVariable("id") Long id) {
        return autorService.getAuthorById(id);
    }
}
