package com.chunsun.memberservice.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chunsun.memberservice.application.dto.StudentDto;
import com.chunsun.memberservice.application.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	/*
	* 학생 카드 생성
	* 학생 카드 수정
	* 학생 카드 조회(본인 카드)
	* 학생 카드 조회(남 카드)
	* */

	@PostMapping
	public ResponseEntity<StudentDto.CardResponse> addCard(
		@RequestBody StudentDto.CardRequest request) {

		StudentDto.CardResponse response = studentService.createCard(request);
		return ResponseEntity.ok(response);
	}

	@PutMapping
	public ResponseEntity<StudentDto.CardResponse> updateCard(
		@RequestBody StudentDto.CardRequest request) {

		StudentDto.CardResponse response = studentService.updateCard(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<StudentDto.GetCardResponse> getCard(
		@RequestBody StudentDto.GetCardRequest request) {

		StudentDto.GetCardResponse response = studentService.getCard(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDto.GetDetailResponse> getDetail(
		@PathVariable Long studentId) {

		StudentDto.GetDetailResponse response = studentService.getDetail(studentId);
		return ResponseEntity.ok(response);
	}
}
