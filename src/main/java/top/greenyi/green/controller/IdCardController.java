package top.greenyi.green.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.greenyi.green.bean.IdCard;
import top.greenyi.green.service.IdCardService;

import java.util.HashMap;

/**
 * @author Green
 */
@Slf4j
@Api(tags = "身份认证")
@RestController
@RequestMapping("/id-card")
public class IdCardController {
    @Autowired
    private IdCardService idCardService;

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
    public IdCard getIdCardInfo(@RequestBody IdCard idCard) {
        HashMap<String, String> hashMap = new HashMap<String, String>(0);
        hashMap.put("cardNo", idCard.getCardNo());
        hashMap.put("name", idCard.getName());
        IdCard dbIdCard = idCardService.getIdCard(hashMap);
        log.info(dbIdCard.toString());
        return dbIdCard;
    }

}
