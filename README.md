# Distributed_Systems_Project


### Build Instructions
1. Open a Command Prompt Window/Terminal
2. Clone the repository using the `git clone` command
3. Move into the cloned directory using the `cd` command
4. Compile the project files using the `javac` command
	 ```sh
	javac ServerProtocol.java SocketClient.java SocketServer.java ClientProtocal.java
	```
3. Run the following command to start the server in the current command prompt/terminal window, 
	```sh
	java SocketServer
	```
4. In a new command prompt/terminal window and run the following command to start the client program
	```sh
	java SocketClient
