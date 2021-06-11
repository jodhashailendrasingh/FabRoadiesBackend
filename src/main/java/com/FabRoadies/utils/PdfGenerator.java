package com.fabRoadies.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fabRoadies.entity.Passenger;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PdfGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(PdfGenerator.class);

    public static void generateItenary(List<Passenger> reservation, String filePath) throws DocumentException{
        LOGGER.info("generateItinerary()");
        Document document=new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.addTitle("Here is your Flight ticket");
            document.add(generateTable(reservation));
            document.close();

        } catch (FileNotFoundException e){}
              
    }
    public static PdfPTable generateTable(List<Passenger> reservation){
        PdfPTable table=new PdfPTable(2);

        PdfPCell cell = new PdfPCell(new Phrase("Ticket Details"));

        cell.setColspan(2);
        table.addCell(cell);

   /*     cell = new PdfPCell(new Phrase("Flight Details"));
        cell.setColspan(2);
        table.addCell(cell);

    */   
        table.addCell("Bus Number");
        table.addCell(reservation.get(0).getTicket().getBus().getBusno()); 
        table.addCell("Ticket Number");
        table.addCell(" "+reservation.get(0).getTicket().getTicketId()); 
        
        table.addCell("Departure City");
        table.addCell(reservation.get(0).getTicket().getBus().getDepartureCity());
        table.addCell("Arival City");
        table.addCell(reservation.get(0).getTicket().getBus().getArrivalCity());

       
        for(int i=0;i<reservation.size();i++)
        {  
          table.addCell("Passenger Name");
          table.addCell(reservation.get(i).getName());
          table.addCell("Passenger SeatNo");
          table.addCell(" "+reservation.get(i).getSeatno());

        }
     
        return table;
    }
}