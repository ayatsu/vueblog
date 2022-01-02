package com.mmjj.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mmjj.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {

    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

}