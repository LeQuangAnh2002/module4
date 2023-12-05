package com.codegym.controller;

import com.codegym.entity.Book;
import com.codegym.entity.Detail;
import com.codegym.entity.LibraryCard;
import com.codegym.service.BookService;
import com.codegym.service.DetailService;
import com.codegym.service.LibraryCardServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/card")
public class LibraryCardController {
    @Autowired
    private BookService bookService;
    @Autowired
    private DetailService detailService;
    @Autowired
    private LibraryCardServie libraryCardServie;
    @GetMapping("")
    public String showList(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books",books);
        return "list";
    }
    @GetMapping("/{id}")
    public String showDetail(@PathVariable("id") int id,Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        model.addAttribute("LibraryCard",new LibraryCard());
        return "detail";
    }
    @GetMapping("/borrowedBook")
    public String borrowedBook(Model model,@RequestParam(name="idBook") int idBook, @RequestParam(value = "quantity",defaultValue = "1" ,required = false) int quantity,
                               @ModelAttribute("LibraryCard") LibraryCard libraryCard,@RequestParam(name="bookName") String bookName) throws ClassNotFoundException {
        Detail detail = new Detail();
        if(idBook > 0 && bookService.checkQuantityBook(idBook)){
            bookService.decreaseBookQuantity(idBook,quantity);
            libraryCard.setIdBook(libraryCardServie.generateBorrowCode());
            libraryCard.setBookName(bookName);
            libraryCardServie.create(libraryCard);
//          save Detail
            detail.setBook(bookService.findById(idBook));
            detail.setLibraryCard(libraryCardServie.findByIDCard(libraryCard.getIdBook()));
            detail.setQuantity(quantity);
            detailService.create(detail);

            return "redirect:/card/borrow";

        }else {
            throw new ClassNotFoundException("Số lượng sách không đủ để mượn.");
        }


    }
    @GetMapping("/borrow")
    public String borrow(Model model){
        List<LibraryCard> libraryCards = libraryCardServie.findAll();
        model.addAttribute("libraryCards",libraryCards);

        return "borrow";
    }

    @GetMapping("/payBook")
    public String payBook(@RequestParam("id") String idCard,@RequestParam("quantity") int quantity ){

        if(idCard != null){
            detailService.payBookQuantity(idCard,quantity);
            int idDetail = detailService.findIdByCardId(idCard).orElse(null);
            detailService.deleteById(idDetail);
            libraryCardServie.deleteCard(idCard);

        }
        return "redirect:/card/borrow";
    }
}

