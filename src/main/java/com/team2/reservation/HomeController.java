package com.team2.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.team2.reservation.rest.service.RestService;
import com.team2.reservation.user.model.UserVo;
import com.team2.reservation.user.service.UserService;

@Controller
public class HomeController {
    private final RestService restService;
    private final UserService userService;

    @Autowired
    public HomeController(RestService restService, UserService userService) {
        this.restService = restService;
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        restService.list(model);
        return "index";
    }
    @GetMapping("/mypage")
    public String mypage(Model model) {
        // �ʿ信 ���� �𵨿� ������ �߰�
        return "mypage"; // mypage.html ��� �̵�
    }
    @PostMapping("/review")
    public String review(Model model) {
    	// �ʿ信 ���� �𵨿� ������ �߰�
    	return "review"; 
    }

    
    @PostMapping("/")
    public String add(@ModelAttribute UserVo bean) {
        userService.add(bean);
        return "redirect:/";
    }
}