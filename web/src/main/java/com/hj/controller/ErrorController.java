package com.hj.controller;

import com.hj.biz.Result;
import com.hj.biz.error.ErrorCode;
import com.hj.biz.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2014/10/26  1:28
 */
@Controller
public class ErrorController {

    Logger logger= LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping(value="/error",produces = "application/json")
    @ResponseBody
    public Result<?> error(){
        //���ַ�����Ҫ�ı׶����޷���ȡ������쳣��Ϣ
        return ResultUtil.forkFailResult(ErrorCode.SYSTEM_ERROR);
    }

    /** ����@ExceptionHandler�쳣���� */
    @ExceptionHandler({Exception.class})
    public Result<?> exp(HttpServletRequest request, Exception ex) {

        logger.error("\n system error: \n",ex);
        /**
         * ������ʵ���Ը��ݲ�ͬ�Ĵ�������ͬ�Ĵ����
         */
        return ResultUtil.forkFailResult(ErrorCode.SYSTEM_ERROR);
    }
}

