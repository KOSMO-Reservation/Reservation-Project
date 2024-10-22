package com.team2.reservation.resrve.model;

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
	 private int reserveNo; // �߰�: ���� ID
	 private String restName, restReview;
	
	 private Timestamp reserveTime;
}
