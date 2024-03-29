package com.group42.utils.reverse;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import org.junit.Test;

/**
 * MySQL reverse engineering
 *
 * @author Guofeng Lin
 * @since 3.5.3
 */
public class MySQLGeneratorTest extends BaseGeneratorTest {

    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
        .Builder("jdbc:mysql://localhost:3306/smart_diet", "root", "Y38GnG9LXt0jp26B")
        .build();

    @Test
    public void testSimple() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
//        generator.strategy(strategyConfig().build());
        generator.global(globalConfig().outputDir("src/test/java").author("Guofeng Lin").build());
        generator.packageInfo(packageConfig().parent("com.group42").mapper("dao").build());
        generator.strategy(strategyConfig().addInclude("user_target").build());
        generator.execute();
    }
}
