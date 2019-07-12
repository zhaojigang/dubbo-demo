package io.study.dubbo.spi.adaptive.manual;

import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * 手动编写 SPI 适配类
 * 注意：适配类也需要在配置文件中进行配置
 */
@Adaptive
public class AdaptiveLog implements Log {
    private static final ExtensionLoader<Log> loader = ExtensionLoader.getExtensionLoader(Log.class);

    @Override
    public void execute(String name) {
        Log log = null;
        if (name == null || name.length() == 0) {
            log = loader.getDefaultExtension();
        } else {
            log = loader.getExtension(name);
        }
        if (log != null) {
            log.execute(name);
        }
    }
}
