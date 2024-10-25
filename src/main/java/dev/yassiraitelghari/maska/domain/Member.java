package dev.yassiraitelghari.maska.domain;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName ;

    @Column(name = "identity_number")
    private String identityNumber;

    private String nationality ;

    @Column(name = "start_date")
    private LocalDateTime startDate ;

    @Column(name = "end_date")
    private LocalDateTime endDate ;

}
