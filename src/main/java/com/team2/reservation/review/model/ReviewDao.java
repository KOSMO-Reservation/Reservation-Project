package com.team2.reservation.review.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ReviewDao {
    // ���� �߰�
    @Insert("INSERT INTO review (userNo, restNo, reviewContent, reviewScore, createDate) "
            + "VALUES (#{userNo}, #{restNo}, #{reviewContent}, #{reviewScore}, NOW())")
    int addReview(ReviewVo bean);

    // Ư�� �Ĵ��� ��� ���� ��ȸ (userName ����)
    @Select("SELECT r.*, u.userName FROM review r JOIN users u ON r.userNo = u.userNo "
            + "WHERE r.restNo = #{restNo} ORDER BY r.createDate DESC")
    List<ReviewVo> getReviewsByRestaurant(int restNo);

    // Ư�� ������� ��� ���� ��ȸ (userName ����)
    @Select("SELECT r.*, u.userName FROM review r JOIN users u ON r.userNo = u.userNo "
            + "WHERE r.userNo = #{userNo} ORDER BY r.createDate DESC")
    List<ReviewVo> getReviewsByUser(int userNo);

    // ����ڰ� �ش� ��ȣ�� ���� ���� ���� Ȯ�� - @Param �߰�
    @Select("SELECT COUNT(*) FROM review WHERE userNo = #{userNo} AND restNo = #{restNo}")
    int checkExistingReview(@Param("userNo") int userNo, @Param("restNo") int restNo);
    
    // Ư�� ���� ��ȸ (userName ����)
    @Select("SELECT r.*, u.userName FROM review r JOIN users u ON r.userNo = u.userNo "
            + "WHERE r.reviewNo = #{reviewNo}")
    ReviewVo getReview(int reviewNo);

    // ���� ����
    @Update("UPDATE review SET reviewContent = #{reviewContent}, reviewScore = #{reviewScore} "
            + "WHERE reviewNo = #{reviewNo}")
    int updateReview(ReviewVo bean);

    // ���� ����
    @Delete("DELETE FROM review WHERE reviewNo = #{reviewNo}")
    int deleteReview(int reviewNo);
}
