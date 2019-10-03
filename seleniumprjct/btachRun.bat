set projectLocation=C:\Users\mvkuma.ORADEV\git\seleniumprjct\seleniumprjct
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testNG1.xml
pause