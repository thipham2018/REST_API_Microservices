package org.ac.cst8277.pham.thi.config.security;

import org.ac.cst8277.pham.thi.common.utils.JwtTokenUtils;
import org.ac.cst8277.pham.thi.config.security.jwt.JwtUserDetailsService;
import org.ac.cst8277.pham.thi.dao.LastVisitRepository;
import org.ac.cst8277.pham.thi.dao.UserRepository;
import org.ac.cst8277.pham.thi.dto.LastVisit;
import org.ac.cst8277.pham.thi.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Service
public class UserManagementService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LastVisitRepository lastVisitRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    public Users createSessionLogin(String email){
        Users users = userRepository.findByEmail(email);
        if(users == null) return null;
        LastVisit lastVisit = new LastVisit();
        lastVisitRepository.save(lastVisit);
        users.setLastVisitId(lastVisit.getId());
        userRepository.save(users);
        UserDetails userDetails = userDetailsService.loadUserByEmail(email);
        String jwtToken = JwtTokenUtils.generateToken(userDetails);
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        session.setAttribute("jwt_token", jwtToken);
        return users;
    }

    public Users getSessionLogin(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        String jwtToken = (String) session.getAttribute("jwt_token");
        String email = JwtTokenUtils.getUsernameFromToken(jwtToken);
        return userRepository.findByEmail(email);
    }
}
