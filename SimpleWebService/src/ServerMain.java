public class ServerMain {


    public static void main(String[] args) {
        Server server = new Server();


            server.receive();

            //server.send();


    }

}
/*
HTTP/1.0 200 Document Follows\r\n
        Content-Type: text/html; charset=UTF-8\r\n
        Content-Length: <file_byte_size> \r\n
        \r\n
        HTTP/1.0 200 Document Follows\r\n
        Content-Type: image/<image_file_extension> \r\n
        Content-Length: <file_byte_size> \r\n
        \r\n
        HTTP/1.0 404 Not Found\r\n
        Content-Type: text/html; charset=UTF-8\r\n
        Content-Length: <file_byte_size> \r\n
        \r\n*/
