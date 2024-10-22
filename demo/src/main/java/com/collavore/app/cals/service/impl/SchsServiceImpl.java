package com.collavore.app.cals.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.collavore.app.cals.mapper.SchsMapper;
import com.collavore.app.cals.service.CalsVO;
import com.collavore.app.cals.service.SchsService;
import com.collavore.app.cals.service.SchsVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchsServiceImpl implements SchsService {
	private final SchsMapper schsMapper;

	// 조회
	@Override
	public List<SchsVO> SchsList() {
		return schsMapper.selectSchsAll();
	}

	// 단건조회
	@Override
	public SchsVO SchsInfo(SchsVO schsVO) {
		return schsMapper.selectSchsInfo(schsVO);
	}

	// 등록
	@Override
	public int insertSchs(SchsVO schsVO) {
		int result = schsMapper.insertSchsInfo(schsVO);
		return result == 1 ? schsVO.getSchNo() : -1;

	}
	
	//수정
	@Override
	public Map<String, Object> updateSchs(SchsVO schsVO) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			int updatedRows = schsMapper.updateSchsInfo(schsVO);

			if (updatedRows > 0) {
				resultMap.put("result", true);
				resultMap.put("message", "일정이 성공적으로 수정되었습니다.");
			} else {

				resultMap.put("result", false);
				resultMap.put("message", "수정할 일정이 없습니다.");
			}
		} catch (Exception e) {
			resultMap.put("result", false);
			resultMap.put("message", "수정 중 오류가 발생했습니다.");
		}
		return resultMap;
	}

	// 삭제
	@Override
	public int deleteSchs(int schsNO) {
		return schsMapper.deleteSchsInfo(schsNO);
	}

	// =====================캘린더 사이드바=====================
	// 사이드바 캘린더 전체
	@Override
	public List<CalsVO> allCal() {
		return schsMapper.selectSoloCal();
	}

	// 개인캘린더
	@Override
	public List<CalsVO> soloCal() {
		return schsMapper.selectSoloCal();
	}

	// 공유캘린더
	@Override
	public List<CalsVO> teamCal() {
		return schsMapper.selectTeamCal();
	}

	// 프로젝트 캘린더
	@Override
	public List<CalsVO> projCal() {
		return schsMapper.selectProjCal();
	}

	// 캘린더 등록
	@Override
	public int insertCals(CalsVO calsVO) {
		int result = schsMapper.insertCalsInfo(calsVO);
		return result == 1 ? calsVO.getCalNo() : -1;

	}
	
	// 캘린더 수정
	@Override
	public Map<String, Object> updateCals(CalsVO calsVO) {
	    Map<String, Object> resultMap = new HashMap<>();
	    try {
	        int updatedRows = schsMapper.updateCalsInfo(calsVO); // 매퍼 호출

	        if (updatedRows > 0) {
	            resultMap.put("result", true);
	        } else {
	            resultMap.put("result", false);
	        }
	    } catch (Exception e) {
	        resultMap.put("result", false);
	    }
	    return resultMap;
	}

	// 캘린더를 휴지통으로 이동 (isDelete = 'h1')
	@Override
	public String moveTrash(String calNo) {
		int result = schsMapper.updateCalToTrash(calNo);
		return result > 0 ? "Success" : null;
	}

	// 휴지통에서 캘린더 복원 (isDelete = 'h2')
	@Override
	public String calRestore(String calNo) {
		int result = schsMapper.restoreCalFromTrash(calNo);
		return result > 0 ? "Success" : null;
	}

	// 캘린더 완전 삭제
	@Override
	public String permanentlyDel(String calNo) {
		int result = schsMapper.permanentlyDeleteCal(calNo);
		return result > 0 ? "Success" : null;
	}

	// =====================END 캘린더 사이드바=====================

}