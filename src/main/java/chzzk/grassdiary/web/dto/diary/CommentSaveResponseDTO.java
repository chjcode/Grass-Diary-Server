package chzzk.grassdiary.web.dto.diary;

import chzzk.grassdiary.domain.diary.comment.Comment;
import chzzk.grassdiary.domain.member.Member;
import java.time.format.DateTimeFormatter;

public record CommentSaveResponseDTO(
        // 멤버 정보(사진, 아이디), 댓글내용, 작성 시간
        // todo: 사진정보 추가
        Long memberId,
        String content,
        String createdDate,
        String createdAt

) {
    public static CommentSaveResponseDTO from(Member member, Comment comment) {
        return new CommentSaveResponseDTO(
                member.getId(),
                comment.getContent(),
                comment.getCreatedAt().format(DateTimeFormatter.ofPattern("yy년 MM월 dd일")),
                comment.getCreatedAt().format(DateTimeFormatter.ofPattern("HH:mm"))
        );
    }

}