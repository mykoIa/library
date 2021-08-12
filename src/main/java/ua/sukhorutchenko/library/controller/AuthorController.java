package ua.sukhorutchenko.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.sukhorutchenko.library.entity.Author;
import ua.sukhorutchenko.library.service.AuthorServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/get")
    public List<Author> showAllAuthor() {
        return authorService.findAllAuthor();
    }

    @GetMapping("/get/{id}")
    public Author findAuthorById(@PathVariable("id") Long id) {
        return authorService.findAuthorById(id);
    }

    @RequestMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthorById(id);
    }

    @RequestMapping(value = "/add/{name}")
    public Author addAuthor(@PathVariable("name") String name) {
        return authorService.addAuthor(new Author(name));
    }

    @RequestMapping("/update/{id}&{name}")
    public void updateAuthor(@PathVariable("id") Long id,
                             @PathVariable("name") String name) {
        authorService.updateAuthor(authorService.findAuthorById(id), name);
    }
}


//    GetMapping("/timerange")
//    @ResponseBody
//    @ApiOperation(value = "Request for issuing a list of average exchange rates for all sources for a period")
//    public List<ExchangeModel> getExchangeRateByDate(@ApiParam(Description.BASE_CURRENCY) @RequestParam("base") String baseCurrency,
//                                                     @ApiParam(Description.CURRENCY) @RequestParam("currencies") String currencies,
//                                                     @ApiParam(Description.DATE_FROM) @RequestParam("dateFrom") Long dateFrom,
//                                                     @ApiParam(Description.DATE_TO) @RequestParam("dateTo") Long dateTo) {
//        Optional<Currency> currency = ParseCurrencyUtil.parseCurrency(baseCurrency);
//        if (!currency.isPresent()) {
//            return Collections.emptyList();
//        }
//        return dbService.findByTimeRange(currency.get().getCurrencyCode(), ParseCurrencyUtil.parseCurrencies(currencies), dateFrom, dateTo);
//    }
