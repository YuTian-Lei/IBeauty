package cn.IBeauty.service;
import java.util.List;

import cn.IBeauty.po.UserEntity;
import cn.IBeauty.core.Service;



/**
 *
 * @author CodeGenerator
 * @date 2019/11/22
 */
public interface UserEntityService extends Service<UserEntity> {
	public  List<UserEntity>  selectListByName(String name);
}
