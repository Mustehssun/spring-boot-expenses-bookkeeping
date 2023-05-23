package com.mustehssuniqbal.expensesbookkeeping.filters;

import com.mustehssuniqbal.expensesbookkeeping.domain.User;
import com.mustehssuniqbal.expensesbookkeeping.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class UserFilter extends OncePerRequestFilter {
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String username = (String) req.getAttribute("username");
        Optional<User> user = userRepository.findByUsername(username);

        req.setAttribute("user", user.orElse(null));

        filterChain.doFilter(req, res);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest req) {
        String path = req.getServletPath();

        return path.startsWith("/auth/");
    }
}
