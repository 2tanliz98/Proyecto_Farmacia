//package dgtic.core.springwebproyecto.util;
//
//import com.lowagie.text.Document;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//import dgtic.core.springwebproyecto.model.DetalleCompra;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.view.document.AbstractPdfView;
//
//import java.awt.*;
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.Map;
//
//@Component("reservacion/buscar-reservacion")
//public class PedidoPdf extends AbstractPdfView {
//    @Override
//    protected void buildPdfDocument(Map<String, Object> model, Document document,
//                                    PdfWriter writer,
//                                    HttpServletRequest request,
//                                    HttpServletResponse response) throws Exception {
//        List<DetalleCompra> datos= (List<DetalleCompra>) model.get("datos");
//        PdfPTable tabla=new PdfPTable(6);
//        PdfPCell celda=new PdfPCell(new Phrase("Nombre del Cliente"));
//        celda.setBackgroundColor(new Color(167,218,255));
//        celda.setPadding(8f);
//        tabla.addCell(celda);
//        tabla.addCell("Fecha Reservación");
//        tabla.addCell("Fecha Inicio");
//        tabla.addCell("Hotel");
//        tabla.addCell("Habitación");
//        tabla.addCell("Precio");
//        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
//        for (ReservacionEntity r:datos) {
//
//            tabla.addCell(r.getCliente().getNombre() + " "+r.getCliente().getApellidoPaterno());
//            tabla.addCell(f.format(r.getFechaReservacion()));
//            tabla.addCell(f.format(r.getFechaInicio()));
//            tabla.addCell(r.getHabitacion().getHotel().getNombre());
//            tabla.addCell(r.getHabitacion().getNombre());
//            tabla.addCell(String.valueOf(r.getHabitacion().getPrecio()));
//        }
//
//        document.add(tabla);
//
//    }
//}
