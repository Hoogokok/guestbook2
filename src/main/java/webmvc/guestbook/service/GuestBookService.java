package webmvc.guestbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webmvc.guestbook.dto.GuestBookDto;
import webmvc.guestbook.repository.GuestBookDao;

import java.util.Date;
import java.util.List;

@Service
public class GuestBookService {
    @Autowired
    GuestBookDao guestBookDao;


    @Transactional
    public List<GuestBookDto> getGuestBooks() {
        // TODO Auto-generated method stub
        return guestBookDao.selectAll();
    }

    @Transactional(readOnly = false)
    public GuestBookDto addGuest(GuestBookDto guest) {
        // TODO Auto-generated method stub
        guest.setReg_date(new Date());
        long no = guestBookDao.insert(guest);
        guest.setNo(no);
        return guest;
    }

    @Transactional(readOnly = false)
    public int delete(Long no, String password) {
        // TODO Auto-generated method stub
        int delete = 0;
        if (findPassword(no).matches(password)) {
            delete = guestBookDao.delete(no);
        }
        return delete;
    }

    public String findPassword(Long no) {
        return guestBookDao.findByNo(no);
    }
}
