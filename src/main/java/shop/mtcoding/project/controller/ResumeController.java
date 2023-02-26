package shop.mtcoding.project.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import shop.mtcoding.project.dto.ResponseDto;
import shop.mtcoding.project.dto.resume.ResumeReq.ResumeWriteReqDto;
import shop.mtcoding.project.exception.CustomApiException;
import shop.mtcoding.project.model.ResumeRepository;
import shop.mtcoding.project.model.User;
import shop.mtcoding.project.service.ResumeService;

@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private HttpSession session;

    private void mockUserSession() {
        User mockUser = new User(
                1,
                "ssar@nate.com",
                "1234",
                "ssar",
                "2000-01-01",
                "010-1234-1234",
                "/images/default_profile.png",
                "부산시 부산진구",
                new Timestamp(System.currentTimeMillis()));
        session.setAttribute("principal", mockUser);
    }

    @GetMapping("/user/resume") // 이력서관리
    public String resume() {
        return "resume/resume";
    }

    @PostMapping("/user/resume/write")
    public ResponseEntity<?> write(@RequestBody ResumeWriteReqDto resumeWriteReqDto) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            throw new CustomApiException("인증이 되지 않았습니다", HttpStatus.UNAUTHORIZED);
        }
        if (resumeWriteReqDto.getEducation() == null) {
            throw new CustomApiException("학력을 입력해주세요");
        }
        if (resumeWriteReqDto.getEducation() == null) {
            throw new CustomApiException("경력을 입력해주세요");
        }
        if (resumeWriteReqDto.getTitle() == null) {
            throw new CustomApiException("제목을 입력해주세요");
        }
        if (!(resumeWriteReqDto.getState() == 0 || resumeWriteReqDto.getState() == 1)) {
            throw new CustomApiException("공개여부를 선택해주세요");
        }
        resumeService.글쓰기(resumeWriteReqDto, principal.getUserId());

        return new ResponseEntity<>(new ResponseDto<>(1, "이력서 작성이 완료되었습니다.", null), HttpStatus.OK);

    }

    @GetMapping("/user/resume/write")
    public String writeResume(Model model) {
        mockUserSession();
        return "resume/writeResumeForm";
    }

    @GetMapping("/user/resume/{id}/update")
    public String updateResume() {
        return "resume/updateResumeForm";
    }

    @GetMapping("/resume/{id}")
    public String resumeDetail() {
        return "/resume/resumeDetail";
    }

    
}

// 🟨 공개하면 기업이 접근 가능 🟨
// 🟨 이력서번호 "/resume/이력서번호"

// 🟩 🔐 유저권한필요 🔐 🟩
// 🟩 이력서관리 "/user/resume"
// 🟩 이력서작성 "/user/resume/write"
// 🟩 이력서수정 "/user/resume/이력서번호/update"