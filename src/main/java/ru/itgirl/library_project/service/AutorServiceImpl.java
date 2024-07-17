package ru.itgirl.library_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.dto.AutorDto;
import ru.itgirl.library_project.dto.BookDto;
import ru.itgirl.library_project.nodel.Author;
import ru.itgirl.library_project.nodel.Book;
import ru.itgirl.library_project.repository.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorServiceImpl implements AutorService {
    private final AuthorRepository authorRepository;
    @Override
    public AutorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        AutorDto autorDto = convertEntityToDto(author);
        return autorDto;
    }
    private AutorDto convertEntityToDto(Author author) {
        List<BookDto> bookDtoList = author.getBooks().stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build())
                .toList();

        AutorDto autorDto = AutorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .books(bookDtoList)
                .build();
        return autorDto;
    }
}
