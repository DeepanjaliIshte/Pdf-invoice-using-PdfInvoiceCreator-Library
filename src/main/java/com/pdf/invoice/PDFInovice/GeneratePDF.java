package com.pdf.invoice.PDFInovice;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class GeneratePDF {
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        String path = "invoice.pdf";

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        
        Document document = new Document(pdfDocument);
        
        String imagePath="DRI.png";
        ImageData imgdata =ImageDataFactory.create(imagePath);
        Image image=new Image(imgdata);
        
       float x=pdfDocument.getDefaultPageSize().getWidth()/2;
       float y=pdfDocument.getDefaultPageSize().getHeight()/2;
       image.setFixedPosition(x-80, y-150);
       image.setOpacity(0.4f);
       
       document.add(image);

        // Define column widths
        float twocolumn = 290f;
        float twocolumn150 = twocolumn + 150f;
        float twocolumnWidth[] = {twocolumn150, twocolumn};
        float threecolumn = 190f;
        float fullwidth[] = {threecolumn * 3};
        float threecolumnwidth[] = {threecolumn, threecolumn, threecolumn};

        // Adding spacing paragraph
        Paragraph paragraph = new Paragraph("\n");

        // Invoice header
        Table table = new Table(twocolumnWidth);
        table.addCell(new Cell().add("Invoice").setFontSize(25f).setBorder(Border.NO_BORDER).setBold().setFontColor(Color.MAGENTA));

        // Invoice details
        Table nestedTable = new Table(new float[]{twocolumn / 2, twocolumn / 2});
        nestedTable.addCell(texCell("Invoice No:"));
        nestedTable.addCell(textValue("DRI070198"));
        nestedTable.addCell(texCell("Invoice Date:"));
        nestedTable.addCell(textValue("03/08/2024"));
        table.addCell(new Cell().add(nestedTable).setBorder(Border.NO_BORDER));

        // Divider
        Border border = new SolidBorder(Color.CYAN, 1.8f);
        Table divider = new Table(fullwidth);
        divider.setBorder(border);

        document.add(table);
        document.add(divider);
        document.add(paragraph);

        // Billing and Shipping Information
        Table table1 = new Table(twocolumnWidth);
        table1.addCell(billingAndShipping("Billing Information"));
        table1.addCell(billingAndShipping("Shipping Information"));
        document.add(table1.setMarginBottom(12f));

        Table table2 = new Table(twocolumnWidth);
        table2.addCell(getCellleft("Company", true));
        table2.addCell(getCellleft("Name", true));
        table2.addCell(getCellleft("Teen Titan Go", false));
        table2.addCell(getCellleft("Raven", false));
        document.add(table2);

        Table table3 = new Table(twocolumnWidth);
        table3.addCell(getCellleft("Name", true));
        table3.addCell(getCellleft("Address", true));
        table3.addCell(getCellleft("Robin", false));
        table3.addCell(getCellleft("New York, 14 building 5th floor behind ocean", false));
        document.add(table3);

        float onecolumnwidth[] = {twocolumn150};
        Table table4 = new Table(onecolumnwidth);
        table4.addCell(getCellleft("Address", true));
        table4.addCell(getCellleft("India Motu Patlu house near by Chota Bheem garden", false));
        table4.addCell(getCellleft("Email", true));
        table4.addCell(getCellleft("teentitansgo@gmail.com", false));
        document.add(table4);

        // Divider with Dashed Border
        Table driver1 = new Table(fullwidth);
        Border border1 = new DashedBorder(Color.CYAN, 1f);
        document.add(driver1.setBorder(border1));

        // Product Table Header
        Paragraph productParagraph = new Paragraph("Product").setFontSize(20f).setBorder(Border.NO_BORDER).setBold().setFontColor(Color.RED);
        document.add(productParagraph.setBold());

        Table threeTable = new Table(threecolumnwidth);
        threeTable.setBackgroundColor(Color.CYAN, 10f);

        threeTable.addCell(new Cell().add("Description").setBold().setFontColor(Color.DARK_GRAY).setBorder(Border.NO_BORDER));
        threeTable.addCell(new Cell().add("Quantity").setBold().setFontColor(Color.DARK_GRAY).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
        threeTable.addCell(new Cell().add("Price").setBold().setFontColor(Color.DARK_GRAY).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT).setMarginRight(15f));
        document.add(threeTable);

        // Product List
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Telma-40", 3, 250));
        productList.add(new Product("Lavira-500", 5, 750));
        productList.add(new Product("Lavitamin-D3", 4, 624));
        productList.add(new Product("Itakas 130 SB", 3, 730));
        productList.add(new Product("Naporex 250", 3, 450));
        productList.add(new Product("Ceftigest", 3, 170));

        Table threeTable2 = new Table(threecolumnwidth);
        float totalSum = 0f;
        for (Product product : productList) {
            float total = product.getQuantity() * product.getPriceperpiece();
            totalSum += total;
            threeTable2.addCell(new Cell().add(product.getPname()).setBorder(Border.NO_BORDER).setMarginLeft(10f));
            threeTable2.addCell(new Cell().add(String.valueOf(product.getQuantity())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
            threeTable2.addCell(new Cell().add(String.valueOf(total)).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER).setMarginRight(15f));
        }

        document.add(threeTable2.setMargin(20f));

        float onetwo[] = {threecolumn + 125f, threecolumn * 2};
        Table table5 = new Table(onetwo);
        table5.addCell(new Cell().add("").setBorder(Border.NO_BORDER));
        table5.addCell(driver1).setBorder(Border.NO_BORDER);
        document.add(table5);

        // Centered "Total" label above the total sum
        Table tableNameTable = new Table(new float[]{threecolumn * 100, threecolumn});
        tableNameTable.addCell(new Cell().add("Total").setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
        tableNameTable.addCell(new Cell().add(String.valueOf(totalSum)).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
        document.add(tableNameTable);

        // Divider before Terms and Conditions
        document.add(divider);
        document.add(new Paragraph(""));

        // Terms and Condition header
        Table table7 = new Table(fullwidth);
        table7.addCell(new Cell().add("Terms and Conditions \n").setBold().setBorder(Border.NO_BORDER).setFontColor(Color.RED).setFontSize(20f));
        
        List<String> TncList = new ArrayList<>();
        TncList.add("1. The Seller shall not be liable to the buyer directly or indirectly for any loss or damage suffered.");
        TncList.add("2. The Seller warrants the product for one year from the date of shipment.");
        TncList.add("3. All returns must be made within 30 days of receipt of goods.");
        TncList.add("4. Payment must be made within 30 days from the invoice date.");
        TncList.add("5. Any disputes shall be governed by the laws of the seller's country.");
        
        for (String tnc : TncList) {
            table7.addCell(new Cell().add(tnc).setBorder(Border.NO_BORDER));
        }
        
        document.add(table7);
        
        document.close();
        System.out.println("PDF generated");
    }

    // Helper methods for styling cells
    static Cell texCell(String textValue) {
        return new Cell().add(textValue).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
    }

    static Cell textValue(String textValue) {
        return new Cell().add(textValue).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }

    static Cell billingAndShipping(String textValue) {
        return new Cell().add(textValue).setBold().setFontSize(14f).setFontColor(Color.RED).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }

    static Cell getCellleft(String textValue, boolean isBold) {
        Cell myCell = new Cell().add(textValue).setFontSize(12f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
        return isBold ? myCell.setBold() : myCell;
    }
}

// Product class
class Product {
    private String pname;
    private int quantity;
    private float priceperpiece;

    public Product(String pname, int quantity, float priceperpiece) {
        this.pname = pname;
        this.quantity = quantity;
        this.priceperpiece = priceperpiece;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPriceperpiece() {
        return priceperpiece;
    }

    public void setPriceperpiece(float priceperpiece) {
        this.priceperpiece = priceperpiece;
    }
}