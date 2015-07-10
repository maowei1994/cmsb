package com.hj.client.tmp;

import java.io.*;

/**
 * ��������ͳ�ƣ�Ŀǰ����Ϊjava��׺��xml��׺����
 * @author tinglang (editice@gmail.com)
 * @since 2015/1/16  13:32
 */
public class CodeCountUtil {
    static long  normalLine=0;
    static long commentLine=0;
    static long whiteLine=0;

    public static void p(Object obj){
        System.out.println(obj);
    }
    public static void countcode(File f){
        BufferedReader br=null;
        boolean bln=false;
        try{
            br=new BufferedReader(new FileReader(f));
            String line="";
            try {
                while((line = br.readLine()) != null) {
                    line=line.trim();
                    if(line.matches("^[\\s&&[^\\n]]*$")){
                        whiteLine+=1;
                    }else if(line.startsWith("/*")&&!line.equals("*/")){
                        commentLine+=1;
                        bln=true;
                    }else if (bln==true){
                        commentLine+=1;
                        if(line.endsWith("*/")){
                            bln=false;
                        }
                    }else if(line.startsWith("/*")&&line.endsWith("*/")){
                        commentLine+=1;
                    }else if(line.startsWith("//")){
                        commentLine+=1;
                    }else {
                        normalLine+=1;
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static void execute(File file){
        if(file.isFile()){
            if(file.getName().matches(".*\\.java$") || file.getName().matches(".*\\.xml$")){
                countcode(file);
            }
        }else{
            File[] fs=file.listFiles();
            for(File f:fs){
                execute(f);
            }
        }
    }

    public static void main(String args[]){
        //��ȡ��Ŀ¼����� ���� .java �ļ�����ͳ�ơ�Ŀǰû�����ļ��еݹ����
        File f=new File("d:/code/baoshi");
        execute(f);
        p("����ͳ�ƣ�");
        p("ע�͵Ĵ�������:"+commentLine);
        p("�հ׵Ĵ�������:"+whiteLine);
        p("��Ч�Ĵ�������:"+normalLine);
    }
}
