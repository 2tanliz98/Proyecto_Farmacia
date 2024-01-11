//package dgtic.core.springwebproyecto.util;
//
//import com.lowagie.text.Document;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//import dgtic.core.springwebproyecto.model.DetalleCompra;
//import dgtic.core.springwebproyecto.model.Pedido;
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
//        tabla.addCell("Dirección");
//        tabla.addCell("Método de pago");
//        tabla.addCell("Detalle orden");
//        tabla.addCell("Total");
//        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
//        for (Pedido p:datos) {
//            tabla.addCell(p.getCliente().getNombre() + " "+p.getCliente().getApellidoPaterno());
//            tabla.addCell(f.format(p.getFechaReservacion()));
//            tabla.addCell(f.format(p.getFechaInicio()));
//            tabla.addCell(p.getHabitacion().getHotel().getNombre());
//            tabla.addCell(p.getHabitacion().getNombre());
//            tabla.addCell(String.valueOf(p.getHabitacion().getPrecio()));
//        }
//
//        document.add(tabla);
//
//    }
//}
