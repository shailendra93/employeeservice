package com.paypal.bfs.test.model.bo;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateEmployeeResponseBo {

    private Integer code;
    private String status;
    private String employeeId;
    private String message;
}
