package org.example.telegrambackend.AUTH.user_profiles.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.telegrambackend.AUTH.user.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "user_profiles",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "display_name"),
                @UniqueConstraint(columnNames = "user_id")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            unique = true
    )
    private User user;

    @Column(nullable = false, length = 100)
    private String displayName;

    @Column(nullable = false, length = 500)
    private String bio;

    @Column(name = "avatar_url", nullable = false, length = 500)
    private String avatarUrl;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public UserProfile(String displayName, String bio, String avatarUrl, LocalDate dateOfBirth){
        this.displayName = displayName;
        this.bio = bio;
        this.avatarUrl = avatarUrl;
        this.dateOfBirth = dateOfBirth;
    }
}
