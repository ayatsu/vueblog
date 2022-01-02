package com.mmjj.controller;


import com.mmjj.common.lang.Result;
import com.mmjj.entity.MUser;
import com.mmjj.service.MUserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mmjj
 * @since 2021-12-31
 */
@RestController
public class MUserController {
    @Autowired
    MUserService mUserService;

//    @RequiresAuthentication
    @GetMapping("/index")
    public Result index(){
        MUser user = mUserService.getById(1L);
        return Result.success(user);
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody MUser user){
        return Result.success(user);
    }

}
