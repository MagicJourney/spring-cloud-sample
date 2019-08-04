package com.tanner.user.dto;

import com.tanner.user.entity.UserDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value = "用户DTO")
public class UserDTO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "用户服务端口")
    private int userServicePort;

    public UserDTO(UserDO userDO, int serverPort) {
        this.id = userDO.getId();
        this.nickname = userDO.getNickname();
        this.avatar = userDO.getAvatar();
        this.userServicePort = serverPort;
    }
}
