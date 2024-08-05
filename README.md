# Pdf-invoice-using-PdfInvoiceCreator-Library
<h6>This code generates a structured PDF invoice that includes a watermark, styled text, and multiple tables. It lists products with prices, displays the total amount, and concludes with terms and conditions. Helper methods are used to streamline cell creation and styling, while the Product class models the product data. The iText library is used extensively to manage the PDF creation and layout.</h6>


<h3>GeneratePDF: </h3>
<h6>This is the main class that contains all the logic to generate a PDF file.<br>
main(String[] args): The main method where the program starts executing.<br>
throws FileNotFoundException, MalformedURLException: The method declares that it might throw these exceptions, which are checked exceptions in Java.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>PDF Setup </h3>
path: This variable holds the path where the PDF file will be saved.
PdfWriter: This creates a writer instance that writes the PDF to the file specified by path.
PdfDocument: This represents the PDF document itself.
setDefaultPageSize(PageSize.A4): Sets the page size of the PDF to A4.
Document: This is the main class to add content (like paragraphs, tables, etc.) to the PDF.

------------------------------------------------------------------------------------------------------------------------
<h3>Adding a Watermark </h3>
imagePath: Path to the image that will be used as a watermark.
ImageDataFactory.create(imagePath): Loads the image data from the specified path.
Image: Creates an Image object that will be used to add the watermark to the PDF.
x, y: Calculate the center position of the page.
setFixedPosition: Positions the image at the specified coordinates, adjusted by offsets.
setOpacity(0.4f): Sets the transparency level of the watermark.
document.add(image): Adds the image to the PDF.

------------------------------------------------------------------------------------------------------------------------
<h3> Defining Column Widths</h3>
These variables define different column widths used in the tables within the PDF:
twocolumn: Width for two columns.
twocolumn150: Adjusted width for a wider two-column layout.
threecolumn: Width for three columns.
fullwidth: Width spanning across the full page width.
threecolumnwidth: Array defining three equally spaced columns.

------------------------------------------------------------------------------------------------------------------------
<h3>Adding a Paragraph for Spacing </h3>
Paragraph: Creates a new paragraph with a newline character for adding vertical spacing in the document.

------------------------------------------------------------------------------------------------------------------------
<h3>Invoice Header</h3>
Table: Creates a new table with the specified column widths.
addCell: Adds a new cell to the table with the "Invoice" label, sets the font size, removes the border, makes the text bold, and sets the font color to magenta.

------------------------------------------------------------------------------------------------------------------------
<h3> Invoice Details</h3>
nestedTable: Creates a nested table with two equally spaced columns.
texCell, textValue: Helper methods (defined later) are used to create styled cells for the invoice number and date.
The nested table is added as a cell to the main invoice table.

------------------------------------------------------------------------------------------------------------------------
<h3> Divider Line</h3>
SolidBorder: Creates a solid border with a thickness of 1.8f and color cyan.
divider: Creates a table that serves as a divider line across the page.

------------------------------------------------------------------------------------------------------------------------
<h3>Adding Tables and Information to the Document </h3>
document.add: These lines add the invoice table, divider line, and spacing paragraph to the document.

------------------------------------------------------------------------------------------------------------------------
<h3>Billing and Shipping Information </h3>
billingAndShipping: A helper method to create a styled cell with "Billing Information" and "Shipping Information" headers.
setMarginBottom: Adds some margin below the table.

------------------------------------------------------------------------------------------------------------------------
<h3>Additional Billing and Shipping Details </h3>
getCellleft: A helper method used to create cells with left-aligned text.
These tables add the company, name, address, and email details for both billing and shipping information.

------------------------------------------------------------------------------------------------------------------------
<h3>Another Divider with Dashed Border </h3>
DashedBorder: Creates a dashed border instead of a solid one.
A divider table with this border is added to the document.

------------------------------------------------------------------------------------------------------------------------
<h3>Product Table Header </h3>
productParagraph: Creates a paragraph to act as the header for the product section, styled with bold red text.
threeTable: A table with three columns is created, with a cyan background color.
Adds header cells for "Description", "Quantity", and "Price" to the product table.

------------------------------------------------------------------------------------------------------------------------
<h3>Product List </h3>
productList: Creates a list of Product objects representing the products to be listed in the invoice, with each product having a name, quantity, and price per piece.
Iterates over the productList, calculates the total for each product (quantity * price), and adds these details to the table. It also calculates the totalSum of all products.

------------------------------------------------------------------------------------------------------------------------
<h3> Adding Total and Divider</h3>
Adds an empty cell followed by a divider to the document.
Adds a table with the "Total" label and the calculated totalSum on the right.

------------------------------------------------------------------------------------------------------------------------
<h3>Terms and Conditions </h3>
Adds a divider line and a blank paragraph for spacing.
table7: Creates a table for the terms and conditions section and adds a bold red header.
TncList: Creates a list of strings representing the terms and conditions.
Loops through the TncList and adds each term as a cell in the terms and conditions table.
------------------------------------------------------------------------------------------------------------------------
<h3>Closing the Document</h3>
<h5>document.close():</h5> <h6>> Closes the document, which finalizes and writes the PDF to the specified path.
Prints "PDF generated" to the console to indicate successful completion.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Helper Methods</h3>
<h5>texCell: </h5><h6>Creates a right-aligned bold cell with no border.</h6>
<h5>textValue:</h5> Creates a left-aligned cell with no border.
<h5>billingAndShipping:</h5> Creates a styled cell for billing and shipping headers.
<h5>getCellleft: </h5>Creates a left-aligned cell with optional bold styling.</h6>

------------------------------------------------------------------------------------------------------------------------
<h3>Product Class</h3>
<h5>Product:</h5> <h6>A simple class that holds information about a product, including its name, quantity, and price per piece.</h6>
<h5>getters and setters:</h5> <h6>Methods to access and modify the product's attributes.</h6>
