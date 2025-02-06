package com.chunsun.memberservice.application.dto;

import java.util.List;

import com.chunsun.memberservice.domain.Bank;
import com.chunsun.memberservice.domain.Category;
import com.chunsun.memberservice.domain.Gender;

public record TeacherDto() {
	public record CreateCardRequest(
		Long id,
		String description,
		String careerDescription,
		String careerProgress,
		String classContents,
		Boolean isWanted,
		Bank bank,
		String account,
		Integer price) {
	}

	public record CreateCardResponse(
		String message) {
	}

	public record UpdateCardRequest(
		Long id,
		String description,
		String careerDescription,
		String careerProgress,
		String classContents,
		Boolean isWanted,
		Bank bank,
		String account,
		Integer price) {
	}

	public record UpdateCardResponse(
		String message) {
	}

	public record GetCardRequest(
		Long id
	){
	}

	public record GetCardResponse(
		String description,
		String careerDescription,
		String careerProgress,
		String classContents,
		Boolean isWanted,
		Bank bank,
		String account,
		Integer price,
		Integer totalClassCount,
		Integer totalClassHours,
		List<Category> categories) {
	}

	public record GetDetailResponse(
		String name,
		String nickname,
		Gender gender,
		Integer age,
		String description,
		String careerDescription,
		String careerProgress,
		String classContents,
		Integer price,
		Integer totalClassCount,
		Integer totalClassHours,
		List<Category> categories) {
	}

	public record ClassFinishRequest(
		Long id,
		Integer time
	) {
	}

	public record ClassFinishResponse(
		Integer totalClassCount,
		Integer totalClassHours
	){
	}

	public record GetClassRequest(
		Long id
	){
	}

}
