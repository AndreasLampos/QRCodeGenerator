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
<strong>Example. Main Menu:</strong>

![Screenshot (117)](https://github.com/user-attachments/assets/ee669835-6b90-4051-987b-ce8639af7523)

<strong>Creating the QR for the specific URL. Even gives us the ability to change dimensions:</strong>

![Screenshot (118)](https://github.com/user-attachments/assets/c79c89bc-5555-49bc-a0ba-71c51925adde)

<strong>Reading-Decoding a QR code, by giving its path:</strong>
![Screenshot (119)](https://github.com/user-attachments/assets/e4ecf4a0-f4b7-4b06-9020-a89c3e976a88)

<strong>Shows the user his history of creating and reading QR codes:</strong>

![Screenshot (120)](https://github.com/user-attachments/assets/5aae3f2f-7ab3-42ff-88e6-5839eb727319)


<strong>Making sure the URL inputted is valid:</strong>

![Screenshot (121)](https://github.com/user-attachments/assets/f775cb55-3b8c-46b3-afc8-d8ac8ba9c55d)

<strong>Lastly, checks if the QR code file is stored locally, lets the user know it already exists and asks whether the user wants to overwrite it or not. :</strong>

![Screenshot (123)](https://github.com/user-attachments/assets/c0bc4e06-4dc9-4a08-b6cc-dea2863424f2)

<h2>Contribution</h2>
<p>
    Contributions are welcome! If you have suggestions for features or improvements, feel free to open an issue or submit a pull request.
</p>

<h2>Acknowledgments</h2>
<p>
    Special thanks to the <a href="https://github.com/zxing/zxing">ZXing</a> community for their open-source QR code generation and decoding library.
</p>
