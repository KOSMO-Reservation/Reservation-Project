package com.team2.reservation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.http.ResponseEntity;
=======
>>>>>>> Stashed changes
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team2.reservation.restaurant.model.RestaurantVo;
import com.team2.reservation.restaurant.service.RestaurantService;
<<<<<<< Updated upstream
import com.team2.reservation.reserve.service.ReserveService;
import com.team2.reservation.user.model.UserDao;
=======
import com.team2.reservation.reserve.service.ReserveService; // ReserveService �߰�
>>>>>>> Stashed changes
import com.team2.reservation.user.model.UserVo;
import com.team2.reservation.user.service.UserService;

@Controller
public class HomeController {
    private final UserService userService;
    private final RestaurantService restService;
<<<<<<< Updated upstream
    private final ReserveService reserveService;  // ���� ���� �߰�
    private final UserDao userDao;

    @Autowired
    public HomeController(RestaurantService restService, UserService userService, ReserveService reserveService, UserDao userDao) {
        this.restService = restService;
        this.userService = userService;
        this.reserveService = reserveService;  // ���� ���� �ʱ�ȭ
        this.userDao = userDao;
=======
    private final ReserveService reserveService; // ReserveService �߰�

    @Autowired
    public HomeController(RestaurantService restService, UserService userService, ReserveService reserveService) {
        this.restService = restService;
        this.userService = userService;
        this.reserveService = reserveService; // ReserveService �ʱ�ȭ
>>>>>>> Stashed changes
    }
    
    // index page
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        UserVo user = (UserVo) session.getAttribute("loggedInUser"); 
        model.addAttribute("user", user); 
        restService.list(model);
        return "index";
    }
<<<<<<< Updated upstream
    
    // ����������: ������� ���� ����� �����ִ� ��� �߰�
    @GetMapping("/mypage")
    public String myPage(Model model, HttpSession session) {
        UserVo user = (UserVo) session.getAttribute("loggedInUser");  // �α����� ����� ��������
        if (user == null) {
            return "redirect:/login";  // �α��εǾ� ���� ������ �α��� �������� �����̷�Ʈ
        }

        // ������� ���� ��� ��ȸ (userNo ���)
        reserveService.listByUser(user.getUserNo(), model);  // ���� ����� model�� �߰�
        return "mypage";  // mypage.jsp�� �̵�
    }

    // register
=======

>>>>>>> Stashed changes
    @PostMapping("/")
    public String add(@ModelAttribute UserVo bean) {
        userService.add(bean);
        return "redirect:/";
    }
    
<<<<<<< Updated upstream
    // check-email
    @PostMapping("/check-email")
    public ResponseEntity<String> checkEmail(@RequestParam String userEmail) {
        System.out.println("recieve msg : " + userEmail);  
        boolean isAvailable = userService.isEmailAvailable(userEmail);
        return isAvailable ? ResponseEntity.ok("available") : ResponseEntity.ok("exists");
    }

    // login
=======
>>>>>>> Stashed changes
    @PostMapping("/login")
    public String login(@RequestParam String userEmail, @RequestParam String userPw, HttpSession session, Model model) {
        UserVo user = userService.login(userEmail, userPw);
        if (user != null) {
<<<<<<< Updated upstream
            System.out.println("Login Success : " + user);
=======
            System.out.println("Login successful: " + user);
>>>>>>> Stashed changes
            session.setAttribute("loggedInUser", user);
            return "redirect:/"; 
        } else {
            model.addAttribute("errorMessage", "Wrong email or Password");
            return "index";
        }
    }

<<<<<<< Updated upstream
    // logout
=======
>>>>>>> Stashed changes
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); 
        return "redirect:/";
    }
    
<<<<<<< Updated upstream
    // restaurant intro
=======
    // ���������� ��ȸ
    @GetMapping("/mypage")
    public String myPage(Model model, HttpSession session) {
        UserVo user = (UserVo) session.getAttribute("loggedInUser"); 
        if (user != null) {
            reserveService.list(model); // ���� ����� �߰�
            return "mypage"; 
        } else {
            return "redirect:/"; // �α������� ���� ��� index�� �����̷�Ʈ
        }
    }
    
>>>>>>> Stashed changes
    @GetMapping("/restaurant/{restNo}")
    @ResponseBody
    public RestaurantVo detail(@PathVariable int restNo) {
        return restService.detail(restNo);
    }
}
