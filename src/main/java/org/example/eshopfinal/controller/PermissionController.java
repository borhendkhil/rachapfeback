package org.example.eshopfinal.controller;

import org.example.eshopfinal.entities.security.Permission;
import org.example.eshopfinal.service.impl.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@CrossOrigin(origins = "*")
public class PermissionController {
//ADMIN
    @Autowired
    private PermissionService permissionService;

    @GetMapping
    @PreAuthorize("hasPermission(null, 'Permission', 'permission_read')")
    public List<Permission> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasPermission(#id, 'Permission', 'permission_read')")
    public Permission getPermissionById(@PathVariable Long id) {
        return permissionService.getPermissionById(id);
    }

    @PostMapping
    @PreAuthorize("hasPermission(null, 'Permission', 'permission_add')")
    public Permission createPermission(@RequestBody Permission permission) {
        return permissionService.createPermission(permission);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasPermission(#id, 'Permission', 'permission_update')")
    public Permission updatePermission(@PathVariable Long id, @RequestBody Permission permissionDetails) {
        return permissionService.updatePermission(id, permissionDetails);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasPermission(#id, 'Permission', 'permission_delete')")
    public void deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
    }
}