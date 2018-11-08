package com.thingtrust.trend.util.ImageUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * <p>png格式验证码</p>
 *
 * @author: wuhongjun
 * @version:1.0
 */
public class SpecCaptcha extends Captcha {
    public SpecCaptcha() {
    }

    public SpecCaptcha(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public SpecCaptcha(final int width, final int height, final int len) {
        this(width, height);
        this.len = len;
    }

    public SpecCaptcha(final int width, final int height, final int len, final Font font) {
        this(width, height, len);
        this.font = font;
    }

    /**
     * 生成验证码
     *
     * @throws IOException IO异常
     */
    @Override
    public void out(final OutputStream out) {
        graphicsImage(alphas(), out);
    }

    /**
     * 画随机码图
     *
     * @param strs 文本
     * @param out  输出流
     */
    private boolean graphicsImage(final char[] strs, final OutputStream out) {
        boolean ok = false;
        try {
            final BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            final Graphics2D g = (Graphics2D) bi.getGraphics();
            AlphaComposite ac3;
            Color color;
            final int len = strs.length;
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
            // 随机画干扰的蛋蛋
            for (int i = 0; i < 15; i++) {
                color = color(150, 250);
                g.setColor(color);
                g.drawOval(Randoms.num(width), Randoms.num(height), 5 + Randoms.num(10), 5 + Randoms.num(10));// 画蛋蛋，有蛋的生活才精彩
                color = null;
            }
            g.setFont(font);
            final int h = height - ((height - font.getSize()) >> 1);
            final int w = width / len;
            final int size = w - font.getSize() + 1;
            /* 画字符串 */
            for (int i = 0; i < len; i++) {
                ac3 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);// 指定透明度
                g.setComposite(ac3);
                color = new Color(20 + Randoms.num(110), 20 + Randoms.num(110), 20 + Randoms.num(110));// 对每个字符都用随机颜色
                g.setColor(color);
                g.drawString(strs[i] + "", (width - (len - i) * w) + size, h - 4);
                color = null;
                ac3 = null;
            }
            ImageIO.write(bi, "png", out);
            out.flush();
            ok = true;
        } catch (final IOException e) {
            ok = false;
        } finally {
            try {
                out.close();
            } catch (final IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ok;
    }
}
