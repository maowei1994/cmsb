package com.hj.view;

import com.hj.dal.domain.dataobject.CpmcZcDO;
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
public class QyZcViewExcel extends AbstractExcelView {

    List<CpmcZcDO> qxInfos;

    public QyZcViewExcel(List<CpmcZcDO> qxInfos) {
        this.qxInfos = qxInfos;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        HSSFSheet sheet = workbook.createSheet("qxInfo");
        sheet.setDefaultColumnWidth((short) 15);
        HSSFCell cell = getCell(sheet, 0, 0);
        setText(cell, "ҩ��ע���걨������Ϣ�б�");
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        cell = getCell(sheet, 1, 0);
        cell.setCellValue("����ʱ�䣺"+new Date());
        //cell.setCellStyle(dateStyle);

        getCell(sheet, 2, 0).setCellValue("ID");
        getCell(sheet, 2, 1).setCellValue("ROWKEY");
        getCell(sheet, 2, 2).setCellValue("������ҵ");
        getCell(sheet, 2, 3).setCellValue("ע������");
        getCell(sheet, 2, 4).setCellValue("CFDA����״̬");
        getCell(sheet, 2, 5).setCellValue("ҩƷӢ����");
        getCell(sheet, 2, 6).setCellValue("״̬��ʼʱ��");
        getCell(sheet, 2, 7).setCellValue("�����");
        getCell(sheet, 2, 8).setCellValue("CDE�а�����");
        getCell(sheet, 2, 9).setCellValue("ҩƷ����");
        getCell(sheet, 2, 10).setCellValue("ҩƷ������");
        getCell(sheet, 2, 11).setCellValue("��������");
        getCell(sheet, 2, 12).setCellValue("��������Ʒ��");
        getCell(sheet, 2, 13).setCellValue("�±��뿪����ʱ��");
        getCell(sheet, 2, 14).setCellValue("�±���ǰ����");
        getCell(sheet, 2, 15).setCellValue("������������");
        getCell(sheet, 2, 16).setCellValue("�±������������");
        getCell(sheet, 2, 17).setCellValue("CDE״̬");
        getCell(sheet, 2, 18).setCellValue("�ش�ר��");
        getCell(sheet, 2, 19).setCellValue("�±��Ŷ�����");
        getCell(sheet, 2, 20).setCellValue("�±������ٶ�");
        getCell(sheet, 2, 21).setCellValue("CDE��������");
        getCell(sheet, 2, 22).setCellValue("�±���������ʱ��");
        getCell(sheet, 2, 23).setCellValue("�±�����״̬");

        int size= qxInfos.size();

        for(int i=0;i<size;i++){
            HSSFRow sheetRow = sheet.createRow(i+3);
            CpmcZcDO info= qxInfos.get(i);

            sheetRow.createCell(0).setCellValue(info.getId());
            sheetRow.createCell(1).setCellValue(info.getRowkey());
            sheetRow.createCell(2).setCellValue(info.getScqy());
            sheetRow.createCell(3).setCellValue(info.getZclx());
            sheetRow.createCell(4).setCellValue(info.getCfda_blzt());
            sheetRow.createCell(5).setCellValue(info.getCpmc_en());
            sheetRow.createCell(6).setCellValue(parseDate(info.getKsrq()));
            sheetRow.createCell(7).setCellValue(info.getSlh());
            sheetRow.createCell(8).setCellValue(parseDate(info.getCde_cbrq()));
            sheetRow.createCell(9).setCellValue(info.getYplx());
            sheetRow.createCell(10).setCellValue(info.getCpmc());
            sheetRow.createCell(11).setCellValue(info.getSqlx());
            sheetRow.createCell(12).setCellValue(info.getTsps());
            sheetRow.createCell(13).setCellValue(info.getXb_lksj());
            sheetRow.createCell(14).setCellValue(info.getXb_dqpm());
            sheetRow.createCell(15).setCellValue(info.getFsspjl());
            sheetRow.createCell(16).setCellValue(info.getXb_rwfl());
            sheetRow.createCell(17).setCellValue(info.getCde_zt());
            sheetRow.createCell(18).setCellValue(info.getZdzx());
            sheetRow.createCell(19).setCellValue(info.getXb_pdzs());
            sheetRow.createCell(20).setCellValue(info.getXb_spsd());
            sheetRow.createCell(21).setCellValue(info.getCde_spjl());
            sheetRow.createCell(22).setCellValue(info.getXb_jrsj());
            sheetRow.createCell(23).setCellValue(info.getXb_pszt());
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
