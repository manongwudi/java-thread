package cn.wudimanong.spi.impl;

import cn.wudimanong.spi.SPIService;

/**
 * @author joe
 */
public class SpiImpl1 implements SPIService {
    @Override
    public void execute() {
        System.out.println("SpiImpl1 Hello.");
    }
}
