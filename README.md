# Project15Group1CloudComputing
Trang web Ecommerence bán hàng kết nối với Amazon Aurora.
1. Tạo Amazon Aurora tạo database 
link nhóm tham khảo:https://www.youtube.com/watch?v=n_QplvENyLY&feature=youtu.be
2. Tạo data base sử dụng script nhóm đã up lên git connect Mysql
3. Các bước xây dựng trang web
# Cài đặt project
1. Tải source từ git quàn sử dùng Eclipse để quản lý code.
2. Tạo EC2 instance với AMI linux
3. Tải Putty với key .ppk của EC2 Instace vừa tạo
  - Sau đó sử dụng Putty để connect
  - Lấy DNS EC2 để connect
Sau khi đã kết nối vào thì chúng ta tạo thư mục java để chưa các môi trường cần thiết để deploy app.
4. Dowload java 8 
- $ wget https://builds.openlogic.com/downloadJDK/openlogic-openjdk-jre/11.0.8%2B10/openlogic-openjdk-jre-11.0.8%2B10-linux-x64-el.rpm
- Sau khi tải xong ta thực hiện giải nén
- $ tar xvzf openlogic-openjdk-jre-11.0.8%2B10-linux-x64-el.rpm
5. Tải Tomcat 8
- $ wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.78/bin/apache-tomcat-8.5.78.tar.gz
- Ta giải nén sau khi tải về
- $ tar xvzf apache-tomcat-8.5.78.tar.gz
- Để tiết kiệm bộ nhớ chúng ta xóa các file không cần thiết
- $ rm -r openlogic-openjdk-jre-11.0.8%2B10-linux-x64-el.rpm
- $ rm -r apache-tomcat-8.5.78.tar.gz
6. Sử dụng các lệnh sau để thực chạy tomcat
- $ cd apache-tomcat-8.5.78/
- $ cd bin
- $ ./startup.sh
- $ ps -ef | grep tomcat
- $ wget http://localhost:8080 # sử dụng port 8080 của tomcat
7. Cấu hình tài khoản để đăng nhập vào tomcat server
- trở về thư mục apache-tomcat: $ cd ..
- $ vi conf/tomcat-users.xml
- thêm vào cuối file nội dung: <role rolename="manager-gui"/> <user username="admin" password="admin" roles="manager-gui"/> 
- Sau thực hiện chạy lại: $ ./startup.sh
- $ ps -ef | grep tomcat
- $ wget http://localhost:8080 # sử dụng port 8080 của tomcat
8. Dùng eclipse export file war để deloy lên tomcat-server

# Cảm ơn mọi người đã ghé qua !
