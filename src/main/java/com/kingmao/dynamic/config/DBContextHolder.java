package com.kingmao.dynamic.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author QX
 * @date 2020/4/28
 */
public class DBContextHolder {
    private static final Logger logger = LoggerFactory.getLogger(DBContextHolder.class);

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter_apple = new AtomicInteger(-1);
    private static final AtomicInteger counter_peach = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void masterApple() {
        set(DBTypeEnum.MASTER_APPLE);
        logger.info("切换到master写库 dynamic_apple");
    }

    public static void masterPeach() {
        set(DBTypeEnum.MASTER_PEACH);
        logger.info("切换到master写库 dynamic_peach");
    }

    public static void slaveApple() {
        //  轮询
        int index = counter_apple.getAndIncrement() % 2;
        if (counter_apple.get() > 9999) {
            counter_apple.set(-1);
        }
        if (index == 0) {
            set(DBTypeEnum.SLAVE1_APPLE);
            logger.info("切换到slave1读库 dynamic_apple");
        }else {
            set(DBTypeEnum.SLAVE2_APPLE);
            logger.info("切换到slave2读库 dynamic_apple");
        }
    }

    public static void slavePeach() {
        //  轮询
        int index = counter_peach.getAndIncrement() % 2;
        if (counter_peach.get() > 9999) {
            counter_peach.set(-1);
        }
        if (index == 0) {
            set(DBTypeEnum.SLAVE1_PEACH);
            logger.info("切换到slave1读库 dynamic_peach");
        }else {
            set(DBTypeEnum.SALVE2_PEACH);
            logger.info("切换到slave2读库 dynamic_peach");
        }
    }
}
