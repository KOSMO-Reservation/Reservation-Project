package com.team2.reservation.user.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    
    // �α��� Ȯ�� (��й�ȣ�� ��ȸ���� ����)
    @Select("SELECT userNo, userName, userEmail, userPhone FROM users WHERE userEmail = #{userEmail}")
    UserVo findByEmail(@Param("userEmail") String userEmail);
    
    // ��й�ȣ Ȯ���� ���� ���� �޼ҵ�
    @Select("SELECT userPw FROM users WHERE userEmail = #{userEmail}")
    String getPasswordByEmail(@Param("userEmail") String userEmail);
    
    // �ߺ� �̸��� Ȯ��
    @Select("SELECT COUNT(*) FROM users WHERE userEmail = #{userEmail}")
    int countByEmail(@Param("userEmail") String userEmail);
    
    // ȸ������
    @Insert("INSERT INTO users (userName, userEmail, userPw, userPhone) VALUES (#{userName}, #{userEmail}, #{userPw}, #{userPhone})")
    int addInfo(UserVo bean);
}