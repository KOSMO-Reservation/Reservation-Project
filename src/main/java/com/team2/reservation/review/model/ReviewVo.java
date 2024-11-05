package com.team2.reservation.review.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewVo {
    private int reviewNo;        	// ���� ��ȣ
    private int userNo;          	// ����� ��ȣ
    private int restNo;          	// �Ĵ� ��ȣ
    private String userName;			// ����� �̸�
    private String reviewContent; 	// ���� ����
    private int reviewScore;     	// ����
    private Timestamp createDate; 	// �ۼ���
}
