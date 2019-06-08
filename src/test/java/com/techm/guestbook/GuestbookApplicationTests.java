package com.techm.guestbook;

import com.techm.guestbook.domain.GuestBookEntry;
import com.techm.guestbook.domain.GuestBookEntryRepository;
import com.techm.guestbook.service.GuestBookService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
/**
 *
 * @author GV00339350
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestbookApplicationTests {

    @Test
    public void contextLoads() {
    }
   

}
