package com.team2.intro;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet({"/intro", "/reservation", "/submitReservation"})  // 3���� URL ������ ó��
public class IntroController extends HttpServlet {

    // ������ �������� ���� ���� ó���ϴ� �޼ҵ�
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        if (path.endsWith("/intro")) {
            showGallery(request, response);  // ������ ������ ��û
        } else if (path.endsWith("/reservation")) {
            showReservationForm(request, response);  // ���� �� ��û
        }
    }

    // ���� ó���ϴ� �޼ҵ�
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        if (path.endsWith("/submitReservation")) {
            processReservation(request, response);  // ���� ó��
        }
    }

    // ������ ������ ǥ��
    private void showGallery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, String>> galleryItems = new ArrayList<>();

        // ������� 1
        Map<String, String> item1 = new HashMap<>();
        item1.put("id", "1");
        item1.put("image", "photo1.jpg");
        item1.put("title", "������� 1");
        item1.put("description", "�� ��������� ���� ������ �����Դϴ�.");
        galleryItems.add(item1);

        // ������� 2
        Map<String, String> item2 = new HashMap<>();
        item2.put("id", "2");
        item2.put("image", "photo2.jpg");
        item2.put("title", "������� 2");
        item2.put("description", "�� ��������� ���� ������ �����Դϴ�.");
        galleryItems.add(item2);

        // ������� 3
        Map<String, String> item3 = new HashMap<>();
        item3.put("id", "3");
        item3.put("image", "photo3.jpg");
        item3.put("title", "������� 3");
        item3.put("description", "�� ��������� ���� ������ �����Դϴ�.");
        galleryItems.add(item3);

        // ������� 4
        Map<String, String> item4 = new HashMap<>();
        item4.put("id", "4");
        item4.put("image", "photo4.jpg");
        item4.put("title", "������� 4");
        item4.put("description", "�� ��������� ���� ������ �����Դϴ�.");
        galleryItems.add(item4);

        request.setAttribute("IntroItems", galleryItems);  // �����͸� JSP�� ����
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/intro.jsp");
        dispatcher.forward(request, response);  // ������ �������� ������
    }

    // ���� �� ǥ��
    private void showReservationForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/reservationForm.jsp");
        dispatcher.forward(request, response);  // ���� �� �������� ������
    }

    // ���� ó��
    private void processReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String people = request.getParameter("people");  // ���� �ο�
        String reservationDate = request.getParameter("reservationDate");  // ���� ��¥

        // ���� ó�� (���÷� ������ ���)
        System.out.println("����� �ο�: " + people);
        System.out.println("���� ��¥: " + reservationDate);

        // ���� �Ϸ� �� �������� �����̷�Ʈ
        response.sendRedirect(request.getContextPath() + "/intro");
    }
}