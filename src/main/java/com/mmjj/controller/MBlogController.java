package com.mmjj.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mmjj.common.lang.Result;
import com.mmjj.entity.MBlog;
import com.mmjj.entity.MUser;
import com.mmjj.service.MBlogService;
import com.mmjj.service.MUserService;
import com.mmjj.util.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mmjj
 * @since 2021-12-31
 */
@RestController
public class MBlogController {

    @Autowired
    MBlogService blogService;
    @Autowired
    MUserService userService;

//    @RequiresAuthentication
    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") int currentPage){
        Page page = new Page(currentPage, 10);
        IPage pageData = blogService.page(page, new QueryWrapper<MBlog>().orderByDesc("created"));

        return Result.success(pageData);
    }

    @RequiresAuthentication
    @GetMapping("/all")
    public Result allList(){
        Page page = new Page(1, 99999);
        IPage pageData = blogService.page(page, new QueryWrapper<MBlog>().orderByDesc("created"));

        return Result.success(pageData);
    }


    @RequiresAuthentication
    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(name = "id") Long id){
        MBlog blog = blogService.getById(id);
        Assert.notNull(blog, "Target not exist");

        return Result.success(blog);
    }



    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody MBlog blog) {
        MUser admin = userService.getById(1L);
        MBlog temp = null;
        if(admin.getId().longValue() == ShiroUtil.getProfile().getId().longValue()){
            if(blog.getId() != null) {
                temp = blogService.getById(blog.getId());
            } else {
                temp = new MBlog();
                temp.setUserId(ShiroUtil.getProfile().getId());
                temp.setCreated(LocalDateTime.now());
                temp.setStatus(0);
                temp.setType(0);
            }
            BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status", "type");
            blogService.saveOrUpdate(temp);
            return Result.success("操作成功");
        }else{
            return Result.fail("no authorization for visitor");
        }


    }


}
