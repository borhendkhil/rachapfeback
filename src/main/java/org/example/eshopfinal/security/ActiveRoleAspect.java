package org.example.eshopfinal.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.example.eshopfinal.decorators.ActiveRole;
import org.example.eshopfinal.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ActiveRoleAspect {

    @Autowired
    private IRoleService roleService; // Assuming you have a service to check roles and their status

    @Pointcut("@annotation(activeRole)")
    public void callAt(ActiveRole activeRole) { }

    @Around("callAt(activeRole)")
    public Object around(ProceedingJoinPoint pjp, ActiveRole activeRole) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            for (String role : activeRole.roles()) {
                if (authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role))
                        && roleService.isRoleActive(role)) {
                    return pjp.proceed();
                }
            }
        }
        System.out.println("User does not have required role");
        throw new AccessDeniedException("User does not have required role");
    }
}