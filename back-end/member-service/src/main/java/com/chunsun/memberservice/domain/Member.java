package com.chunsun.memberservice.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
	private Student student;

	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
	private Teacher teacher;

	private String kakaoId;

	private String name;

	private String nickname;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private String email;

	private String profileImage;

	private LocalDate birthdate;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MemberCategory> memberCategories = new ArrayList<>();

	@CreatedDate
	private LocalDateTime createdAt;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	private LocalDateTime deletedAt;

	@Builder
	public Member(String kakaoId, String email, String name, String nickname, LocalDate birthdate, Role role,Gender gender) {
		this.kakaoId = kakaoId;
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.birthdate = birthdate;
		this.role = role;
		this.gender = gender;
		this.createdAt = LocalDateTime.now();
	}

	public Member(Long memberId) {
		this.id = memberId;
	}

	public void updateInfo(String nickname, String profileImage) {
		if(nickname != null) this.nickname = nickname;
		if(profileImage != null) this.profileImage = profileImage;
		updatedAt = LocalDateTime.now();
	}

	public void delete() {
		this.deletedAt = LocalDateTime.now();
	}

	public void updateRole(Role role) {
		this.role = role;
	}
}
