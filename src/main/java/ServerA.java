import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器A
 */
public class ServerA {
    private static final int LEN = 1024;


    public static void main(String[] args) throws IOException {
        //监听端口号
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("ServerA服务器开启。。。");
        while (true){
            Socket socket = serverSocket.accept();   //阻塞监听
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        handler(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            ).start();

        }
    }

    public static void handler(Socket socket) throws IOException {
        // 读取数据
        InputStream inputStream = socket.getInputStream();

        //将bit数据转为字符串
        byte[] inStr = new byte[LEN];
        int data = 0;
        while ((data = inputStream.read(inStr)) != -1){
            System.out.println(new String(inStr, 0, data, "UTF-8"));
        }
        inputStream.close();
        // 将01010这样的bit数据 转换为 字符数据
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        String str = reader.readLine();
//        System.out.println(str);

    }
}
