package top.greenyi.green.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.greenyi.green.bean.IdCard;
import top.greenyi.green.common.api.IdCardApi;
import top.greenyi.green.mapper.IdCardMapper;
import top.greenyi.green.service.IIdCardService;

/**
 * @author Green
 */
@Service
public class IdCardServiceImpl extends ServiceImpl<IdCardMapper, IdCard> implements IIdCardService {

    @Autowired
    private IdCardApi idCardApi;

    @Override
    public IdCard getIdCard(String cardNo, String name) {
        return idCardApi.getIdCard(cardNo, name);
    }

}
