package shcedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shcedule.entity.User;
import shcedule.repository.UserRepository;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class LoginFilter implements Filter {

    private final UserRepository userRepository;

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String method = httpRequest.getMethod();
        String requestURI = httpRequest.getRequestURI();
        String email = httpRequest.getParameter("email");
        String password = httpRequest.getParameter("password");

        log.info("로그인 필터 로직 실행");

        // 유저 등록(POST), 로그인 경로는 filter 적용 제외
        if (!requestURI.startsWith("/login")
                && !(requestURI.startsWith("/users") && "POST".equals(method))
                && !isAuthenticated(email, password)) {
            // 세션이 존재하면 가져오고, 세션이 없으면 session = null
            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute("email") == null) {
                httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "로그인 해주세요.");

                return;
            }
        }

        chain.doFilter(request, response);
    }

    // 이메일 및 비밀번호 인증 확인
    private boolean isAuthenticated(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);

        return user.isPresent() && user.get().getPassword().equals(password);
    }
}
