package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mayongbo
 * @Description
 * @date 2020/12/7 14:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private Long gid;
    private String gname;
    private Long uuId;
    private Integer gstatus;
}
