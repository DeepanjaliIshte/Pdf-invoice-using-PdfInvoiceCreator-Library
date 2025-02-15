# Pdf-invoice-using-PdfInvoiceCreator-Library
<h6>This code generates a structured PDF invoice that includes a watermark, styled text, and multiple tables. It lists products with prices, displays the total amount, and concludes with terms and conditions. Helper methods are used to streamline cell creation and styling, while the Product class models the product data. The iText library is used extensively to manage the PDF creation and layout.</h6>


<h3>GeneratePDF: </h3>
<h6>This is the main class that contains all the logic to generate a PDF file.<br></h6>
<h4>main(String[] args):</h4><h6>The main method where the program starts executing.<br>
throws FileNotFoundException, MalformedURLException: The method declares that it might throw these exceptions, which are checked exceptions in Java.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>PDF Setup </h3>
<h4>path:</h4><h6> This variable holds the path where the PDF file will be saved.<br></h6>
<h4>PdfWriter:</h4> <h6>This creates a writer instance that writes the PDF to the file specified by path.<br></h6>
<h4>PdfDocument:</h4><h6> This represents the PDF document itself.<br></h6>
<h4>setDefaultPageSize(PageSize.A4):</h4> <h6>Sets the page size of the PDF to A4.<br></h6>
<h4>Document:</h4> <h6>This is the main class to add content (like paragraphs, tables, etc.) to the PDF.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Adding a Watermark </h3>
<h4>imagePath:</h4><h6>Path to the image that will be used as a watermark.<br></h6>
<h4>ImageDataFactory.create(imagePath):</h4> <h6>Loads the image data from the specified path.<br></h6>
<h4>Image:</h4> <h6>Creates an Image object that will be used to add the watermark to the PDF.<br></h6>
<h4>x, y:</h4><h6> Calculate the center position of the page.<br></h6>
<h4>setFixedPosition:</h4> <h6>Positions the image at the specified coordinates, adjusted by offsets.<br></h6>
<h4>setOpacity(0.4f):</h4> <h6>Sets the transparency level of the watermark.<br></h6>
<h4>document.add(image):</h4><h6>Adds the image to the PDF.<br></h6>

------------------------------------------------------------------------------------------------------------------------
<h3> Defining Column Widths</h3>
<h4>These variables define different column widths used in the tables within the PDF:</h4>
<h4>twocolumn:</h4> <h6> Width for two columns.<br></h6>
<h4>twocolumn140:</h4> <h6>Adjusted width for a wider two-column layout.<br></h6>
<h4>threecolumn:</h4><h6> Width for three columns.<br></h6>
<h4>fullwidth:</h4><h6>Width spanning across the full pge width.<br></h6>
<h4>threecolumnwidth:</h4><h6>Array defining three equally spaced columns.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Adding a Paragraph for Spacing </h3>
<h4>Paragraph:</h4></h6> Creates a new paragraph with a newline character for adding vertical spacing in the document.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Invoice Header</h3>
<h4>Table:</h4><h6> Creates a new table with the specified column widths.<br></h6>
<h4>addCell:</h4><h6> Adds a new cell to the table with the "Invoice" label, sets the font size, removes the border, makes the text bold, and sets the font color to magenta.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3> Invoice Details</h3>
<h4>nestedTable:</h4> <h6>Creates a nested table with two equally spaced columns.<br></h6>
<h4>texCell, textValue: </h4><h6>Helper methods (defined later) are used to create styled cells for the invoice number and date.
The nested table is added as a cell to the main invoice table.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3> Divider Line</h3>
<h4>SolidBorder: </h4><h6>Creates a solid border with a thickness of 1.8f and color cyan.<br>
<h4>divider: </h4><h6>Creates a table that serves as a divider line across the page.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Adding Tables and Information to the Document </h3>
<h4>document.add:</h4><h6> These lines add the invoice table, divider line, and spacing paragraph to the document.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Billing and Shipping Information </h3>
<h4>billingAndShipping: </h4><h6>A helper method to create a styled cell with "Billing Information" and "Shipping Information" headers.<br>
<h4>setMarginBottom:</h4><h6> Adds some margin below the table.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Additional Billing and Shipping Details </h3>
<h4>getCellleft:</h4><h6>A helper method used to create cells with left-aligned text.
These tables add the company, name, address, and email details for both billing and shipping information.</h6> 

------------------------------------------------------------------------------------------------------------------------
<h3>Another Divider with Dashed Border </h3>
<h4>DashedBorder:</h4><h6> Creates a dashed border instead of a solid one.<br>
A divider table with this border is added to the document.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Product Table Header </h3>
<h4>productParagraph:</h4><h6> Creates a paragraph to act as the header for the product section, styled with bold red text.
<h4>threeTable:</h4> <h6>A table with three columns is created, with a cyan background color.<br>
Adds header cells for "Description", "Quantity", and "Price" to the product table.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Product List </h3>
<h4>productList:</h4><h6> Creates a list of Product objects representing the products to be listed in the invoice, with each product having a name, quantity, and price per piece.<br>
Iterates over the productList, calculates the total for each product (quantity * price), and adds these details to the table. It also calculates the totalSum of all products.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3> Adding Total and Divider</h3>
<h6>Adds an empty cell followed by a divider to the document.<br>
Adds a table with the "Total" label and the calculated totalSum on the right.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Terms and Conditions </h3>
<h6>Adds a divider line and a blank paragraph for spacing.<br></h6>
<h4>table7:</h4> <h6>Creates a table for the terms and conditions section and adds a bold red header.<br></h6>
<h4>TncList: </h4><h6>Creates a list of strings representing the terms and conditions.<br>
Loops through the TncList and adds each term as a cell in the terms and conditions table.</h6>
------------------------------------------------------------------------------------------------------------------------
<h3>Closing the Document</h3>
<h4>document.close():</h4> <h6>> Closes the document, which finalizes and writes the PDF to the specified path.
Prints "PDF generated" to the console to indicate successful completion.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Helper Methods</h3>
<h4>texCell: </h4><h6>Creates a right-aligned bold cell with no border.</h6>
<h4>textValue:</h4><h6> Creates a left-aligned cell with no border.</h6>
<h4>billingAndShipping:</h4> <h6>Creates a styled cell for billing and shipping headers.</h6>
<h4>getCellleft: </h4><h6>Creates a left-aligned cell with optional bold styling.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Product Class</h3>
<h4>Product:</h4> <h6>A simple class that holds information about a product, including its name, quantity, and price per piece.</h6>
<h4>getters and setters:</h4> <h6>Methods to access and modify the product's attributes.</h6>

<img width="305" alt="invoice" src="https://github.com/user-attachments/assets/0702f25d-8802-470a-a90f-61265d8a6489">
