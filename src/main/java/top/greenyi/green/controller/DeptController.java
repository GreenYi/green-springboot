package top.greenyi.green.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.greenyi.green.base.BaseResponse;
import top.greenyi.green.bean.Dept;
import top.greenyi.green.common.response.ResponseCode;
import top.greenyi.green.common.response.ResponseResult;
import top.greenyi.green.service.DeptService;

import java.util.List;

/**
 * @author Green
 */

@Slf4j
@Api(tags = "部门管理")
@BaseResponse
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
    public ResponseResult insert(@RequestBody Dept dept) {
        deptService.insert(dept);
        return new ResponseResult(ResponseCode.SUCCESS_INSERT, dept);
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
    public ResponseResult delete(@PathVariable Long id) {
        Dept dept = deptService.get(id);
        deptService.delete(id);
        return new ResponseResult(ResponseCode.SUCCESS_DELETE, dept);
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
    public ResponseResult update(@PathVariable Long id, @RequestBody Dept dept) {
        dept.setId(id);
        deptService.update(dept);
        Dept updatedDept = deptService.get(id);
        return new ResponseResult(ResponseCode.SUCCESS_UPDATE, updatedDept);
    }

    /**
     * 获取部门信息
     * @return
     */
    @ApiOperation(value = "获取部门信息", httpMethod = "GET")
    @GetMapping("/{id}")
    public ResponseResult get(@PathVariable Long id) {
        Dept dept = deptService.get(id);
        return new ResponseResult(ResponseCode.SUCCESS_GET, dept);
    }

    /**
     * 获取所有部门
     *
     * @return
     */
    @ApiOperation(value = "获取所有部门", httpMethod = "GET")
    @GetMapping("/list")
    public ResponseResult getAll() {
        List<Dept> list = deptService.getAll();
        return new ResponseResult(ResponseCode.SUCCESS_GET, list);
    }

}
