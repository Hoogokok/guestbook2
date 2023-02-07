package webmvc.guestbook.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import webmvc.guestbook.dto.GuestBookDto;
import webmvc.guestbook.service.GuestBookService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Api(value = "GuestBookControllerTest")
public class GuestBookController {

    @Autowired
    GuestBookService guestBookService;

    @ApiOperation(
            value = "방문록",
            notes = "방문객을 전부 찾아서 보여줍니다.",
            httpMethod = "GET",
            consumes = "application/json",
            protocols = "http",
            responseHeaders = {

            })

    @ApiResponses({
            @ApiResponse(code = 200 , message="Ok"),
            @ApiResponse(code = 404, message = "No params")
    })
    @GetMapping("/list")
    public String list(ModelMap model) {
        List<GuestBookDto> list = guestBookService.getGuestBooks();
        model.addAttribute("list", list);
        return "list";
    }

    @PostMapping("/write")
    String write(@ModelAttribute GuestBookDto guestBookDto) {
        guestBookService.addGuest(guestBookDto);
        return "redirect:/list";
    }

    @GetMapping(path = "/delete")
    public String deleteForm(@RequestParam(name = "no", required = true) Long no, HttpSession session) {
        session.setAttribute("no", no);
        return "deleteForm";
    }

    @PostMapping(path = "/delete")
    public String delete(@RequestParam(name = "password", required = true) String password, @SessionAttribute("no") String no) {
        long no1 = Long.parseLong(no);

        guestBookService.delete(no1, password);

        return "redirect:/list";
    }
}
