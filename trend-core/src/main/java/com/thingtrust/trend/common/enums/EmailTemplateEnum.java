package com.thingtrust.trend.common.enums;

import lombok.Getter;

/**
 * @author WangYu
 */

@Getter
public enum EmailTemplateEnum {
    /**
     * 发行资产成功
     */
    ISSUE_ASSET_SUCCESS_MAIL(1, "TrustNote email", "emailTemplate1");


    /**
     * 邮件类型
     */
    private final int type;
    /**
     * 邮件主题
     */
    private final String subject;

    /**
     * 邮件模板名称
     */
    private final String templateName;

    EmailTemplateEnum(final int type, final String subject, final String templateName) {
        this.type = type;
        this.subject = subject;
        this.templateName = templateName;
    }
}
