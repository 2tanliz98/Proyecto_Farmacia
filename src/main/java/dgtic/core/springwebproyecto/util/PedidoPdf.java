package dgtic.core.springwebproyecto.util;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dgtic.core.springwebproyecto.model.DetalleCompra;
import dgtic.core.springwebproyecto.model.Pedido;
import dgtic.core.springwebproyecto.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Component("/pdf")
public class PedidoPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        List<DetalleCompra> detalle= (List<DetalleCompra>) model.get("detalle");
        List<Usuario> usuario= (List<Usuario>) model.get("usuario");

        PdfPTable tablaUsuario = new PdfPTable(2);
        PdfPCell celda=new PdfPCell(new Phrase("Nombre del Cliente"));
        celda.setBackgroundColor(new Color(167,218,255));
        celda.setPadding(8f);
        tablaUsuario.addCell(celda);
        tablaUsuario.addCell("Nombre");
        tablaUsuario.addCell("Correo");
        tablaUsuario.addCell("Dirección");

        SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");

        tablaUsuario.addCell(usuario.get(0).getNombre()+" "+usuario.get(0).getApPaterno()+
                " "+usuario.get(0).getApMaterno());
        tablaUsuario.addCell(usuario.get(0).getEmail());
        tablaUsuario.addCell(usuario.get(0).getDireccion().getCalle()+" "+
                usuario.get(0).getDireccion().getNumero()+" "+
                usuario.get(0).getDireccion().getCodigoPostal()+" "+
                usuario.get(0).getDireccion().getColonia()+" "+
                usuario.get(0).getDireccion().getMunicipio()+" "+
                usuario.get(0).getDireccion().getEstado()+" ");
        document.add(tablaUsuario);

    }
}
