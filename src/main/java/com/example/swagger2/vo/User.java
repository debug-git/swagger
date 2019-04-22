package com.example.swagger2.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "用户基本信息")
public class User {
    @ApiModelProperty(value = "姓名")
    @NotNull(message = "姓名不能为空")
    @Size(min = 2, message = "姓名至少两个字符")
    private String name;

    @ApiModelProperty(value = "年龄")
    @Max(value = 500, message = "年龄不能大于500")
    @Min(value = 0, message = "年龄不能小于0岁")
    private Integer age;

//    @JsonIgnore
//    private String some;
}
