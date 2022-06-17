import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 用户进程B
 */
public class ServerB {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        System.out.println("ServerB用户进程开启。。。");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //获取输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //将字符数据转为bit信息
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(str);
        writer.flush();
        socket.close();

    }
}
