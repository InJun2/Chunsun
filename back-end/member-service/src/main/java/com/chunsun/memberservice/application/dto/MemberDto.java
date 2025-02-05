package com.chunsun.memberservice.application.dto;

import java.time.LocalDate;
import java.util.List;

import com.chunsun.memberservice.domain.Category;
import com.chunsun.memberservice.domain.Gender;
import com.chunsun.memberservice.domain.Role;

public record MemberDto() {

	public record KaKaoRequest(
		String kakaoId,
		String email) {
	}

	public record KaKaoResponse(){

	}

	public record SignUpRequest(
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

	public record GetInfoRequest() {
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
