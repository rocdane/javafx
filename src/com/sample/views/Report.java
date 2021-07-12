package com.sample.views;

import com.sample.utils.Database;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Report {

    private static JasperReport jasperReport;
    private static JasperDesign jasperDesign;
    private static JRDesignQuery jrDesignQuery;
    private static JasperViewer jasperViewer;
    private static JasperPrint jasperPrint;

    public static void createReport(String source, String query){
        try {
            jasperDesign = JRXmlLoader.load(Report.class.getResourceAsStream(source));
            jrDesignQuery = new JRDesignQuery();
            jrDesignQuery.setText(query);
            jasperDesign.setQuery(jrDesignQuery);

            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, Database.getConnection());
            jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setVisible(true);
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
