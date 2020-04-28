package com.kingmao.dynamic.config;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
/**
 * @author QX
 * @date 2020/4/28
 */

@Aspect
@Component
public class DataSourceAop {

/*    @Pointcut("!@annotation(com.cjs.example.annotation.Master) " +
            "&& (execution(* com.cjs.example.service..*.select*(..)) " +
            "|| execution(* com.cjs.example.service..*.get*(..)))")*/

    @Pointcut("(execution(* com.kingmao.dynamic.*.service..*.select*(..)) " +
            "|| execution(* com.kingmao.dynamic.*.service..*.get*(..)))")
    public void readPointcut() {

    }

/*    @Pointcut("@annotation(com.cjs.example.annotation.Master) " +
            "|| execution(* com.cjs.example.service..*.insert*(..)) " +
            "|| execution(* com.cjs.example.service..*.add*(..)) " +
            "|| execution(* com.cjs.example.service..*.update*(..)) " +
            "|| execution(* com.cjs.example.service..*.edit*(..)) " +
            "|| execution(* com.cjs.example.service..*.delete*(..)) " +
            "|| execution(* com.cjs.example.service..*.remove*(..))")*/
@Pointcut("execution(* com.kingmao.dynamic.*.service..*.insert*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.add*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.update*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.edit*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.delete*(..)) " +
        "|| execution(* com.kingmao.dynamic.*.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
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
