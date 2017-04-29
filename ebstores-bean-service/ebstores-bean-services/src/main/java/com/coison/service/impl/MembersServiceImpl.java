package com.coison.service.impl;

import com.coison.dao.MembersMapper;
import com.coison.model.Members;
import com.coison.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/29.
 */
@Service("membersService")
public class MembersServiceImpl implements MembersService {

    @Autowired
    MembersMapper memberMapper;

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return false;
    }

    @Override
    public boolean insert(Members record) {
        return false;
    }

    @Override
    public boolean insertSelective(Members record) {
        return false;
    }

    @Override
    public Members selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public boolean updateByPrimaryKeySelective(Members record) {
        return false;
    }

    @Override
    public boolean updateByPrimaryKey(Members record) {
        return false;
    }

    @Override
    public List<Members> selectAllMembers() {
        return memberMapper.selectAllMembers();
    }
}
