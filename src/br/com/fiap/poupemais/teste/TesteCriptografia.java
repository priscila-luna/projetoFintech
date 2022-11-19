package br.com.fiap.poupemais.teste;
import br.com.fiap.poupemais.util.CriptografiaUtils;
public class TesteCriptografia {

	public static void main(String[] args) {
		try {
			System.out.println(CriptografiaUtils.criptografar("123456"));
			System.out.println(CriptografiaUtils.criptografar("123456"));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
