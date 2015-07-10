package com.hj.view;

import com.hj.biz.util.YPUtil;
import com.hj.client.FR;
import com.hj.dal.domain.dataobject.YgyZdcsSaleDO;
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
 * @since 2015/3/7  16:32
 */
public class QyPowerSaleViewExcel extends AbstractExcelView {

    List<YgyZdcsSaleDO> saleDOs;

    public QyPowerSaleViewExcel(List<YgyZdcsSaleDO> saleDOs) {
        this.saleDOs = saleDOs;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {
        HSSFSheet sheet = workbook.createSheet("qySales");
        sheet.setDefaultColumnWidth((short) 15);
        HSSFCell cell = getCell(sheet, 0, 0);
        setText(cell, "������������");
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        cell = getCell(sheet, 1, 0);
        cell.setCellValue("����ʱ�䣺" + new Date());
        //cell.setCellStyle(dateStyle);

        getCell(sheet, 2, 0).setCellValue("����");
        getCell(sheet, 2, 1).setCellValue("���۶�");
        getCell(sheet, 2, 2).setCellValue("ͬ��������");

        List<FR> frs = YPUtil.getFrFromSale(saleDOs);

        int size = frs.size();

        for (int i = 0; i < size; i++) {
            HSSFRow sheetRow = sheet.createRow(i + 3);
            FR info = frs.get(i);
            sheetRow.createCell(0).setCellValue(info.getDetailJD());
            sheetRow.createCell(1).setCellValue(info.getXse());
            sheetRow.createCell(2).setCellValue(info.getRate());
        }
        long time = System.currentTimeMillis();
        String filename = time + ".xls";//��������ʱ�ͻ���Excel������

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
