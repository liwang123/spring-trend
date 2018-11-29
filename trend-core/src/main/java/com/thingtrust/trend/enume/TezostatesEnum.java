package com.thingtrust.trend.enume;

/**
 * @author zhuxl
 * CreateTime: 17/12/26
 */
public enum TezostatesEnum {
    ESTIMATED(1, "Estimated"),
    ROASTING(2, "Roasting"),
    PAYING(3, "Paying"),
    PAIED(4, "Paied"),
    FROZEN(5, "Frozen"),
    FAILURE(6, "Failure");

    private int code;
    protected String msg;

    private TezostatesEnum(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String msg(final int code) {
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public String appendMsg(final String msg) {
        return getMsg() + ":" + msg;
    }

    public static String getTezos(final int code) {
        for (final TezostatesEnum c : TezostatesEnum.values()) {
            if (c.getCode() == code) {
                return c.getMsg();
            }
        }
        return null;
    }

}
