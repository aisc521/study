package com.it.cs.excel.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Author cuishuai
 * @Date 2019/12/23 16:49
 */
@Data
public class WorkSheetDetail {
    //工作内容
    private String workCtx;
    // 用工人总数    工日数 = gwnNum+tmnNum
    private Float totalHumanDays;
    //普工用工数 1-4小时为半天，4-8小时为一天;120每天
    private Integer gwnNum;
    //技工用工数 1-4小时为半天，4-8小时为一天；160每天
    private Integer tmnNum;
    // 单价（元）
    private Float unitPrice;
    // 金额(元） = gwnNum*120+tmnNum+160
    private Float unitAmount;
    // 备注
    private String notes;

    public WorkSheetDetail(String workCtx, Float totalHumanDays, Integer gwnNum, Integer tmnNum, Float unitPrice,
                           Float unitAmount, String notes) {
        super();
        this.workCtx = workCtx;
        this.totalHumanDays = totalHumanDays;
        this.gwnNum = gwnNum;
        this.tmnNum = tmnNum;
        this.unitPrice = unitPrice;
        this.unitAmount = unitAmount;
        this.notes = notes;
    }
}
