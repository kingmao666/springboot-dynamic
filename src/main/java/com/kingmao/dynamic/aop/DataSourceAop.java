package com.kingmao.dynamic.aop;

import com.kingmao.dynamic.apple.AppleController;
import com.kingmao.dynamic.config.DBContextHolder;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
/**
 * @author QX
 * @date 2020/4/28
 */

@Aspect
@Component
public class DataSourceAop {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceAop.class);

/*    @Pointcut("!@annotation(com.cjs.example.annotation.Master) " +
            "&& (execution(* com.cjs.example.service..*.select*(..)) " +
            "|| execution(* com.cjs.example.service..*.get*(..)))")

    @Pointcut("(execution(* com.kingmao.dynamic.*.service..*.select*(..)) " +
            "|| execution(* com.kingmao.dynamic.*.service..*.find*(..)) " +
            "|| execution(* com.kingmao.dynamic.*.service..*.get*(..)))")
    public void readPointcut() {

    }*/

    /**
     * 拦截service层数据
     */
/*    @Pointcut("@annotation(com.cjs.example.annotation.Master) " +
            "|| execution(* com.cjs.example.service..*.insert*(..)) " +
            "|| execution(* com.cjs.example.service..*.add*(..)) " +
            "|| execution(* com.cjs.example.service..*.update*(..)) " +
            "|| execution(* com.cjs.example.service..*.edit*(..)) " +
            "|| execution(* com.cjs.example.service..*.delete*(..)) " +
            "|| execution(* com.cjs.example.service..*.remove*(..))")*/
/*@Pointcut("execution(* com.kingmao.dynamic.*.service..*.insert*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.add*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.update*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.edit*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.delete*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.save*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.remove*(..))")
    public void writePointcut() {

    }*/

/*    @Before("readPointcut()")
    public void read() {
        logger.info("拦截到查询数据库操作");
        DBContextHolder.slave1();
    }

    @Before("writePointcut()")
    public void write() {
        logger.info("拦截到插入||更新||删除数据库操作");
        DBContextHolder.master();
    }*/


    @Pointcut("(execution(* com.kingmao.dynamic.apple.dao..*.select*(..)) " +
            "|| execution(* com.kingmao.dynamic.apple.dao..*.find*(..)) " +
            "|| execution(* com.kingmao.dynamic.apple.dao..*.get*(..)))")
    public void readAppleDaoPointcut() {

    }

    @Before("readAppleDaoPointcut()")
    public void appRead() {
        logger.info("拦截到 [dynamic-apple] |select*|find*|get*| 数据库操作");
        DBContextHolder.slaveApple();
    }

    @Pointcut("(execution(* com.kingmao.dynamic.peach.dao..*.select*(..)) " +
            "|| execution(* com.kingmao.dynamic.peach.dao..*.find*(..)) " +
            "|| execution(* com.kingmao.dynamic.peach.dao..*.get*(..)))")
    public void readPeachDaoPointcut() {

    }

    @Before("readPeachDaoPointcut()")
    public void peachRead() {
        logger.info("拦截到 [dynamic-peach] |select*|find*|get*| 数据库操作");
        DBContextHolder.slavePeach();
    }

    @Pointcut("execution(* com.kingmao.dynamic.apple.dao..*.insert*(..)) " +
            "|| execution(* com.kingmao.dynamic.apple.dao..*.add*(..)) " +
            "|| execution(* com.kingmao.dynamic.apple.dao..*.update*(..)) " +
            "|| execution(* com.kingmao.dynamic.apple.dao..*.edit*(..)) " +
            "|| execution(* com.kingmao.dynamic.apple.dao..*.delete*(..)) " +
            "|| execution(* com.kingmao.dynamic.apple.dao..*.save*(..)) " +
            "|| execution(* com.kingmao.dynamic.apple.dao..*.remove*(..))")
    public void writeApplePointcut() {

    }

    @Before("writeApplePointcut()")
    public void appleWrite() {
        logger.info("拦截到 [dynamic-apple] |insert*|add*|update*|edit*|delete*|save*|remove*| 数据库操作");
        DBContextHolder.masterApple();
    }

    @Pointcut("execution(* com.kingmao.dynamic.peach.dao..*.insert*(..)) " +
            "|| execution(* com.kingmao.dynamic.peach.dao..*.add*(..)) " +
            "|| execution(* com.kingmao.dynamic.peach.dao..*.update*(..)) " +
            "|| execution(* com.kingmao.dynamic.peach.dao..*.edit*(..)) " +
            "|| execution(* com.kingmao.dynamic.peach.dao..*.delete*(..)) " +
            "|| execution(* com.kingmao.dynamic.peach.dao..*.save*(..)) " +
            "|| execution(* com.kingmao.dynamic.peach.dao..*.remove*(..))")
    public void writePeachPointcut() {

    }

    @Before("writePeachPointcut()")
    public void peachWrite() {
        logger.info("拦截到 [dynamic-peach] |insert*|add*|update*|edit*|delete*|save*|remove*| 数据库操作");
        DBContextHolder.masterPeach();
    }




    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.kingmao.dynamic.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
