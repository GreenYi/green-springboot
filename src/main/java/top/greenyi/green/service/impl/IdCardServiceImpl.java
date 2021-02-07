package top.greenyi.green.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.greenyi.green.bean.IdCard;
import top.greenyi.green.common.api.IdCardApi;
import top.greenyi.green.service.IdCardService;

import java.util.List;

/**
 * @author Green
 */
@Service
public class IdCardServiceImpl implements IdCardService {

    @Autowired
    private IdCardApi idCardApi;

    @Override
    public IdCard getIdCard(String cardNo, String name) {
        return idCardApi.getIdCard(cardNo, name);
    }

    @Override
    public void insert(IdCard idCard) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Long update(IdCard idCard) {
        return null;
    }

    @Override
    public IdCard get(Long id) {
        return null;
    }

    @Override
    public List<IdCard> getAll() {
        return null;
    }
}
