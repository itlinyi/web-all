package com.itlinyi.schedule.pojo;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author 林一
 * @version 1.0
 */
/*
 * 使用lombok帮助我们生成这些内容getter setter 全参构造 无参构造 equals hashcode
 *  使用步骤
 * 1.检查idea是否已经安装了lombok插件
 * 2.检查是否勾选了enable annotation processer
 * 3.导入lombok的依赖
 * 4.在实体类上添加注解
 * */
@AllArgsConstructor//添加了全参构造
@NoArgsConstructor//添加了无参构造
@Data //getter setter equals hashcode toString
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;


}
