package com.shuke.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shuke.my.shop.commons.persistence.BaseEntity;
import com.shuke.my.shop.commons.utils.RegexUtils;
import com.shuke.my.shop.commons.utils.RegexUtils_2;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
public class TbUser extends BaseEntity {

    @Length(min = 6, max = 20, message = "用户名长度必须介于 6 和 20 之间")
    private String username;
    @JsonIgnore
    @Length(min = 6, max = 20, message = "密码长度必须介于 6 和 20 之间")
    private String password;
    @Pattern(regexp = RegexUtils_2.PHONE,message = "手机号格式不正确")
    private String phone;
    @Pattern(regexp = RegexUtils_2.EMAIL,message = "邮箱格式不正确")
    private String email;
}
