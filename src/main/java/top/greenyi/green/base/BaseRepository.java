package top.greenyi.green.base;

import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Green
 */
@Repository
public interface BaseRepository<T> {

    /**
     * 添加
     * @param t
     */
    void insert(T t);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id修改
     * @param t
     * @return
     */
    Long update(T t);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    T get(Long id);

    /**
     * 获取所有
     * @return
     */
    List<T> getAll();

}
