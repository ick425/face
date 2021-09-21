package tax;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 稿酬所得
 */
@Data
public class Gcsd {

    /**
     * 姓名
     */
    private String xm;

    /**
     * 证照类型
     */
    private String zzlx;

    /**
     * 证照号码
     */
    private String zzhm;

    /**
     * 任职受雇日期
     */
    private String rzsgrq;

    /**
     * 当期收入额
     */
    private BigDecimal sre;

    /**
     * 当期免税收入
     */
    private BigDecimal mssd;

    /**
     * 其他
     */
    private BigDecimal qt;

    /**
     * 准予扣除的捐赠额
     */
    private BigDecimal zykcjze;

    /**
     * 减免税额
     */
    private BigDecimal jmse;

    /**
     * 备注
     */
    private String bz;

    /**
     * 所得项目名称
     */
    private String sdxm;

}