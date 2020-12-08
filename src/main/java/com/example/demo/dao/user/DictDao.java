package com.example.demo.dao.user;

import com.example.demo.domain.MyDict;
import org.apache.ibatis.annotations.*;

/**
 * @author mayongbo
 * @Description
 * @date 2020/12/7 14:33
 */
@Mapper
public interface DictDao {


    @Insert("INSERT INTO `t_dict` (`dict_name`, `dict_code`) VALUES (#{dictName}, #{dictCode})")
    int insert(MyDict dict);

    @Select("SELECT * from `t_dict`  where dict_id = #{dictId}")
    MyDict getByDictId(@Param("dictId") Long dictId);

    @Delete("delete from `t_dict`  where dict_id = #{dictId}")
    int deleteByDictId(@Param("dictId") Long dictId);


}
