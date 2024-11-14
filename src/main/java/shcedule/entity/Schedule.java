package shcedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "schedule")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 일정 식별자 아이디 (기본키)

    @ManyToOne
    @JoinColumn(name = "userId")
    @Setter
    private User user; // 유저 식별자 아이디 (외래키)

    private String title;
    private String contents;

    @Column(name = "createdDate")
    @CreatedDate
    private Long createdDate;

    @Column(name = "modifiedDate")
    @LastModifiedDate
    private Long modifiedDate;

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}