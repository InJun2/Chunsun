package com.chunsun.memberservice.application.dto;

import java.time.LocalDate;
import java.util.List;

import com.chunsun.memberservice.domain.Entity.Category;
import com.chunsun.memberservice.domain.Enum.Gender;

public record MemberDto() {

	public record SignUpRequest(
		String kakaoId,
		String email,
		String name,
		String nickname,
		LocalDate birthdate,
		Gender gender) {
	}

	public record SignUpResponse(
		String message) {
	}

	public record UpdateInfoRequest(
		String nickname,
		String profileImage
	) {
	}

	public record UpdateInfoResponse() {
	}

	public record GetInfoRequest(
		Long id
	) {
	}

	public record GetInfoResponse(
		String name,
		String nickname,
		String email,
		LocalDate birthdate,
		Gender gender,
		String profileImage
	) {
	}

	public record MemberListItem(
		Long id,
		String nickname,
		Integer age,
		Gender gender,
		List<Category> categories){
	}
}
