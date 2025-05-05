package br.senai.dev.ryan.model;

public class EndereçoIP {
	int[] octets = new int[4];

	public EndereçoIP(String text) {
		String[] parts = text.split("\\.");
		if (parts.length != 4)
			throw new RuntimeException("IP deve ter 4 números");
		for (int i = 0; i < 4; i++) {
			octets[i] = Integer.parseInt(parts[i]);
			if (octets[i] < 0 || octets[i] > 255)
				throw new RuntimeException("Octeto inválido: " + octets[i]);
		}
	}

	public String toString() {
		return octets[0] + "." + octets[1] + "." + octets[2] + "." + octets[3];
	}

	public String getClassType() {
		int first = octets[0];
		if (first <= 127)
			return "A";
		if (first <= 191)
			return "B";
		if (first <= 223)
			return "C";
		if (first <= 239)
			return "D";
		return "E";
	}

	public String toBinary() {
		String s = "";
		for (int i = 0; i < 4; i++) {
			String b = Integer.toBinaryString(octets[i]);
			while (b.length() < 8)
				b = "0" + b;
			s += b + (i < 3 ? "." : "");
		}
		return s;
	}
}
