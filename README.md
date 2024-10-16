<h1>QR Code Generator & Reader</h1>

<h2>Overview</h2>
<p>
    The <strong>QR Code Generator & Reader</strong> is a simple yet powerful Java-based application that enables users to easily create and read QR codes from their command line interface. This project is designed for anyone interested in QR code technology, whether you’re a beginner looking to learn about Java programming or a professional wanting to incorporate QR codes into your applications.
</p>

<h2>Features</h2>
<ul>
    <li><strong>Generate QR Codes</strong>: Input any URL or text to create a customizable QR code image. You can specify the filename and dimensions for the output.</li>
    <li><strong>Read QR Codes</strong>: Decode QR codes from image files and retrieve the embedded text or URL with ease.</li>
    <li><strong>History Tracking</strong>: Keep a log of all generated and read QR codes, allowing for easy access and management of your QR code activities.</li>
    <li><strong>User-Friendly Interface</strong>: Navigate through the application with a simple menu-driven interface, enhanced with clear prompts and visually appealing formatting for an improved user experience.</li>
    <li><strong>Input Validation</strong>: Ensure valid URL input and file existence checks to enhance usability and prevent errors.</li>
</ul>

<h2>Technologies Used</h2>
<ul>
    <li>Java</li>
    <li>ZXing (Zebra Crossing) library for QR code generation and decoding</li>
    <li>Buffered Image Processing for image handling</li>
</ul>

<h2>Getting Started</h2>
<p>To get started with the QR Code Generator & Reader:</p>
<ol>
    <li><strong>Clone the repository</strong>:
        <pre><code>git clone https://github.com/AndreasLampos/QRCodeGenerator.git</code></pre>
    </li>
    <li><strong>Navigate to the project directory</strong>:
        <pre><code>cd qrcodegen</code></pre>
    </li>
    <li><strong>Add the ZXing libraries</strong> to your classpath (download the latest version from <a href="https://github.com/zxing/zxing/releases">ZXing releases</a>). If you find it hard to locate the two JAR files needed try these 2 links. https://mvnrepository.com/artifact/com.google.zxing/javase/3.5.3 (for JAVASE) , https://mvnrepository.com/artifact/com.google.zxing/core/3.5.3 (for CORE).</li>
    <li><strong>Compile and run</strong> the application:
        <pre><code>javac -cp .:lib/* QRCodeGen.java</code></pre>
        <pre><code>java -cp .:lib/* QRCodeGen</code></pre>
    </li>
</ol>
<strong>Example</strong>:
https://github.com/user-attachments/assets/f3b15bf6-e573-4d71-883d-53890de3af34
![Screenshot (118)](https://github.com/user-attachments/assets/d68c14ae-7400-42ac-bd17-e1c2275c984b)


<h2>Contribution</h2>
<p>
    Contributions are welcome! If you have suggestions for features or improvements, feel free to open an issue or submit a pull request.
</p>

<h2>Acknowledgments</h2>
<p>
    Special thanks to the <a href="https://github.com/zxing/zxing">ZXing</a> community for their open-source QR code generation and decoding library.
</p>
