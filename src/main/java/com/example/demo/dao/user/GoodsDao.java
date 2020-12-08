package com.example.demo.dao.user;

import com.example.demo.domain.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author mayongbo
 * @Description
 * @date 2020/12/7 14:33
 */
@Mapper
public interface GoodsDao {


    @Insert("INSERT INTO `goods` (`gname`, `user_id`, `gstatus`) VALUES (#{gname}, #{userId}, #{gstatus})")
    int insert(Goods goods);

    @Select("SELECT * from `goods`  where gid = #{gid} and uu_id = #{uuId}")
    Goods getById(@Param("gid") Long gid, @Param("uuId") Long uuId);

    @Select("SELECT * from `goods`  where uu_id = #{uuId}")
    Goods getByUuId( @Param("uuId") Long uuId);
}
