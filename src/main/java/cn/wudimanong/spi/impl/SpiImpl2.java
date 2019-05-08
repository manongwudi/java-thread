package cn.wudimanong.spi.impl;

import cn.wudimanong.spi.SPIService;

/**
 * @author joe
 */
public class SpiImpl2 implements SPIService {
    @Override
    public void execute() {
        System.out.println("SpiImpl2 Hello.");
    }
}
