package shop.mtcoding.project.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.project.dto.ResponseDto;
import shop.mtcoding.project.dto.user.UserReq.UserJoinReqDto;
import shop.mtcoding.project.exception.CustomApiException;
import shop.mtcoding.project.exception.CustomException;
import shop.mtcoding.project.model.User;
import shop.mtcoding.project.model.UserRepository;
import shop.mtcoding.project.service.UserService;

@Controller
public class UserController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

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

    @PostMapping("/user/join")
    public String join(UserJoinReqDto userJoinReqDto) {
        if (userJoinReqDto.getEmail() == null || userJoinReqDto.getEmail().isEmpty()) {
            throw new CustomException("이메일을 작성해주세요");
        }
        if (userJoinReqDto.getName() == null || userJoinReqDto.getName().isEmpty()) {
            throw new CustomException("이름을 작성해주세요");
        }
        if (userJoinReqDto.getPassword() == null ||
                userJoinReqDto.getPassword().isEmpty()) {
            throw new CustomException("패스워드를 작성해주세요");
        }
        if (userJoinReqDto.getPassword() == null ||
                userJoinReqDto.getPassword().isEmpty()) {
            throw new CustomException("동일한 패스워드를 작성해주세요");
        }
        if (userJoinReqDto.getBirth() == null || userJoinReqDto.getBirth().isEmpty()) {
            throw new CustomException("생년월일을 작성해주세요");
        }
        if (userJoinReqDto.getTel() == null || userJoinReqDto.getTel().isEmpty()) {
            throw new CustomException("휴대폰번호을 작성해주세요");
        }
        userService.회원가입(userJoinReqDto);

        return "redirect:/user/login";
    }

    @GetMapping("/join/emailCheck")
    public ResponseEntity<?> sameUsernameCheck(String email) {
        User userPS = userRepository.findByUserEmail(email);
        if (userPS != null) {
            throw new CustomApiException("동일한 email이 존재합니다.");
        }
        return new ResponseEntity<>(new ResponseDto<>(1, "해당 email은 사용 가능합니다.", null), HttpStatus.OK);
    }

    @GetMapping("/user/join")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/user/login")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/myhome")
    public String myhome() {
        mockUserSession();
        return "user/myhome";
    }

    @GetMapping("/user/interest")
    public String interest() {
        return "user/interest";
    }

    @GetMapping("/user/update")
    public String update() {
        return "user/updateForm";
    }

    @GetMapping("/user/scrap")
    public String scarp() {
        return "user/scrap";
    }

    @GetMapping("/user/offer")
    public String offer() {
        return "user/offer";
    }
}

// ⬜ 회원가입 "/user/join"
// ⬜ 로그인 "/user/login"
// ⬜ 관심기업 "/user/interest"

// 🟩 🔐 유저권한필요 🔐 🟩
// 🟩 유저홈 "/user/myhome"
// 🟩 회원수정 "/user/update"
// 🟩 스크랩 "/user/scrap"
// 🟩 지원 및 받은제안 "/user/offer"