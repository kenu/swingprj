package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.json.JSONObject;

public class SimpleSwingExample {

	public static void main(String[] args) {
		// Swing GUI 작업을 이벤트 디스패치 스레드에서 실행하도록 합니다.
		SwingUtilities.invokeLater(() -> {
			// JFrame 인스턴스 생성
			JFrame frame = new JFrame("Simple Swing Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(300, 200);

			// JButton 생성
			JButton button = new JButton("Click me!");
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
			        HttpClient client = HttpClient.newHttpClient();
			        HttpRequest request = HttpRequest.newBuilder()
			                .uri(URI.create("https://fun.okdevtv.com/api/words"))
			                .build();

			        CompletableFuture<String> futureResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			                .thenApply(HttpResponse::body)
			                .exceptionally(ex -> {
			                    // 예외 처리
			                    System.err.println("Error occurred: " + ex.getMessage());
			                    return "{\"content\": \"Hello World\"}";
			                });
			        try {
						String responseBody = futureResponse.get();
						System.out.println(responseBody);
				        JSONObject jsonObject = new JSONObject(responseBody);
				        String content = jsonObject.getString("content");

						JOptionPane.showMessageDialog(frame, content);
					} catch (InterruptedException | ExecutionException e1) {
						e1.printStackTrace();
					}
				}
			});

			// JFrame에 버튼 추가
			frame.getContentPane().add(button);

			// JFrame 가시화
			frame.setVisible(true);
		});
	}
}
