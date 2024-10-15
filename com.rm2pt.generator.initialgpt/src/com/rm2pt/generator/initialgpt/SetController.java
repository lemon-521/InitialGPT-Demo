package com.rm2pt.generator.initialgpt;




import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class SetController {

	
	public static void OutFileString(String cu,String filePath) throws IOException {
				String a = cu.toString();
				OutputStream os = null;
				OutputStreamWriter ops = null;
				BufferedWriter bw = null;
				File f1 = new File(filePath);
				if(!f1.exists()) {
					f1.getParentFile().mkdirs();
				}
				try {
					os = new FileOutputStream(f1);
					ops = new OutputStreamWriter(os);
					bw = new BufferedWriter(ops);
					bw.write(a);
					bw.newLine();
					bw.flush();
				}
				catch(FileNotFoundException e){
					e.printStackTrace();
				}
				catch(IOException e) {
					
					e.printStackTrace();
				}
				
				System.out.println(" Modify successfulString!!!");
			
			}//OutFile
	
	public static byte[] GetFile(String filePath){
			   
			   File file = new File(filePath);
			   byte[] b = new byte[(int) file.length()];
			   FileInputStream fis = null;
				  try {
					 fis = new FileInputStream(file);
				  } catch (FileNotFoundException e2) {
					 // TODO Auto-generated catch block
					 e2.printStackTrace();
				 }
				   try {
					 fis.read(b);   
			    	} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				 }
			   return b;
		  }//GetFile
		   

		    
   


	/* 添加pom.xml 里面的依赖 */
	public static void setpomEntity(String path,String projectName){
			//获取文件路径
			
		File fileTest = new File(path+"/"
				+projectName +"Prototype/src-gen/entities/EntityManager.java");
			
			String filePath = fileTest.getAbsolutePath();
			
			 byte[]b=GetFile(filePath);
			 
			 String content = new String(b);
			  
			 StringBuffer sb = new  StringBuffer(content);  
		
			 
			  int addImportDcl = sb.indexOf("import java.io.File;");
			  sb.insert(addImportDcl, "	import org.json.JSONArray;\r\n"
			  		+ "import org.json.JSONObject;\r\n"
			  		+ "import org.yaml.snakeyaml.Yaml;\r\n"
			  		+ "import com.google.gson.JsonObject;\r\n"
			  		+ "import com.google.gson.JsonParser;\r\n"
			  		+ "import java.util.ArrayList;\r\n"
			  		+ "import cn.hutool.core.util.ObjectUtil;\r\n"
			  		+ "import cn.hutool.json.JSONUtil;\r\n"
			  		+ "import java.time.LocalDate;\r\n"
			  		+ "import java.time.format.DateTimeFormatter;\r\n"
			  		+ "import java.time.format.DateTimeParseException;\r\n"
			  		+ "import java.time.ZoneId;\r\n"
			  		+ "import java.time.Instant;\r\n"
			  		+ "import java.util.HashSet;\r\n"
			  		+ "import java.util.Set;\r\n"
			  		+ "import com.fasterxml.jackson.core.JsonProcessingException;\r\n"
			  		+ "import java.util.Random;\r\n"
			  		+ "import com.fasterxml.jackson.databind.JsonMappingException;\r\n"
			  		+ "import java.util.concurrent.ThreadLocalRandom;\r\n"
			  		+ "import org.json.JSONException;\r\n"
					  );
			  try {
				  OutFileString(sb.toString(),filePath);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}


		/* 添加pom.xml 里面的依赖 */
	public static void setpom(String path,String projectName){
			//获取文件路径
			
			File fileTest = new File(path+"/"
					+projectName +"Prototype/pom.xml");
			
			String filePath = fileTest.getAbsolutePath();
			
			 byte[]b=GetFile(filePath);
			 
			 String content = new String(b);
			  
			 StringBuffer sb = new  StringBuffer(content);  
		
			 
			  int addImportDcl = sb.indexOf("</project>");
			  sb.insert(addImportDcl-19, "<dependency>\r\n"
				 		+ "		    <groupId>org.yaml</groupId>\r\n"
				 		+ "		    <artifactId>snakeyaml</artifactId>\r\n"
				 		+ "		    <version>1.26</version>\r\n"
				 		+ "		</dependency>\r\n"
				 		+ "		<!-- https://mvnrepository.com/artifact/org.json/json -->\r\n"
				 		+ "		<dependency>\r\n"
				 		+ "		    <groupId>org.json</groupId>\r\n"
				 		+ "		    <artifactId>json</artifactId>\r\n"
				 		+ "		    <version>20160810</version>\r\n"
				 		+ "		</dependency>\r\n"
				 		+ "		\r\n"  
				 		+ " 	<dependency>\r\n"
				 		+ "			<groupId>com.google.code.gson</groupId>\r\n"
				 		+ "			<artifactId>gson</artifactId>\r\n"
				 		+ "			<version>2.8.3</version>\r\n"
				 		+ "		</dependency>"
				 		+ " \r\n"
					  	+ "        <dependency>\r\n"
					  	+ "		    <groupId>com.theokanning.openai-gpt3-java</groupId>\r\n"
					  	+ "		    <artifactId>client</artifactId>\r\n"
					  	+ "		    <version>0.11.0</version>\r\n"
					  	+ "		</dependency>   \r\n"
					  	+ "		<dependency>\r\n"
					  	+ "		    <groupId>cn.hutool</groupId>\r\n"
					  	+ "		    <artifactId>hutool-all</artifactId>\r\n"
					  	+ "		    <version>5.8.10</version>\r\n"
					  	+ "		</dependency>\r\n"
					  	+ "		"
					  	+ "       <dependency>\r\n"
					  	+ "		    <groupId>com.fasterxml.jackson.core</groupId>\r\n"
					  	+ "		    <artifactId>jackson-databind</artifactId>\r\n"
					  	+ "		    <version>2.13.0</version>\r\n"
					  	+ "		</dependency>\r\n"
					  	+ "		<dependency>\r\n"
					  	+ "		    <groupId>com.fasterxml.jackson.dataformat</groupId>\r\n"
					  	+ "		    <artifactId>jackson-dataformat-yaml</artifactId>\r\n"
					  	+ "		    <version>2.13.0</version>\r\n"
					  	+ "		</dependency>\r\n"
					  );
			  
			  
			  
			  
			  
			  try {
				  OutFileString(sb.toString(),filePath);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	
	
	
	public static void setLoadfxml(String path, String projectName)
		{
	    	  //获取文件路径runtime-New_configuration
	    	   //获取文件路径
				File fileTest = new File(path+"/"
				+ projectName +"Prototype/src-gen/gui/Prototype.fxml");  		   			 	

				String filePath = fileTest.getAbsolutePath();
//			String filePath = "../../"+projectName+"Prototype/src-gen/gui/Prototype.fxml";
			  byte[]b=GetFile(filePath);
			  String content = new String(b);
			  
			  StringBuffer sb = new  StringBuffer(content);  
			  int addloafileClicked = sb.indexOf(
				"<Button text=\"Check All Invariants\" onAction=\"#checkAllInvariants\"/>");
			  //System.out.println("addButtonClicked：" + addloafileClicked + "sssssssss");
			  sb.insert(addloafileClicked,
					  "<Button text=\"Load File\" onAction=\"#loadfile\"  /> \r\n"
					+ "<Button text=\"Initial Data Generation\" onAction=\"#generation\"  /> \r\n"
			  );
			  
			  try {
				OutFileString(sb.toString(),filePath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	/*添加import、button、buttonclick、loadfileclicke等Controller内容*/
	 public static void setBlock(String path, String projectName,String strCon) {
	 	    	  //获取文件路径runtime-New_configuration
	 	    	   //获取文件路径
	 	    	  File fileTest = new File(path+"/"
	 	 				+ projectName +"Prototype/src-gen/gui/PrototypeController.java");
	  			 String filePath = fileTest.getAbsolutePath();
	 			  byte[]b=GetFile(filePath);
	 			  String content = new String(b);
	 			  

	 			 StringBuffer sb = new StringBuffer(content);  
	
	
	 			int addimport = sb.indexOf("public class PrototypeController");
		 		sb.insert(addimport-1,
		 				"\r\n import javafx.scene.control.Button;\r\n"
		 				+ "import java.io.FileNotFoundException;\r\n"
		 				+ "import java.io.FileInputStream;\r\n"
		 				+ "import java.util.ArrayList;\r\n"
		 				+ "import org.yaml.snakeyaml.Yaml;\r\n"
		 				+ "import org.json.JSONArray;\r\n"
		 				+ "import org.json.JSONObject;\r\n"
		 				+ "import javafx.scene.Scene;\r\n"
		 				+ "import javafx.event.ActionEvent;\r\n"
		 				+ "import javafx.event.EventHandler;\r\n"
		 				+ "import javafx.stage.WindowEvent;\r\n"
		 				);
		 		
	 			 
	 			 
	 			 
	 			 
	 			 
	 			int addCode = sb.indexOf("public void actorTreeViewBinding(");
//	 			System.out.println( "\n str: " +str);
		 		sb.insert(addCode-10,strCon);
		 		
		 		
	 
	 
	 
 			     int addLoadfileClicked = sb.indexOf("public void save(ActionEvent event");
 			     sb.insert(addLoadfileClicked,"/**\r\n"
 			     		+ "	 * 测试 load file\r\n"
 			     		+ "	 */\r\n"
 			     		+ "	public void loadfile(ActionEvent event) {\r\n"
 			     		+ "\r\n"
 			     		+ "		Stage stage = (Stage) mainPane.getScene().getWindow();\r\n"
 			     		+ "\r\n"
 			     		+ "		FileChooser fileChooser = new FileChooser();\r\n"
 			     		+ "		fileChooser.setTitle(\"Open Yaml File\");\r\n"
 			     		+ "		fileChooser.getExtensionFilters().addAll(new ExtensionFilter(\"RMCode Yaml File\", \"*.yaml\"));\r\n"
 			     		+ "\r\n"
 			     		+ "		File file = fileChooser.showOpenDialog(stage);\r\n"
 			     		+ "\r\n"
 			     		+ "		if (file != null) {\r\n"
 			     		+ "			System.out.println(\"choose file: \" + file.getAbsolutePath());\r\n"
 			     		+ "			yamlPath = file.getAbsolutePath();\r\n"
 			     		+ "				EntityManager.loadFile(file,1);\r\n"
 			     		+ "			//EntityManager.load(file);\r\n"
 			     		+ "		}\r\n"
 			     		+ "		// refresh GUI after load data\r\n"
 			     		+ "		refreshAll();\r\n"
 			     		+ "	}\r\n"
 			     		
// 			     		public void generation(ActionEvent event) {
//
// 			     			OpenAiSpeaker.ChatClient_new chatClient = new OpenAiSpeaker.ChatClient_new();
// 			     			Stage stage = new Stage();
// 			     			
// 			     			
// 			     			chatClient.start(stage);
//
// 			     			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
// 			     			      @Override
// 			     			      public void handle(WindowEvent event) {
// 			     			        System.out.print("监听到窗口关闭");
// 			     			        refreshAll();
// 			     			      }
// 			     			    });
//
// 			     			refreshAll();
// 			     		}
						+"  //generate data\r\n"
 			    		+"	public void generation(ActionEvent event){\r\n"
 			    		+ "\r\n"
 			    		+ "		ChatClient_new chatClient = new ChatClient_new();\r\n"
 			    		+ "		Stage stage = new Stage();\r\n"
 			    		+ "		chatClient.start(stage);\r\n"
 			    		+ "		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {\r\n"
 			    		+ "		    @Override\r\n"
 			    		+ "			public void handle(WindowEvent event) {\r\n"
 			    		+ "			   System.out.print(\"监听到窗口关闭\");\r\n"
 			    		+ "			   refreshAll();}\r\n"
 			    		+ "		});\r\n"
 			    		+ "		refreshAll();\r\n"
 			    		+ "	}\r\n"
 			    		 
 			    		 );


 			     int addStringYaml = sb.indexOf("int objectindex;");
 			     sb.insert(addStringYaml,"String yamlPath;");
 			     sb.insert(addStringYaml,"\r\n public void startclick(TableView tableView, String Title) \r\n"
 			     		+ "	{	\r\n"
 			     		+ "		Stage primaryStage =new Stage();\r\n"
 			     		+ "\r\n"
 			     		+ "		VBox vbox = new VBox(tableView);\r\n"
 			     		+ "\r\n"
 			     		+ "		 Scene scene = new Scene(vbox, 450, 300);\r\n"
 			     		+ "	     primaryStage.setTitle(\"All Objects \"+Title +\": \");\r\n"
 			     		+ "	     primaryStage.setScene(scene);\r\n"
 			     		+ "\r\n"
 			     		+ "	     primaryStage.show();\r\n"
 			     		+ "	}\r\n");
 			     
 			     try {
 					OutFileString(sb.toString(),filePath);
 					} catch (IOException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}

 				 
 				 
 				 
 				 
	 }//end	 				
	 
	 
	 
	 public static void setLoadEntityManager(String path, String projectName,String str)
		{
			//获取文件路径
			
			File fileTest = new File(path+"/"
					+projectName +"Prototype/src-gen/entities/EntityManager.java");
			
			String filePath = fileTest.getAbsolutePath();
			
			 byte[]b=GetFile(filePath);
			 
			 String content = new String(b);
			  
			 StringBuffer sb = new  StringBuffer(content);  
		
			 
			  int addImportDcl = sb.indexOf("public static void load(File file)");
			  
			  sb.insert(addImportDcl, 
					  "\r\npublic static String file2String(final File file) throws IOException {\r\n"
					  + "	    if (file.exists()) {\r\n"
					  + "	        byte[] data = new byte[(int) file.length()];\r\n"
					  + "	        boolean result;\r\n"
					  + "	        FileInputStream inputStream = null;\r\n"
					  + "	        try {\r\n"
					  + "	            inputStream = new FileInputStream(file);\r\n"
					  + "	            int len = inputStream.read(data);\r\n"
					  + "	            result = len == data.length;\r\n"
					  + "	        } finally {\r\n"
					  + "	            if (inputStream != null) {\r\n"
					  + "	                inputStream.close();\r\n"
					  + "	            }\r\n"
					  + "	        }\r\n"
					  + "	        if (result) {\r\n"
					  + "	            return new String(data);\r\n"
					  + "	        }\r\n"
					  + "	    }\r\n"
					  + "	    return null;\r\n"
					  + "	}"
					  +str
					  );
			  try {
				  OutFileString(sb.toString(),filePath);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}

	 public static void setChatClient(String path, String projectName,String str) throws IOException
		{
			//获取文件路径
			
//			File fileTest = new File(path+"/"
//					+projectName +"Prototype/src-gen/gui/ChatClient_new.java");
			 
		 File file = new File(path+"/"
						+projectName +"Prototype/src-gen/gui/ChatClient_new.java");
	         // 或者 File file = new File("D:\\123.txt");
	 		
	 		if(file.createNewFile()) {
	 			System.out.println("ChatClient_new文件创建成功！");
	 		} else {
	 			System.out.println("ChatClient_new文件创建失败！");
	 		}
//			
	 		
            System.out.println(path+"/"
					+projectName +"Prototype/src-gen/gui/ChatClient_new.java");
            System.out.println(file.getAbsolutePath());
            
			String filePath = file.getAbsolutePath();
			
			  try {
				  OutFileString(str.toString(),filePath);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}

	 public static void setOpenAiSpeaker(String path, String projectName,String str) throws IOException
		{
			//获取文件路径
			
//			File fileTest = new File(path+"/"
//					+projectName +"Prototype/src-gen/gui/OpenAiSpeaker.java");
//			
//			String filePath = fileTest.getAbsolutePath();


                File file = new File(path+"/"
    					+projectName +"Prototype/src-gen/gui/OpenAiSpeaker.java");
                // 或者 File file = new File("D:\\123.txt");
        		
        		if(file.createNewFile()) {
        			System.out.println("OpenAiSpeaker文件创建成功！");
        		} else {
        			System.out.println("OpenAiSpeaker文件创建失败！");
        		}
        		
        		String filePath = file.getAbsolutePath();
  			  try {
				  OutFileString(str.toString(),filePath);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		
			 

		}


}
	 
	 
	 
	
	
	
	
	
	
	
	