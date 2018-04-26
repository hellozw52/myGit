@echo off
echo 开始签名

echo origianl_apk_name: %1
echo signed_apk_name: %2

echo java -jar D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/signapk.jar D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/09tv.x509.pem D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/09tv.pk8  D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/app_original/%1  D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/app_sign/%2
java -jar D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/signapk.jar D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/09tv.x509.pem D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/09tv.pk8  D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/app_original/%1   D:/apache-tomcat-7.0.26/webapps/ZwSignApp/app/APK_sign/app_sign/%2

echo 签名完成
