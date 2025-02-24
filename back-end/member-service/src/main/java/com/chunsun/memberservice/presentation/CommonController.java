package com.chunsun.memberservice.presentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.chunsun.memberservice.application.dto.CategoryDto;
import com.chunsun.memberservice.application.dto.LikeDto;
import com.chunsun.memberservice.application.service.CategoryService;
import com.chunsun.memberservice.application.service.LikeService;
import com.chunsun.memberservice.common.util.HeaderUtil;
import com.chunsun.memberservice.domain.Entity.Category;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommonController {

	private final CategoryService categoryService;
	private final LikeService likeService;

	@PostMapping("/category")
	public ResponseEntity<CategoryDto.CategoryResponse> createCategory(
		@RequestHeader("X-User-ID") Long memberId,
		@RequestBody CategoryDto.CategoryRequest request) {

		categoryService.createCategory(memberId, request);

		return ResponseEntity.ok().body(new CategoryDto.CategoryResponse("카테고리 입력 완료", request.categoryIds()));
	}

	@PutMapping("/category/{id}")
	public ResponseEntity<CategoryDto.CategoryResponse> updateCategory(
		@RequestHeader("X-User-ID") Long memberId,
		@PathVariable Long id,
		@RequestBody CategoryDto.CategoryRequest request) {
		HeaderUtil.validateUserId(id, memberId);

		categoryService.updateCategory(id, request.categoryIds());

		return ResponseEntity.ok().body(new CategoryDto.CategoryResponse("카테고리 업데이트 완료", request.categoryIds()));
	}

	@GetMapping("/category/{id}")
	public List<Category> getUserCategories(
		@RequestHeader("X-User-ID") Long memberId,
		@PathVariable long id) {
		HeaderUtil.validateUserId(id, memberId);

		return categoryService.getUserCategories(id);
	}

	@GetMapping("/categories")
	public List<Category> getCategory() {

		return categoryService.getList();
	}

	@PostMapping("/like")
	public ResponseEntity<LikeDto.LikeResponse> like(
		@RequestHeader("X-User-ID") Long memberId,
		@RequestBody LikeDto.LikeRequest request) {
		HeaderUtil.validateUserId(request.likerId(), memberId);

		Boolean isLike = likeService.getLike(request);

		String message = isLike? (request.likerId() + "가 찜했습니다.") : (request.likerId() + "가 찜을 해제했습니다.");

		return ResponseEntity.ok(new LikeDto.LikeResponse(isLike, message));
	}
}