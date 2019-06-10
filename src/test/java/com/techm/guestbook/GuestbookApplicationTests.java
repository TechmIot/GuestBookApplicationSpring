package com.techm.guestbook;

import com.techm.guestbook.domain.GuestBookEntry;
import com.techm.guestbook.domain.GuestBookEntryRepository;
import com.techm.guestbook.service.GuestBookService;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;
/**
 *
 * @author GV00339350
 */
/*
All the Guestbookservices to be tested in this Class
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestbookApplicationTests {
     @Autowired
    private GuestBookEntryRepository guestBookEntryRepository;


    @Test
    public void contextLoads() {
        
    }
   @Autowired
   private GuestBookService guestBookService;
   
 
   private GuestBookEntry guestBookEntry;
   /*
   GuestBookService Test for findAllEntries
   */
   @Test
   public void findAllEntries()
   {
       
      guestBookEntry=this.guestBookService.findAllEntries().get(0);
      assertEquals("Ganesan",guestBookEntry.getUser());
      assertEquals("Quick word is important to convey this message",guestBookEntry.getComment());
    }
    /*
   Guestbookservice Test for findGuestBookEntryById
   */
   @Test
   public void findGuestBookEntryById()
   {
       guestBookEntry=this.guestBookService.findGuestBookEntryById(2);
       assertEquals("John",guestBookEntry.getUser());
       
   }
   /*
   GuestBookService Test for deleteGuestBoookEntryById
   */
   
 @Test
 @DirtiesContext
  public void deleteGuestBookEntryById () throws Exception {
        guestBookEntryRepository.deleteGuestBookEntryById(2);
       assertNotNull(guestBookEntryRepository.findById(2));
    }
   /*
   Guestbookservice Test for update service
   */
   @Test
 public void save () throws Exception {
    guestBookEntry=this.guestBookService.findGuestBookEntryById(1);
     guestBookEntry.setUser("Roger");
     guestBookEntry.setComment("hellow new message");
     this.guestBookEntryRepository.save(guestBookEntry);
    
   assertTrue(guestBookService.findGuestBookEntryById(1).getUser().equalsIgnoreCase("Roger"));
   assertTrue(guestBookService.findGuestBookEntryById(1).getComment().equalsIgnoreCase("hellow new message"));
 }
    
    }

  


