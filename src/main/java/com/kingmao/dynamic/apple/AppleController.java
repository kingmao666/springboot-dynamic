package com.kingmao.dynamic.apple;

import com.kingmao.dynamic.apple.entity.Apple;
import com.kingmao.dynamic.apple.service.AppleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author QX
 * @date 2020/4/29
 */
@RestController
public class AppleController {
    @Autowired
    private AppleService appleService;

    private static final Logger logger = LoggerFactory.getLogger(AppleController.class);

    @GetMapping("/getAll")
    public List<Apple> getAllApple(){
        logger.info("进入到getAllApple");
        return appleService.getAll();
    }
}
