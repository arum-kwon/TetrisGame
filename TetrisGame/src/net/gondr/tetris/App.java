package net.gondr.tetris;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;


public class App extends Application {
	public static App app; //싱글톤 기법을 활용하기 위한 스태틱 변수
	public Game game = null;
	
//중간 생략
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			app = this; //스태틱 변수에 자기자신을 넣어서 싱글톤으로 활용함.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/net/gondr/views/Main.fxml"));
			AnchorPane anchorPane = (AnchorPane)loader.load();

			Scene scene = new Scene(anchorPane);
			
			scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
				if(game != null)
					game.keyHandler(e); //게임의 이벤트 핸들러로 넘겨준다.
			});
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	public void showGameOverview() {

		Label titleLabel = new Label();
		titleLabel.setText("GAME OVER");
		titleLabel.setFont(new Font(25));
		AnchorPane.setTopAnchor(titleLabel, (double) 30);
		//Scene scene = new Scene(anchorPane);
		
//		try {
//
//			Label titleLabel = new Label();
//			titleLabel.setText("GAME OVER");
//			titleLabel.setFont(new Font(25));
//			// 연락처 요약을 가져온다.
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
//			AnchorPane personOverview = (AnchorPane) loader.load();
//
//			// 연락처 요약을 상위 레이아웃 가운데로 설정한다.
//			rootLayout.setCenter(personOverview);
//			
//			// 메인 애플리케이션이 컨트롤러를 이용할 수 있게 한다.
//	        PersonOverviewController controller = loader.getController();
//	        controller.setMainApp(this);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
}
