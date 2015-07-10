package com.hj.mvc;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2014/10/26  1:10
 */
public class MyExceptionHandler implements HandlerExceptionResolver {


    @ResponseBody
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {

        // ���ݲ�ͬ����ת��ͬҳ��
        if(ex instanceof NullPointerException) {
            return new ModelAndView("error-business", null);
        }else if(ex instanceof RuntimeException) {
            return new ModelAndView("error-parameter", null);
        } else {
            return new ModelAndView("error", null);
        }
    }
}

