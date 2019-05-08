package cn.wudimanong.spi;


import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author joe
 */
public class SPIMain {
    public static void main(String[] args) {

        ServiceLoader<SPIService> loaders =
                ServiceLoader.load(SPIService.class);

        Iterator<SPIService> spiServiceIterator = loaders.iterator();
        System.out.println("classPath:" + System.getProperty("java.class.path"));
        while (spiServiceIterator.hasNext()) {
            SPIService spiService = spiServiceIterator.next();
            System.out.println(spiService.execute());
        }
    }
}
