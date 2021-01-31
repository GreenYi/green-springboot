package top.greenyi.green.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.greenyi.green.bean.Dept;
import top.greenyi.green.service.DeptService;

import java.util.List;

/**
 * @author Green
 */
@Slf4j
@Api(tags = "部门管理")
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 添加部门信息
     * @param dept
     * @return
     */
    @ApiOperation(value = "添加部门信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dept", value = "部门信息", dataType = "Dept",dataTypeClass = Dept.class,paramType = "body",required = true)
    })
    @PostMapping("/depts")
    public Dept addDept(@RequestBody Dept dept) {
        log.info("addDept");
        deptService.insert(dept);
        log.info(dept.toString());
        return dept;
    }

    /**
     * 获取所有部门
     * @return
     */
    @ApiOperation(value = "获取所有部门", httpMethod = "GET")
    @GetMapping("/list")
    public List<Dept> getAll() {
        log.info("getAll");
        log.info(deptService.getAll().toString());
        return deptService.getAll();
    }

    /**
     * 删除部门信息
     * @param id
     * @return
     */
    @ApiOperation(value = "删除部门信息", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的id", paramType = "path")
    })
    @DeleteMapping("/{id}")
    public Dept removeDept(@PathVariable Long id) {
        log.info("removeDept");
        Dept dept = deptService.get(id);
        deptService.delete(id);
        log.info(dept.toString());
        return dept;
    }

    /**
     * 修改部门信息
     * @param id
     * @param dept
     * @return
     */
    @ApiOperation(value = "修改部门信息", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dept", value = "部门信息",dataType = "Dept",dataTypeClass = Dept.class,paramType = "body",required = true),
            @ApiImplicitParam(name = "id", value = "修改的id", paramType = "path")
    })
    @PutMapping("/{id}")
    public Dept updateDept(@PathVariable Long id, @RequestBody Dept dept) {
        log.info("updateDept");
        deptService.update(dept);
        return deptService.get(dept.getId());
    }


}
