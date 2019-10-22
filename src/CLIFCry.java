/**
 * CONTENT: A PERSONAL UTILITY MINI-PPROJECT.  
 * THEME: TEXT FILE SYMMETRIC CRYPTOGRAFY.  
 * PROJECT NAME: CLIFileCrypto.  
 * SOURCE FILE NAME: CLIFileCrypto.java and cryptocore package.  
 * BIN FILE NAME: CLIFileCrypto.class and cryptocore_package.jar.  
 * PPROJECT VERSION: 0.0.1.beta.  
 * BRANCH: MASTER.  
 * AUTHOR: RONALDO PI MA SI.  
 * DATE: 2019-OCT.  
 * LANGUAGE: JAVA 8.  
 * PLATAFORM: Microsoft Windows7, Eclipse IDE EE v201903(4.11.0), JDK_SE-JRE-JVM 1.8.0.22.  
 *   
 * NOTA IMPORTANTE / ISEN��O DE RESPONSABILIDADE:
 * Este � um projeto pessoal, particular, com finalidade exclusiva de estudos
 * em tecnologia da informa��o, e de uso e fruto �nico e exclusivamente de seu
 * autor. Trata-se de um projeto em fase de desenvovimento e experimenta��es,
 * o qual n�o tem nenhuma responsabilidade pelas informa��es nele contidas,
 * t�o pouco sobre seus resultados e efeitos ao ser utilizado.  
 *   
 * IMPORTANT NOTE / DISCLAIMER:
 * This is a personal, private project, solely for the purpose of my studies_
 * in information technology, and for the sole and exclusive use of its author.
 * It is a project under development and experimentation, which has no respon-
 * sibility for the information contained therein, nor about its results and_
 * effects when used.  
 */


// ### IMPORTS
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;




public class CLIFCry {
	/**
	 * @param args
	 */

	// Declara��o de constantes e vari�veis globais.
	public static final String PROGRAM_NAME = "CLIFileCrypto";
	public static final String PROGRAM_ALIAS = "CLIFCry";
	public static final String PROGRAM_VERSION = "0.0.1.beta";
	public static final String DESTIN_FILE_EXTENSION = ".CLIFCry";
	protected static final String[] OPTIONS_ARRAY = { "-t", "-e", "-d", "-h" }; // Vector of acceptables options
																				// b.0.0.1.

	// Auxiliar methods declarations.
	protected static final boolean optionValidate(String aValue, String[] aVector) {
		for (int i = 0; i < aVector.length; i++) {
			if (aVector[i].equalsIgnoreCase(aValue))
				return true;
		}
		return false;
	}

