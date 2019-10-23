/******************************************************************************
 * CryptoCorePack (symm.wwo.pw)
 * Cryptogrphy Core Package  
 * 
 * The CryptoCore.java and its resources are a project sample, which I have_
 * developing to demonstrate some of my abilities.
 *   
 * The CryptoCorePack project belongs to my personal portfolio. Its detailed_
 * project can be followed just here on GitHub:_
 * https://github.com/users/ROPIMASI/projects/ . It is also found on my web-
 * portfolio: https://ropimasi.wixsite.com/portfolio .  
 * 
 * CONTENT: A PERSONAL UTILITY MINI PPROJECT.
 * THEME: TEXT SYMETRIC CRYPTOGRAFY PACKAGE.
 * PROJECT NAME: CryptoCorePack.
 * PPROJECT VERSION: 1.0.0.beta.
 * SOURCE FILE NAME: CryptoCore.java.
 * BIN FILE NAME: CryptoCore.class or its JAR: cryptocorepack.jar.
 * DEPENDENCES: None.
 * BRANCH: MASTER.
 * AUTHOR: RONALDO PI MA SI.
 * DATE: 2019-OCT.
 * LANGUAGE: JAVA 8.
 * PLATAFORM: Microsoft Windows7, Eclipse IDE EE v201903(4.11.0),_
 * JDK_SE-JRE-JVM 1.8.0.22.
 * 
 * NOTA IMPORTANTE / ISENÇÃO DE RESPONSABILIDADE:
 * Este é um projeto pessoal, particular, com finalidade exclusiva de estudos
 * em tecnologia da informação, e de uso e fruto único e exclusivamente de seu
 * autor. Trata-se de um projeto em fase de desenvovimento e experimentações,
 * o qual não tem nenhuma responsabilidade pelas informações nele contidas,
 * tão pouco sobre seus resultados e efeitos ao ser utilizado.  
 *   
 * IMPORTANT NOTE / DISCLAIMER:
 * This is a personal, private project, solely for the purpose of my studies_
 * in information technology, and for the sole and exclusive use of its author.
 * It is a project under development and experimentation, which has no respon-
 * sibility for the information contained therein, nor about its results and_
 * effects when used.  
******************************************************************************/




// IMPORT OF DEPENDENCES.



// MAIN CLASS.
public final class CryptoCore {

	// Declaração de constantes e variáveis globais.
	public static final String PACK_NAME = "CryptoCorePack";
	public static final String PACK_VERSION = "1.0.0.beta";
	public static final String CHAR_SET_ABLE = "ASCII";
	public static final boolean IN_DEBUG_MODE = true;
	
	
	
	// Método auxiliar de verificação exclusivo para DEBUG_MODE == true.
	protected static void idmPrint(String str) {
		if (IN_DEBUG_MODE) System.out.println(str);
	}

	
	
	// Método redimensionador da senha através de repetição.
	public static String resizeRepeating(String key, int newLength) {
		if (key.length() == newLength) {
			idmPrint(",");
			return key;
		} else if (key.length() < newLength) {
			int pos = 0;
			int tokenSize = key.length();
			do {
				idmPrint(",");
				key += key.charAt(pos);
				pos = (pos <= tokenSize - 1) ? pos + 1 : 0;
			} while (key.length() < newLength);
			return key;
		} else { // (key.length() > newLength)
			idmPrint(",");
			key = key.substring(0, newLength);
			return key;
		}
	}

	
	
	// Encriptar simétrica sem senha. 
	public static String symmEncrypt(String decryptedText) {
		/**
		 * Return an encrypted string from a given natural text (input on arg).
		 * 
		 */
		String encryptedText = "";
		for (int i = 0; i < decryptedText.length(); i++) {
			idmPrint(".");
			encryptedText += (char) ((int) (decryptedText.charAt(i)) + (decryptedText.length() - i));
		}
		idmPrint("[" + encryptedText + "]");
		return encryptedText;
	}

	
	
	// Overloading... Encriptar simétrica com senha. 
	public static String symmEncrypt(String decryptedText, String password) {
		/**
		 * Return an encrypted string from a given natural text (input on arg).
		 * 
		 */
		idmPrint("[" + password + "][" + decryptedText.length() + "]");
		password = resizeRepeating(password, decryptedText.length());
		String encryptedText = "";
		for (int i = 0; i < decryptedText.length(); i++) {
			idmPrint(".");
			encryptedText += (char) ((int) (decryptedText.charAt(i)) + (int) (password.charAt(i)) + i);
		}
		idmPrint("[" + password + "][" + decryptedText.length() + "][" + encryptedText + "]");
		return encryptedText;
	}

	
	
	// Decriptar simétrica sem senha.
	public static String symmDecrypt(String encryptedText) {
		/**
		 * Return a decrypted string from a given encrypted text (input on arg).
		 * 
		 */
		String decryptedText = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			idmPrint(":");
			decryptedText += (char) ((int) (encryptedText.charAt(i)) - (encryptedText.length() - i));
		}
		idmPrint("[" + decryptedText + "]");
		return decryptedText;
	}

	
	
	// Overloading... Decriptar simétrica sem senha.
	public static String symmDecrypt(String encryptedText, String password) {
		/**
		 * Return a decrypted string from a given encrypted text (input on arg).
		 * 
		 */
		idmPrint("[" + password + "][" + encryptedText.length() + "]");
		password = resizeRepeating(password, encryptedText.length());
		String decryptedText = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			idmPrint(":");
			decryptedText += (char) ((int) (encryptedText.charAt(i)) - (int) (password.charAt(i)) - i);
		}
		idmPrint("[" + password + "][" + encryptedText.length() + "][" + decryptedText + "]");
		return decryptedText;
	}
}
