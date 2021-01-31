package top.greenyi.green.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.greenyi.green.bean.Dept;
import top.greenyi.green.repository.DeptRepository;
import top.greenyi.green.service.DeptService;

import java.util.Date;
import java.util.List;

/**
 * @author Green
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public void insert(Dept dept){
        dept.setCreateTime(new Date());
        deptRepository.insert(dept);
    }

    @Override
    public void delete(Long id){
        deptRepository.delete(id);
    }

    @Override
    public Long update(Dept dept){
        dept.setUpdateTime(new Date());
        return deptRepository.update(dept);
    }

    @Override
    public Dept get(Long id){
        return deptRepository.get(id);
    }

    @Override
    public List<Dept> getAll(){
        return deptRepository.getAll();
    }

}
