package com.collavore.app.project.service;

import java.util.List;
import java.util.Map;


public interface PjService {
	//프로젝트현황 리스트 
	public List<ProjectVO> projectList();
	//프로젝트 생성
	public int projectinsert(ProjectVO proejctVO);
	// 프로젝트 삭제
	public int projectDelete(int projNo);
	// 프로젝트 업무 삭제
	public int projectwrkDelete(int pwNo);	
	// 프로젝트 단건조회
	public ProjectVO projectInfo(int projNo); 
	// 프로젝트 수정
	public int updateProject(ProjectVO proejctVO);
	
	// 프로젝트 폴더 리스트 
	public List<ProjectFoldersVO> projectfolderList();
	// 프로젝트 파일 리스트
	public List<ProjectFilesVO> projectfileList(int pfNo);
	
	public int saveFile(String originalFilename, ProjectFilesVO projectFilesVO);
	
	public ProjectFilesVO getFileDetails(Long projFileNo);
	
	// 프로젝트 트리구조 리스트
	public List<ProjectVO> projecttreeList();
	
	public int  projectwrkinsert(ProjectVO projectVO);
	
	public int selectPwNo(int pdwNo);
	
	public int projectdwrkinsert(ProjectVO projectVO);
	
	
	public ProjectVO projectwrkInfo(int pwNo);
	
	public ProjectVO projectdwrkInfo(int pdwNo);
	
	public Map<String, Object> updatewrkProject(ProjectVO projectVO);
	
	public Map<String, Object> updatedwrkProject(ProjectVO projectVO);
	
	// 프로젝트 상세업무 코멘트 전체 리스트
	public List<ProjectDWorkComtVO> projectDWrkComtList();
	
	// 프로젝트 상세업무 코멘트 단건조회 
//	public List<ProjectVO> projectDWrkComtInfo(int pdwNo);
	public List<ProjectVO> projectDWrkComtInfo(int pdwNo);
	
	// 프로젝트 상세업무 코멘트 생성
	public int projectdwrkcomtinsert(ProjectVO projectVO);
	
	// 부서정보 리스트
	public List<ProjectVO> departmentsList();
	/*
	 * // 프로젝트 담당자 public List<ProjectVO> projMgrInfo(); // 프로젝트 업무 담당자 public
	 * List<ProjectVO> wrkMgrIngo();
	 */

	
	  // 프로젝트 상세업무 담당자 public List<ProjectVO> dwrkMgrInfo(); // 업무 리스트 public
	  List<ProjectVO> jobsList();
	 
	// 업무별 담당자 리스트
	public List<ProjectVO> projectMgrListInfo(int jobNo);
	
	// 사원 리스트 출력
	public List<ProjectVO> empList();
	
	// 상세업무의 업무자 리스트 출력
	public List<ProjectVO> deteilwrkerList();
	
	// 상세업무 진행현황 업데이트
	public int updatestatusProject(ProjectVO projectVO);
	
	
//	public List<ProjectVO> getProjects(int page, int size);
//
//	public long getTotalProjects();

	// 로그인한 회원의 깃토큰값 가져오기
	
	// 등록된 깃의 clone_url값을 받아와서 git 주소로 입력하기.
	public int addGitUrl(ProjectVO projectVO);
	
	// 상세업무 삭제
	public int projectdwrkDelete(int pdwNo);
	
	// 업무리스트 
	public List<ProjectVO> projectwrkList(int projNo);
	
	// 코멘트 삭제
	public int projectcomtsDelete(int pdwcNo);
	
	// 프로젝트 폴더 생성
	public int projectfolderinsert(ProjectVO projectVO);
	
	// 프로젝트 폴더 삭제
	public int projectfolderDelete(int projNo);
	
	// 프로젝트 폴더 단건 조회
	public ProjectVO projectfolderInfo(int projNo);
	
	// 프로젝트 파일 조회
	public List<ProjectVO> projfileinfo(Integer pfNo);
	
	// 프로젝트 파일 삭제
	public int projfiledel(Integer pfNo);
	
	// 프로젝트 업무 단건 삭제
	public int projectwrkoneDelete(int pwNo);
	
	// 프로젝트 파일 삭제
	public int fileDelete(int projFileNo);
	
	// 회사 깃 정보 가져오기
	public ProjectVO compGitInfo();
	
	// 프로젝트 코멘트 삭제
	public int projectComtDel(int projNo);
	
	// 프로젝트 상세업무 삭제(단건)
	public int projectdeteilworkDelete(int pdwNo);
}
