package com.liruilong.demo.mapper;



import com.liruilong.model.Hr;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2020/5/2 18:24
 */
@Component
public interface HrMapper extends Mapper<Hr> {

    @Select("SELECT id,name,phone,telephone,address,enabled,username,password,userface,remark FROM hr  WHERE username != #{username}")
    List<Hr> selectAllHrs( String username );
}
