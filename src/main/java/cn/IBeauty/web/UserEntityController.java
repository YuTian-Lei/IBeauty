package cn.IBeauty.web;

import cn.IBeauty.core.Result;
import cn.IBeauty.core.ResultGenerator;
import cn.IBeauty.po.UserEntity;
import cn.IBeauty.service.UserEntityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author CodeGenerator
 * @date 2019/11/22
 */
@RestController
@RequestMapping("/user/entity")
public class UserEntityController {
    @Resource
    private UserEntityService userEntityService;

    @PostMapping
    public Result add(@RequestBody UserEntity userEntity) {
        userEntityService.save(userEntity);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        userEntityService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserEntity userEntity) {
        userEntityService.update(userEntity);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        UserEntity userEntity = userEntityService.findById(id);
        return ResultGenerator.genSuccessResult(userEntity);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserEntity> list = userEntityService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
