package top.greenyi.green.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.greenyi.green.bean.IdCard;
import top.greenyi.green.common.response.BaseResponse;
import top.greenyi.green.common.response.ResponseCode;
import top.greenyi.green.common.response.ResponseResult;
import top.greenyi.green.service.IIdCardService;

/**
 * @author Green
 */
@Slf4j
@Api(tags = "身份认证")
@BaseResponse
@RestController
@RequestMapping("/id-card")
public class IdCardController {
    @Autowired
    private IIdCardService idCardService;

    /**
     * 身份认证
     * @param idCard
     * @return
     */
    @ApiOperation(value = "身份认证", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idCard", value = "身份证信息", dataType = "IdCard", dataTypeClass = IdCard.class, paramType = "body", required = true),
    })
    @PostMapping("/id-card")
    public ResponseResult getIdCard(@RequestBody IdCard idCard) {
        IdCard responseIdCard = idCardService.getIdCard(idCard.getCardNo(), idCard.getName());
        Integer responseCode = idCardService.getResponseCode();
        if (responseCode.equals(HttpStatus.SC_OK)){
            return new ResponseResult(ResponseCode.SUCCESS_GET, responseIdCard);
        } else if (responseCode.equals(HttpStatus.SC_FORBIDDEN)) {
            return new ResponseResult(ResponseCode.RESOURCES_FORBIDDEN, null);
        }
        // Test
        return new ResponseResult(ResponseCode.SERVICE_ERROR, null);
    }

}
