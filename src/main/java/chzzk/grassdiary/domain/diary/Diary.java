package chzzk.grassdiary.domain.diary;

import chzzk.grassdiary.domain.base.BaseTimeEntity;
import chzzk.grassdiary.domain.color.ConditionLevel;
import chzzk.grassdiary.domain.member.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter // DBTest에서 임시 사용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Diary extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ColumnDefault("true")
    private Boolean isPrivate;

    @OneToMany(mappedBy = "diary")
    private List<DiaryLike> diaryLikes = new ArrayList<>();

    @ColumnDefault("false")
    private Boolean hasImage;

    @ColumnDefault("false")
    private Boolean hasTag;

    @Enumerated(EnumType.STRING)
    private ConditionLevel conditionLevel;

    @Builder
    public Diary(Long id, Member member, String content, Boolean isPrivate, List<DiaryLike> diaryLikes, Boolean hasImage, Boolean hasTag, ConditionLevel conditionLevel) {
        this.id = id;
        this.member = member;
        this.content = content;
        this.isPrivate = isPrivate;
        this.diaryLikes = diaryLikes;
        this.hasImage = hasImage;
        this.hasTag = hasTag;
        this.conditionLevel = conditionLevel;
    }

    public void update(String content, Boolean isPrivate, Boolean hasImage, Boolean hasTag, ConditionLevel conditionLevel) {
        this.content = content;
        this.isPrivate = isPrivate;
        this.hasImage = hasImage;
        this.hasTag = hasTag;
        this.conditionLevel = conditionLevel;
    }
}
