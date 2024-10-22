package com.team2.reservation.reserve.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReserveVo {
    private int reserveNo;     // ���� ��ȣ
    private int restNo;        // �Ĵ� ��ȣ
    private String restName;   // �Ĵ� �̸�
    private String restReview; // ����
    private Timestamp restTime;  // ���� �ð�
    private int userNo;        // ����� ��ȣ
}
