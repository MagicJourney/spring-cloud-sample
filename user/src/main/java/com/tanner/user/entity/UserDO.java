package com.tanner.user.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-15
 */
@Entity
@Table(name = "tb_user")
@Data
@ToString
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "avatar")
    private String avatar;
}
