package com.collavore.app.cals.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.collavore.app.cals.service.SchsVO;

public interface SchsMapper {

	// 전체 일정 조회
	public List<SchsVO> selectSchsAll(int empNo);
	// 풀캘린더에서 이벤트드롭으로 날짜시간값만 바꾸기
	int updateEventTime(SchsVO schsVO);
	

	// 등록
	public int insertSchsInfo(SchsVO schsVO);

	// 등록
	public int alarmInsert(SchsVO schsVO);

	// type에 따른 cal_no 조회
	public int selectCalType(String type);

	// 단건조회
	public SchsVO selectSchsInfo(SchsVO schsVO);

	// 수정
	public int updateSchsInfo(SchsVO schsVO);

	// 수정 알림등록
	public int updateAlarmInfo(SchsVO schsVO);

	// 알림 정보 삽입 (알림이 없는 경우 새로 삽입)
	public int insertAlarmInfo(SchsVO schsVO);

	// 알림 정보 삭제 (알림 설정이 비활성화된 경우)
	public int deleteAlarmInfo(int schNo);
	
	 //  알림 요일 정보만 업데이트하는 메서드
    int updateAlarmYoil(SchsVO schsVO);

	// 해당 sch_no의 알림 존재 여부 확인
	public int checkAlarm(int schNo);

	// 삭제 조건
	public int deleteSchsInfo(int schsNO);

	// ===캘린더관련

	// 일정생성창 캘린더 전체 조회
	public List<SchsVO> selectAllCal(int empNo); // 공유 일정 조회
	// 공유캘린더 조회

	public List<SchsVO> selectTeamCal(int empNo); // 공유 일정 조회

	// 캘린더 등록
	public int insertCalsInfo(SchsVO schsVO);
	// 캘린더 공유자 정보 삽입
	// 매퍼 메서드 정의 (매개변수 Map 사용)
	public int insertCalShares(Map<String, Object> params);
	
	

//	// 캘린더 수정
//	public int updateCalsInfo(SchsVO schsVO);
	// 캘린더 기본 정보 업데이트
    int updateCalendarDetails(@Param("calNo") int calNo, @Param("name") String name, @Param("color") String color);

    // 기존 참여자 삭제
    int deleteParticipantsByCalNo(@Param("calNo") int calNo);

    // 새 참여자 추가
    int addParticipant(Map<String, Object> params);
	//캘린더 수정할때 저장된 기본값 불러오기 부서 사원 참여자 
	public List<Map<String, Object>> getCalInfo(int calNo);
	
	// 캘린더 정보 조회
	public SchsVO selectCalInfo(int calNo);
	
	
	

	// 캘린더삭제
	// 휴지통 리스트
	public List<SchsVO> selectToTrash();
	
	// 프로젝트 리스트
	public List<SchsVO> selectprojList(int empNo);
	
	public int updateCalToTrash(int calNo); // 캘린더를 휴지통으로 이동

	public int restoreCalFromTrash(int calNo); // 캘린더 복원 (isDelete를 'h2'로 업데이트)

//	public int permanentlyDeleteCal(int calNo); // 캘린더 완전 삭제 (휴지통에 있는 캘린더 삭제)
	
	//----- 캘린더 완전삭제 -----
	// 일정관리 조회
    List<Integer> getSchedulesByCalNo(int calNo);

    // 일정알림관리 조회
    List<Integer> getAlarmsByScheduleNo(int schNo);

    // 일정알림 삭제
    int deleteAlarm(int alarmNo);

    // 일정 삭제
    int deleteSchedule(int schNo);

    // 캘린더 공유관리 삭제
    int deleteCalShares(int calNo);

    // 캘린더 삭제
    int deleteCalendar(int calNo);
  //-----end 캘린더 완전삭제 -----
	
	
	// 새로 등록된 사원에 내캘린더 생성
	public void insertMyCal(@Param("empNo") int empNo, @Param("result") Map<String, Object> result);
	
	
	
	List<Map<String, Object>> selectDeptWithEmp();

//	public List<SchsVO> selectDeptList();
//	// 캘린더 수정 추가시 부서 사원 리스트
//	List<Map<String, Object>> selectDeptEmp(@Param("calNo") int deptNo);

}