	// Entry method.
	public static void main(String[] args) throws IOException {
		// Declarar vari�veis.
		FileReader readableFile = null;
		BufferedReader readableBuffer = null;
		FileWriter writableFile = null;
		PrintWriter writablePrinter = null;
		String myLine = "";
		int lineIndex;
		StringBuilder doneText = null;

		// N�mero de argumentos enviados na linha de comando.
		int numArgs = args.length;
		System.out.println("\n\nN�mero de argumentos: [" + numArgs + "]");

		// Se existe pelo menos 1 argumento, valida-lo.
		if (numArgs > 0) {

			// Listar argumentos.
			System.out.println("\nLista de argumentos:");
			for (int i = 0; i < numArgs; i++)
				System.out.println(i + " = [" + args[i] + "]");

			// Validar primeiro argumento como op��o aceit�vel.
			if (optionValidate(args[0], OPTIONS_ARRAY)) { // V�lido.

				// Execultar o bloco da op��o comandada.
				switch (args[0]) {

				case "-e": // Encrypt
					System.out.println("\nOp��o: -e [ENCRYPTING]");

					// Lidar com arquivo origem.
					System.out.println("\nA ler arquivo origem...");
					// Associar arquivo origem.
					readableFile = new FileReader(args[1]);
					readableBuffer = new BufferedReader(readableFile);

					// Mostrar arquivo origem.
					// Ler 1a linha.
					myLine = readableBuffer.readLine();
					lineIndex = 0;
					while (myLine != null) {
						// Ler todas linhas at� o fim do arquivo.
						System.out.printf("%d %s\n", lineIndex, myLine);
						myLine = readableBuffer.readLine();
						lineIndex++;
					}
					readableFile.close();
					readableBuffer.close();

					// Encriptar propriamente dito.
					System.out.println("\nEncriptando...");
					// Preparar StringBuilder para receber sequ�ncias de linhas cifradas.
					doneText = new StringBuilder();
					// Associar arquivo origem.
					readableFile = new FileReader(args[1]);
					readableBuffer = new BufferedReader(readableFile);
					// Ler 1a linha.
					myLine = readableBuffer.readLine();
					lineIndex = 0;
					while (myLine != null) {
						// Ler todas linhas at� o fim do arquivo,
						// encriptando-as e adicionando-as no StringBuilder.
						doneText.append(CryptoCore.encrypt(myLine, args[2]) + "\n");
						// Ler pr�xima linha.
						myLine = readableBuffer.readLine();
						lineIndex++;
					}
					System.out.println("\nDemonstra��o:\n" + doneText.toString());

					// Gravar texto cifrado num novo arquivo.
					System.out.println("\nGravando...");
					// Associar arquivo destino.
					writableFile = new FileWriter(args[1] + DESTIN_FILE_EXTENSION);
					writablePrinter = new PrintWriter(writableFile);
					// Escrever a StringBuilder no arquivo.
					writablePrinter.printf(doneText.toString());
					readableFile.close();
					readableBuffer.close();
					writableFile.close();
					writablePrinter.close();

					break;

				case "-d": // Decrypt
					System.out.println("\nOp��o: -d [DECRYPTING]");

					// Lidar com arquivo origem.
					System.out.println("\nA ler arquivo origem...");
					// Associar arquivo origem.
					readableFile = new FileReader(args[1]);
					readableBuffer = new BufferedReader(readableFile);

					// Mostrar arquivo origem.
					// Ler 1a linha.
					myLine = readableBuffer.readLine();
					lineIndex = 0;
					while (myLine != null) {
						// Ler todas linhas at� o fim do arquivo.
						System.out.printf("%d %s\n", lineIndex, myLine);
						// Ler pr�xima linha.
						myLine = readableBuffer.readLine();
						lineIndex++;
					}
					readableFile.close();
					readableBuffer.close();

					// Decriptar propriamente dito.
					System.out.println("\nDecriptando...");
					// Preparar StringBuilder para receber sequ�ncias de linhas cifradas.
					doneText = new StringBuilder();
					// Associar arquivo origem.
					readableFile = new FileReader(args[1]);
					readableBuffer = new BufferedReader(readableFile);
					// Ler 1a linha.
					myLine = readableBuffer.readLine();
					lineIndex = 0;
					while (myLine != null) {
						// Ler todas linhas at� o fim do arquivo,
						// decriptando-as e adicionando-as no StringBuilder.
						doneText.append(CryptoCore.decrypt(myLine, args[2]) + "\n");
						// Ler pr�xima linha.
						myLine = readableBuffer.readLine();
						lineIndex++;
					}
					System.out.println("\nDemonstra��o:\n" + doneText.toString());

					// Gravar texto decifrado num novo arquivo.
					System.out.println("\nGravando...");
					// Associar arquivo destino.
					writableFile = new FileWriter(args[1] + ".CFCdec");
					writablePrinter = new PrintWriter(writableFile);
					// Escrever a StringBuilder no arquivo.
					writablePrinter.printf(doneText.toString());
					readableFile.close();
					readableBuffer.close();
					writableFile.close();
					writablePrinter.close();

					break;

				case "-h": // Imprimir em tela sintaxe e ajuda r�pida.
					System.out.println("\nOp��o: -h [HELP]\n");
					System.out.println("Syntax: CLIFileCrypto <-option> <file_path_name [password]>");
					System.out.println("-e \t to encrypt;");
					System.out.println("-d \t to decrypt;");
					System.out.println("-h \t to help;");
					break;

				default: // Op��o inv�lida.
					System.out.println("\nOp��o: inv�lida. Use op��o -h para ajuda.");
				}
			}
		} else {
			System.out.println("\nNenhum argumento.");
		}

		System.out.println("\nConcluido.\n");
	}
}
