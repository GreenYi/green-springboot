package top.greenyi.green.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.greenyi.green.bean.SysUser;
import top.greenyi.green.common.response.BaseResponse;
import top.greenyi.green.common.response.ResponseCode;
import top.greenyi.green.common.response.ResponseResult;
import top.greenyi.green.service.ISysUserService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Green
 * @since 2021-03-17
 */
@Slf4j
@Api(tags = "用户管理")
@BaseResponse
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 获取所有用户
     * @return 统一的公共响应体
     */
    @ApiOperation(value = "获取所有用户", httpMethod = "GET")
    @GetMapping("/list")
    public ResponseResult getAll() {
        List<SysUser> list = sysUserService.list();
        return new ResponseResult(ResponseCode.SUCCESS_GET, list);
    }
}
