all: client server

client:
	javac -cp "jersey-bundle-1.19.jar" webservice/Cliente.java webservice/Calculadora.java webservice/CalculadoraRest.java

server:
	javac -cp "jersey-bundle-1.19.jar" webservice/Servidor.java

run_server: server
	@java -version
	@java -cp ".:jersey-bundle-1.19.jar" webservice.Servidor

run_client: client
	@java -version
	@java -cp ".:jersey-bundle-1.19.jar" webservice.Cliente $(operand1) $(operand2) $(operation)

clean:
	rm  webservice/*.class

