package com.team2.reservation.reserve.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ReserveDao {
    
    // ������� ���� ����� ��ȸ (userNo�� ����)
    @Select("SELECT r.restNo, r.restName, r.restReview, res.reserveTime AS restTime, res.reserveNo "
          + "FROM restaurant r JOIN reservation res ON r.restNo = res.restNo "
          + "WHERE res.userNo = #{userNo} ORDER BY res.reserveNo")
    List<ReserveVo> pullListByUser(int userNo);
    
    // Ư�� ���� ���� ��ȸ
    @Select("SELECT r.restNo, r.restName, r.restReview, res.reserveTime AS restTime, res.reserveNo "
          + "FROM restaurant r JOIN reservation res ON r.restNo = res.restNo WHERE res.reserveNo = #{reserveNo}")
    ReserveVo getList(int reserveNo);
    
    // ���� �߰�
    @Update("INSERT INTO reservation (restNo, userNo, reserveTime) VALUES (#{restNo}, #{userNo}, NOW())")
    int addList(ReserveVo bean);
    
    // ���� ���� ����
    @Update("UPDATE restaurant SET restName=#{restName}, restReview=#{restReview} WHERE restNo=#{restNo}; "
          + "UPDATE reservation SET reserveTime=NOW() WHERE reserveNo=#{reserveNo}")
    int setList(ReserveVo bean);

    // ���� ����
    @Delete("DELETE FROM reservation WHERE reserveNo=#{reserveNo}")
    int rmList(int reserveNo);
}

