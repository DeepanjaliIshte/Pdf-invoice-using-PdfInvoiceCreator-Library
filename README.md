# Pdf-invoice-using-PdfInvoiceCreator-Library
<h6>This Java code uses the iText library to generate a PDF invoice document. Here's a summary of its key components:</h6>

<h4>Main Components:</h4>
<h4>PDF Setup:</h4>
<h6>PdfWriter and PdfDocument are used to create a new PDF file named invoice_with_border.pdf.<br>
PageBorderEventHandler is implemented to draw a black border around each page of the PDF.</h6>

<h4>Watermark:</h4>
<h6>An image watermark (DRI.png) is added to the center of the page with reduced opacity.</h6>

<h4>Tables and Layout:</h4>
<h6>Multiple tables are created to structure the content, including the invoice header, billing/shipping information, product list, and terms and conditions.
Cells are customized with different alignments, fonts, colors, and borders.</h6>

<h4>Product List:</h4>
<h6>A list of products is created and displayed in a table, with columns for description, quantity, and total price.<br>
The total sum of all products is calculated and displayed.</h6>

<h4>Terms and Conditions:</h4>
<h6>A list of terms and conditions is added to the end of the document.</h6>

</h4>Custom Event Handler:</h4>
<h4>PageBorderEventHandler:</h4>
<h6>This class handles the drawing of a border around each page using the PdfCanvas object. The border is a black rectangle, 2 points thick, inset 10 points from the page edges.</h6>

<h4>Utility Methods:</h4>
<h6>Helper methods like texCell, textValue, billingAndShipping, and getCellleft are defined to simplify cell creation with consistent styling.</h6>

<h4>Product Class:</h4>
<h6>A simple Product class holds the details of each product, including its name, quantity, and price per piece.</h6>

<h4>Output:</h4>
<h6>The code generates a PDF named invoice_with_border.pdf with a structured layout, including tables, watermarks, borders, and styled text.</h6>
