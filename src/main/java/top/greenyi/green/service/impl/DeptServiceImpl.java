package top.greenyi.green.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.stereotype.Service;
import top.greenyi.green.bean.Dept;
import top.greenyi.green.mapper.DeptMapper;
import top.greenyi.green.service.IDeptService;

import java.util.Date;

/**
 * @author Green
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Override
    public boolean save(Dept entity) {
        entity.setCreateTime(new Date());
        return SqlHelper.retBool(this.getBaseMapper().insert(entity));
    }

    @Override
    public boolean updateById(Dept entity) {
        entity.setUpdateTime(new Date());
        return SqlHelper.retBool(this.getBaseMapper().updateById(entity));
    }

}
