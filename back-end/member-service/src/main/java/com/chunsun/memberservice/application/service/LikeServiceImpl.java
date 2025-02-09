package com.chunsun.memberservice.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chunsun.memberservice.application.dto.LikeDto;
import com.chunsun.memberservice.common.error.GlobalErrorCodes;
import com.chunsun.memberservice.common.exception.BusinessException;
import com.chunsun.memberservice.domain.Entity.Like;
import com.chunsun.memberservice.domain.Entity.Member;
import com.chunsun.memberservice.domain.Repository.LikeRepository;
import com.chunsun.memberservice.domain.Repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeServiceImpl implements LikeService {

	private final LikeRepository likeRepository;
	private final MemberRepository memberRepository;

	// 찜하기 요청, 취소
	@Override
	@Transactional
	public Boolean getLike(LikeDto.LikeRequest request) {

		Long liker = request.likerId();
		Long likee = request.likeeId();

		if(!memberRepository.existsById(likee)) {
			throw new BusinessException(GlobalErrorCodes.USER_NOT_FOUND);
		}

		Boolean isLike = likeRepository.existsByLikerIdAndLikeeId(liker,likee);

		if(isLike) {
			likeRepository.deleteByLikerIdAndLikeeId(liker, likee);

			return false;
		} else {
			Like like =Like.builder().
				likerId(liker).
				likeeId(likee).
				build();
			likeRepository.save(like);

			return true;
		}
	}
}
