package com.coison.dao;


import com.coison.model.Members;

import java.util.List;

public interface MembersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Members record);

    int insertSelective(Members record);

    Members selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Members record);

    int updateByPrimaryKey(Members record);

    //查询所有的用户信息
    List<Members> selectAllMembers();
}