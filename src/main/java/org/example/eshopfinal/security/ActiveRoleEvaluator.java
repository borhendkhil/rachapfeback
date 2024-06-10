package org.example.eshopfinal.security;

import org.example.eshopfinal.entities.security.Role;
import org.example.eshopfinal.repository.PermissionRepository;
import org.example.eshopfinal.repository.RoleRepository;
import org.example.eshopfinal.service.IRoleService;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class ActiveRoleEvaluator implements PermissionEvaluator {

    private final IRoleService roleService;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    public ActiveRoleEvaluator(RoleRepository roleRepository, IRoleService roleService, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.roleService = roleService;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        System.out.println("iciiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        String[] roles = (String[]) permission;
        for (String role : roles) {
            if (hasRole(authentication, role) && roleService.isRoleActive(role) && hasPermission(authentication, role, targetDomainObject)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }

    private boolean hasRole(Authentication authentication, String roleName) {
        System.out.println(roleName+" ----------------------");
        return authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(roleName));
    }
    private boolean hasPermission(Authentication authentication, String roleName, Object permission) {
        Role role = roleRepository.findByLabel(roleName).orElse(null);
        if (role == null || !role.getFlag()) {
            return false;
        }
        return role.getPermissions().stream()
                .anyMatch(rolePermission -> rolePermission.getName().equals(permission.toString()));
    }
}