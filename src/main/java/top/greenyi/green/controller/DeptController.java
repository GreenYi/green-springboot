package top.greenyi.green.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.greenyi.green.bean.Dept;
import top.greenyi.green.common.constants.LogConstants;
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
    public Dept insert(@RequestBody Dept dept) {
        log.info(LogConstants.METHODS, "insert");
        deptService.insert(dept);
        log.info("insert: {}", dept);
        return dept;
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
    public Dept delete(@PathVariable Long id) {
        log.info(LogConstants.METHODS, "delete");
        Dept dept = deptService.get(id);
        deptService.delete(id);
        log.info("delete: {}", dept);
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
    public Dept update(@PathVariable Long id, @RequestBody Dept dept) {
        log.info(LogConstants.METHODS, "update");
        deptService.update(dept);
        Dept updatedDept = deptService.get(dept.getId());
        log.info("update: {}", updatedDept);
        return updatedDept;
    }

    /**
     * 获取所有部门
     * @return
     */
    @ApiOperation(value = "获取所有部门", httpMethod = "GET")
    @GetMapping("/list")
    public List<Dept> getAll() {
        log.info(LogConstants.METHODS, "getAll");
        List<Dept> list = deptService.getAll();
        log.info("getAll: {}", list);
        return list;
    }

}
