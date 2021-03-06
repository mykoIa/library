package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.*;
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
        return bookInformationService.findAllBookInformation();
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public BookInformationDTO findBookInfoById(@PathVariable Long id) {
        return bookInformationService.findBookInformationById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteBookInfo(@PathVariable Long id) {
        bookInformationService.deleteBookInformationById(id);
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public void addBookInfo(@RequestBody BookInformationDTO bookInformationDTO) {
        bookInformationService.addBookInformation(bookInformationDTO);
    }

    @PutMapping("/update")
    @ResponseBody
    public void updateBookInfo(@RequestBody BookInformationDTO bookInformationDTO) {
        bookInformationService.updateBookInformation(bookInformationDTO);
    }

}
