# restservice

The Requirements are as below:
1.	The rest service should read the Plain text and identify the numbers in it.
2.	The details : Number position,  Line number and the number should be displayed
3.	The output should be in json format



Note:
I have used spring boot to create the service. Consuming plain/text was not happening. I tried a lot of ways but none of them worked. 
I developed the functionality where the user can upload a text file in the post request and the rest service will read the text from the file and identify the numbers and other details and will display result in json response.

Build Instructions
1.	Extract the zip file into you local drive.
2.	Import the project as existing maven project.
3.	Open application.properties file to change the directory to desired location. 
 
4.	Update the directory in Constant file.
5.	I have configured localhost:8082. You can change the port in application.properties file if necessary.
6.	Find FindingnumberApplication.java RunAsJava application

 
Go to below link in browser. You can add plug in to chrome if not present. If its already present you get Launch application option. Click on it.
https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en
rest service URI: http://localhost:8082/extractNumericDataFromFileUpload
Select POST
Go to Body, select form-data, 
In key enter ‘file’ choose the text file which is provided in the mail.
Hit the send button.
