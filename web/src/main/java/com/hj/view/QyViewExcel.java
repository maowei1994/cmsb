package com.hj.view;

import com.hj.client.object.list.QyPwBasicInfo;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/4  13:59
 */
public class QyViewExcel extends AbstractExcelView {

    List<QyPwBasicInfo> ypPwBasicInfos;

    public QyViewExcel(List<QyPwBasicInfo> pwBasicInfoList) {
        this.ypPwBasicInfos = pwBasicInfoList;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HSSFSheet sheet = workbook.createSheet("qypwInfo");
        sheet.setDefaultColumnWidth((short) 15);
        HSSFCell cell = getCell(sheet, 0, 0);
        setText(cell, "��ҵ�����б�����");
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        cell = getCell(sheet, 1, 0);
        cell.setCellValue("����ʱ�䣺"+new Date());
        //cell.setCellStyle(dateStyle);

        getCell(sheet, 2, 0).setCellValue("��׼�ĺ�");
        getCell(sheet, 2, 1).setCellValue("��Ʒ����");
        getCell(sheet, 2, 3).setCellValue("��Ʒ��");
        getCell(sheet, 2, 4).setCellValue("ҩƷ��");

        int size=ypPwBasicInfos.size();

        for(int i=0;i<size;i++){
            HSSFRow sheetRow = sheet.createRow(i+3);
            QyPwBasicInfo info=ypPwBasicInfos.get(i);
            sheetRow.createCell(0).setCellValue(info.getPzwh());
            sheetRow.createCell(1).setCellValue(info.getCpmc());
            sheetRow.createCell(2).setCellValue(info.getSpm());
            sheetRow.createCell(3).setCellValue(info.getYpm());
        }
        long time=System.currentTimeMillis();
        String filename = time+".xls";//��������ʱ�ͻ���Excel������

        /**
         * ��ȡ�ͻ���������Ͳ���ϵͳ��Ϣ
         * ��IE������еõ����ǣ�User-Agent=Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; Alexa Toolbar)
         * ��Firefox�еõ����ǣ�User-Agent=Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.7.10) Gecko/20050717 Firefox/1.0.6
         */
//        String agent = request.getHeader("USER-AGENT");
//        filename = YPUtil.encodeFilename(filename, agent);//���������ļ���
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + filename);
        OutputStream ouputStream = response.getOutputStream();
        workbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }
}
