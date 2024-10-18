package com.team2.reservation.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team2.reservation.user.model.UserDao;
import com.team2.reservation.user.model.UserVo;

@Service
public class UserService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }
    
    public UserVo login(String userEmail, String userPw) {
        UserVo user = userDao.findByEmail(userEmail);
        if (user != null && passwordEncoder.matches(userPw, user.getUserPw())) {
            return user; // �α��� ���� �� ����� ������ ��ȯ
        }
        return null; // �α��� ���� �� null ��ȯ
    }
    
    public boolean isEmailAlreadyRegistered(String email) {
        return userDao.findByEmail(email) != null;
    }
    
    @Transactional
    public void register(UserVo user) {
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            throw new IllegalArgumentException("����� �̸��� �ʼ��Դϴ�.");
        }
        if (user.getUserEmail() == null || user.getUserEmail().isEmpty()) {
            throw new IllegalArgumentException("�̸����� �ʼ��Դϴ�.");
        }
        if (user.getUserPw() == null || user.getUserPw().isEmpty()) {
            throw new IllegalArgumentException("��й�ȣ�� �ʼ��Դϴ�.");
        }

//        // �̸��� �ߺ� üũ
//        if (userDao.findByEmail(user.getUserEmail()) != null) {
//            throw new IllegalStateException("�̹� ��ϵ� �̸����Դϴ�.");
//        }

        // ��й�ȣ ��ȣȭ
        user.setUserPw(passwordEncoder.encode(user.getUserPw()));

        int result = userDao.addUser(user);
        if (result != 1) {
            throw new RuntimeException("����� ��Ͽ� �����߽��ϴ�.");
        }
    }
}