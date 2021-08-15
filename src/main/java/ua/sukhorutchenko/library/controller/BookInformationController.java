package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.dto.BookInformationDTO;
import ua.sukhorutchenko.library.entity.BookInformation;
import ua.sukhorutchenko.library.mapper.BookInformationMapper;
import ua.sukhorutchenko.library.service.BookInformationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/bookInfo")
public class BookInformationController {

    private final BookInformationServiceImpl bookInformationService;

    public BookInformationController(BookInformationServiceImpl bookInformationService) {
        this.bookInformationService = bookInformationService;
    }

    @GetMapping("/getAll")
    public List<BookInformationDTO> showAllBookInfo() {
        return BookInformationMapper.INSTANCE.toDTO(bookInformationService.findAllBookInformation());
    }

    @PostMapping("/getById")
    @ResponseBody
    public BookInformationDTO findBookInfoById(@RequestBody BookInformationDTO bookInformationDTO) {
        return BookInformationMapper.INSTANCE.toDTO(bookInformationService.findBookInformationById(bookInformationDTO.getId()));
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteBookInfo(@RequestBody BookInformationDTO bookInformationDTO) {
        bookInformationService.deleteBookInformationById(bookInformationDTO.getId());
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public void addBookInfo(@RequestBody BookInformationDTO bookInformationDTO) {
        bookInformationService.addBookInformation(new BookInformation(bookInformationDTO.getGenre(), bookInformationDTO.getNumberOfPages()));
    }

    @PutMapping("/update")
    @ResponseBody
    public void updateBookInfo(@RequestBody BookInformationDTO bookInformationDTO) {
        bookInformationService.updateBookInformation(bookInformationService.findBookInformationById(bookInformationDTO.getId()),
                bookInformationDTO.getGenre(), bookInformationDTO.getNumberOfPages());
    }

}
