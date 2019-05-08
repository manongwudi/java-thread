package cn.wudimanong.spi.impl;

import cn.wudimanong.spi.SPIService;

/**
 * @author joe
 */
public class SpiImpl1 implements SPIService {
    @Override
    public String execute() {
        return "SpiImpl1 Hello.";
    }
}
