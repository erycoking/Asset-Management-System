/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groups;

/**
 *
 * @author makwata
 */
import javafx.collections.ObservableList;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Phrase;
import javafx.scene.control.TableView;

// itextpdf library is used to generate pdfs
public class Printpdf {
    public void createPdf (TableView table) throws Exception {
        
         Document report = new Document(PageSize.A4, 50, 50, 50, 50);
         // the path to where the pdf will be generated
         // be mindful of linux or windows file path differences
         PdfWriter.getInstance(report, new FileOutputStream("/home/makwata/Desktop/group.pdf"));
         report.open();
         
         // title of the document
         Paragraph title = new Paragraph("Practicals Group List", FontFactory.getFont(FontFactory.COURIER_BOLD, 16, Font.BOLD, new CMYKColor(0, 255, 255,17)));
         title.setSpacingBefore(25);
         title.setSpacingAfter(25);
                 
         PdfPTable reportable = new PdfPTable(4);
         reportable.setSpacingAfter(25);
         PdfPCell reportcell;
         
         // table column headers
         reportable.addCell(new PdfPCell(new Phrase("Name", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, Font.BOLD, new CMYKColor(16, 255, 220, 16)))));
         reportable.addCell(new PdfPCell(new Phrase("Registration", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, Font.BOLD, new CMYKColor(16, 255, 220, 16)))));
         reportable.addCell(new PdfPCell(new Phrase("GroupLeader", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, Font.BOLD, new CMYKColor(16, 255, 220, 16)))));
         reportable.addCell(new PdfPCell(new Phrase("Groups", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 13, Font.BOLD, new CMYKColor(16, 255, 220, 16)))));
         
         // populate the report table values with cell values
         for(Students student:getList(table)) {
             reportcell =  new PdfPCell(new Phrase(student.getName()));
             reportcell.setPaddingTop(10);
             reportcell.setPaddingLeft(10);
             reportable.addCell(reportcell).setFixedHeight(50);
             
             reportcell =  new PdfPCell(new Phrase(student.getRegno()));
             reportcell.setPaddingTop(10);
             reportcell.setPaddingLeft(10);
             reportable.addCell(reportcell).setFixedHeight(50);
             
             reportcell =  new PdfPCell(new Phrase(isLeader(student.getLeader())));
             reportcell.setPaddingTop(10);
             reportcell.setPaddingLeft(10);
             reportable.addCell(reportcell).setFixedHeight(50);
             
             reportcell = new PdfPCell(new Phrase(student.getGroup()));
             reportcell.setPaddingTop(10);
             reportcell.setPaddingLeft(10);
             reportable.addCell(reportcell).setFixedHeight(50);
         }
         
         // add the title and the table into the document
         report.add(title);
         report.add(reportable);
         report.close();
     }
     
     // method to convert boolean values from DB into human readable values
     // example from true or false to indicator is group leader 
     public String isLeader(Boolean value) {
         if(value) {
             return "group leader";
         }
         else {
             return null;
         }
     }
     
     // returns an observable list of students
     public ObservableList<Students> getList(TableView table) {
         ObservableList<Students> students;
         students = table.getItems();
         return students;
     }
     
}
