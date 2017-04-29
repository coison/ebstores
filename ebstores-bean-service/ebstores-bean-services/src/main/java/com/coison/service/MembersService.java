package com.coison.service;

import com.coison.model.Members;

import java.util.List;

/**
 * Created by Administrator on 2017/4/29.
 */
public interface MembersService {

    boolean deleteByPrimaryKey(Long id);

    boolean insert(Members record);

    boolean insertSelective(Members record);

    Members selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Members record);

    boolean updateByPrimaryKey(Members record);

    //查询所有的用户信息
    List<Members> selectAllMembers();
}
