package com.mbc.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ezen.model.MemberDAO;
import kr.ezen.model.MemberDTO;

@Controller
public class MemberController {
	
	@Autowired // DI(Dependency Injection: 의존성 주입)
	private MemberDAO dao;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		List<MemberDTO> memberList = dao.memberList();
		model.addAttribute("list", memberList);
		
		return "memberList";
	}
	
	@RequestMapping("/memberRegister.do")
	public String memberRegister() {
		return "register";
	}
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberDTO dto) {
		int cnt = dao.memberInsert(dto);
		
		return "redirect:memberList.do";
	}
	
	@RequestMapping("/memberInfo.do")
	public String memberInfo(int no, Model model) {
		MemberDTO dto = dao.memberInfo(no);
		model.addAttribute("dto", dto);
		
		return "memberInfo";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberDTO dto) {
		dao.memberUpdate(dto);
		
		return "redirect:memberList.do";
	}
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(int no) {
		dao.deleteMember(no);
		
		return "redirect:memberList.do";
	}
	
	
	
	
	
	
	
	
	
}
