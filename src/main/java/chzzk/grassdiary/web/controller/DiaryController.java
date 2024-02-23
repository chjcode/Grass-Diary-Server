package chzzk.grassdiary.web.controller;

import chzzk.grassdiary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/diary")
public class DiaryController {
    private final DiaryService diaryService;

    /**
     * 유저별 날짜에 따른 일기 검색(잔디 클릭시 사용)
     * API 형식: api/diary/1?date=2024-02-21
     */
    @GetMapping("/{memberId}")
    public ResponseEntity<?> searchByDate(@PathVariable Long memberId, @RequestParam String date) {
        return ResponseEntity.ok(diaryService.findByDate(memberId, date));
    }

    /**
     * 대표 일기(오늘의 좋아요 가장 많은 받은 일기 10개)
     * memberId: 해당 일기에 대한 작성자의 좋아요 유무를 판단하기 위해 필요
     */
    @GetMapping("/popularity/{memberId}")
    public ResponseEntity<?> todayPopularDiary(@PathVariable Long memberId) {
        return ResponseEntity.ok(diaryService.popularDiary(memberId));
    }
}
