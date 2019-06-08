package com.techm.guestbook.controller;

import com.techm.guestbook.domain.GuestBookEntry;
import com.techm.guestbook.service.GuestBookService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
Spring MVC REST Controller for GuestBook Entry Message CRUD Implementation
*/
/**
 *
 * @author GV00339350
 */
@RequestMapping ("/api")
@RestController
public class GuestBookRestController {
      private static final Logger logger = LoggerFactory.getLogger(GuestBookRestController.class);

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping ("/comments")
    public List <GuestBookEntry> testMapping () {
          logger.info("getComments from entries..", guestBookService.findAllEntries ());
        return guestBookService.findAllEntries ();
    }

    @GetMapping ("/comment/{id}")
    public GuestBookEntry findGuestBookEntryById (@PathVariable ("id") Integer id) {
        logger.info("id for entries..", this.guestBookService.findGuestBookEntryById (id));
        return this.guestBookService.findGuestBookEntryById (id);
    }

    @GetMapping ("/user/{user}")
    public List <GuestBookEntry> findGuestBookEntriesByUser (@PathVariable ("user") String user) {
        logger.info("user for entries..", this.guestBookService.findGuestBookEntriesByUser (user));
        return this.guestBookService.findGuestBookEntriesByUser (user);
    }

    @DeleteMapping ("/comment/{id}")
    public void deleteGuestBookEntryById (@PathVariable ("id") Integer id) {
        this.guestBookService.deleteGuestBookEntryById (id);
    }

    @PostMapping ("/add")
    public void addComment (@RequestBody GuestBookEntry guestBookEntry) {
        this.guestBookService.save (guestBookEntry);
    }

    @PostMapping ("/update")
    public void updateComment (@RequestBody GuestBookEntry guestBookEntry) {
        this.guestBookService.save (guestBookEntry);
    }

}
