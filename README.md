# Pdf-invoice-using-PdfInvoiceCreator-Library
<h6>This code generates a structured PDF invoice that includes a watermark, styled text, and multiple tables. It lists products with prices, displays the total amount, and concludes with terms and conditions. Helper methods are used to streamline cell creation and styling, while the Product class models the product data. The iText library is used extensively to manage the PDF creation and layout.</h6>


<h3>GeneratePDF: </h3>
<h6>This is the main class that contains all the logic to generate a PDF file.<br>
main(String[] args): The main method where the program starts executing.<br>
throws FileNotFoundException, MalformedURLException: The method declares that it might throw these exceptions, which are checked exceptions in Java.</h6>

<h3>PDF Setup </h3>

<h3>Adding a Watermark </h3>

<h3> Defining Column Widths</h3>

<h3>Adding a Paragraph for Spacing </h3>


<h3> Invoice Details</h3>

<h3> Divider Line</h3>

<h3>Adding Tables and Information to the Document </h3>

<h3>Billing and Shipping Information </h3>


<h3>Additional Billing and Shipping Details </h3>

<h3>Another Divider with Dashed Border </h3>

<h3>Product Table Header </h3>

<h3>Product List </h3>

<h3> Adding Total and Divider</h3>

<h3>Terms and Conditions </h3>

<h3>Closing the Document</h3>

<h3>Helper Methods</h3>

<h3>Product Class</h3>
<h5>Product:</h5> <h6>A simple class that holds information about a product, including its name, quantity, and price per piece.</h6>
<h5>getters and setters:</h5> <h6>Methods to access and modify the product's attributes.</h6>
