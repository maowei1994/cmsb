package com.hj.view;

import com.hj.client.object.list.YpPwBasicInfo;
import com.hj.dal.domain.dataobject.SfdaQxDO;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.hj.biz.util.DateUtil.parseDate;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/4  13:59
 */
public class QxViewExcel extends AbstractExcelView {

    List<SfdaQxDO> qxInfos;

    public QxViewExcel(List<SfdaQxDO> qxInfos) {
        this.qxInfos = qxInfos;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HSSFSheet sheet = workbook.createSheet("qxInfo");
        sheet.setDefaultColumnWidth((short) 15);
        HSSFCell cell = getCell(sheet, 0, 0);
        setText(cell, "��е������Ϣ�б�");
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        cell = getCell(sheet, 1, 0);
        cell.setCellValue("����ʱ�䣺"+new Date());
        //cell.setCellStyle(dateStyle);

        getCell(sheet, 2, 0).setCellValue("ID");
        getCell(sheet, 2, 1).setCellValue("����/����");
        getCell(sheet, 2, 2).setCellValue("��Ʒ���ܽṹ�����");
        getCell(sheet, 2, 3).setCellValue("��׼����");
        getCell(sheet, 2, 4).setCellValue("��Ʒ���÷�Χ");
        getCell(sheet, 2, 5).setCellValue("��Ч����");
        getCell(sheet, 2, 6).setCellValue("ע���");
        getCell(sheet, 2, 7).setCellValue("��������");
        getCell(sheet, 2, 8).setCellValue("������λ");
        getCell(sheet, 2, 9).setCellValue("��Ʒ��׼");
        getCell(sheet, 2, 10).setCellValue("��Ʒ����");
        getCell(sheet, 2, 11).setCellValue("����ͺ�");
        getCell(sheet, 2, 12).setCellValue("ע�����");

        int size= qxInfos.size();

        for(int i=0;i<size;i++){
            HSSFRow sheetRow = sheet.createRow(i+3);
            SfdaQxDO info= qxInfos.get(i);

            sheetRow.createCell(0).setCellValue(info.getId());
            sheetRow.createCell(1).setCellValue(info.getGj());
            sheetRow.createCell(2).setCellValue(info.getProduct_struct_composition());
            sheetRow.createCell(3).setCellValue(parseDate(info.getApproval_date()));
            sheetRow.createCell(4).setCellValue(info.getProduct_scope());
            sheetRow.createCell(5).setCellValue(parseDate(info.getValidity_period()));
            sheetRow.createCell(6).setCellValue(info.getRegist_num());
            sheetRow.createCell(7).setCellValue(info.getProductSite());
            sheetRow.createCell(8).setCellValue(info.getProduct_company());
            sheetRow.createCell(9).setCellValue(info.getProduct_standard());
            sheetRow.createCell(10).setCellValue(info.getProduct_name());
            sheetRow.createCell(11).setCellValue(info.getSpecification_model());
            sheetRow.createCell(12).setCellValue(info.getZcdl());
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
