package com.liruilong.demo.service;

import com.liruilong.demo.mapper.HrMapper;
import com.liruilong.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2020/5/2 18:36
 */
@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;


    public List<Hr> getAllHrs(Authentication authentication) {
        Hr hr = (Hr) authentication.getPrincipal();
        return hrMapper.selectAllHrs(hr.getUsername());
    }

    public Integer addHr(Hr hr) {
        return hrMapper.insertSelective(hr);
    }

    public Integer deleteHrByEid(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKey(hr);
    }



    public Hr getUserfase(String username) {
        Hr hr = new Hr();
        hr.setUsername(username);
        return hrMapper.selectOne(hr);
    }
    public Hr getHr(String name) {
        Hr hr = new Hr();
        hr.setName(name);
        hr.setEnabled(null);
        return hrMapper.selectOne(hr);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = new Hr();
        hr.setUsername(username);
        hr = hrMapper.selectOne(hr);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return hr;
    }
}
