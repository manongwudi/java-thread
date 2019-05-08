package cn.wudimanong.spi;


import java.util.ServiceLoader;

/**
 * @author joe
 */
public class SPIMain {
    public static void main(String[] args) {

        ServiceLoader<SPIService> loaders =
                ServiceLoader.load(SPIService.class);

        for (SPIService in : loaders) {
            in.execute();
        }
    }
}
