package com.chunsun.memberservice.domain.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "likes")
@Getter
@NoArgsConstructor
public class Like {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long likerId;

	private Long likeeId;

	@CreatedDate
	private LocalDateTime createdAt;

	@Version
	private Long version;

	@Builder
	public Like(Long likerId, Long likeeId) {
		this.likerId = likerId;
		this.likeeId = likeeId;
		createdAt = LocalDateTime.now();
	}
}
