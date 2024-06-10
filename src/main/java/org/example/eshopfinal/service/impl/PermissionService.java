package org.example.eshopfinal.service.impl;

import org.example.eshopfinal.entities.security.Permission;
import org.example.eshopfinal.repository.PermissionRepository;
import org.example.eshopfinal.service.IPersmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService implements IPersmissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission getPermissionById(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }

    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission updatePermission(Long id, Permission permissionDetails) {
        Permission permission = permissionRepository.findById(id).orElse(null);
        if (permission != null) {
            permission.setName(permissionDetails.getName());
            return permissionRepository.save(permission);
        }
        return null;
    }

    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }
}