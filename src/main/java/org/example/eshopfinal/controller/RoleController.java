package org.example.eshopfinal.controller;

import lombok.AllArgsConstructor;
import org.example.eshopfinal.entities.security.Role;
import org.example.eshopfinal.service.IRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/role")
@CrossOrigin(origins = "*")
public class RoleController {
    //admin

    private final IRoleService roleService;



    @GetMapping
    public List<Role> getAllRoles(){
        List<Role> list= roleService.getAllRole();
        return  list;
    }

    @PostMapping("/add")
    public Role AjouterRole(@RequestBody Role r){
        return roleService.ajouterRrole(r);
    }

    @PutMapping("flag/{id}")
    public void FlagRole(@PathVariable Long id){
        roleService.FlagRole(id);}

    @PutMapping("update/{id}")
    public void UpdateRole(@PathVariable Long id,@RequestBody Role r) {
        roleService.updaterole(r,id);}

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);
    }


}
