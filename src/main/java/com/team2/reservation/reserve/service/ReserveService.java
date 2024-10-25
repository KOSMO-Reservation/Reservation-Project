package com.team2.reservation.reserve.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team2.reservation.reserve.model.ReserveDao;
import com.team2.reservation.reserve.model.ReserveVo;

@Service
public class ReserveService {
    private final ReserveDao reserveDao;

    @Autowired
    public ReserveService(ReserveDao reserveDao) {
        this.reserveDao = reserveDao;
    }

    // ������� ���� ����� ��ȸ�ϴ� �޼���
    public void listByUser(int userNo, Model model) {
        model.addAttribute("list", reserveDao.pullListByUser(userNo));
    }
    
    // ���� �� ���� ��ȸ
    public ReserveVo detail(int reserveNo) {
        return reserveDao.getList(reserveNo);
    }

    // ���� �߰�
    public void add(ReserveVo bean) {
        System.out.println(reserveDao.addList(bean));
    }

    // ���� ����
    public void edit(ReserveVo bean) {
        reserveDao.setList(bean);
    }

    // ���� ����
    public void delete(int reserveNo) {
        reserveDao.rmList(reserveNo);
    }
    
    // ���� �߰� ��� (���� �ߺ� üũ ����)
    public void addReservation(int restNo, int headCount, String reserveDate, int userNo) {
        ReserveVo reserve = new ReserveVo();
        reserve.setRestNo(restNo);
        reserve.setHeadCount(headCount);
        reserve.setUserNo(userNo);

        LocalDateTime localDateTime;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            localDateTime = LocalDateTime.parse(reserveDate, formatter).withSecond(0);
        } catch (Exception e) {
            throw new IllegalStateException("�߸��� ��û�Դϴ�."); 
        }

        LocalDate today = LocalDate.now();
        if (localDateTime.toLocalDate().isEqual(today)) {
            List<ReserveVo> existingReservations = reserveDao.findReservationsByUserAndRestaurant(userNo, restNo, today);
            if (!existingReservations.isEmpty()) {
                throw new IllegalStateException("���Ͽ� �̹� ����� ��������Դϴ�.");
            }
        }

        reserve.setReserveTime(Timestamp.valueOf(localDateTime));
        reserveDao.addList(reserve);
    }
}
