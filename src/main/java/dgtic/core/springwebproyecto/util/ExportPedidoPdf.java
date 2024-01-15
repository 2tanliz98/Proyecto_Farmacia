package dgtic.core.springwebproyecto.util;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import dgtic.core.springwebproyecto.model.DetalleCompra;
import dgtic.core.springwebproyecto.model.Pedido;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ExportPedidoPdf {
    private List<DetalleCompra> detalles;
    private Pedido pedido;

    public ExportPedidoPdf(List<DetalleCompra> detalles, Pedido pedido) {
        this.detalles = detalles;
        this.pedido = pedido;
    }

    private void writetableHeader(PdfPTable table){
        table.setSpacingBefore(15);

        PdfPCell celda=new PdfPCell();
        celda.setBackgroundColor(new Color(47, 58, 65));
        celda.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.WHITE);

        celda.setPhrase(new Phrase("Nombre artículo",font));
        table.addCell(celda);
        celda.setPhrase(new Phrase("Precio",font));
        table.addCell(celda);
        celda.setPhrase(new Phrase("Cantidad",font));
        table.addCell(celda);
        celda.setPhrase(new Phrase("Total",font));
        table.addCell(celda);
    }
    private void writetableData(PdfPTable table){
        for(DetalleCompra detalleCompra: detalles){
            table.addCell(detalleCompra.getDetalleCompraId().getArticulo().getNombre());
            table.addCell(detalleCompra.getDetalleCompraId().getArticulo().getPrecio().toString());
            table.addCell(detalleCompra.getCantidad().toString());
            table.addCell(detalleCompra.getPrecioTotal().toString());
        }
    }
    public void export(HttpServletResponse response) throws IOException {
        Document doc = new Document();

        PdfWriter.getInstance(doc, response.getOutputStream());

        doc.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);

        Paragraph titulo = new Paragraph("VITALFARMACIA",font);
        doc.add(titulo);
        doc.add(new Paragraph("Detalle de la orden #"+pedido.getPedidoId(),font));

        doc.add(new Paragraph("DATOS DEL USUARIO"));
        doc.add(new Paragraph("Nombre: "+pedido.getUsuario().getNombre()+" "+
                pedido.getUsuario().getApPaterno()+" "+pedido.getUsuario().getApMaterno() ));
        doc.add(new Paragraph("Correo: "+pedido.getUsuario().getEmail()));
        doc.add(new Paragraph("Dirección: "+pedido.getUsuario().getDireccion().getCalle()+" "+
                pedido.getUsuario().getDireccion().getNumero()+" "+
                pedido.getUsuario().getDireccion().getCodigoPostal()+" "+
                pedido.getUsuario().getDireccion().getColonia()+" "+
                pedido.getUsuario().getDireccion().getMunicipio()+" "+
                pedido.getUsuario().getDireccion().getEstado()
        ));

        doc.add(new Paragraph("FORMA DE PAGO"));
        doc.add(new Paragraph(pedido.getMetodoPago().getNombre()));

        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
        doc.add(new Paragraph("FECHA PEDIDO: "+f.format(pedido.getFecha())));

        doc.add(new Paragraph("DETALLE DE LA COMPRA"));

        PdfPTable table = new PdfPTable(4);
        writetableHeader(table);
        writetableData(table);
        doc.add(table);

        doc.add(new Paragraph("TOTAL: "+ pedido.getTotal().toString()));
        doc.close();

    }

}
