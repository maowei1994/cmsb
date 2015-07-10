package com.hj.mvc;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.Map;
import java.util.logging.Logger;


/**
 * @author tinglang (editice@gmail.com)
 * @since 2014/9/25  22:13
 */
public class MyInterceptor implements HandlerInterceptor {

    private static final Logger log = Logger.getLogger("interCeptor");

    public MyInterceptor() {
        // TODO Auto-generated constructor stub
    }

    private String mappingURL;//��������ӳ�䵽��Ҫ���ص�·��

    public void setMappingURL(String mappingURL) {
        this.mappingURL = mappingURL;
    }

    /**
     * ��ҵ��������������֮ǰ������
     * �������false
     * �ӵ�ǰ������������ִ��������������afterCompletion(),���˳���������
     *
     * �������true
     * ִ����һ��������,ֱ�����е���������ִ�����
     * ��ִ�б����ص�Controller
     * Ȼ�������������,
     * �����һ������������ִ�����е�postHandle()
     * �����ٴ����һ������������ִ�����е�afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // TODO Auto-generated method stub
        log.info("==============ִ��˳��: 1��preHandle================");
        request.setCharacterEncoding("utf-8");
//        if(mappingURL==null || url.matches(mappingURL)){
//            request.getRequestDispatcher("/msg.jsp").forward(request, response);
//            return false;
//        }
        attribute(request);
        return true;
    }

    private void attribute(HttpServletRequest request) throws Exception{
        String queryString=request.getQueryString();
        if (StringUtils.isBlank(queryString)) {
            return ;
        }
        String[] rr = queryString.split("&");
        for (String r : rr) {
            String[] tmp = r.split("=");
            if (tmp.length == 2) {
                request.setAttribute(tmp[0],URLDecoder.decode(tmp[1], "utf-8"));
            }
            else {
                request.setAttribute(tmp[0], "");
            }
        }
    }



    //��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ�еĶ���
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        log.info("==============ִ��˳��: 2��postHandle================");
    }

    /**
     * ��DispatcherServlet��ȫ����������󱻵���
     *
     * �����������׳��쳣ʱ,��ӵ�ǰ����������ִ�����е���������afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        log.info("==============ִ��˳��: 3��afterCompletion================");
    }

}

