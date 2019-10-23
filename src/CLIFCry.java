/******************************************************************************
 * CLIFCry (symm.wwo.pw.1f.1pw)
 * Command Line Interface File Cryptografer  
 * 
 * The CLIFCry.java and its resources are a project sample, which I have_
 * developing to demonstrate some of my abilities.
 *   
 * The CLIFCry project belongs to my personal portfolio. Its detailed project_
 * can be followed just here on GitHub:_
 * https://github.com/users/ROPIMASI/projects/ . It is also found on my web-
 * portfolio: https://ropimasi.wixsite.com/portfolio .  
 * 
 * CONTENT: A PERSONAL UTILITY MINI PPROJECT.
 * THEME: TEXT FILE SYMETRIC CRYPTOGRAFER.
 * PROJECT NAME: CLIFCry.
 * PPROJECT VERSION: 1.0.0.beta.
 * SOURCE FILE NAME: CLIFCry.java.
 * BIN FILE NAME: CLIFCry.class.
 * DEPENDENCES: cryptocorepack.jar.
 * BRANCH: MASTER.
 * AUTHOR: RONALDO PI MA SI.  
 * DATE: 2019-OCT.
 * LANGUAGE: JAVA 8.
 * PLATAFORM: Microsoft Windows7, Eclipse IDE EE v201903(4.11.0),_
 * JDK_SE-JRE-JVM 1.8.0.22.
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
******************************************************************************/



// PACKAGE OWNER: none.



// IMPORT OF DEPENDENCES.
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
//import cryptocorepack.*; temporariamente usando CryptoCore.class no mesmo path/pacote de CLIFCry.class,
// sem importar de um pacote externo.



// MAIN CLASS.
public class CLIFCry {
	/**
	 * @param args
	 */


	
	// Declara��o de constantes e vari�veis globais.
	public static final String PROGRAM_NAME = "CLIFCry";
	public static final String PROGRAM_VERSION = "1.0.0.beta";
	public static final String DESTIN_FILE_EXTENSION = ".CLIFCry";
	protected static final String[] OPTIONS_ARRAY = { "-e", "-d", "-h" }; // Vector of acceptables options
																		  // on 1.0.0.beta.

	
	// Auxiliar method to validate whether aValue in aVector.
	protected static final boolean optionValidate(String aValue, String[] aVector) {
		for (int i = 0; i < aVector.length; i++) {
			if (aVector[i].equalsIgnoreCase(aValue))
				return true;
		}
		return false;
	}

	
	
	// Entrance method.
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
		
		
		
		// debug print.
		System.out.println("\n\nN�mero de argumentos: [" + numArgs + "]");

		
		
		// Se existe pelo menos 1 argumento, valida-lo.
		if (numArgs > 0) {

			// debug print.
			System.out.println("\nLista de argumentos:");
			for (int i = 0; i < numArgs; i++)
				System.out.println(i + " = [" + args[i] + "]");

			// Validar primeiro argumento se op��o aceit�vel.
			if (optionValidate(args[0], OPTIONS_ARRAY)) { // V�lido.

				// Execultar o bloco da op��o comandada.
				switch (args[0]) {

				case "-e": // Encrypt
					// Lidar com arquivo origem.
					// --- inicio debug print. ---
					System.out.println("\nOp��o: -e [ENCRYPTING]");
					System.out.println("\nA ler arquivo origem...");
					readableFile = new FileReader(args[1]);
					readableBuffer = new BufferedReader(readableFile);
					myLine = readableBuffer.readLine();
					lineIndex = 0;
					while (myLine != null) {
						System.out.printf("%d %s\n", lineIndex, myLine);
						myLine = readableBuffer.readLine();
						lineIndex++;
					}
					readableFile.close();
					readableBuffer.close();
					// --- fim debug print. ---

					
					// Encriptar propriamente dito.
					// debug print.
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
						doneText.append(CryptoCore.symmEncrypt(myLine, args[2]) + "\n");
						// Ler pr�xima linha.
						myLine = readableBuffer.readLine();
						lineIndex++;
					}
					// debug print.
					System.out.println("\nDemonstra��o:\n" + doneText.toString());

					// Gravar texto cifrado num novo arquivo.
					// debug print.
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
					// Lidar com arquivo origem.
					// --- inicio debug print. ---
					System.out.println("\nOp��o: -d [DECRYPTING]");
					System.out.println("\nA ler arquivo origem...");
					readableFile = new FileReader(args[1]);
					readableBuffer = new BufferedReader(readableFile);
					myLine = readableBuffer.readLine();
					lineIndex = 0;
					while (myLine != null) {
						System.out.printf("%d %s\n", lineIndex, myLine);
						myLine = readableBuffer.readLine();
						lineIndex++;
					}
					readableFile.close();
					readableBuffer.close();
					// --- fim debug print. ---

					// Decriptar propriamente dito.
					// dubug print.
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
						doneText.append(CryptoCore.symmDecrypt(myLine, args[2]) + "\n");
						// Ler pr�xima linha.
						myLine = readableBuffer.readLine();
						lineIndex++;
					}
					// dubug print.
					System.out.println("\nDemonstra��o:\n" + doneText.toString());

					// Gravar texto decifrado num novo arquivo.
					// dubug print.
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
					System.out.println("-h \t to help.");
					break;

				default: // Op��o inv�lida.
					System.out.println("\nErro: Op��o inexperada.\nUltilize op��o <-h> para ajuda.\nSe este erro persistir contate _ _ _ _ _ _ _ _.");
				}
			} else {
				System.out.println("\nErro: Argumento inv�lido.\nUltilize op��o <-h> para ajuda.");	
			}
		} else {
			System.out.println("\nErro: Nenhum argumento encontrado.\nUltilize op��o <-h> para ajuda.");
		}
		System.out.println("\nConcluido.\n");
	}
	
	
	
	// Uma class aninhada s� contendo as frases padronizadas.
	public class CLIFCMultIdiomNotes {
		// para implementar uma colet�nea de notas padronizadas (string constantes).
		
	}
}
