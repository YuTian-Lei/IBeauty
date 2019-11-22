package cn.IBeauty.service.impl;

import java.util.List;

import cn.IBeauty.dao.UserEntityMapper;
import cn.IBeauty.po.UserEntity;
import cn.IBeauty.service.UserEntityService;
import cn.IBeauty.core.AbstractService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;



/**
 *
 * @author CodeGenerator
 * @date 2019/11/22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserEntityServiceImpl extends AbstractService<UserEntity> implements UserEntityService {
    @Resource
    private UserEntityMapper userEntityMapper;

    public  List<UserEntity>  selectListByName(String name){
    	Example example = new Example(UserEntity.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("nickname", name);
		return userEntityMapper.selectByExample(example);
    }
}
